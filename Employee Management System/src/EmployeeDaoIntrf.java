public interface EmployeeDaoIntrf {
    // Create employee
    void createEmployee(Employee emp);

    // Show all employees
    void showAllEmployee();

    // Show employee by ID
    void showEmployeeBasedOnID(int id);

    // Update employee
    void updateEmployee(int id, String name);

    // Delete employee
    void deleteEmployee(int id);
}
