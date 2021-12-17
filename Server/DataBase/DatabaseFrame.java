package Server.DataBase;

import Server.server.Account;
import Server.tweet.ReTweet;
import Server.tweet.Tweeting;

import java.util.ArrayList;
import java.util.HashSet;

public interface DatabaseFrame {

    /**
     * This method add a new account
     * @param account the account you want to add
     */
    void addAccount(Account account);
    /**
     * This method remove an account
     * @param account the account you want to remove
     */
    void removeAccount(Account account);
    /**
     * this method is adding a tweet
     * @param tweet the tweet you want to create
     * @param account the account want to create tweet
     */
    void addTweet(Tweeting tweet,Account account);
    /**
     * This method remove a Tweet
     * @param tweet the tweet you want to create
     * @param account the account want to create tweet
     */
    void removeTweet(Tweeting tweet,Account account);

    /**
     * this method like a tweet
     * @param tweet the tweet you want to like
     * @param account the account that want to like
     */
    void addLike(Tweeting tweet,Account account);
    /**
     * This method unlike a tweet
     * @param tweet the tweet you want to unlike
     * @param account the account want to unlike
     */
    void unLike(Tweeting tweet, Account account);
    /**
     * This method follow an account
     * @param follower the account that follow an account
     * @param followed the account that is followed by an account
     */
    void follow(Account follower, Account followed);
    /**
     * This method unfollow an account
     * @param follower the account that unfollow an account
     * @param followed the account that is unfollowed by an account
     */
    void unFollow(Account follower, Account followed);
    /**
     * This method add a mew Reply
     * @param tweet the tweet you want to reply to it
     * @param reply the reply(Tweeting)
     */
    void addReply(Tweeting tweet,Tweeting reply);
    /**
     * This method add a mew Reply
     * @param tweet the tweet you want to reply to it
     * @param reply the reply(Tweeting)
     */
    void removeReply(Tweeting tweet,Tweeting reply);

    /**
     * This method retweets a tweet
     * @param tweet the tweet you want to retweet
     * @param reTweeter the account that retweet from tweet
     */
    void retweet(Tweeting tweet, Account reTweeter);
    /**
     * This method add a notification
     * @param account the account that get the notification
     * @param text the notification
     */
    void addNotification(Account account,String text);
    /**
     * The Getter for Tweets
     * @param account the account you want to get its tweets
     * @return list of tweets
     */
    ArrayList<Tweeting> getTweets(Account account);
    /**
     * The Getter for Likes
     * @param tweet the tweet you want to get it likes
     * @return list of likes
     */
    HashSet<Account> getLikes(Tweeting tweet);

    /**
     * The Getter for followers
     * @param account the account you want to get its followers
     * @return the list of Followers
     */
    HashSet<Account> getFollowers(Account account);
    /**
     * The Getter for Account by parameter tweet
     * @param tweet the Tweet that you want to get account of that
     * @return the account of the tweet
     */
    Account getAccountByTweet(Tweeting tweet);
    /**
     * The Getter for Account by parameter reply
     * @param reply the reply that you want to get the account
     * @return return the account of reply(replier) if exist/ else return null
     */
    Account getAccountByReply(Tweeting reply);
    /**
     * The Getter of TweetReplies
     * @param tweet the tweet you want to get the list of reply
     * @return the list of reply
     */
    ArrayList<Tweeting> getTweetReplies(Tweeting tweet);
    /**
     * The Getter for AccountReplies(It shows every reply that have been done by this account )
     * @param account the account you want to get the list of replies
     * @return the list of replies
     */
    ArrayList<Tweeting> getAccountReplies(Account account);
    /**
     * The Getter for retweet
     * @param account the account you want to get the list of retweet
     * @return list of retweet
     */
    ArrayList<Tweeting> getRetweets(Account account);
    /**
     * The getter for accountRetweets
     * @param tweet the tweet you want to get list of reTweeter(account)
     * @return the list of reTweeter(account)
     */
    ArrayList<Account> getAccountRetweets(Tweeting tweet);
    /**
     * The Getter for Account by parameter retweet
     * @param reTweet the retweet that you want to get the account
     * @return return the account of retweet(reTweeter) if exist/ else return null
     */
    Account getAccountByRetweet(ReTweet reTweet);
    /**
     * the method that check whether the
     * username is in tweets.keyset() or not
     * tweets.keyset() have list of all accounts
     * @param UserName the username
     * @return the account with username
     */
    Account checkAccount(String UserName);

}
