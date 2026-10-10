package com.hibernate.servlet;

import com.hibernate.DAO.EmployeeDAO;
import com.hibernate.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/save-employee")
public class saveEmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;
    @Override
    public void init(){
        employeeDAO = new EmployeeDAO();
        System.out.println("save emoel");
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("save Employee");
        String IdParam = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String department = req.getParameter("department");
        String salary = req.getParameter("salary");
        //convert id
        int id=0;
        if(IdParam!=null && !IdParam.equals("")){
            id=Integer.parseInt(IdParam);
        }

        //salaary
        double sal=0;
        if(salary!=null && !salary.equals("")){
            sal=Double.parseDouble(salary);
        }
        System.out.println("id:"+IdParam+" name:"+name+" email:"+email+" department:"+department+" salary:"+salary);
        Employee employee = new Employee();

        employee.setName(name);
        employee.setEmail(email);
        employee.setDepartment(department);
        employee.setSalary(sal);
        employeeDAO.saveEmployee(employee);
        resp.sendRedirect(req.getContextPath()+"/employees");
    }
}
