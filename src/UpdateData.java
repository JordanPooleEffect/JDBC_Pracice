import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
public class UpdateData {
    public static void main(String[] args) {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "UPDATE users SET name = ?, email = ? WHERE id = ?"
             )) {
            String name = "Zedric Marc Tabinas";
            String email = "zedricmarc.tabinas@cit.edu";
            int id = 5;

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setInt(3, id);



            int rows = statement.executeUpdate();

            System.out.println("Rows Updated: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
