package com.hibernate.servlet;

import com.hibernate.DAO.EmployeeDAO;
import com.hibernate.model.Employee;
import com.hibernate.util.ThymeLeafConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
@WebServlet("/edit-employee")
public class EditEmployee extends HttpServlet {
    private EmployeeDAO employeeDAO;
    private TemplateEngine templateEngine;
    @Override
    public void init(){
        employeeDAO = new EmployeeDAO();
        templateEngine= ThymeLeafConfig.createTemplateEngine();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeDAO.getEmployeeId(id);

        if (employee == null) {

            response.sendError(
                    HttpServletResponse.SC_NOT_FOUND,
                    "Employee not found"
            );

            return;
        }


        IWebExchange exchange =
                JakartaServletWebApplication
                        .buildApplication(
                                getServletContext()
                        )
                        .buildExchange(
                                request,
                                response
                        );


        WebContext context =
                new WebContext(
                        exchange,
                        request.getLocale()
                );


        context.setVariable(
                "employee",
                employee
        );


        templateEngine.process(
                "employee-form",
                context,
                response.getWriter()
        );

    }
}
