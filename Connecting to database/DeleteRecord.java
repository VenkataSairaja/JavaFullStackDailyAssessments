//Deleting a Record from a MySQL Database using JDBC
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteRecord {
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

            // Create a prepared statement to delete a record
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM orders WHERE id =?");

            // Prompt the user to enter the order id to be deleted
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the order ID to be deleted: ");
            int id = scanner.nextInt();

            // Set the value for the prepared statement
            preparedStatement.setInt(1, id);

            // Execute the prepared statement
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Order deleted successfully!");
            } else {
                System.out.println("Failed to delete the order.");
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