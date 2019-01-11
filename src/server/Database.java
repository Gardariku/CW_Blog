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
            dataSource = (DataSource)envContext.lookup("jdbc/chat");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        Connection connection = dataSource.getConnection();
    }

}

