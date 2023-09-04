package Jsp.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class EmployeeControllerView extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String jdbcUrl = "jdbc:mysql://localhost:3306/employees";
            String jdbcUser = "root";
            String jdbcPassword = "root";

            try {
                Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);

                // Query to retrieve all fields except Employee ID from the "employee" table
                String selectQuery = "SELECT * FROM employee"; // Modify this query according to your table structure

                PreparedStatement pstmt = conn.prepareStatement(selectQuery);
                ResultSet resultSet = pstmt.executeQuery();

                // Create a StringBuilder to store the HTML table
                StringBuilder tableHtml = new StringBuilder();
                tableHtml.append("<table border='3'><tr><th>First Name</th><th>Last Name</th><th>Date of Birth</th><th>Gender</th><th>Email</th><th>Phone Number</th><th>Subject</th></tr>");

                while (resultSet.next()) {
                    String firstName = resultSet.getString("employee_firstname");
                    String lastName = resultSet.getString("employee_lastname");
                    String dob = resultSet.getString("employee_DOB");
                    String gender = resultSet.getString("employee_gender");
                    String email = resultSet.getString("employee_email");
                    String phoneNumber = resultSet.getString("employee_phoneno");
                    String subject = resultSet.getString("employee_subject");

                    tableHtml.append("<tr><td>").append(firstName).append("</td><td>").append(lastName).append("</td><td>")
                            .append(dob).append("</td><td>").append(gender)
                            .append("</td><td>").append(email).append("</td><td>").append(phoneNumber).append("</td><td>")
                            .append(subject).append("</td><td>")
                            .append("<form action='EmployeeControllerDelete' method='post'>")
                            .append("<input type='hidden' name='employeeId' value='").append(resultSet.getString("employee_id")).append("' />")
                            .append("<input type='submit' value='Delete' />")
                            .append("</form>").append("</td></tr>");
                }

                tableHtml.append("</table>");

                // Set the HTML table as an attribute to be used in your JSP
                request.setAttribute("tableHtml", tableHtml.toString());

                // Forward to a JSP page that will display the table
                RequestDispatcher dispatcher = request.getRequestDispatcher("/views/ViewAllJsp.jsp");
                dispatcher.forward(request, response);

                resultSet.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }