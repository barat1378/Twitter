package Server.DataBase;

import Server.server.Account;
import Server.tweet.ReTweet;
import Server.tweet.Tweeting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * This class represents a database
 * store all data of a Twitter(accounts,Tweets,notifications...)
 */
public class Database implements DatabaseFrame{
    //Map an account to list of followers(accounts)
    //because an account has multiple followers
    private final static HashMap<Account, HashSet<Account>> followers;
    //Map an account to list of tweets
    //because an account has multiple tweets
    private final static HashMap<Account, ArrayList<Tweeting>> tweets;
    //Map a Tweet to list of likes
    //because a tweet has multiple likes
    private final static HashMap<Tweeting,HashSet<Account>> likes;
    //Map a tweet to list of account who retweeted
    private final static HashMap<Tweeting,ArrayList<Account>> accountReTweets;
    //Map a tweet to list of replies(Tweeting)
    private final static HashMap<Tweeting,ArrayList<Tweeting>> tweetReplies;
    /* Map an account to list of replies that it has done
     فرق ریپلای اکانت با ریپلای توییت در این است که
    ریپلای توویت لیست ریپلای های یک توییت را نشان میدهد
    و اکانت ریپلای لیست ریپلای های را که یک اکانت انجام داده
     */
    private static final HashMap<Account,ArrayList<Tweeting>> accountReplies;
    private final static HashMap<Account,ArrayList<String>> notifications;
    private final static HashMap<Account,ArrayList<Tweeting>> retweets;


    static {
        tweets = new HashMap<>();
        likes = new HashMap<>();
        followers = new HashMap<>();
        accountReTweets = new HashMap<>();
        tweetReplies = new HashMap<>();
        retweets = new HashMap<>();
        notifications = new HashMap<>();
        accountReplies = new HashMap<>();
    }
//*****************************************************//
// ************** THE ADD/REMOVE METHODS ***************//
//****************************************************//
    /**
     * This method add a new account
     * when an account created the list of
     * tweets, followers, notifications, accountReplies
     * should be created
     * @param account the account you want to add
     */
    @Override
    public void addAccount(Account account) {
        tweets.put(account,new ArrayList<>());
        followers.put(account,new HashSet<>());
        notifications.put(account,new ArrayList<>());
        accountReplies.put(account,new ArrayList<>());
        retweets.put(account,new ArrayList<>());
    }

    /**
     * This method remove an account
     * when an account removed so the tweets, followers
     * notifications,accountReplies should also remove
     * @param account the account you want to remove
     */
    @Override
    public void removeAccount(Account account) {
        tweets.remove(account);
        followers.remove(account);
        notifications.remove(account);
        accountReplies.remove(account);
    }

    /**
     * this method is adding a tweet
     * when a tweet is created the list of
     * tweetReplies, likes, retweets should create
     * @param tweet the tweet you want to create
     * @param account the account want to create tweet
     */
    @Override
    public void addTweet(Tweeting tweet, Account account) {
        tweets.get(account).add(tweet);
        likes.put(tweet,new HashSet<>());
        tweetReplies.put(tweet,new ArrayList<>());
        accountReTweets.put(tweet,new ArrayList<>());
    }

    /**
     * This method remove a Tweet
     * @param tweet the tweet you want to create
     * @param account the account want to create tweet
     */
    @Override
    public void removeTweet(Tweeting tweet, Account account) {
        tweets.get(account).remove(tweet);
        likes.remove(tweet);
        tweetReplies.remove(tweet);
    }

    /**
     * this method like a tweet
     * @param tweet the tweet you want to like
     * @param account the account that want to like
     */
    @Override
    public void addLike(Tweeting tweet, Account account) {
       likes.get(tweet).add(account);
    }

    /**
     * This method unlike a tweet
     * @param tweet the tweet you want to unlike
     * @param account the account want to unlike
     */
    @Override
    public void unLike(Tweeting tweet, Account account) {
        likes.remove(tweet).remove(account);
    }

    /**
     * This method follow an account
     * @param follower the account that follow an account
     * @param followed the account that is followed by an account
     */
    @Override
    public void follow(Account follower, Account followed) {
        followers.get(followed).add(follower);
    }

    /**
     * This method unfollow an account
     * @param follower the account that unfollow an account
     * @param followed the account that is unfollowed by an account
     */
    @Override
    public void unFollow(Account follower, Account followed) {
        followers.get(followed).remove(follower);
    }

