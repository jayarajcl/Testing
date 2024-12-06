import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class VulnerableApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        try {
            // Database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
            Statement statement = connection.createStatement();

            // Vulnerable to SQL Injection
            String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid credentials.");
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
