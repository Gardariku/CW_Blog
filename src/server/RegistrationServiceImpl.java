package server;

import api.RegistrationService;
import com.caucho.hessian.server.HessianServlet;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;

public class RegistrationServiceImpl extends HessianServlet implements RegistrationService {
    public boolean Registrate(String login, String pass)
    {
        Database db = DBConnectionImpl.getConnect();
        try {
            String command = "insert into Users (Login, Password, Date) values ('" + login + "', '" + pass + "', '" + Date.from(Instant.now()) + "');";
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