package server;

import java.sql.*;

public class Database {
    Connection connection = null;
    ResultSet resultSet = null;

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:Chat.db");
    }

}

