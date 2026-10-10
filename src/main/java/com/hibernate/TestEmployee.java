package com.hibernate;

import com.hibernate.DAO.EmployeeDAO;
import com.hibernate.model.Employee;

import java.util.List;

public class TestEmployee {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        //create

        Employee employee1 = new Employee("HEllo","hello@gmail.com","IT",3000);
        employeeDAO.saveEmployee(employee1);


        //READ ALL
        List<Employee> employees = employeeDAO.getAllEmployees();
        for(Employee employee:employees){
            System.out.println(employee.getName());
        }
        //get one emplutee
        Employee employee = employeeDAO.getEmployeeId(1);
        System.out.println("ID: " + employee.getId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Department: " + employee.getDepartment());
        System.out.println("Salary: " + employee.getSalary());

        //update
        Employee updateEmployee = employeeDAO.getEmployeeId(1);
        if(updateEmployee != null){
            updateEmployee.setSalary(8000);
            updateEmployee.setDepartment("it");
            employeeDAO.updateEmployee(updateEmployee);
        }

        //edlete
        employeeDAO.deleteEmployee(2);
        System.out.println("employee deleted");
    }
}
