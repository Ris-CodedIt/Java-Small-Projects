package com.riscodedit;

import java.sql.*;
import java.util.Scanner;

public class EmployeeDaoimpl implements  EmployeeDaoIntrf{
    private Connection con;
    private Scanner empScanner = new Scanner(System.in);

    @Override
    public void createEmployee() {
        con = DBConnection.createDbConnection();
        System.out.println("Enter Id: ");
        int id = empScanner.nextInt();
        System.out.println("Enter Name: ");
        String name = empScanner.next();
        System.out.println("Enter Salary");
        double salary = empScanner.nextDouble();
        System.out.println("Enter age");
        int age = empScanner.nextInt();

        Employee newEmp = new Employee(id,name,salary,age);
        String query = "insert into employee values(?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, newEmp.getId());
            pstm.setString(2, newEmp.getName());
            pstm.setDouble(3, newEmp.getSalary());
            pstm.setInt(4, newEmp.getAge());

            int count = pstm.executeUpdate();
            if(count!=0)
                System.out.println("Employee Inserted Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showAllEmployees() {
        con = DBConnection.createDbConnection();
        String query = "select * from employee";

        try {
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery(query);
            System.out.println("Employee Details");
            System.out.println("-----------------------------------------------------------------");
            System.out.format("%s\t%s\t%s\t\t%s\n","ID", "Name", "Salary","Age");
            System.out.println("-----------------------------------------------------------------");
            while (results.next()){
                System.out.format("%d\t%s\t%f\t%d\n", results.getInt(1),
                        results.getString(2),
                        results.getDouble(3),
                        results.getInt(4));
                System.out.println("------------------------------------------------------------");
            }
            System.out.println("**********************************************************************");

        } catch (Exception e) {
           e.printStackTrace();
        }

    }

    @Override
    public void showEmployeeBasedOnId(int id) {
        con = DBConnection.createDbConnection();
        String query = "select * from employee where id="+id;

        try {
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery(query);
            System.out.println("Employee Details");
            System.out.println("-----------------------------------------------------------------");
            System.out.format("%s\t%s\t%s\t\t%s\n","ID", "Name", "Salary","Age");
            while (results.next()){
                System.out.format("%d\t%s\t%f\t%d\n", results.getInt(1),
                        results.getString(2),
                        results.getDouble(3),
                        results.getInt(4));
            }
            System.out.println("**********************************************************************");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, String name) {
        con = DBConnection.createDbConnection();
        String query = "update employee set name=? where id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, name);
            pstm.setInt(2, id);

            int count = pstm.executeUpdate();
            if(count!=0)
                System.out.println("Employee Updated Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        con = DBConnection.createDbConnection();
        String query = "delete from employee where id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setInt(1, id);

            int count = pstm.executeUpdate();
            if(count!=0)
                System.out.println("Employee Deleted Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
