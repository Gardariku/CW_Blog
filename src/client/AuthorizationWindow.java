package client;

import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AuthorizationWindow extends JFrame{
    public String name;
    public String position;
    public String password;
    public String surname;
    public String middle_name;
    public int workerId;

    public AuthorizationWindow() throws IOException{

        setTitle("Авторизация");
        setBounds(200, 200, 400, 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.DARK_GRAY);
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        add(jp);
        JMenuBar jmenubar = new JMenuBar();
        jmenubar.setBounds(0,0,20,20);
        jp.add(jmenubar, BorderLayout.PAGE_START);
        JMenu jmenu = new JMenu("File");
        jmenubar.add(jmenu);
        JMenuItem exit = new JMenuItem("Exit");
        jmenu.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);

            }
        });
        JPanel jp1 = new JPanel();
        jp1.setLayout(new GridLayout(4, 1));
        JPanel jp2 = new JPanel();
        jp2.setLayout(new GridLayout(3, 1));
        jp.add(jp1, BorderLayout.CENTER);
        JLabel jLabel1 = new JLabel("Имя пользователя:");
        jp1.add(jLabel1);
        JTextField login = new JTextField();
//        textField.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    String command = textField.getText();
//                    Statement statement = connection.createStatement();
//                    statement.executeUpdate(command);
//                }  catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//        });
        jp1.add(login);
        JLabel jLabel2 = new JLabel("Пароль:");
        jp1.add(jLabel2);
        JTextField password = new JTextField();
        jp1.add(password);
        JButton jButton = new JButton("Отправить");
        AuthService authService = (AuthService) MainApp.factory.create(AuthService.class, MainApp.serverAddress + "AuthService");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (authService.Auth(login.getText(), password.getText())){
                        try {
                            UserWindow userWindow = new UserWindow(login.getText());
                        }
                        catch (IOException e2) {
                            // Handle IOException
                        }
                    }
            }
        });
        jp.add(jp2, BorderLayout.PAGE_END);
        jp2.add(jButton);
        JButton jButton1 = new JButton("Регистрация");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    RegistrationWindow registrationWindow = new RegistrationWindow();
                }
                catch (IOException e2) {
                    // Handle IOException
                }

            }
        });
        jp2.add(jButton1);
        JButton jButton2 = new JButton("Вход под Гостем");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GuestWindow guestWindow = new GuestWindow();
                }
                catch (IOException e2) {
                    // Handle IOException
                }
                }
        });
        jp2.add(jButton2);
        setVisible(true);
    }
}

