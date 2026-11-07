import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainMenu extends JFrame {

    private JButton reservationButton;
    private JButton cancellationButton;
    private JButton exitButton;

    public MainMenu() {

        setTitle("Online Reservation System");
        setSize(760, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel =
                new JPanel(new BorderLayout());

        mainPanel.setBackground(
                new Color(245, 247, 250)
        );

        // ================= LEFT PANEL =================

        JPanel leftPanel =
                new JPanel();

        leftPanel.setPreferredSize(
                new Dimension(300, 450)
        );

        leftPanel.setBackground(
                new Color(45, 82, 120)
        );

        leftPanel.setLayout(
                new GridBagLayout()
        );

        GridBagConstraints leftGbc =
                new GridBagConstraints();

        leftGbc.gridx = 0;
        leftGbc.anchor =
                GridBagConstraints.CENTER;

        JLabel iconLabel =
                new JLabel("✈");

        iconLabel.setFont(
                new Font(
                        "Segoe UI Symbol",
                        Font.PLAIN,
                        48
                )
        );

        iconLabel.setForeground(
                Color.WHITE
        );

        leftGbc.gridy = 0;

        leftPanel.add(
                iconLabel,
                leftGbc
        );

        JLabel systemLabel =
                new JLabel("ONLINE");

        systemLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        25
                )
        );

        systemLabel.setForeground(
                Color.WHITE
        );

        leftGbc.gridy = 1;

        leftGbc.insets =
                new Insets(15, 0, 0, 0);

        leftPanel.add(
                systemLabel,
                leftGbc
        );

        JLabel reservationLabel =
                new JLabel(
                        "RESERVATION SYSTEM"
                );

        reservationLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
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
                        "<html><center>"
                        + "Manage your reservations<br>"
                        + "quickly and easily."
                        + "</center></html>"
                );

        subtitleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
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

        JLabel titleLabel =
                new JLabel("Dashboard");

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        27
                )
        );

        titleLabel.setForeground(
                new Color(35, 45, 55)
        );

        rightPanel.add(
                titleLabel,
                BorderLayout.NORTH
        );

        JLabel instructionLabel =
                new JLabel(
                        "Choose an option to continue"
                );

        instructionLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        instructionLabel.setForeground(
                new Color(120, 125, 130)
        );

        JPanel headingPanel =
                new JPanel();

        headingPanel.setBackground(
                new Color(250, 251, 253)
        );

        headingPanel.setLayout(
                new BorderLayout()
        );

        headingPanel.add(
                titleLabel,
                BorderLayout.NORTH
        );

        headingPanel.add(
                instructionLabel,
                BorderLayout.SOUTH
        );

        rightPanel.add(
                headingPanel,
                BorderLayout.NORTH
        );

        // ================= BUTTON PANEL =================

        JPanel buttonPanel =
                new JPanel();

        buttonPanel.setBackground(
                new Color(250, 251, 253)
        );

        buttonPanel.setLayout(
                new GridLayout(
                        3,
                        1,
                        0,
                        12
                )
        );

        reservationButton =
                createMenuButton(
                        "Book Reservation"
                );

        cancellationButton =
                createMenuButton(
                        "Cancel Reservation"
                );

        exitButton =
                createMenuButton(
                        "Exit"
                );

        buttonPanel.add(
                reservationButton
        );

        buttonPanel.add(
                cancellationButton
        );

        buttonPanel.add(
                exitButton
        );

        rightPanel.add(
                buttonPanel,
                BorderLayout.CENTER
        );

        // ================= FOOTER =================

        JLabel footerLabel =
                new JLabel(
                        "Online Reservation System"
                );

        footerLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        11
                )
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

        // ================= BUTTON ACTIONS =================

        reservationButton.addActionListener(
                e -> {
                    new ReservationForm();
                }
        );

        cancellationButton.addActionListener(
                e -> {
                    new CancellationForm();
                }
        );

        exitButton.addActionListener(
                e -> {
                    System.exit(0);
                }
        );

        // ================= ADD PANELS =================

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

    private JButton createMenuButton(
            String text
    ) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        button.setForeground(
                new Color(45, 55, 65)
        );

        button.setBackground(
                Color.WHITE
        );

        button.setFocusPainted(false);

        button.setPreferredSize(
                new Dimension(280, 45)
        );

        button.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(215, 220, 225)
                        ),
                        BorderFactory.createEmptyBorder(
                                8, 15, 8, 15
                        )
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        return button;
    }

    public static void main(String[] args) {

        new MainMenu();
    }
}