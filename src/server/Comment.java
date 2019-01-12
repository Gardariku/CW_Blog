package server;

import java.io.Serializable;

public class Comment implements Serializable {
    int PostID;
    String Date;
    String Author;
    String Text;

    public int getPostID() {
        return PostID;
    }

    public void setPostID(int postID) {
        PostID = postID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }


}
