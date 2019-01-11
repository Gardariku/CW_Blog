package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import api.EntriesService;
import server.Entry;

public class GuestWindow extends JFrame{

    JPanel jPanel2;
    Container container2;

    public GuestWindow() throws IOException {

        GuestWindow userWindow = this;
        this.setTitle("Добро пожаловать, Гость!");
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
            public void actionPerformed(ActionEvent e){
                userWindow.container2.removeAll();
                userWindow.container2.setSize(jPanel2.getWidth(), jPanel2.getHeight());
                int color = 0;
                List<Entry> ents = showService.ShowEntries("All");
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
            }
        });
        container.add(jButton2);
        jPanel1.add(container);
        jPanel2.add(container2);
        this.setVisible(true);

    }
}
