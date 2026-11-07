import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CancellationForm extends JFrame {

    private JTextField pnrField;
    private JTextArea bookingDetailsArea;
    private JButton cancelButton;

    private int currentPNR = 0;

    private final Color backgroundColor =
            new Color(250, 251, 253);

    private final Color panelColor =
            new Color(45, 82, 120);

    private final Color textColor =
            new Color(45, 55, 65);

    private final Color borderColor =
            new Color(205, 210, 216);

    public CancellationForm() {

        setTitle("Online Reservation System - Cancellation");
        setSize(760, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel =
                new JPanel(new BorderLayout());

        mainPanel.setBackground(backgroundColor);

        // ================= LEFT PANEL =================

        JPanel leftPanel =
                new JPanel();

        leftPanel.setPreferredSize(
                new Dimension(250, 500)
        );

        leftPanel.setBackground(panelColor);

        leftPanel.setLayout(
                new GridBagLayout()
        );

        GridBagConstraints leftGbc =
                new GridBagConstraints();

        leftGbc.gridx = 0;
        leftGbc.anchor = GridBagConstraints.CENTER;

        JLabel iconLabel =
                new JLabel("✕");

        iconLabel.setFont(
                new Font(
                        "Segoe UI Symbol",
                        Font.PLAIN,
                        45
                )
        );

        iconLabel.setForeground(Color.WHITE);

        leftGbc.gridy = 0;

        leftPanel.add(
                iconLabel,
                leftGbc
        );

        JLabel titleOne =
                new JLabel("CANCEL");

        titleOne.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        24
                )
        );

        titleOne.setForeground(Color.WHITE);

        leftGbc.gridy = 1;

        leftGbc.insets =
                new Insets(15, 0, 0, 0);

        leftPanel.add(
                titleOne,
                leftGbc
        );

        JLabel titleTwo =
                new JLabel("RESERVATION");

        titleTwo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        titleTwo.setForeground(
                new Color(220, 230, 240)
        );

        leftGbc.gridy = 2;

        leftGbc.insets =
                new Insets(3, 0, 0, 0);

        leftPanel.add(
                titleTwo,
                leftGbc
        );

        JLabel subtitleLabel =
                new JLabel(
                        "<html><center>"
                        + "Enter your PNR number<br>"
                        + "to view your booking."
                        + "</center></html>"
                );

        subtitleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
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
                new JPanel(
                        new BorderLayout(10, 15)
                );

        rightPanel.setBackground(
                backgroundColor
        );

        rightPanel.setBorder(
                new EmptyBorder(
                        30, 35, 25, 35
                )
        );

        // ================= HEADING =================

        JLabel headingLabel =
                new JLabel("Cancel Reservation");

        headingLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        25
                )
        );

        headingLabel.setForeground(
                new Color(35, 45, 55)
        );

        rightPanel.add(
                headingLabel,
                BorderLayout.NORTH
        );

        // ================= CENTER =================

        JPanel centerPanel =
                new JPanel(
                        new BorderLayout(10, 15)
                );

        centerPanel.setBackground(
                backgroundColor
        );

        // PNR PANEL

        JPanel pnrPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                0,
                                5
                        )
                );

        pnrPanel.setBackground(
                backgroundColor
        );

        JLabel pnrLabel =
                new JLabel("PNR Number");

        pnrLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        pnrLabel.setForeground(textColor);

        pnrField =
                new JTextField();

        pnrField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        pnrField.setPreferredSize(
                new Dimension(220, 36)
        );

        pnrField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                borderColor
                        ),
                        BorderFactory.createEmptyBorder(
                                5, 10, 5, 10
                        )
                )
        );

        JButton fetchButton =
                new JButton("Fetch");

        fetchButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        fetchButton.setBackground(
                new Color(235, 239, 243)
        );

        fetchButton.setForeground(textColor);

        fetchButton.setFocusPainted(false);

        fetchButton.setPreferredSize(
                new Dimension(85, 36)
        );

        fetchButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        pnrPanel.add(pnrLabel);

        pnrPanel.add(
                Box.createHorizontalStrut(15)
        );

        pnrPanel.add(pnrField);

        pnrPanel.add(
                Box.createHorizontalStrut(8)
        );

        pnrPanel.add(fetchButton);

        centerPanel.add(
                pnrPanel,
                BorderLayout.NORTH
        );

        // ================= BOOKING DETAILS =================

        bookingDetailsArea =
                new JTextArea();

        bookingDetailsArea.setEditable(false);

        bookingDetailsArea.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        bookingDetailsArea.setForeground(
                textColor
        );

        bookingDetailsArea.setBackground(
                Color.WHITE
        );

        bookingDetailsArea.setLineWrap(true);

        bookingDetailsArea.setWrapStyleWord(true);

        bookingDetailsArea.setBorder(
                BorderFactory.createEmptyBorder(
                        12, 12, 12, 12
                )
        );

        JScrollPane scrollPane =
                new JScrollPane(
                        bookingDetailsArea
                );

        scrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(
                                borderColor
                        ),
                        "Booking Details",
                        0,
                        0,
                        new Font(
                                "Segoe UI",
                                Font.BOLD,
                                12
                        ),
                        textColor
                )
        );

        centerPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        rightPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        // ================= BOTTOM =================

        JPanel bottomPanel =
                new JPanel(
                        new BorderLayout()
                );

        bottomPanel.setBackground(
                backgroundColor
        );

        JLabel infoLabel =
                new JLabel(
                        "Fetch a reservation before cancelling"
                );

        infoLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        11
                )
        );

        infoLabel.setForeground(
                new Color(130, 135, 140)
        );

        cancelButton =
                new JButton("Cancel Reservation");

        cancelButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        cancelButton.setBackground(
                new Color(180, 70, 70)
        );

        cancelButton.setForeground(
                Color.WHITE
        );

        cancelButton.setFocusPainted(false);

        cancelButton.setPreferredSize(
                new Dimension(165, 38)
        );

        cancelButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        cancelButton.setEnabled(false);

        bottomPanel.add(
                infoLabel,
                BorderLayout.WEST
        );

        bottomPanel.add(
                cancelButton,
                BorderLayout.EAST
        );

        rightPanel.add(
                bottomPanel,
                BorderLayout.SOUTH
        );

        // ================= ACTIONS =================

        fetchButton.addActionListener(
                e -> fetchReservation()
        );

        cancelButton.addActionListener(
                e -> cancelReservation()
        );

        pnrField.addActionListener(
                e -> fetchReservation()
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

    // =====================================================
    // FETCH RESERVATION
    // =====================================================

    private void fetchReservation() {

        String pnrText =
                pnrField.getText().trim();

        if (pnrText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a PNR number."
            );

            return;
        }

        int pnr;

        try {

            pnr =
                    Integer.parseInt(
                            pnrText
                    );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "PNR must be numeric."
            );

            return;
        }

        String sql =
                "SELECT * FROM reservations "
                + "WHERE pnr = ?";

        try (
                Connection connection =
                        Database.connect();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    pnr
            );

            try (
                    ResultSet resultSet =
                            statement.executeQuery()
            ) {

                if (resultSet.next()) {

                    currentPNR = pnr;

                    String passengerName =
                            resultSet.getString(
                                    "passenger_name"
                            );

                    int trainNumber =
                            resultSet.getInt(
                                    "train_number"
                            );

                    String trainName =
                            resultSet.getString(
                                    "train_name"
                            );

                    String classType =
                            resultSet.getString(
                                    "class_type"
                            );

                    String journeyDate =
                            resultSet.getString(
                                    "journey_date"
                            );

                    String source =
                            resultSet.getString(
                                    "source_station"
                            );

                    String destination =
                            resultSet.getString(
                                    "destination_station"
                            );

                    bookingDetailsArea.setText(
                            "PNR: "
                            + pnr
                            + "\n\nPassenger Name: "
                            + passengerName
                            + "\nTrain Number: "
                            + trainNumber
                            + "\nTrain Name: "
                            + trainName
                            + "\nClass Type: "
                            + classType
                            + "\nJourney Date: "
                            + journeyDate
                            + "\nSource Station: "
                            + source
                            + "\nDestination Station: "
                            + destination
                    );

                    cancelButton.setEnabled(true);

                } else {

                    currentPNR = 0;

                    bookingDetailsArea.setText("");

                    cancelButton.setEnabled(false);

                    JOptionPane.showMessageDialog(
                            this,
                            "Reservation not found."
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

    // =====================================================
    // CANCEL RESERVATION
    // =====================================================

    private void cancelReservation() {

        if (currentPNR == 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fetch a valid reservation first."
            );

            return;
        }

        int choice =
                JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to cancel this reservation?",
                        "Confirm Cancellation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );

        if (
                choice != JOptionPane.YES_OPTION
        ) {

            return;
        }

        String sql =
                "DELETE FROM reservations "
                + "WHERE pnr = ?";

        try (
                Connection connection =
                        Database.connect();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    currentPNR
            );

            int rowsDeleted =
                    statement.executeUpdate();

            if (rowsDeleted > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Reservation cancelled successfully.",
                        "Cancellation Successful",
                        JOptionPane.INFORMATION_MESSAGE
                );

                pnrField.setText("");

                bookingDetailsArea.setText("");

                cancelButton.setEnabled(false);

                currentPNR = 0;

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Reservation could not be cancelled."
                );
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Cancellation failed: "
                    + e.getMessage()
            );
        }
    }

    // =====================================================
    // MAIN
    // =====================================================

    public static void main(String[] args) {

        new CancellationForm();
    }
}