    /**
     * This method add a mew Reply
     * @param tweet the tweet you want to reply to it
     * @param reply the reply(Tweeting)
     */
    @Override
    public void addReply(Tweeting tweet, Tweeting reply) {
        tweetReplies.get(tweet).add(reply);
    }
    /**
     * This method remove a Reply
     * @param tweet the tweet you want to remove reply from
     * @param reply the reply(Tweeting)
     */
    @Override
    public void removeReply(Tweeting tweet, Tweeting reply) {
        tweetReplies.get(tweet).remove(reply);
    }
    /**
     * This method retweets a tweet
     * @param tweet the tweet you want to retweet
     * @param reTweeter the account that retweet from tweet
     */
    @Override
    public void retweet(Tweeting tweet, Account reTweeter){
        accountReTweets.get(tweet).add(reTweeter);
        retweets.get(reTweeter).add(tweet);
    }
    /**
     * This method add a notification
     * @param account the account that get the notification
     * @param text the notification
     */
    @Override
    public void addNotification(Account account, String text) {
        notifications.get(account).add(text);
    }

//***************************************************//
//*************** THE GETTER METHOD *****************//
//***************************************************//
    /**
     * The Getter for Tweets
     * @param account the account you want to get its tweets
     * @return list of tweets
     */
    @Override
    public ArrayList<Tweeting> getTweets(Account account) {
        return tweets.get(account);
    }

    /**
     * The Getter for Likes
     * @param tweet the tweet you want to get it likes
     * @return list of likes
     */
    @Override
    public HashSet<Account> getLikes(Tweeting tweet) {
        return likes.get(tweet);
    }

    /**
     * The Getter for followers
     * @param account the account you want to get its followers
     * @return the list of Followers
     */
    @Override
    public HashSet<Account> getFollowers(Account account) {
        return followers.get(account);
    }

    /**
     * The Getter for Account by parameter tweet
     * @param tweet the Tweet that you want to get account of that
     * @return the account of the tweet
     */
    @Override
    public Account getAccountByTweet(Tweeting tweet){
        for(Account a: tweets.keySet()){
            for(Tweeting t : tweets.get(a)){
                if(t.equals(tweet)){
                    return a;
                }
            }
        }
    return null;}

    /**
     * The Getter for Account by parameter reply
     * @param reply the reply that you want to get the account
     * @return return the account of reply(replier) if exist/ else return null
     */
    @Override
    public Account getAccountByReply(Tweeting reply){
        for(Account a: accountReplies.keySet()){
            for(Tweeting t : accountReplies.get(a)){
                if(t.equals(reply)){
                    return a;
                }
            }
        }
        return null;}
    /**
     * The Getter for Account by parameter retweet
     * @param reTweet the retweet that you want to get the account
     * @return return the account of retweet(reTweeter) if exist/ else return null
     */
    @Override
    public Account getAccountByRetweet(ReTweet reTweet){
        for (Account a: retweets.keySet()) {
            for (Tweeting t : retweets.get(a)) {
                if (t.equals(reTweet)) {
                    return a;
                }
            }
        }
        return null;
    }


    /**
     * The Getter of TweetReplies
     * @param tweet the tweet you want to get the list of reply
     * @return the list of reply
     */
    @Override
    public ArrayList<Tweeting> getTweetReplies(Tweeting tweet) {
        return tweetReplies.get(tweet);
    }

    /**
     * The Getter for AccountReplies(It shows every reply that have been done by this account )
     * @param account the account you want to get the list of replies
     * @return the list of replies
     */
    @Override
    public ArrayList<Tweeting> getAccountReplies(Account account){
        return accountReplies.get(account);
    }

    /**
     * The Getter for retweet
     * @param account the account you want to get the list of retweet
     * @return list of retweet
     */
    @Override
    public ArrayList<Tweeting> getRetweets(Account account) {
        return retweets.get(account);
    }

    /**
     * The getter for accountRetweets
     * @param tweet the tweet you want to get list of reTweeter(account)
     * @return the list of reTweeter(account)
     */
    @Override
    public ArrayList<Account> getAccountRetweets(Tweeting tweet){
        return accountReTweets.get(tweet);
    }

    /**
     * the method that check whether the
     * username is in tweets.keyset() or not
     * tweets.keyset() have list of all accounts
     * @param UserName the username
     * @return the account with username
     */
    public Account checkAccount(String UserName){
        for(Account a: tweets.keySet()){
            if(a.getUserName().equals(UserName)){
                return a;
            }
        }
        return null;
    }

}
