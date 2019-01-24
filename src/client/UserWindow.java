package client;

import api.EntriesService;
import api.UserService;
import server.Entry;
import server.User;

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
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel entPanel = new JPanel(new BorderLayout());
        JPanel userPanel = new JPanel(new GridLayout(8,2,30,50));
        tabbedPane.addTab("Записи", entPanel);
        tabbedPane.addTab("Профиль", userPanel);
        this.add(tabbedPane);
        Container container = new Container();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container2 = new Container();
        container2.setLayout(new BoxLayout(container2, BoxLayout.Y_AXIS));
        container2.setBackground(Color.WHITE);

        JPanel jPanel1 = new JPanel();
        entPanel.add(jPanel1, BorderLayout.WEST);
        jPanel2 = new JPanel();

        entPanel.add(jPanel2, BorderLayout.CENTER);
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
                    JPanel jPanel3 = new JPanel(new GridLayout(4, 1, 20, 20));
                    JLabel jLabel = new JLabel(i.getTitle());
                    JLabel jLabel1 = new JLabel(i.getPostDate().toString());
                    JButton jLabel2 = new JButton(i.getAuthor());
                    jLabel2.setBorderPainted( false );
                    jLabel2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                ProfileWindow profileWindow = new ProfileWindow(i.getAuthor());
                            }
                            catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
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
                                e2.printStackTrace();
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
                                e2.printStackTrace();
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
                    JPanel jPanel3 = new JPanel(new GridLayout(4, 1, 20 ,20));
                    JLabel jLabel = new JLabel(i.getTitle());
                    JLabel jLabel1 = new JLabel(i.getPostDate().toString());
                    JButton jLabel2 = new JButton(i.getAuthor());
                    jLabel2.setBorderPainted( false );
                    jLabel2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                ProfileWindow profileWindow = new ProfileWindow(i.getAuthor());
                            }
                            catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
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
                                e2.printStackTrace();
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
                                e2.printStackTrace();
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
                    JPanel jPanel3 = new JPanel(new GridLayout(4, 1, 20, 20));
                    JLabel jLabel = new JLabel(i.getTitle());
                    JLabel jLabel1 = new JLabel(i.getPostDate().toString());
                    JButton jLabel2 = new JButton(i.getAuthor());
                    jLabel2.setBorderPainted( false );
                    jLabel2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                ProfileWindow profileWindow = new ProfileWindow(i.getAuthor());
                            }
                            catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
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
                                e2.printStackTrace();
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
                                e2.printStackTrace();
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
                    e2.printStackTrace();
                }
            }
        });
        container.add(jButton3);
        jPanel1.add(container);
        jPanel2.add(container2);

        userPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        UserService userService = (UserService) MainApp.factory.create(UserService.class, MainApp.serverAddress + "UserService");

        User currentUser = userService.getUserInfo(true, login);
        JLabel jLabel1 = new JLabel("Имя пользователя:");
        userPanel.add(jLabel1);
        JTextField name = new JTextField();
        name.setText(currentUser.getLogin());
        userPanel.add(name);

        JLabel jLabel2 = new JLabel("Пароль:");
        userPanel.add(jLabel2);
        JTextField password = new JTextField();
        password.setText(currentUser.getPassword());
        userPanel.add(password);

        JLabel jLabel3 = new JLabel("Имя:");
        userPanel.add(jLabel3);
        JTextField firstName = new JTextField();
        firstName.setText(currentUser.getFirstName());
        userPanel.add(firstName);

        JLabel jLabel4 = new JLabel("Фамилия:");
        userPanel.add(jLabel4);
        JTextField lastName = new JTextField();
        lastName.setText(currentUser.getLastName());
        userPanel.add(lastName);

        JLabel jLabel5 = new JLabel("Отчество:");
        userPanel.add(jLabel5);
        JTextField affix = new JTextField();
        affix.setText(currentUser.getAffix());
        userPanel.add(affix);

        JLabel jLabel6 = new JLabel("Дата рождения:");
        userPanel.add(jLabel6);
        JTextField birthDate = new JTextField();
        birthDate.setText(currentUser.getBirthDate());
        userPanel.add(birthDate);

        JLabel jLabel7 = new JLabel("Интересы:");
        userPanel.add(jLabel7);
        JTextField info = new JTextField();
        info.setText(currentUser.getInfo());
        userPanel.add(info);

        JButton jButtonSend = new JButton("Отправить");
        jButtonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentUser.setLogin(name.getText());
                currentUser.setPassword(password.getText());
                currentUser.setFirstName(firstName.getText());
                currentUser.setLastName(lastName.getText());
                currentUser.setAffix(affix.getText());
                currentUser.setBirthDate(birthDate.getText());
                currentUser.setInfo(info.getText());
                userService.refreshUserInfo(currentUser);
            }
        });
        userPanel.add(jButtonSend, BorderLayout.PAGE_END);


        this.setVisible(true);

    }
}
