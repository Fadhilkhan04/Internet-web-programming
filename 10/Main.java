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
      String query = "SELECT emp_id, bought, age FROM employee";
      ResultSet resultSet = statement.executeQuery(query);

      // Process and display the result set
      System.out.println("emp_id\tbought\tage");
      System.out.println("-------------------------");
      while (resultSet.next()) {
        int emp_id = resultSet.getInt("emp_id");
        String bought = resultSet.getString("bought"); // Ensure case matches with DB column
        int age = resultSet.getInt("age");

        System.out.println(emp_id + "\t" + bought + "\t" + age);
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
