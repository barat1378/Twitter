package Server.tweet;

public class Reply extends Tweet{

    /**
     * The Tweet class constructor
     *
     * @param content the content
     */
    public Reply(String content) {
        super(content);
    }
    @Override
    public String toString(){
        return super.toString().indent(2);
    }
}
