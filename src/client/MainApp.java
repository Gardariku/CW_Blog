package client;


import com.caucho.hessian.client.HessianProxyFactory;

import java.io.IOException;

public class MainApp {
    static HessianProxyFactory factory = new HessianProxyFactory();
    static String serverAddress = "http://localhost:8080/";
    public static void main(String[] args) {
        try {
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

