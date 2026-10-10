package com.hibernate.servlet;

import com.hibernate.DAO.EmployeeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete-employee")
public class DeleteEmployee extends HttpServlet {

    private EmployeeDAO employeeDAO;

    @Override
    public void init() {

        employeeDAO =
                new EmployeeDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int id=Integer.parseInt(request.getParameter("id"));
        employeeDAO.deleteEmployee(id);
        response.sendRedirect( request.getContextPath()
                + "/employees");
    }
}
