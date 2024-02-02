import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterScreen extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    private JTextField fullnameField;

    private JTextField emailField;

    private JButton registerButton;

    private JButton backButton;


    // constructor method
    public RegisterScreen() {
        setTitle("Register screen");
        setSize(300, 320);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // center windows screen
        setLocationRelativeTo(null);

        setLayout(null);

        createUI();
    }


    public void createUI() {
        // username
        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(10, 20, 80, 25);
        add(userLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(100, 20, 165, 25);
        add(usernameField);

        // password
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 55, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 55, 165, 25);
        add(passwordField);

        // full name
        JLabel nameLabel = new JLabel("Full Name");
        nameLabel.setBounds(10, 90, 80, 25);
        add(nameLabel);

        fullnameField = new JTextField(20);
        fullnameField.setBounds(100, 90, 165, 25);
        add(fullnameField);

        // email
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(10, 125, 80, 25);
        add(emailLabel);

        emailField = new JTextField(20);
        emailField.setBounds(100, 125, 165, 25);
        add(emailField);

        // register button
        registerButton = new JButton("Register");
        registerButton.setBounds(100, 160, 100, 25);
        add(registerButton);

        // back button
        backButton = new JButton("Back");
        backButton.setBounds(100, 190, 80, 25);
        add(backButton);

        registerButton.addActionListener(e -> performRegistration());
    }

    private void performRegistration() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String fullname = fullnameField.getText();
        String email = emailField.getText();

        // check
        if (username.isEmpty() || password.isEmpty() || fullname.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // insert query
        String sql = "INSERT INTO users (username, password, fullname, email) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, fullname);
            pstmt.setString(4, email);

            int effectedRows = pstmt.executeUpdate();

            if (effectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Resgitration Succesfull");
            } else {
                JOptionPane.showMessageDialog(this, "Registration failed.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error during registration: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }


}
