import java.sql.*;
import java.util.Scanner;

public class Main {
  // Database credentials
  private static final String URL = "jdbc:mysql://localhost:3306/testdb";
  private static final String USER = "root";
  private static final String PASSWORD = "";

  // Database connection
  private Connection connection;

  // Constructor to initialize the database connection
  public Main() {
    try {
      // Load MySQL JDBC driver
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection(URL, USER, PASSWORD);
      System.out.println("Database connected successfully.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Add a new student
  public void addStudent(String name, int age, String grade) {
    String query = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setString(1, name);
      statement.setInt(2, age);
      statement.setString(3, grade);
      statement.executeUpdate();
      System.out.println("Student added successfully.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // View all students
  public void viewStudents() {
    String query = "SELECT * FROM students";
    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {
      System.out.println("ID\tName\t\tAge\tGrade");
      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String grade = resultSet.getString("grade");
        System.out.printf("%d\t%s\t\t%d\t%s%n", id, name, age, grade);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // Update a student's information
  public void updateStudent(int id, String name, int age, String grade) {
    String query = "UPDATE students SET name = ?, age = ?, grade = ? WHERE id = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setString(1, name);
      statement.setInt(2, age);
      statement.setString(3, grade);
      statement.setInt(4, id);
      int rowsUpdated = statement.executeUpdate();
      if (rowsUpdated > 0) {
        System.out.println("Student updated successfully.");
      } else {
        System.out.println("No student found with the provided ID.");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // Delete a student by ID
  public void deleteStudent(int id) {
    String query = "DELETE FROM students WHERE id = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setInt(1, id);
      int rowsDeleted = statement.executeUpdate();
      if (rowsDeleted > 0) {
        System.out.println("Student deleted successfully.");
      } else {
        System.out.println("No student found with the provided ID.");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // Close the database connection
  public void close() {
    try {
      if (connection != null) {
        connection.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // Main function with a simple text-based menu
  public static void main(String[] args) {
    Main sms = new Main();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\n--- Student Management System ---");
      System.out.println("1. Add Student");
      System.out.println("2. View Students");
      System.out.println("3. Update Student");
      System.out.println("4. Delete Student");
      System.out.println("5. Exit");
      System.out.print("Choose an option: ");
      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          System.out.print("Enter Name: ");
          String name = scanner.next();
          System.out.print("Enter Age: ");
          int age = scanner.nextInt();
          System.out.print("Enter Grade: ");
          String grade = scanner.next();
          sms.addStudent(name, age, grade);
          break;
        case 2:
          sms.viewStudents();
          break;
        case 3:
          System.out.print("Enter Student ID to Update: ");
          int idToUpdate = scanner.nextInt();
          System.out.print("Enter New Name: ");
          String newName = scanner.next();
          System.out.print("Enter New Age: ");
          int newAge = scanner.nextInt();
          System.out.print("Enter New Grade: ");
          String newGrade = scanner.next();
          sms.updateStudent(idToUpdate, newName, newAge, newGrade);
          break;
        case 4:
          System.out.print("Enter Student ID to Delete: ");
          int idToDelete = scanner.nextInt();
          sms.deleteStudent(idToDelete);
          break;
        case 5:
          sms.close();
          System.out.println("Exiting Student Management System.");
          return;
        default:
          System.out.println("Invalid option. Please try again.");
      }
    }
  }
}
