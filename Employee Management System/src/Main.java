import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDaoIntrf dao = new EmployeeDaoImpl();
        System.out.println("Welcome to Employee Management Application");

        while (true) {
            System.out.println("1. Add Employee \n" +
                    "2. Show All Employees \n" +
                    "3. Show Employee based on ID \n" +
                    "4. Update Employee \n" +
                    "5. Delete Employee \n" +
                    "6. Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    // Add employee
                    Employee emp = new Employee();
                    System.out.println("Enter Employee ID: ");
                    int id = sc.nextInt();
                    System.out.println("Enter Employee Name: ");
                    String name = sc.next();
                    System.out.println("Enter Employee Salary: ");
                    double salary = sc.nextDouble();
                    System.out.println("Enter Employee Age: ");
                    int age = sc.nextInt();

                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    dao.createEmployee(emp); // Assumes createEmployee is implemented
                    break;

                case 2:
                    // Show all employees
                    dao.showAllEmployee(); // Assumes showAllEmployee is implemented
                    break;

                case 3:
                    // Show employee by ID
                    System.out.println("Enter Employee ID to show the details: ");
                    int empid = sc.nextInt();
                    dao.showEmployeeBasedOnID(empid); // Assumes showEmployeeBasedOnID is implemented
                    break;

                case 4:
                    // Update employee
                    System.out.println("Enter Employee ID to update the details: ");
                    int empid1 = sc.nextInt();
                    System.out.println("Enter new Employee Name: ");
                    String newName = sc.next();
                    dao.updateEmployee(empid1, newName); // Assumes updateEmployee is implemented
                    break;

                case 5:
                    // Delete employee
                    System.out.println("Enter Employee ID to delete: ");
                    int empidToDelete = sc.nextInt();
                    dao.deleteEmployee(empidToDelete); // Assumes deleteEmployee is implemented
                    break;

                case 6:
                    // Exit the application
                    System.out.println("Thank you for using our Application!");
                    System.exit(0); // Exit the application

                default:
                    System.out.println("Invalid choice, please enter a valid option!");
                    break;
            }
        }
    }
}
