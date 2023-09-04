package Jsp.controller;
import Jsp.Dao.EmployeeDAO;
import Jsp.model.EmployeeModel;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class EmployeeControllerInsert extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeModel employee = new EmployeeModel();
        String firstname = request.getParameter("employee_firstname");
        employee.setFirstName(firstname);
        String lastname = request.getParameter("employee_lastname");
        employee.setLastName(lastname);
        String dob = request.getParameter("employee_DOB");
        employee.setDOB(dob);
        String gender = request.getParameter("employee_gender");
        employee.setGender(gender);
        String email = request.getParameter("employee_email");
        employee.setEmail(email);
        String phoneno = request.getParameter("employee_phoneno");
        employee.setPhone_no(phoneno);
        String subject = request.getParameter("employee_subject");
        employee.setSubject(subject);

            // Call the DAO method to insert employee data
        EmployeeDAO employeeDAO = new EmployeeDAO();
        boolean insertionSuccessful = employeeDAO.insertEmployee(employee);

        if (insertionSuccessful) {
            // Set attributes for forwarding to result.jsp
            response.sendRedirect(request.getContextPath() + "/EmployeeControllerView");
        } else {
            System.out.println("Data not inserted");
        }
    }
}
