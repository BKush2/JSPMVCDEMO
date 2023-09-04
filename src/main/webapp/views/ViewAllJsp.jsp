<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
        /* Add CSS styles for the button */
        .blue-button {
            background-color: blue;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }
    </style>
    <meta charset="UTF-8">
    <title>View All Employees</title>
</head>
<body>
    <h1>Employee List</h1>
    <p>Below is the list of all employees:</p>

    <!-- Display the HTML table -->
    <%= request.getAttribute("tableHtml") %>
    <script>
            // This script will remove the deleted row from the table
            var deletedEmployeeId = "<%= request.getParameter("deletedEmployeeId") %>";
            if (deletedEmployeeId !== "") {
                var rowToDelete = document.querySelector("tr[data-employee-id='" + deletedEmployeeId + "']");
                if (rowToDelete) {
                    rowToDelete.remove();
                }
            }
        </script>
         <button class="blue-button" onclick="redirectToRegister()">Go to Register</button>
            <script>
                // Function to redirect to the register.jsp page
                function redirectToRegister() {
                    window.location.href = "register";
                }
            </script>
</body>
</html>