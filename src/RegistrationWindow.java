import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;

public class RegistrationWindow extends JFrame{
    public String name;
    public String position;
    public String password;
    public String surname;
    public String middle_name;
    public int workerId;

    public RegistrationWindow(Database database, Connection connection){

        RegistrationWindow registrationWindow = this;
        setTitle("Регистрация");
        setBounds(200, 200, 400, 200);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String command = "insert into Users (Login, Password, Date) values ('" + login.getText() + "', '" + password.getText() + "', '" + Date.from(Instant.now()) + "');";
                    Statement statement = connection.createStatement();
                    statement.execute(command);
                    statement.close();
                    registrationWindow.setVisible(false);
                }  catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        jp.add(jButton, BorderLayout.PAGE_END);
        setVisible(true);
    }
}

