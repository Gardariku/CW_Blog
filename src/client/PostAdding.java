package client;

import api.EntriesService;
import server.Entry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;

public class PostAdding extends JFrame{

    public PostAdding(String login) throws IOException {

        PostAdding pa = this;
        pa.setResizable(false);
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
        EntriesService addService = (EntriesService) MainApp.factory.create(EntriesService.class, MainApp.serverAddress + "EntriesService");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Entry entry = new Entry();
                entry.setCategory("Физика");
                if (jRadioButton.isSelected()) entry.setCategory("Математика");
                entry.setDate(Date.from(Instant.now()));
                entry.setAuthor(login);
                entry.setTitle(jTextField.getText());
                entry.setText(jTextArea.getText());
                addService.AddEntry(entry);
                pa.dispose();
            }
        });
        this.add(jButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
