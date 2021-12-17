package Server.server;

import Server.DataBase.Database;


/**
 * The observer class follow/unfollow an account
 */
public class ObserverService  {
    private static Database database = new Database();
    /**
     * The follow method follow an account
     * @param follower the account that follow an account
     * @param followed the account that is being followed by follower
     */
    public static void follow(Account follower, Account followed) {
        if(follower==null || followed == null) {
            System.out.println("follower or followed cannot be null");
            return;
        }
     database.follow(follower,followed);
    }

    /**
     * This method unfollow an account
     * @param unFollower the account that want to unfollow an account
     * @param unfollowed the account that is going to be unFollow
     */
    public static void unfollow(Account unFollower, Account unfollowed) {
        if(unFollower==null || unfollowed == null) {
            System.out.println("unFollower or unfollowed cannot be null");
            return;
        }
        database.follow(unFollower,unfollowed);
    }


}
