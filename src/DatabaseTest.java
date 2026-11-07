import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseTest {

    public static void main(String[] args) {

        String url = "jdbc:sqlite:reservation.db";

        try (Connection connection = DriverManager.getConnection(url)) {

            System.out.println("Database connected successfully.");

        } catch (Exception e) {

            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
    }
}