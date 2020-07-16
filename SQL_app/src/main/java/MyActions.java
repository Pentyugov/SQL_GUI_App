import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;


public class MyActions implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    static class AddButtonAction implements ActionListener{
        JTextField authorTextField;
        JTextField bookTitleTextField;

        AddButtonAction(JTextField authorTextField, JTextField bookTitleTextField) {
            this.authorTextField = authorTextField;
            this.bookTitleTextField = bookTitleTextField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (authorTextField.getText().isEmpty()) {

                JOptionPane.showConfirmDialog(null, "Enter AUTHOR", "WARNING", JOptionPane.DEFAULT_OPTION);
            }
            else if (bookTitleTextField.getText().isEmpty()) {
                JOptionPane.showConfirmDialog(null, "Enter BOOK TITLE", "WARNING", JOptionPane.DEFAULT_OPTION);
            }
            else {
                String SQLAddCommand = "";
                SQLAddCommand += "INSERT book (author, title) ";
                SQLAddCommand += "VALUES ('" + authorTextField.getText().toUpperCase();
                SQLAddCommand += "', '";
                SQLAddCommand += bookTitleTextField.getText().toUpperCase() + "');";
                System.out.println(SQLAddCommand);
                try {
                    MySQLConnection.statement.executeUpdate(SQLAddCommand);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }


    static class CheckBoxAction implements ActionListener {
        JButton jButton;
        JButton jButton1;
        JCheckBox checkBox;

        CheckBoxAction(JButton jButton, JButton jButton1, JCheckBox checkBox) {
            this.jButton = jButton;
            this.jButton1 = jButton1;
            this.checkBox = checkBox;


        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkBox.isSelected()) {
                jButton1.setEnabled(false);
                jButton.setEnabled(true);
            }
            else {
                jButton1.setEnabled(true);
                jButton.setEnabled(false);

            }
        }
    }


    static class getDataButtonAction implements ActionListener{
        MyTableModel myTableModel;

        @Override
        public void actionPerformed(ActionEvent e) {

            myTableModel = new MyTableModel();
            try {
                MySQLConnection.resultSet = MySQLConnection.statement.executeQuery("SELECT * FROM Book;");
                while (MySQLConnection.resultSet.next()) {
                    String[] tmp = {
                        MySQLConnection.resultSet.getString("id"),
                        MySQLConnection.resultSet.getString("author"),
                        MySQLConnection.resultSet.getString("Title")
                    };
                    myTableModel.addData(tmp);


                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            MySQLConnection.myFirstGUI.getTable1().setModel(myTableModel);
        }
    }


    static class cancelButtonAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    static class loginButtonAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            MySQLConnection.setUserName(Main.loginPanel.getLoginTextFields().getText());
            MySQLConnection.setPassword(Main.loginPanel.getPasswordTextField().getText());
            try {
                MySQLConnection.setConnection();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid Login or Password", "Error", JOptionPane.WARNING_MESSAGE);
            }
            Main.loginPanel.setVisible(false);
            Main.loginPanel.dispose();
        }
    }

    static class removeButtonAction implements ActionListener{

        static int rowToRemove;
        removeButtonAction(){

        }
        @Override
        public void actionPerformed(ActionEvent e) {
          String id = (String) MySQLConnection.myFirstGUI.getTable1().getValueAt(rowToRemove, 0);
          String deleteCommand = "DELETE FROM book WHERE id = " + id + ";";
            System.out.println(deleteCommand);
            System.out.println(deleteCommand);
            try {
                MySQLConnection.statement.executeUpdate(deleteCommand);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
           MyTableModel myTableModel;
            myTableModel = new MyTableModel();
            try {
                MySQLConnection.resultSet = MySQLConnection.statement.executeQuery("SELECT * FROM Book;");
                while (MySQLConnection.resultSet.next()) {
                    String[] tmp = {
                            MySQLConnection.resultSet.getString("id"),
                            MySQLConnection.resultSet.getString("author"),
                            MySQLConnection.resultSet.getString("book_title")
                    };
                    myTableModel.addData(tmp);


                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            MySQLConnection.myFirstGUI.getTable1().setModel(myTableModel);

        }
    }

    static class selectRowInTable extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) //одинарный шелчок
            {
                int row = MySQLConnection.myFirstGUI.getTable1().rowAtPoint(e.getPoint());
                if (row > -1) {
                    removeButtonAction.rowToRemove = MySQLConnection.myFirstGUI.getTable1().convertRowIndexToModel(row); //номер строки из модели данных

                    System.out.println();
                }
            }

        }
    }
}
