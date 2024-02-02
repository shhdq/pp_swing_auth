import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // RegisterScreen registerScreen = new RegisterScreen();

        SwingUtilities.invokeLater(() -> {
            RegisterScreen registerScreen = new RegisterScreen();
            registerScreen.setVisible(true);
        });

    }
}