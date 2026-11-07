import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginForm extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginForm() {

        setTitle("Online Reservation System");
        setSize(760, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 247, 250));

        // ================= LEFT PANEL =================

        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(300, 450));
        leftPanel.setBackground(new Color(45, 82, 120));
        leftPanel.setLayout(new GridBagLayout());

        GridBagConstraints leftGbc =
                new GridBagConstraints();

        leftGbc.gridx = 0;
        leftGbc.anchor = GridBagConstraints.CENTER;

        JLabel iconLabel =
                new JLabel("✈");

        iconLabel.setFont(
                new Font("Segoe UI Symbol", Font.PLAIN, 48)
        );

        iconLabel.setForeground(Color.WHITE);

        leftGbc.gridy = 0;
        leftPanel.add(
                iconLabel,
                leftGbc
        );

        JLabel systemLabel =
                new JLabel("ONLINE");

        systemLabel.setFont(
                new Font("Segoe UI", Font.BOLD, 25)
        );

        systemLabel.setForeground(Color.WHITE);

        leftGbc.gridy = 1;
        leftGbc.insets =
                new Insets(15, 0, 0, 0);

        leftPanel.add(
                systemLabel,
                leftGbc
        );

        JLabel reservationLabel =
                new JLabel("RESERVATION SYSTEM");

        reservationLabel.setFont(
                new Font("Segoe UI", Font.BOLD, 18)
        );

        reservationLabel.setForeground(
                new Color(220, 230, 240)
        );

        leftGbc.gridy = 2;
        leftGbc.insets =
                new Insets(3, 0, 0, 0);

        leftPanel.add(
                reservationLabel,
                leftGbc
        );

        JLabel subtitleLabel =
                new JLabel(
                        "<html><center>Book and manage your<br>"
                        + "reservations easily.</center></html>"
                );

        subtitleLabel.setFont(
                new Font("Segoe UI", Font.PLAIN, 13)
        );

        subtitleLabel.setForeground(
                new Color(215, 225, 235)
        );

        leftGbc.gridy = 3;
        leftGbc.insets =
                new Insets(25, 0, 0, 0);

        leftPanel.add(
                subtitleLabel,
                leftGbc
        );

        // ================= RIGHT PANEL =================

        JPanel rightPanel =
                new JPanel();

        rightPanel.setBackground(
                new Color(250, 251, 253)
        );

        rightPanel.setBorder(
                new EmptyBorder(
                        45, 55, 40, 55
                )
        );

        rightPanel.setLayout(
                new BorderLayout(10, 10)
        );

        JLabel welcomeLabel =
                new JLabel("Welcome Back");

        welcomeLabel.setFont(
                new Font("Segoe UI", Font.BOLD, 27)
        );

        welcomeLabel.setForeground(
                new Color(35, 45, 55)
        );

        rightPanel.add(
                welcomeLabel,
                BorderLayout.NORTH
        );

        JPanel formPanel =
                new JPanel();

        formPanel.setBackground(
                new Color(250, 251, 253)
        );

        formPanel.setLayout(
                new GridBagLayout()
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        // Username label

        JLabel usernameLabel =
                new JLabel("Username");

        usernameLabel.setFont(
                new Font("Segoe UI", Font.BOLD, 13)
        );

        usernameLabel.setForeground(
                new Color(70, 80, 90)
        );

        gbc.gridy = 0;
        gbc.insets =
                new Insets(15, 0, 5, 0);

        formPanel.add(
                usernameLabel,
                gbc
        );

        // Username field

        usernameField =
                new JTextField();

        usernameField.setFont(
                new Font("Segoe UI", Font.PLAIN, 14)
        );

        usernameField.setPreferredSize(
                new Dimension(280, 38)
        );

        usernameField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(205, 210, 216)
                        ),
                        BorderFactory.createEmptyBorder(
                                5, 10, 5, 10
                        )
                )
        );

        gbc.gridy = 1;
        gbc.insets =
                new Insets(0, 0, 10, 0);

        formPanel.add(
                usernameField,
                gbc
        );

        // Password label

        JLabel passwordLabel =
                new JLabel("Password");

        passwordLabel.setFont(
                new Font("Segoe UI", Font.BOLD, 13)
        );

        passwordLabel.setForeground(
                new Color(70, 80, 90)
        );

        gbc.gridy = 2;
        gbc.insets =
                new Insets(5, 0, 5, 0);

        formPanel.add(
                passwordLabel,
                gbc
        );

        // Password field

        passwordField =
                new JPasswordField();

        passwordField.setFont(
                new Font("Segoe UI", Font.PLAIN, 14)
        );

        passwordField.setPreferredSize(
                new Dimension(280, 38)
        );

        passwordField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(205, 210, 216)
                        ),
                        BorderFactory.createEmptyBorder(
                                5, 10, 5, 10
                        )
                )
        );

        gbc.gridy = 3;
        gbc.insets =
                new Insets(0, 0, 18, 0);

        formPanel.add(
                passwordField,
                gbc
        );

        // Login button

        loginButton =
                new JButton("Login");

        loginButton.setPreferredSize(
                new Dimension(280, 40)
        );

        loginButton.setFont(
                new Font("Segoe UI", Font.BOLD, 14)
        );

        loginButton.setBackground(
                new Color(45, 82, 120)
        );

        loginButton.setForeground(
                Color.WHITE
        );

        loginButton.setFocusPainted(false);

        loginButton.setBorder(
                BorderFactory.createEmptyBorder(
                        8, 20, 8, 20
                )
        );

        loginButton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        gbc.gridy = 4;
        gbc.insets =
                new Insets(0, 0, 10, 0);

        formPanel.add(
                loginButton,
                gbc
        );

        rightPanel.add(
                formPanel,
                BorderLayout.CENTER
        );

        JLabel footerLabel =
                new JLabel(
                        "Secure access to your reservation system"
                );

        footerLabel.setFont(
                new Font("Segoe UI", Font.PLAIN, 11)
        );

        footerLabel.setForeground(
                new Color(135, 140, 145)
        );

        footerLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        rightPanel.add(
                footerLabel,
                BorderLayout.SOUTH
        );

        // ================= ACTION =================

        loginButton.addActionListener(
                e -> checkLogin()
        );

        getRootPane().setDefaultButton(
                loginButton
        );

        mainPanel.add(
                leftPanel,
                BorderLayout.WEST
        );

        mainPanel.add(
                rightPanel,
                BorderLayout.CENTER
        );

        add(mainPanel);

        setVisible(true);
    }

    // ================= LOGIN CHECK =================

    private void checkLogin() {

        String username =
                usernameField.getText().trim();

        String password =
                new String(
                        passwordField.getPassword()
                );

        if (username.isEmpty()
                || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter username and password."
            );

            return;
        }

        String sql =
                "SELECT * FROM users "
                + "WHERE username = ? "
                + "AND password = ?";

        try (
                Connection connection =
                        Database.connect();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(
                    1,
                    username
            );

            statement.setString(
                    2,
                    password
            );

            try (
                    ResultSet resultSet =
                            statement.executeQuery()
            ) {

                if (resultSet.next()) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Login Successful!"
                    );

                    new MainMenu();

                    dispose();

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Invalid username or password."
                    );
                }
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database error: "
                    + e.getMessage()
            );
        }
    }

    public static void main(String[] args) {

        new LoginForm();
    }
}