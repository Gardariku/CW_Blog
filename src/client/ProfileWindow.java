package client;

import api.UserService;
import server.User;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ProfileWindow extends JFrame {
    public ProfileWindow(String login) throws IOException {

        this.setSize(400, 400);
        JPanel userPanel = new JPanel(new GridLayout(6,2,30,50));
        userPanel.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
        this.add(userPanel);
        userPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        UserService userService = (UserService) MainApp.factory.create(UserService.class, MainApp.serverAddress + "UserService");

        User currentUser = userService.getUserInfo(false, login);
        JLabel jLabel1 = new JLabel("Имя пользователя:");
        userPanel.add(jLabel1);
        JLabel name = new JLabel(currentUser.getLogin());
        userPanel.add(name);

        JLabel jLabel3 = new JLabel("Имя:");
        userPanel.add(jLabel3);
        JLabel firstName = new JLabel(currentUser.getFirstName());
        userPanel.add(firstName);

        JLabel jLabel4 = new JLabel("Фамилия:");
        userPanel.add(jLabel4);
        JLabel lastName = new JLabel();
        lastName.setText(currentUser.getLastName());
        userPanel.add(lastName);

        JLabel jLabel5 = new JLabel("Отчество:");
        userPanel.add(jLabel5);
        JLabel affix = new JLabel();
        affix.setText(currentUser.getAffix());
        userPanel.add(affix);

        JLabel jLabel6 = new JLabel("Дата рождения:");
        userPanel.add(jLabel6);
        JLabel birthDate = new JLabel();
        birthDate.setText(currentUser.getBirthDate());
        userPanel.add(birthDate);

        JLabel jLabel7 = new JLabel("Интересы:");
        userPanel.add(jLabel7);
        JLabel info = new JLabel();
        info.setText(currentUser.getInfo());
        userPanel.add(info);
        this.setVisible(true);
    }
}
