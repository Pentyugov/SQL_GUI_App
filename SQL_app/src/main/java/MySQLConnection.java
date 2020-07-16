import java.sql.*;


public class MySQLConnection {
    static MyFirstGUI myFirstGUI;
    static Statement statement;
    static ResultSet resultSet;
    private static String userName;
    private static String password;
    private static String URL = "jdbc:mysql://localhost:3306/Test";


    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        MySQLConnection.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        MySQLConnection.password = password;
    }

    public static void setConnection () throws ClassNotFoundException {


//         соединение напрямую
        try {
            userName = "root";
            password = "Y1Q1y8In";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, userName, password);
            statement = connection.createStatement();
            System.out.println("Connected");
            myFirstGUI = new MyFirstGUI();
        }
        catch (SQLException e) {
            System.out.println("Что то пошло не так");
        }



//        Соединение через логин-панель
        /*
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, getUserName(), getPassword());
        statement = connection.createStatement();
        System.out.println("Connected");
        myFirstGUI = new MyFirstGUI();
        */

    }

}
