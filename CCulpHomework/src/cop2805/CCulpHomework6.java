package cop2805;
import java.sql.*;
import java.util.*;

public class CCulpHomework6 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        Connection connection;

        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","cop2805");
            Statement statement = connection.createStatement();

            ResultSet res = null;
            res = statement.executeQuery("SELECT * FROM Employees");

            while (res.next()) {
                Employee emp = new Employee(res.getInt("employeeId"), res.getString("firstName"), res.getString("lastName"));
                employees.add(emp);
            }

            for (Employee emp : employees) {
                System.out.println(emp.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class Employee {
    int employeeId;
    String firstName;
    String lastName;

    public Employee(int id, String firstName, String lastName) {
        this.employeeId = id;
        this. firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(employeeId + ": " + lastName + ", " + firstName);
    }
}
