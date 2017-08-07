/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejd;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kodyscharf
 */
@WebServlet("/EmployeeDirectory")
public class EmployeeDirectory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //create db to get instance of all employees
        EmployeeDatabase db = new EmployeeDatabase();

        String firstName = request.getParameter("firstName");

        
        
        //arrayList of employees
        ArrayList<Employee> employees = db.findEmployees(firstName);

        //set attribute
        request.setAttribute("employees", employees);

        //send over to the employeeDirectory.jsp page
        RequestDispatcher rd = request.getRequestDispatcher("employeeDirectory.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
