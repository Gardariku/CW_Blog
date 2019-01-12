package server;

import java.io.Serializable;
import java.util.Date;

 class Entry implements Serializable {
    String Title;
    String PostDate;
    String Author;
    String Text;

    String Category;

    int ID;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPostDate() {
        return PostDate;
    }

    public void setDate(String date) {
        PostDate = date;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

}
