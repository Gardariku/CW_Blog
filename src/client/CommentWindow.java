package client;

import api.CommentsService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;

public class CommentWindow extends JFrame{

    public CommentWindow(String login, int ID) throws IOException {

        CommentsService commsService = (CommentsService) MainApp.factory.create(CommentsService.class, MainApp.serverAddress + "CommentsService");
        CommentWindow postAdding = this;
        this.setTitle("Добавление нового комментария");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(200, 200, 500, 500);
        this.setLayout(new BorderLayout());
        JPanel jPanel = new JPanel(new GridLayout(1, 1));
        this.add(jPanel, BorderLayout.NORTH);
        JLabel jLabel2 = new JLabel("Текст комментария:");
        jPanel.add(jLabel2);
        JTextArea jTextArea = new JTextArea();
        this.add(jTextArea, BorderLayout.CENTER);
        JButton jButton = new JButton("Добавить");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = "insert into Comments (PostID, Author, Date, Text) values ('" + ID + "', '" + login + "', '" + Date.from(Instant.now()) +  "', '" + jTextArea.getText() + "');";
                commsService.AddComment(ID, login, jTextArea.getText());
                postAdding.dispose();
            }
        });
        this.add(jButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
