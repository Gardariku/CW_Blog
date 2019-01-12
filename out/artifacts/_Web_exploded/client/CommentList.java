package client;

import api.CommentsService;
import api.EntriesService;
import server.Comment;
import server.Entry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class CommentList extends JFrame{

    JPanel jPanel2;
    Container container2;

    public CommentList(String login, int PostID) throws IOException {

        EntriesService showService = (EntriesService) MainApp.factory.create(EntriesService.class, MainApp.serverAddress + "EntriesService");
        CommentsService commsService = (CommentsService) MainApp.factory.create(CommentsService.class, MainApp.serverAddress + "CommentsService");
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
        userWindow.container2.removeAll();
        userWindow.container2.setSize(jPanel2.getWidth(),jPanel2.getHeight());
        int color = 0;

        List<Comment> comms = commsService.ShowComments(PostID);
        for (Comment i: comms){
            JPanel jPanel3 = new JPanel(new GridLayout(3, 1));
            JLabel jLabel1 = new JLabel(i.getDate());
            JLabel jLabel2 = new JLabel(i.getAuthor());
            JLabel jLabel3 = new JLabel(i.getText());
            jPanel3.add(jLabel1);
            jPanel3.add(jLabel2);
            jPanel3.add(jLabel3);
            if (color == 0){
                color = 1;
                jPanel3.setBackground(Color.WHITE);
            } else {
                color = 0;
                jPanel3.setBackground(Color.LIGHT_GRAY);
            }
            jPanel3.setAlignmentX(Component.LEFT_ALIGNMENT);
            userWindow.container2.add(jPanel3);
            userWindow.revalidate();
        }

        JButton jButton = new JButton("Добавить комментарий");
        jButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        jButton.setSize(70, 10);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CommentWindow commentWindow = new CommentWindow(login, PostID);
                }
                catch (IOException e2) {
                    // Handle IOException
                }
            }
        });
        container.add(jButton);
        JButton jButton1 = new JButton("Обновить");
        jButton1.setAlignmentX(Component.LEFT_ALIGNMENT);
        jButton1.setSize(70, 10);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userWindow.container2.removeAll();
                userWindow.container2.setSize(jPanel2.getWidth(), jPanel2.getHeight());
                int color = 0;
                List<Entry> ents = showService.ShowEntries(PostID);
                for (Entry i : ents) {
                    JPanel jPanel3 = new JPanel(new GridLayout(4, 1));
                    JLabel jLabel = new JLabel(i.getTitle());
                    JLabel jLabel1 = new JLabel(i.getDate().toString());
                    JLabel jLabel2 = new JLabel(i.getAuthor());
                    JLabel jLabel3 = new JLabel(i.getText());
                    jPanel3.add(jLabel);
                    jPanel3.add(jLabel1);
                    jPanel3.add(jLabel2);
                    jPanel3.add(jLabel3);
                    if (color == 0) {
                        color = 1;
                        jPanel3.setBackground(Color.WHITE);
                    } else {
                        color = 0;
                        jPanel3.setBackground(Color.LIGHT_GRAY);
                    }
                    userWindow.container2.add(jPanel3);
                    jPanel3.setAlignmentX(Component.LEFT_ALIGNMENT);
                    userWindow.revalidate();
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
