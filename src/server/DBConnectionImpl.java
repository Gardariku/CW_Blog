package server;

import api.DBConnection;
import com.caucho.hessian.server.HessianServlet;

import java.sql.SQLException;

public class DBConnectionImpl extends HessianServlet implements DBConnection {

    public static Database db;

    @Override
    public void Connect() {
        Database database = new Database();
        try {
            database.connect();
            db = database;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("EZY");
    }

    public static Database getConnect() {
        return db;
    }
}
