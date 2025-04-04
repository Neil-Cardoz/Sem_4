import java.sql.*;

public class Demo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/login_schema";
        String user = "root";
        String password = "Weinachten01@";

        String sqlSelect = "SELECT * FROM users";
        String sqlInsert = "INSERT INTO users (Username, Password) VALUES " +
                "('user1', 'password1'), " +
                "('user2', 'password2'), " +
                "('user3', 'password3')";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement()) {

            // Insert users into the table
            int rowsInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(rowsInserted + " rows inserted successfully.");

            // Fetch and display users
            ResultSet rs = stmt.executeQuery(sqlSelect);
            while (rs.next()) {
                System.out.println("Username: " + rs.getString("Username"));
                System.out.println("Password: " + rs.getString("Password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
