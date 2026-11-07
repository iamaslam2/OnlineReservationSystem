import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;

public class ReservationForm extends JFrame {

    private JTextField passengerNameField;
    private JTextField trainNumberField;
    private JTextField trainNameField;
    private JComboBox<String> classTypeBox;
    private JTextField journeyDateField;
    private JTextField sourceField;
    private JTextField destinationField;

    private final Color backgroundColor =
            new Color(250, 251, 253);

    private final Color panelColor =
            new Color(45, 82, 120);

    private final Color textColor =
            new Color(45, 55, 65);

    private final Color borderColor =
            new Color(205, 210, 216);

    public ReservationForm() {

        setTitle("Online Reservation System - Reservation");
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
        leftGbc.anchor =
                GridBagConstraints.CENTER;

        JLabel iconLabel =
                new JLabel("✈");

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
                new JLabel("TRAIN");

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
                        + "Enter passenger details<br>"
                        + "to book your journey."
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
                        new BorderLayout(10, 10)
                );

        rightPanel.setBackground(
                backgroundColor
        );

        rightPanel.setBorder(
                new EmptyBorder(
                        30, 35, 25, 35
                )
        );

        JLabel headingLabel =
                new JLabel("Book Reservation");

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

        // ================= FORM =================

        JPanel formPanel =
                new JPanel(
                        new GridBagLayout()
                );

        formPanel.setBackground(
                backgroundColor
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(5, 5, 5, 12);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        gbc.anchor =
                GridBagConstraints.WEST;

        gbc.weightx = 1;

        // Passenger Name
        addLabel(
                formPanel,
                "Passenger Name",
                gbc,
                0
        );

        passengerNameField =
                createTextField();

        addField(
                formPanel,
                passengerNameField,
                gbc,
                0
        );

        // Train Number
        addLabel(
                formPanel,
                "Train Number",
                gbc,
                1
        );

        trainNumberField =
                createTextField();

        addField(
                formPanel,
                trainNumberField,
                gbc,
                1
        );

        // Train Name
        addLabel(
                formPanel,
                "Train Name",
                gbc,
                2
        );

        trainNameField =
                createTextField();

        trainNameField.setEditable(false);

        trainNameField.setBackground(
                new Color(238, 241, 244)
        );

        addField(
                formPanel,
                trainNameField,
                gbc,
                2
        );

        // Class Type
        addLabel(
                formPanel,
                "Class Type",
                gbc,
                3
        );

        classTypeBox =
                new JComboBox<>(
                        new String[]{
                                "Economy",
                                "Business",
                                "First Class"
                        }
                );

        classTypeBox.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        classTypeBox.setPreferredSize(
                new Dimension(270, 36)
        );

        addField(
                formPanel,
                classTypeBox,
                gbc,
                3
        );

        // Journey Date
        addLabel(
                formPanel,
                "Journey Date",
                gbc,
                4
        );

        JPanel datePanel =
                new JPanel(
                        new BorderLayout(6, 0)
                );

        datePanel.setBackground(
                backgroundColor
        );

        journeyDateField =
                createTextField();

        journeyDateField.setEditable(false);

        journeyDateField.setBackground(Color.WHITE);

        JButton calendarButton =
                new JButton("Calendar");

        calendarButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        calendarButton.setBackground(
                new Color(235, 239, 243)
        );

        calendarButton.setForeground(
                textColor
        );

        calendarButton.setFocusPainted(false);

        calendarButton.setPreferredSize(
                new Dimension(90, 36)
        );

        calendarButton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        datePanel.add(
                journeyDateField,
                BorderLayout.CENTER
        );

        datePanel.add(
                calendarButton,
                BorderLayout.EAST
        );

        addField(
                formPanel,
                datePanel,
                gbc,
                4
        );

        // Source
        addLabel(
                formPanel,
                "Source Station",
                gbc,
                5
        );

        sourceField =
                createTextField();

        addField(
                formPanel,
                sourceField,
                gbc,
                5
        );

        // Destination
        addLabel(
                formPanel,
                "Destination",
                gbc,
                6
        );

        destinationField =
                createTextField();

        addField(
                formPanel,
                destinationField,
                gbc,
                6
        );

        rightPanel.add(
                formPanel,
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
                        "Fill in all required details"
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

        JButton bookButton =
                new JButton("Book Reservation");

        bookButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        bookButton.setBackground(panelColor);

        bookButton.setForeground(Color.WHITE);

        bookButton.setFocusPainted(false);

        bookButton.setPreferredSize(
                new Dimension(165, 38)
        );

        bookButton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        bottomPanel.add(
                infoLabel,
                BorderLayout.WEST
        );

        bottomPanel.add(
                bookButton,
                BorderLayout.EAST
        );

        rightPanel.add(
                bottomPanel,
                BorderLayout.SOUTH
        );

        // ================= ACTIONS =================

        trainNumberField.addActionListener(
                e -> findTrainName()
        );

        trainNumberField.addFocusListener(
                new FocusAdapter() {

                    @Override
                    public void focusLost(
                            FocusEvent e
                    ) {
                        findTrainName();
                    }
                }
        );

        calendarButton.addActionListener(
                e -> showCalendar()
        );

        bookButton.addActionListener(
                e -> bookReservation()
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
    // UI HELPER METHODS
    // =====================================================

    private JTextField createTextField() {

        JTextField field =
                new JTextField();

        field.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        field.setPreferredSize(
                new Dimension(270, 36)
        );

        field.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                borderColor
                        ),
                        BorderFactory.createEmptyBorder(
                                5, 10, 5, 10
                        )
                )
        );

        return field;
    }

