package client;

import api.DBConnection;
import com.caucho.hessian.client.HessianProxyFactory;

import java.io.IOException;

public class MainApp {
    static HessianProxyFactory factory = new HessianProxyFactory();

    static String serverAddress = "http://localhost:8080/";
    public static void main(String[] args) {
        try {
            MainApp.factory.setOverloadEnabled(true);
            DBConnection dbService = (DBConnection) MainApp.factory.create(DBConnection.class, MainApp.serverAddress + "DBConnection");
            dbService.Connect();
            AuthorizationWindow authorizationWindow = new AuthorizationWindow();
        }
        catch (IOException e) {
            // Handle IOException
        }
    }
//        if (authorizationWindow.usercode == 1){
//            WorkerWindow workerWindow = new WorkerWindow(database);
//        }
//        AdminWindow adminWindow = new AdminWindow(database, database.connection);

}

