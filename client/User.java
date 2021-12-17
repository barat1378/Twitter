package client;
import Server.server.Account;
import Server.tweet.Tweeting;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
/**
 * This class represent a user
 */
public class User implements Account {

  private String name;
  private String lastName;
  private String userName;
  private String password;
  private LocalDate birthDate;
  private LocalDateTime memberShipDate;
  private String biography;
    /**
     * The constructor of User class
     * @param name the name
     * @param lastName the last name
     * @param userName the username
     * @param password the password
     * @param biography the biography
     * @param birthDate the birthdate
     */
  public User(String name, String lastName, String userName, String password,String biography,LocalDate birthDate) {
    this.name=name;
    this.lastName=lastName;
    this.memberShipDate=LocalDateTime.now();
    this.password=password;
    this.userName=userName;
    this.birthDate=birthDate;
    this.biography=biography;
  }

    /**
     * @return the date of birth
     */
  @Override
  public String getBirthDate() {
     return birthDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
  }

    /**
     * @return the date that user created an account
     */
  @Override
  public String getMemberShipDate() {
    return memberShipDate.format(DateTimeFormatter.ofPattern("yy/MM/dd hh:mm"));
  }

    /**
     * @return the username
     */
  @Override
  public String getUserName() {
    return userName;
  }


    /**
     * @return name
     */
  public String getName() {
    return name;
  }

    /**
     * @return lastName
     */
  public String getLastName() {
    return lastName;
  }


    /**
     * @return password
     */
  public String getPassword() {
    return password;
  }

  @Override
  /**
   * getter for biography
   */
  public String getBiography() {
      return biography;
  }

  /**
   * setter for password
   * @param password the password you want to set for your account
   */
  @Override
  public void setPassword(String password) {
     this.password=password;
  }

  /**
   * show whether two object of these class is same or not
   * @param obj
   * @return true/false
   */
  @Override
  public boolean equals(Object obj) {
    if(!(obj instanceof User))
      return false;
    User user=(User)obj;
    return this.userName.equals(user.getUserName());
  }

  /**
   * toString method
   * @return a string that show the user's details
   */
  @Override
  public String toString() {
     return "Name: "+name+", UserName: "+userName+", LastName: "+lastName+" , Biography: "+biography;
  }

  /**
   * compare two account with userName
   * @param o an object of Account
   * @return 1 if this is bigger than o /else -1/ return 0 if this is equal with o
   */
    @Override
    public int compareTo(Account o) {
        return userName.compareTo(o.getUserName());
    }
}
