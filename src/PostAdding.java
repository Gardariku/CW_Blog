import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;

public class PostAdding extends JFrame{

    public PostAdding(Database database, Connection connection, String login){

        PostAdding postAdding = this;
        this.setTitle("Добавление новой записи");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(200, 200, 500, 500);
        this.setLayout(new BorderLayout());
        JPanel jPanel = new JPanel(new GridLayout(5, 1));
        this.add(jPanel, BorderLayout.NORTH);
        JLabel jLabel = new JLabel("Заголовок:");
        jPanel.add(jLabel);
        JTextField jTextField = new JTextField();
        jPanel.add(jTextField);
        JLabel jLabel1 = new JLabel("Категория:");
        jPanel.add(jLabel1);
        JPanel jPanel1 = new JPanel(new GridLayout(1, 2));
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton jRadioButton = new JRadioButton("Математика");
        buttonGroup.add(jRadioButton);
        jPanel1.add(jRadioButton);
        JRadioButton jRadioButton1 = new JRadioButton("Физика");
        buttonGroup.add(jRadioButton1);
        jPanel1.add(jRadioButton1);
        jPanel.add(jPanel1);
        JLabel jLabel2 = new JLabel("Текст сообщения:");
        jPanel.add(jLabel2);
        JTextArea jTextArea = new JTextArea();
        this.add(jTextArea, BorderLayout.CENTER);
        JButton jButton = new JButton("Добавить");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String category = "Физика";
                    if (jRadioButton.isSelected()) category = "Математика";
                    String command = "insert into Posts (Title, Author, Date, Category, Text) values ('" + jTextField.getText() + "', '" + login + "', '" + Date.from(Instant.now()) +  "', '" + category +  "', '" + jTextArea.getText() + "');";
                    Statement statement = connection.createStatement();
                    statement.execute(command);
                    statement.close();
                    postAdding.dispose();
                }  catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        this.add(jButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
