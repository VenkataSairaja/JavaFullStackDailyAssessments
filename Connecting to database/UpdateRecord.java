//Updating a Record in a MySQL Database using JDBC
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateRecord {
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

            // Create a prepared statement to update a record
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products SET price =? WHERE id =?");

            // Prompt the user to enter the product id and new price
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the product ID: ");
            int id = scanner.nextInt();
            System.out.println("Enter the new price: ");
            double price = scanner.nextDouble();

            // Set the values for the prepared statement
            preparedStatement.setDouble(1, price);
            preparedStatement.setInt(2, id);

            // Execute the prepared statement
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Product price updated successfully!");
            } else {
                System.out.println("Failed to update the product price.");
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