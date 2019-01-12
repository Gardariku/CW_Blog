package server;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class Database {
    Connection connection = null;
    ResultSet resultSet = null;

    /*public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:Chat.db");
    }*/
    public void connect() throws ClassNotFoundException, SQLException {
        Context initContext = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:C:/db/Chat.db";
            connection = DriverManager.getConnection(url);
        }
     catch (SQLException e) {
        System.out.println(e.getMessage());
    }
        /*(try {
            initContext = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        Context envContext  = null;
        try {
            envContext = (Context)initContext.lookup("java:/comp/env");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        DataSource dataSource = null;
        try {
            dataSource = (DataSource)envContext.lookup("jdbc/Chat");
        } catch (NamingException e) {
            e.printStackTrace();
        }*/

    }

}