    private void addLabel(
            JPanel panel,
            String text,
            GridBagConstraints gbc,
            int row
    ) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        label.setForeground(textColor);

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0;

        panel.add(
                label,
                gbc
        );
    }

    private void addField(
            JPanel panel,
            JComponent component,
            GridBagConstraints gbc,
            int row
    ) {

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.weightx = 1;

        panel.add(
                component,
                gbc
        );
    }

    // =====================================================
    // FIND TRAIN NAME
    // =====================================================

    private void findTrainName() {

        String trainNumberText =
                trainNumberField.getText().trim();

        if (trainNumberText.isEmpty()) {

            trainNameField.setText("");

            return;
        }

        try {

            int trainNumber =
                    Integer.parseInt(
                            trainNumberText
                    );

            String sql =
                    "SELECT train_name FROM trains "
                    + "WHERE train_number = ?";

            try (
                    Connection connection =
                            Database.connect();

                    PreparedStatement statement =
                            connection.prepareStatement(sql)
            ) {

                statement.setInt(
                        1,
                        trainNumber
                );

                try (
                        ResultSet resultSet =
                                statement.executeQuery()
                ) {

                    if (resultSet.next()) {

                        String trainName =
                                resultSet.getString(
                                        "train_name"
                                );

                        trainNameField.setText(
                                trainName
                        );

                    } else {

                        trainNameField.setText(
                                "Train not found"
                        );
                    }
                }

            }

        } catch (NumberFormatException e) {

            trainNameField.setText(
                    "Enter a number"
            );

        } catch (Exception e) {

            trainNameField.setText(
                    "Database error"
            );
        }
    }

    // =====================================================
    // CALENDAR
    // =====================================================

    private void showCalendar() {

        JDialog calendarDialog =
                new JDialog(
                        this,
                        "Select Journey Date",
                        true
                );

        calendarDialog.setSize(
                430,
                380
        );

        calendarDialog.setLocationRelativeTo(
                this
        );

        calendarDialog.setResizable(false);

        JPanel mainCalendarPanel =
                new JPanel(
                        new BorderLayout(
                                8,
                                8
                        )
                );

        mainCalendarPanel.setBackground(
                backgroundColor
        );

        mainCalendarPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        12,
                        12,
                        12,
                        12
                )
        );

        YearMonth[] currentMonth = {
                YearMonth.now()
        };

        JLabel monthLabel =
                new JLabel(
                        "",
                        SwingConstants.CENTER
                );

        monthLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        monthLabel.setForeground(textColor);

        JButton previousButton =
                new JButton("<");

        JButton nextButton =
                new JButton(">");

        styleCalendarButton(
                previousButton
        );

        styleCalendarButton(
                nextButton
        );

        JPanel headerPanel =
                new JPanel(
                        new BorderLayout()
                );

        headerPanel.setBackground(
                backgroundColor
        );

        headerPanel.add(
                previousButton,
                BorderLayout.WEST
        );

        headerPanel.add(
                monthLabel,
                BorderLayout.CENTER
        );

        headerPanel.add(
                nextButton,
                BorderLayout.EAST
        );

        mainCalendarPanel.add(
                headerPanel,
                BorderLayout.NORTH
        );

        JPanel calendarGrid =
                new JPanel(
                        new GridLayout(
                                0,
                                7,
                                1,
                                1
                        )
                );

        calendarGrid.setBackground(
                new Color(225, 230, 235)
        );

        mainCalendarPanel.add(
                calendarGrid,
                BorderLayout.CENTER
        );

        String[] days = {
                "Sun",
                "Mon",
                "Tue",
                "Wed",
                "Thu",
                "Fri",
                "Sat"
        };

        Runnable updateCalendar = () -> {

            calendarGrid.removeAll();

            for (String day : days) {

                JLabel dayLabel =
                        new JLabel(
                                day,
                                SwingConstants.CENTER
                        );

                dayLabel.setFont(
                        new Font(
                                "Segoe UI",
                                Font.BOLD,
                                12
                        )
                );

                dayLabel.setForeground(
                        new Color(70, 80, 90)
                );

                dayLabel.setOpaque(true);

                dayLabel.setBackground(
                        new Color(235, 239, 243)
                );

                calendarGrid.add(
                        dayLabel
                );
            }

            YearMonth month =
                    currentMonth[0];

            monthLabel.setText(
                    month.getMonth().toString()
                    + " "
                    + month.getYear()
            );

            LocalDate firstDay =
                    month.atDay(1);

            int startDay =
                    firstDay.getDayOfWeek()
                            .getValue();

            startDay =
                    startDay % 7;

            for (
                    int i = 0;
                    i < startDay;
                    i++
            ) {

                calendarGrid.add(
                        new JLabel("")
                );
            }

            int totalDays =
                    month.lengthOfMonth();

            for (
                    int day = 1;
                    day <= totalDays;
                    day++
            ) {

                JButton dayButton =
                        new JButton(
                                String.valueOf(day)
                        );

                dayButton.setFont(
                        new Font(
                                "Segoe UI",
                                Font.PLAIN,
                                12
                        )
                );

                dayButton.setFocusPainted(
                        false
                );

                dayButton.setBackground(
                        Color.WHITE
                );

                dayButton.setBorder(
                        BorderFactory.createEmptyBorder(
                                4,
                                4,
                                4,
                                4
                        )
                );

                dayButton.setCursor(
                        new Cursor(
                                Cursor.HAND_CURSOR
                        )
                );

                int selectedDay =
                        day;

                dayButton.addActionListener(
                        e -> {

                            LocalDate selectedDate =
                                    month.atDay(
                                            selectedDay
                                    );

                            DateTimeFormatter formatter =
                                    DateTimeFormatter.ofPattern(
                                            "yyyy-MM-dd"
                                    );

                            journeyDateField.setText(
                                    selectedDate.format(
                                            formatter
                                    )
                            );

                            calendarDialog.dispose();
                        }
                );

                calendarGrid.add(
                        dayButton
                );
            }

            calendarGrid.revalidate();
            calendarGrid.repaint();
        };

        previousButton.addActionListener(
                e -> {

                    currentMonth[0] =
                            currentMonth[0]
                                    .minusMonths(1);

                    updateCalendar.run();
                }
        );

        nextButton.addActionListener(
                e -> {

                    currentMonth[0] =
                            currentMonth[0]
                                    .plusMonths(1);

                    updateCalendar.run();
                }
        );

        updateCalendar.run();

        calendarDialog.add(
                mainCalendarPanel
        );

        calendarDialog.setVisible(true);
    }

    private void styleCalendarButton(
            JButton button
    ) {

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        button.setBackground(
                new Color(235, 239, 243)
        );

        button.setForeground(textColor);

        button.setFocusPainted(false);

        button.setPreferredSize(
                new Dimension(45, 30)
        );
    }

    // =====================================================
    // BOOK RESERVATION
    // =====================================================

    private void bookReservation() {

        String passengerName =
                passengerNameField
                        .getText()
                        .trim();

        String trainNumberText =
                trainNumberField
                        .getText()
                        .trim();

        String trainName =
                trainNameField
                        .getText()
                        .trim();

        String classType =
                (String)
                        classTypeBox
                                .getSelectedItem();

        String journeyDate =
                journeyDateField
                        .getText()
                        .trim();

        String source =
                sourceField
                        .getText()
                        .trim();

        String destination =
                destinationField
                        .getText()
                        .trim();

        // Check empty fields

        if (
                passengerName.isEmpty()
                || trainNumberText.isEmpty()
                || journeyDate.isEmpty()
                || source.isEmpty()
                || destination.isEmpty()
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all required fields."
            );

            return;
        }

        // Check train number

        int trainNumber;

        try {

            trainNumber =
                    Integer.parseInt(
                            trainNumberText
                    );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Train number must be numeric."
            );

            return;
        }

        // Check train name

        if (
                trainName.isEmpty()
                || trainName.equals(
                        "Train not found"
                )
                || trainName.equals(
                        "Enter a number"
                )
                || trainName.equals(
                        "Database error"
                )
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid train number."
            );

            return;
        }

        // Check date

        try {

            LocalDate.parse(
                    journeyDate
            );

        } catch (DateTimeParseException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid date."
            );

            return;
        }

        // Generate PNR

        int pnr =
                generatePNR();

        String sql =
                "INSERT INTO reservations "
                + "(pnr, passenger_name, train_number, "
                + "train_name, class_type, journey_date, "
                + "source_station, destination_station) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

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

            statement.setString(
                    2,
                    passengerName
            );

            statement.setInt(
                    3,
                    trainNumber
            );

            statement.setString(
                    4,
                    trainName
            );

            statement.setString(
                    5,
                    classType
            );

            statement.setString(
                    6,
                    journeyDate
            );

            statement.setString(
                    7,
                    source
            );

            statement.setString(
                    8,
                    destination
            );

            statement.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Reservation Successful!\n\n"
                    + "PNR: " + pnr + "\n"
                    + "Passenger: "
                    + passengerName + "\n"
                    + "Train: "
                    + trainName + "\n"
                    + "Class: "
                    + classType + "\n"
                    + "Journey Date: "
                    + journeyDate + "\n"
                    + "From: "
                    + source + "\n"
                    + "To: "
                    + destination,
                    "Booking Confirmation",
                    JOptionPane.INFORMATION_MESSAGE
            );

            clearFields();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Booking failed: "
                    + e.getMessage()
            );
        }
    }

    // =====================================================
    // GENERATE PNR
    // =====================================================

    private int generatePNR() {

        Random random =
                new Random();

        return 100000
                + random.nextInt(900000);
    }

    // =====================================================
    // CLEAR FORM
    // =====================================================

    private void clearFields() {

        passengerNameField.setText("");

        trainNumberField.setText("");

        trainNameField.setText("");

        journeyDateField.setText("");

        sourceField.setText("");

        destinationField.setText("");

        classTypeBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {

        new ReservationForm();
    }
}