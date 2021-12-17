package Server.tweet;
import Server.DataBase.Database;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This Class represents tweet
 */
public class Tweet implements Tweeting {
  protected Database database = new Database();
  protected static int tweetID;
  private int ID;
  protected String content;
  protected LocalDateTime currentDate;

    /**
     * The Tweet class constructor
     * @param content the content
     */
  public Tweet(String content) {
    this.content=content;
    currentDate=LocalDateTime.now();
    tweetID++;
  }

/////////// The General detail method ////////////

   @Override
   public int getTweetID(){
        return tweetID;
    }

   @Override
   public String getContent(){
        return content;
    }


///////////////// The Date method ///////////////

   @Override
   public LocalDateTime getDate() {
      return currentDate;
    }
   @Override
   public String getDateString(){
      return currentDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
    }

    @Override
    public boolean equals(Object o){
      if(!(o instanceof Tweet))
          return false;
      Tweet t = (Tweet) o;
      return this.content.equals(t.content) && tweetID == t.getTweetID();
    }
    @Override
    public String toString() {
        return dateAndNameBuilder(database.getAccountByTweet(this).getUserName(), getDateString()) + "\n" +
                contentBuild(getContent()) + "Like(" + database.getLikes(this).size() +
                ")\t\tReply(" + database.getTweetReplies(this).size() + ")" + "\t\tRetweet("
                + database.getAccountRetweets(this).size() + ")\n";
    }
    /**
     * this method design the content
     * it means that add \n if the character of a line become bigger than 60
     * if a line is incomplete it is adding space
     * also it is adding '|' at the first and end of line
     * @param content the content you want to design
     * @return the designed content
     */
    private String contentBuild(String content) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = content.length();
        // point means in which line we are
        int point = 1;
        for (int i = 0; i < size; ) {
            stringBuilder.append("|");
            // if size/40 == 0 so, it means that
            // the line is incomplete and add space
            if (size / 60 == 0) {
                int space = 60 - size % 60;
                // it appends the current line to stringBuilder
                stringBuilder.append(content, (point - 1) * 60, point * 60 - space);
                stringBuilder.append(" ".repeat(space));
            }
            // if size/60 != 0 so, it means that
            // the line is complete so,it just appends the
            // current line to stringBuilder
            else
                stringBuilder.append(content, (point - 1) * 60, point * 60);
            stringBuilder.append("|\n");
            size -= point * 60;
            point++;
        }
        return stringBuilder.toString();
    }


    /**
     * This method design the Date and Name
     * It means that after printing name
     * it add some spaces and then print the date
     * @param name the name
     * @param date the date
     * @return the designed string
     */
    private String dateAndNameBuilder(String name, String date) {
        StringBuilder build=new StringBuilder();
        build.append("|").append(name);
        int space=60-(name.length()+date.length());
        build.append(" ".repeat(space));
        build.append(date).append("|");
        return build.toString();
    }
//    @Override
//    public int compareTo(Tweeting o) {
//        return currentDate.compareTo(o.getDate());
//    }
}
