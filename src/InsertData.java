import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertData {

    public static void main(String[] args) {

        try (Connection connection = Database.connect()) {

            String userSql =
                    "INSERT OR IGNORE INTO users (username, password) VALUES (?, ?)";

            try (PreparedStatement statement =
                         connection.prepareStatement(userSql)) {

                statement.setString(1, "admin");
                statement.setString(2, "admin123");

                statement.executeUpdate();
            }

            String trainSql =
                    "INSERT OR IGNORE INTO trains (train_number, train_name) VALUES (?, ?)";

            try (PreparedStatement statement =
                         connection.prepareStatement(trainSql)) {

                statement.setInt(1, 101);
                statement.setString(2, "Green Line Express");
                statement.executeUpdate();

                statement.setInt(1, 202);
                statement.setString(2, "Karachi Express");
                statement.executeUpdate();

                statement.setInt(1, 303);
                statement.setString(2, "Tezgam Express");
                statement.executeUpdate();
            }

            System.out.println("Sample data inserted successfully.");

        } catch (Exception e) {

            System.out.println("Data insertion failed.");
            e.printStackTrace();
        }
    }
}