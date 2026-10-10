package com.hibernate.servlet;

import com.hibernate.DAO.EmployeeDAO;
import com.hibernate.model.Employee;

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
import java.util.List;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {

    private EmployeeDAO employeeDAO;

    private TemplateEngine templateEngine;

    @Override
    public void init() {

        employeeDAO = new EmployeeDAO();

        templateEngine = new TemplateEngine();

        org.thymeleaf.templateresolver.ClassLoaderTemplateResolver resolver =
                new org.thymeleaf.templateresolver.ClassLoaderTemplateResolver();

        resolver.setPrefix("templates/");

        resolver.setSuffix(".html");

        resolver.setTemplateMode("HTML");

        resolver.setCharacterEncoding("UTF-8");

        templateEngine.setTemplateResolver(resolver);
    }


    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Employee> employees =
                employeeDAO.getAllEmployees();

        IWebExchange webExchange =
                JakartaServletWebApplication
                        .buildApplication(getServletContext())
                        .buildExchange(request, response);

        WebContext context =
                new WebContext(
                        webExchange,
                        request.getLocale()
                );

        context.setVariable(
                "employees",
                employees
        );

        templateEngine.process(
                "employees",
                context,
                response.getWriter()
        );
    }
}