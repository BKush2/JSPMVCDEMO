package Jsp.controller;

import javax.servlet.*;
import java.io.IOException;
    public class ValidationFilter implements Filter {
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            String firstname = request.getParameter("employee_firstname");
            String phoneno = request.getParameter("employee_phoneno");

            if (firstname != null && firstname.matches("[a-zA-Z]+") &&
                    phoneno != null && phoneno.matches("\\d{10}")) {
                // Validation passed, redirect to the database connectivity servlet
                RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeControllerInsert");
                dispatcher.forward(request, response);

            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/register.jsp");
                dispatcher.forward(request, response);
            }
        }

        public void init(FilterConfig fConfig) throws ServletException {
            // Initialization code
        }

        public void destroy() {
            // Cleanup code
        }
    }