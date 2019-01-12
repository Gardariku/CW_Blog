package server;

import api.CommentsService;
import com.caucho.hessian.server.HessianServlet;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CommentsServiceImpl extends HessianServlet implements CommentsService {

    @Override
    public List<Comment> ShowComments(int PostID) {
        try {
            Database db = DBConnectionImpl.getConnect();
            Statement statement = db.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Comments where PostID = " + PostID + ";");
            List<Comment> comms = new ArrayList<Comment>();
            int color = 0;
            while (resultSet.next()){
                Comment com = new Comment();
                com.Date = resultSet.getString("Date");
                com.Author = resultSet.getString("Author");
                com.Text = resultSet.getString("Text");
                com.PostID = PostID;
                comms.add(com);
            }
            return comms;

        } catch (SQLException e1) {
            e1.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean AddComment(int ID, String login, String text) {
        try {
            Database db = DBConnectionImpl.getConnect();
            String command = "insert into Comments (PostID, Author, Date, Text) values ('" + ID + "', '" + login + "', '" + Date.from(Instant.now()) +  "', '" + text + "');";
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
