package Server.tweet;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The tweeting interface to achieve abstraction
 * This interface is used to make a connection
 * between server and client
 */
public interface Tweeting extends Serializable,Cloneable {

 ///// General Detail method ////

    int getTweetID();
    String getContent();

 ////// Date method //////

    String getDateString();
    LocalDateTime getDate();

}
