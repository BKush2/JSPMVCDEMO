package Jsp.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

    public class EmployeeControllerDelete extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String jdbcUrl = "jdbc:mysql://localhost:3306/employees";
            String jdbcUser = "root";
            String jdbcPassword = "root";

            String employeeId = request.getParameter("employeeId");

            try {
                Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);

                // Query to delete the employee with the given ID
                String deleteQuery = "DELETE FROM employee WHERE employee_id = ?";

                PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
                pstmt.setString(1, employeeId);
                pstmt.executeUpdate();

                pstmt.close();
                conn.close();

                // Redirect back to the original page after deletion
                response.sendRedirect(request.getContextPath() + "/EmployeeControllerView");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
