import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommentList extends JFrame{

    JPanel jPanel2;
    Container container2;

    public CommentList(Database database, Connection connection, String login, int PostID){



        CommentList userWindow = this;
        this.setTitle("Просмотр комментариев");
        this.setSize(500, 500);
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
        try {
            userWindow.container2.removeAll();
            userWindow.container2.setSize(jPanel2.getWidth(),jPanel2.getHeight());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Comments where PostID = " + PostID + ";");
            int color = 0;
            while (resultSet.next()){
                JPanel jPanel3 = new JPanel(new GridLayout(3, 1));
                JLabel jLabel1 = new JLabel(resultSet.getString("Date"));
                JLabel jLabel2 = new JLabel(resultSet.getString("Author"));
                JLabel jLabel3 = new JLabel(resultSet.getString("Text"));
                jPanel3.add(jLabel1);
                jPanel3.add(jLabel2);
                jPanel3.add(jLabel3);
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
        JButton jButton = new JButton("Добавить комментарий");
        jButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        jButton.setSize(70, 10);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommentWindow commentWindow = new CommentWindow(database, connection, login, PostID);
            }
        });
        container.add(jButton);
        JButton jButton1 = new JButton("Обновить");
        jButton1.setAlignmentX(Component.LEFT_ALIGNMENT);
        jButton1.setSize(70, 10);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    userWindow.container2.removeAll();
                    userWindow.container2.setSize(jPanel2.getWidth(),jPanel2.getHeight());
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("select * from Comments where PostID = " + PostID + ";");
                    int color = 0;
                    while (resultSet.next()){
                        JPanel jPanel3 = new JPanel(new GridLayout(3, 1));
                        JLabel jLabel1 = new JLabel(resultSet.getString("Date"));
                        JLabel jLabel2 = new JLabel(resultSet.getString("Author"));
                        JLabel jLabel3 = new JLabel(resultSet.getString("Text"));
                        jPanel3.add(jLabel1);
                        jPanel3.add(jLabel2);
                        jPanel3.add(jLabel3);
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
                userWindow.revalidate();
                userWindow.repaint();
            }
        });
        container.add(jButton1);
        jPanel1.add(container);
        jPanel2.add(container2);
        this.setVisible(true);

    }
}
