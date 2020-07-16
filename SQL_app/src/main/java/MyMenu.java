import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMenu {
    MyMenu menu;
    private static JMenuBar Menu;
    static JMenuBar getMenu () {
        if (Menu == null) {
            Menu = new JMenuBar();
            JMenu file = new JMenu("File");
            file.add(MyMenuItems.getOpenItem());
            file.add(MyMenuItems.getSaveItem());
            file.addSeparator();
            file.add(MyMenuItems.getExitItem());
            JMenu edit = new JMenu("Edit");
            Menu.add(file);
            Menu.add(edit);
        }
        return Menu;
    }


    static class MyMenuItems {
        static JMenuItem open;
        static JMenuItem save;
        static JMenuItem exit;

        static JMenuItem getOpenItem () {
            if (open == null) {
                open = new JMenuItem("Open", 'O');
                open.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Open menu item was clicked");
                    }
                });
            }
            return open;
        }

        static JMenuItem getSaveItem () {
            if (save == null) {
                save = new JMenuItem("Save");
                save.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Save menu item was clicked");
                    }
                });
            }
            return save;
        }

        static JMenuItem getExitItem () {
            if (exit == null) {
                exit = new JMenuItem("Exit", 'E');
                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Exit menu item was clicked");
                        System.exit(0);
                    }
                });
            }
            return exit;
        }
    }
}
