import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
  // Replace with your database credentials
  private static final String URL = "jdbc:mysql://localhost:3306/testdb";
  private static final String USER = "root";
  private static final String PASSWORD = "";

  public static void main(String[] args) {
    Connection connection = null;
    Statement statement = null;

    try {
      // Load MySQL JDBC Driver
      Class.forName("com.mysql.cj.jdbc.Driver");

      // Establish the connection
      connection = DriverManager.getConnection(URL, USER, PASSWORD);

      // Create a statement
      statement = connection.createStatement();

      // Execute the query
      String query = "SELECT id, name, marks FROM student";
      ResultSet resultSet = statement.executeQuery(query);

      // Process and display the result set
      System.out.println("id\tname\tmarks");
      System.out.println("-------------------------");
      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name"); // Ensure case matches with DB column
        int marks = resultSet.getInt("marks");

        System.out.println(id + "\t" + name + "\t" + marks);
      }

      // Close the result set
      resultSet.close();
    } catch (ClassNotFoundException e) {
      System.out.println("MySQL JDBC Driver not found.");
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        // Close the statement and connection
        if (statement != null)
          statement.close();
        if (connection != null)
          connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
