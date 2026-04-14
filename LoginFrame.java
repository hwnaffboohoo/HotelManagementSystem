import javax.swing.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Login");
        setSize(300, 200);
        setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 20, 80, 25);
        add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(100, 20, 150, 25);
        add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 60, 80, 25);
        add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(100, 60, 150, 25);
        add(passField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(100, 100, 100, 30);
        add(loginBtn);

        loginBtn.addActionListener(e -> {
            if (userField.getText().equals("admin") &&
                String.valueOf(passField.getPassword()).equals("1234")) {

                new BookingGUI().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Wrong login!");
            }
        });
    }
}