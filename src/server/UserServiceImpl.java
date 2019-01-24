package server;

import api.UserService;
import com.caucho.hessian.server.HessianServlet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserServiceImpl extends HessianServlet implements UserService {
    @Override
    public User getUserInfo(boolean access, String login) {
        Database db = DBConnectionImpl.getConnect();
        try {
            Statement statement = db.connection.createStatement();
            ResultSet resultSet;
            User user = new User();
            resultSet = statement.executeQuery("select * from Users where Login = '" + login + "';");
            user.login = resultSet.getString("Login");
            user.firstName = resultSet.getString("FirstName");
            user.lastName = resultSet.getString("LastName");
            user.affix = resultSet.getString("Affix");
            user.birthDate = resultSet.getString("BirthDate");
            user.info = resultSet.getString("Info");
            user.password = access == true ? resultSet.getString("Password") : null;
            return user;

        } catch (SQLException e1) {
            e1.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean refreshUserInfo(User user) {
        Database db = DBConnectionImpl.getConnect();
        try {
            String command = "UPDATE Users SET Password = '" + user.getPassword() + "', Info = '" + user.getInfo() + "', FirstName = '" + user.getFirstName() + "', LastName = '" + user.getLastName() + "', Affix = '" + user.getAffix() + "', BirthDate = '" + user.getBirthDate() + "' WHERE Login = '" + user.getLogin() +"'";
            PreparedStatement statement = db.connection.prepareStatement(command);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return false;
        }
    }

}
