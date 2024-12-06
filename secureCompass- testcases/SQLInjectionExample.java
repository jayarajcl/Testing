import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLInjectionExample {
    public static void main(String[] args) {
        String userId = "1 OR 1=1"; // Example of SQL Injection
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM users WHERE id=" + userId;
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}