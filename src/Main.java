import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        try {
            database.connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        AuthorizationWindow authorizationWindow = new AuthorizationWindow(database, database.connection);
//        if (authorizationWindow.usercode == 1){
//            WorkerWindow workerWindow = new WorkerWindow(database);
//        }
//        AdminWindow adminWindow = new AdminWindow(database, database.connection);

    }
}
