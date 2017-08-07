//package name
package ejd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kodyscharf
 */
public class EmployeeDatabase {

    //three constants for database access
    public static final String DB_URL = "jdbc:mysql://localhost:3306/ejd";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "Ginger123";

    public ArrayList<Employee> findEmployees(String firstName) {

        ArrayList<Employee> employees = new ArrayList();

            try {
                
                //make connection to database
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

                //create statement
                String sql = "SELECT * FROM Employee WHERE firstName LIKE ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, firstName + "%");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    int id = rs.getInt(1);
                    String fn = rs.getString(2);
                    String lastName = rs.getString(3);
                    String department = rs.getString(4);
                    double salary = rs.getDouble(5);

                    Employee employee = new Employee(id, fn, lastName, department, salary);

                    employees.add(employee);

                }

                rs.close();
                ps.close();
                connection.close();

            } catch (SQLException e) {

                System.err.println(e.getSQLState() + ": " + e.getMessage());
            } catch (Exception e) {

                System.err.println(e.getMessage());

            }

        
        return employees;
    }
    

}
