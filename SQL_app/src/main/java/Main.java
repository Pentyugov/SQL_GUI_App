import javax.swing.*;
import java.sql.SQLException;

public class Main {
    static loginPanel loginPanel;
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, UnsupportedLookAndFeelException, InstantiationException {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       /*
       Соединение через панель логин
        loginPanel = new loginPanel();
        */
        
        MySQLConnection.setConnection();

    }
}
