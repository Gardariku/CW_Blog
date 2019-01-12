package server;

import api.EntriesService;
import com.caucho.hessian.server.HessianServlet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EntriesServiceImpl extends HessianServlet implements EntriesService {
    public List<Entry> ShowEntries(String category)
    {
        Database db = DBConnectionImpl.getConnect();
        try {
            Statement statement = db.connection.createStatement();
            ResultSet resultSet = null;
            switch(category)
            {
                case "All": {
                    resultSet = statement.executeQuery("select * from Posts");
                    break;
                }
                case "History": {
                    resultSet = statement.executeQuery("select * from Posts where category = 'Математика'");
                }
                    break;
                case "Travels": {
                    resultSet = statement.executeQuery("select * from Posts where category = 'Физика'");
                    break;
                }
            }
            List<Entry> ents = new ArrayList<Entry>();
            int color = 0;
            while (resultSet.next()){
                Entry entry = new Entry();
                entry.Title = resultSet.getString("Title");
                entry.PostDate = resultSet.getString("Date");
                entry.Author = resultSet.getString("Author");
                entry.Text = resultSet.getString("Text");
                entry.ID = resultSet.getInt("ID");
                ents.add(entry);
            }
            return ents;

        } catch (SQLException e1) {
            e1.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Entry> ShowEntries(int ID) {
        Database db = DBConnectionImpl.getConnect();
        try {
            Statement statement = db.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Comments where PostID = " + ID + ";");
            List<Entry> ents = new ArrayList<Entry>();
            int color = 0;
            while (resultSet.next()){
                Entry entry = new Entry();
                entry.Title = resultSet.getString("Title");
                entry.PostDate = resultSet.getString("Date");
                entry.Author = resultSet.getString("Author");
                entry.Text = resultSet.getString("Text");
                entry.ID = resultSet.getInt("ID");
                ents.add(entry);
            }
            return ents;

        } catch (SQLException e1) {
            e1.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean AddEntry(Entry entry) {
        Database db = DBConnectionImpl.getConnect();
        try {
            String command = "insert into Posts (Title, Author, Date, Category, Text) values ('" + entry.getTitle() + "', '" + entry.getAuthor() + "', '" + entry.getPostDate() +  "', '" + entry.getCategory() +  "', '" + entry.getText() + "');";
            Statement statement = db.connection.createStatement();
            statement.execute(command);
            statement.close();
            return true;
        }  catch (SQLException e1) {
            e1.printStackTrace();
            return false;
        }
    }
}