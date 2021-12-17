package Server.server;
import java.io.Serializable;

/**
 * This interface is used to achieve abstraction
 * and extends serializable because writing objects to file
 * and extends comparable because of sorting the Account with username
 */
public interface Account extends Serializable,Comparable<Account>,Cloneable {
    /**
     * @return the date of birth
     */
    String getBirthDate();
    /**
     * @return the date that user created an account
     */
    String getMemberShipDate();
    /**
     * @return the username
     */
    String getUserName();
    /**
     * @return name
     */
    String getName();
    /**
     * @return lastName
     */
    String getLastName();
    /**
     * setter for password
     * @param password the password you want to set for your account
     */
    void setPassword(String password);
    /**
     * @return password
     */
    String getPassword();
    /**
     * getter for biography
     */
    String getBiography();
}
