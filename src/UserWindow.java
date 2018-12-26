import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserWindow extends JFrame{

    JPanel jPanel2;
    Container container2;

    public UserWindow(Database database, Connection connection, String login){



        UserWindow userWindow = this;
        this.setTitle("Добро пожаловать, " + login +"!");
        this.setSize(1000, 900);
        JPanel jPanel = new JPanel(new BorderLayout());
        this.add(jPanel);
        Container container = new Container();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container2 = new Container();
        container2.setLayout(new BoxLayout(container2, BoxLayout.Y_AXIS));
        container2.setBackground(Color.WHITE);

        JPanel jPanel1 = new JPanel();
        jPanel.add(jPanel1, BorderLayout.WEST);
        jPanel2 = new JPanel();

        jPanel.add(jPanel2, BorderLayout.CENTER);
        JButton jButton = new JButton("Все темы");
        jButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        jButton.setSize(70, 10);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    userWindow.container2.removeAll();
                    userWindow.container2.setSize(jPanel2.getWidth(),jPanel2.getHeight());
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("select * from Posts");
                    int color = 0;
                    while (resultSet.next()){
                        JPanel jPanel3 = new JPanel(new GridLayout(6, 1));
                        JLabel jLabel = new JLabel(resultSet.getString("Title"));
                        JLabel jLabel1 = new JLabel(resultSet.getString("Date"));
                        JLabel jLabel2 = new JLabel(resultSet.getString("Author"));
                        JLabel jLabel3 = new JLabel(resultSet.getString("Text"));
                        int number = resultSet.getInt("ID");
                        JButton jButton2 = new JButton("Просмотр комментариев");
                        jButton2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CommentList commentList = new CommentList(database, connection, login, number);
                            }
                        });
                        JButton jButton3 = new JButton("Оставить комментарий");
                        jButton3.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CommentWindow commentWindow = new CommentWindow(database, connection, login, number);
                            }
                        });
                        jPanel3.add(jLabel);
                        jPanel3.add(jLabel1);
                        jPanel3.add(jLabel2);
                        jPanel3.add(jLabel3);
                        jPanel3.add(jButton2);
                        jPanel3.add(jButton3);
                        if (color == 0){
                            color = 1;
                            jPanel3.setBackground(Color.WHITE);
                        }else{
                            color = 0;
                            jPanel3.setBackground(Color.LIGHT_GRAY);
                        }
                        jPanel3.setAlignmentX(Component.LEFT_ALIGNMENT);
                        userWindow.container2.add(jPanel3);
                        userWindow.revalidate();
                    }

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        container.add(jButton);
        JButton jButton1 = new JButton("Математика");
        jButton1.setAlignmentX(Component.LEFT_ALIGNMENT);
        jButton1.setSize(70, 10);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    userWindow.container2.removeAll();
                    userWindow.container2.setSize(jPanel2.getWidth(),jPanel2.getHeight());
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("select * from Posts where category = 'Математика'");
                    int color = 0;
                    while (resultSet.next()){
                        JPanel jPanel3 = new JPanel(new GridLayout(6, 1));
                        JLabel jLabel = new JLabel(resultSet.getString("Title"));
                        JLabel jLabel1 = new JLabel(resultSet.getString("Date"));
                        JLabel jLabel2 = new JLabel(resultSet.getString("Author"));
                        JLabel jLabel3 = new JLabel(resultSet.getString("Text"));
                        int number = resultSet.getInt("ID");
                        JButton jButton2 = new JButton("Просмотр комментариев");
                        jButton2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CommentList commentList = new CommentList(database, connection, login, number);
                            }
                        });
                        JButton jButton3 = new JButton("Оставить комментарий");
                        jButton3.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CommentWindow commentWindow = new CommentWindow(database, connection, login, number);
                            }
                        });
                        jPanel3.add(jLabel);
                        jPanel3.add(jLabel1);
                        jPanel3.add(jLabel2);
                        jPanel3.add(jLabel3);
                        jPanel3.add(jButton2);
                        jPanel3.add(jButton3);
                        if (color == 0){
                            color = 1;
                            jPanel3.setBackground(Color.WHITE);
                        }else{
                            color = 0;
                            jPanel3.setBackground(Color.LIGHT_GRAY);
                        }
                        jPanel3.setAlignmentX(Component.LEFT_ALIGNMENT);
                        userWindow.container2.add(jPanel3);
                        userWindow.revalidate();
                    }

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        container.add(jButton1);
        JButton jButton2 = new JButton("Физика");
        jButton2.setAlignmentX(Component.LEFT_ALIGNMENT);
        jButton2.setSize(70, 10);
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    userWindow.container2.removeAll();
                    userWindow.container2.setSize(jPanel2.getWidth(),jPanel2.getHeight());
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("select * from Posts where category = 'Физика'");
                    int color = 0;
                    while (resultSet.next()){
                        JPanel jPanel3 = new JPanel(new GridLayout(6, 1));
                        JLabel jLabel = new JLabel(resultSet.getString("Title"));
                        JLabel jLabel1 = new JLabel(resultSet.getString("Date"));
                        JLabel jLabel2 = new JLabel(resultSet.getString("Author"));
                        JLabel jLabel3 = new JLabel(resultSet.getString("Text"));
                        int number = resultSet.getInt("ID");
                        JButton jButton2 = new JButton("Просмотр комментариев");
                        jButton2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CommentList commentList = new CommentList(database, connection, login, number);
                            }
                        });
                        JButton jButton3 = new JButton("Оставить комментарий");
                        jButton3.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CommentWindow commentWindow = new CommentWindow(database, connection, login, number);
                            }
                        });
                        jPanel3.add(jLabel);
                        jPanel3.add(jLabel1);
                        jPanel3.add(jLabel2);
                        jPanel3.add(jLabel3);
                        jPanel3.add(jButton2);
                        jPanel3.add(jButton3);
                        if (color == 0){
                            color = 1;
                            jPanel3.setBackground(Color.WHITE);
                        }else{
                            color = 0;
                            jPanel3.setBackground(Color.LIGHT_GRAY);
                        }
                        jPanel3.setAlignmentX(Component.LEFT_ALIGNMENT);
                        userWindow.container2.add(jPanel3);
                        userWindow.revalidate();
                    }

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        container.add(jButton2);
        JButton jButton3 = new JButton("Добавить запись");
        jButton3.setAlignmentX(Component.LEFT_ALIGNMENT);
        jButton3.setSize(70, 10);
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PostAdding postAdding = new PostAdding(database, connection, login);
            }
        });
        container.add(jButton3);
        jPanel1.add(container);
        jPanel2.add(container2);
        this.setVisible(true);

    }
}
