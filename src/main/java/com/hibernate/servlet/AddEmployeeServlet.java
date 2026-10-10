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
@WebServlet("/add-employee")
public class AddEmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;
    private TemplateEngine templateEngine;
    public  void init(){
        employeeDAO =new EmployeeDAO();
        templateEngine = ThymeLeafConfig.createTemplateEngine();
    }
    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        Employee employee =new Employee();
        IWebExchange webExchange =
                JakartaServletWebApplication
                        .buildApplication(getServletContext())
                        .buildExchange(request, response);
        WebContext context =new WebContext(webExchange,request.getLocale());
        context.setVariable("employee",employee);
        templateEngine.process(
                "employee-form",
                context,
                response.getWriter()
        );

    }
}
