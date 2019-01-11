package server;

import api.AuthService;
import com.caucho.hessian.server.HessianServlet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthServiceImpl extends HessianServlet implements AuthService {
    public boolean Auth(String login, String pass)
    {
        Database db = DBConnectionImpl.getConnect();
        try {
            String command = "select * from Users where Login = '" + login + "' and Password = '" + pass + "';";
            Statement statement = db.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(command);
            resultSet.next();
            String position = resultSet.getString("login");
            if (position.equals(login)){
                return true;
            }
            else return false;
        }  catch (SQLException e1) {
            e1.printStackTrace();
        }
        return false;
    }
}
