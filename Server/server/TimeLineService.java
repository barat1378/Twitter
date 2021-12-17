package Server.server;

import Server.DataBase.Database;
import Server.tweet.Tweeting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TimeLineService class show all tweet that
 * is going to be shown in timeline of an account
 */
public class TimeLineService {
private static Database database = new Database();
 public void printAllReply(Tweeting tweet){
     List<Tweeting> reply = database.getTweetReplies(tweet);
     for(Tweeting t: reply){
         System.out.println(t);
     }
 }
 public void printAllTimeLineTweet(List<Account> followedList){
     ArrayList<Tweeting> tweets = getTimeLineTweet(followedList);
     for(Tweeting t: tweets){
             System.out.println(t);      }
     }

    /**
     * This method print All tweet of the followed_account
     * @param followedList the list of account that you have followed
     */
  public static ArrayList<Tweeting> getTimeLineTweet(List<Account> followedList) {
      ArrayList allTweet = new ArrayList<>();
      for(Account a : followedList)
          allTweet.addAll(database.getTweets(a));
      Collections.sort(allTweet);
  return allTweet;
  }




}
