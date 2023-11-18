package com.riscodedit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDaoIntrf dao = new EmployeeDaoimpl();
        Scanner scanner= new Scanner(System.in);
        System.out.println("Welcome to employee management Application");

        do{
            System.out.println("What would you like to do?");
            System.out.println("1.Add Employee\n" +
                    "2. Show All Employee\n" +
                    "3. Show Employee Based on id\n" +
                    "4. Update Employee\n" +
                    "5. Delete Employee\n" +
                    "0. Exit");

            System.out.print("Enter Choice:  ");

            int choice  = scanner.nextInt();
            switch (choice){
                case 0:
                    System.out.println("Thank you for your time.");
                    System.exit(0);
                case 1:
                    dao.createEmployee();
                    break;

                case 2:
                    dao.showAllEmployees();
                    break;

                case 3:
                    System.out.print("Enter ID:  ");
                    int id = scanner.nextInt();
                    dao.showEmployeeBasedOnId(id);
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int id1 = scanner.nextInt();
                    System.out.println("Enter Name:  ");
                    String name = scanner.next();
                    dao.updateEmployee(id1,name);
                    break;
                case 5:
                    System.out.print("Enter ID:  ");
                    int id2 = scanner.nextInt();
                    dao.deleteEmployee(id2);
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }


        }while (true);
    }
}
