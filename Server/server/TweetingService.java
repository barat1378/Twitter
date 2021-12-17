package Server.server;
import Server.DataBase.Database;
import Server.tweet.Tweeting;

/**
 * The class that add/remove tweet
 */
public class TweetingService {
    private static final Database database = new Database();

    /**
     * add a new tweet
     * @param tweet the tweet you want to add
     * @param user the account that want to tweet
     */
   public static void addTweet(Tweeting tweet, Account user) {
       if(Authentication.signUp(user))
            database.addTweet(tweet,user);
       else
           System.out.println("Invalid data!");
   }

    /**
     * remove a tweet
     * @param tweet the tweet you want to remove
     * @param account the account want to remove tweet
     */
   public static void removeTweet(Tweeting tweet, Account account) {
       database.removeTweet(tweet,account);
   }

    /**
     * Like a tweet
     * @param tweet the tweet you want to like
     * @param user the user that want to like
     */
   public static void LikeTweet(Tweeting tweet, Account user) {
       database.addLike(tweet,user);
   }

   /**
     * unLike a tweet
     * @param tweet the tweet you want to unlike
     * @param user the user that want to unlike
     */
    public static void unLikeTweet(Tweeting tweet, Account user) {
        database.unLike(tweet,user);
    }

    /**
     * This method add reply to a tweet
     * @param tweet the tweet that you want to reply to it
     * @param reply the reply
     */
    public static void replyTweet(Tweeting tweet, Tweeting reply){
        database.addReply(tweet,reply);
    }

    /**
     * This method remove reply from a tweet
     * @param tweet the tweet you want to remove reply from it
     * @param reply the reply
     */
    public static void removeReplyTweet(Tweeting tweet, Tweeting reply){
        database.removeReply(tweet,reply);
    }

    /**
     * This method retweets from another tweet
     * @param tweet the tweet you want to retweet
     * @param account the account want to retweet
     */

    public static void retweet(Tweeting tweet, Account account){
        database.retweet(tweet,account);
    }

}
