//Inserting a New Record into a MySQL Database using JDBC
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertRecord {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a prepared statement to insert a new record
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students (id, name, age) VALUES (?,?,?)");

            // Prompt the user to enter student details
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter student ID: ");
            int id = scanner.nextInt();
            System.out.println("Enter student name: ");
            String name = scanner.next();
            System.out.println("Enter student age: ");
            int age = scanner.nextInt();

            // Set the values for the prepared statement
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);

            // Execute the prepared statement
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("New student record inserted successfully!");
            } else {
                System.out.println("Failed to insert the new student record.");
            }

            // Close the resources
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found!");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}