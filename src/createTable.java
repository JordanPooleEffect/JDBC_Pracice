import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class createTable {
    public static void main(String[] args) {
        try (Connection c = MySQLConnection.getConnection();
             Statement statement = c.createStatement()) {
            String query = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(100) NOT NULL," +
                    "email VARCHAR(100) NOT NULL)";
            statement.execute(query);
            System.out.println("Table created succsys!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

