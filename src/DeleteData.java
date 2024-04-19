import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteData {
    public static void main(String[] args) {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "DELETE FROM users WHERE id = ? RETURNING *"
             )) {
            int id = 4;
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            ResultSet res = statement.getResultSet();
            if(res.next()) {
                System.out.println("- NAME: " + res.getString("name"));
                System.out.println("- EMAIL: " + res.getString("email"));
            }
            System.out.println("+ Deleted Rows: " + rows);
            System.out.println("-----------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
