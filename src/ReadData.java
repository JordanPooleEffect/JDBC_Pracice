import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData {
    public static void main(String[] args) {
        try (Connection c = MySQLConnection.getConnection();
             Statement statement = c.createStatement()) {
            String query = "SELECT * FROM users";
            statement.executeQuery(query);
            ResultSet res = statement.executeQuery(query);
            while(res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String email = res.getString("email");
                System.out.println("+ ID: " + id);
                System.out.println("+ NAME: " + name);
                System.out.println("+ EMAIL: " + email);
                System.out.println("-----------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
