package Server.server;

import Server.DataBase.Database;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This class is used to Authenticate an account
 */
public class Authentication {
    static Database database =new Database();
    /**
     * The login method return true if
     * username and password is correct | else false
     * @param userName the username
     * @param password the password
     * @return the account
     */
  public static boolean logIn (String userName,String password) {
       if(userName==null||password==null) {
           System.out.println("UserName and password can not be null!");
           return false;
       }
      Account a = database.checkAccount(userName);
       if(a!=null){
         return a.getPassword().equals(getShaPassword(password));
       }
      else
          return false;
}

    /**
     * The signUp method adds a new account
     * @param account the account you want to add
     * @return true if successfully added/ else false
     */
  public static boolean signUp(Account account) {
     if(!is256Character(account.getBiography())){
         return false;
     }
     if(database.checkAccount(account.getUserName())!=null){
         return false;
     }
     account.setPassword(getShaPassword(account.getPassword()));
     return true;
   }
    /**
     * @param password password from account
     * @return the hash of this password
     */
    public static String getShaPassword(String password) {
        BigInteger bigInteger=new BigInteger(1,getSha(password));
        StringBuilder buffer=new StringBuilder(bigInteger.toString(16));
        while(buffer.length()<32) {
            buffer.insert(0,'0');
        }
        return buffer.toString();
    }
    private static byte [] getSha(String password) {
        try {
            MessageDigest digest= MessageDigest.getInstance("SHA-256");
            return digest.digest(password.getBytes(StandardCharsets.UTF_8));
        }catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * check whether biography is 256 char or not
     * @param biography the biography
     * @return true if 256 char else false
     */
    public static boolean is256Character(String biography) {
      return biography.length()<=256;
  }
}
