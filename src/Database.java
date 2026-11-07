
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {

    private static final String URL = "jdbc:sqlite:reservation.db";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL);
        } catch (Exception e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
            return null;
        }
    }

    public static void createTables() {

        String usersTable = """
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT NOT NULL UNIQUE,
                    password TEXT NOT NULL
                )
                """;

        String trainsTable = """
                CREATE TABLE IF NOT EXISTS trains (
                    train_number INTEGER PRIMARY KEY,
                    train_name TEXT NOT NULL
                )
                """;

        String reservationsTable = """
                CREATE TABLE IF NOT EXISTS reservations (
                    pnr INTEGER PRIMARY KEY,
                    passenger_name TEXT NOT NULL,
                    train_number INTEGER NOT NULL,
                    train_name TEXT NOT NULL,
                    class_type TEXT NOT NULL,
                    journey_date TEXT NOT NULL,
                    source_station TEXT NOT NULL,
                    destination_station TEXT NOT NULL
                )
                """;

        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {

            statement.execute(usersTable);
            statement.execute(trainsTable);
            statement.execute(reservationsTable);

            System.out.println("Database tables created successfully.");

        } catch (Exception e) {
            System.out.println("Table creation failed.");
            e.printStackTrace();
        }
    }
}