package Server.tweet;
public class ReTweet extends Tweet{

    /**
     * The Tweet class constructor
     *
     * @param content the content
     */
    public ReTweet(String content) {
        super(content);
    }
    @Override
    public String toString(){
        return "(retweeted from" + database.getAccountByRetweet(this) +")";
    }
}
