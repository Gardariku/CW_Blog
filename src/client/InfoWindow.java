package client;
import javax.swing.JOptionPane;

public class InfoWindow
{

    public static void infoBox(String message, String titleBar)
    {
        JOptionPane.showMessageDialog(null, message, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}