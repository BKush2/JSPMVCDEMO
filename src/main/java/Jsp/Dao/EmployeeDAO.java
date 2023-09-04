package Jsp.Dao;

import Jsp.model.EmployeeModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL JDBC driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/employees";
        String jdbcUser = "root";
        String jdbcPassword = "root";

        return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
    }

    public boolean insertEmployee(EmployeeModel employee) {
        String insertQuery = "INSERT INTO employee (employee_firstname, employee_lastname, employee_DOB, employee_gender, employee_email, employee_phoneno, employee_subject) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = getConnection();
            try {
                PreparedStatement pstmt = conn.prepareStatement(insertQuery);
                try {

                    pstmt.setString(1, employee.getFirstName());
                    pstmt.setString(2, employee.getLastName());
                    pstmt.setString(3, employee.getDOB());
                    pstmt.setString(4, employee.getGender());
                    pstmt.setString(5, employee.getEmail());
                    pstmt.setString(6, employee.getPhone_no());
                    pstmt.setString(7, employee.getSubject());

                    int rowsInserted = pstmt.executeUpdate();
                    return rowsInserted > 0;

                } finally {
                    pstmt.close();
                }
            } finally {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
