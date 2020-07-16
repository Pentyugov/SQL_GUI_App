import javax.swing.*;

public class MyTextField {
    private static JTextField authorTextField;
    private static JTextField bookTitleTextField;

    static JTextField getAuthorTextField () {
        if (authorTextField == null) {
            authorTextField = new JTextField(20);
        }
        return authorTextField;
    }

    static JTextField getBookTitleTextField() {

        if (bookTitleTextField == null) {
            bookTitleTextField = new JTextField(20);
        }
        return bookTitleTextField;
    }
}
