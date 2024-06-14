//write one java program which shows the diffrence between Statement and PreparedStatement
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementVsPreparedStatement {
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

            // Create a Statement object
            Statement statement = connection.createStatement();

            // Execute a query using Statement
            statement.executeUpdate("UPDATE employees SET salary = 50000 WHERE id = 1");

            // Create a PreparedStatement object
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employees SET salary =? WHERE id =?");

            // Set the values for the PreparedStatement
            preparedStatement.setInt(1, 60000);
            preparedStatement.setInt(2, 2);

            // Execute the PreparedStatement
            preparedStatement.executeUpdate();

            System.out.println("Statement and PreparedStatement examples executed successfully!");

            // Close the resources
            statement.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found!");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}