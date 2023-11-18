package com.riscodedit;

public interface EmployeeDaoIntrf {
    void createEmployee();
    void showAllEmployees();
    void showEmployeeBasedOnId(int id);
    void updateEmployee(int id, String name);

    void deleteEmployee(int id);

}
