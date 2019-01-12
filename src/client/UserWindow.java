package client;

import api.EntriesService;
import server.Entry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class UserWindow extends JFrame{

    JPanel jPanel2;
    Container container2;

    public UserWindow(String login) throws IOException {

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
        EntriesService showService = (EntriesService) MainApp.factory.create(EntriesService.class, MainApp.serverAddress + "EntriesService");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userWindow.container2.removeAll();
                userWindow.container2.setSize(jPanel2.getWidth(), jPanel2.getHeight());
                int color = 0;
                List<Entry> ents = showService.ShowEntries("All");
                for (Entry i : ents) {
                    JPanel jPanel3 = new JPanel(new GridLayout(4, 1));
                    JLabel jLabel = new JLabel(i.getTitle());
                    JLabel jLabel1 = new JLabel(i.getPostDate().toString());
                    JLabel jLabel2 = new JLabel(i.getAuthor());
                    JLabel jLabel3 = new JLabel(i.getText());
                    int number = i.getID();
                    JButton jButton2 = new JButton("Просмотр комментариев");
                    jButton2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                CommentList commentList = new CommentList(login, number);
                            }
                            catch (IOException e2) {
                                // Handle IOException
                            }
                        }
                    });
                    JButton jButton3 = new JButton("Оставить комментарий");
                    jButton3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                CommentWindow commentWindow = new CommentWindow(login, number);
                            }
                            catch (IOException e2) {
                                // Handle IOException
                            }
                        }
                    });
                    jPanel3.add(jLabel);
                    jPanel3.add(jLabel1);
                    jPanel3.add(jLabel2);
                    jPanel3.add(jLabel3);
                    jPanel3.add(jButton2);
                    jPanel3.add(jButton3);
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
            }
        });
        container.add(jButton);
        JButton jButton1 = new JButton("Математика");
        jButton1.setAlignmentX(Component.LEFT_ALIGNMENT);
        jButton1.setSize(70, 10);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userWindow.container2.removeAll();
                userWindow.container2.setSize(jPanel2.getWidth(), jPanel2.getHeight());
                int color = 0;
                List<Entry> ents = showService.ShowEntries("History");
                for (Entry i : ents) {
                    JPanel jPanel3 = new JPanel(new GridLayout(4, 1));
                    JLabel jLabel = new JLabel(i.getTitle());
                    JLabel jLabel1 = new JLabel(i.getPostDate().toString());
                    JLabel jLabel2 = new JLabel(i.getAuthor());
                    JLabel jLabel3 = new JLabel(i.getText());
                    int number = i.getID();
                    JButton jButton2 = new JButton("Просмотр комментариев");
                    jButton2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                CommentList commentList = new CommentList(login, number);
                            }
                            catch (IOException e2) {
                                // Handle IOException
                            }
                        }
                    });
                    JButton jButton3 = new JButton("Оставить комментарий");
                    jButton3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                CommentWindow commentWindow = new CommentWindow(login, number);
                            }
                            catch (IOException e2) {
                                // Handle IOException
                            }
                        }
                    });
                    jPanel3.add(jLabel);
                    jPanel3.add(jLabel1);
                    jPanel3.add(jLabel2);
                    jPanel3.add(jLabel3);
                    jPanel3.add(jButton2);
                    jPanel3.add(jButton3);
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
            }
        });
        container.add(jButton1);
        JButton jButton2 = new JButton("Физика");
        jButton2.setAlignmentX(Component.LEFT_ALIGNMENT);
        jButton2.setSize(70, 10);
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userWindow.container2.removeAll();
                userWindow.container2.setSize(jPanel2.getWidth(), jPanel2.getHeight());
                int color = 0;
                List<Entry> ents = showService.ShowEntries("Travels");
                for (Entry i : ents) {
                    JPanel jPanel3 = new JPanel(new GridLayout(4, 1));
                    JLabel jLabel = new JLabel(i.getTitle());
                    JLabel jLabel1 = new JLabel(i.getPostDate().toString());
                    JLabel jLabel2 = new JLabel(i.getAuthor());
                    JLabel jLabel3 = new JLabel(i.getText());
                    int number = i.getID();
                    JButton jButton2 = new JButton("Просмотр комментариев");
                    jButton2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                CommentList commentList = new CommentList(login, number);
                            }
                            catch (IOException e2) {
                                // Handle IOException
                            }
                        }
                    });
                    JButton jButton3 = new JButton("Оставить комментарий");
                    jButton3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                CommentWindow commentWindow = new CommentWindow(login, number);
                            }
                            catch (IOException e2) {
                                // Handle IOException
                            }
                        }
                    });
                    jPanel3.add(jLabel);
                    jPanel3.add(jLabel1);
                    jPanel3.add(jLabel2);
                    jPanel3.add(jLabel3);
                    jPanel3.add(jButton2);
                    jPanel3.add(jButton3);
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
            }
        });
        container.add(jButton2);
        JButton jButton3 = new JButton("Добавить запись");
        jButton3.setAlignmentX(Component.LEFT_ALIGNMENT);
        jButton3.setSize(70, 10);
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PostAdding postAdding = new PostAdding(login);
                }
                catch (IOException e2) {
                    // Handle IOException
                }
            }
        });
        container.add(jButton3);
        jPanel1.add(container);
        jPanel2.add(container2);
        this.setVisible(true);

    }
}
