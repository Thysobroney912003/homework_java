//run javac EmployeeManagementSystem.java open cmd ot teminol
// run java EmployeeManagementSystem

import java.util.*;

public class EmployeeManagementSystem {
    static Scanner scanner = new Scanner(System.in);
    static List<Employee> employees = new ArrayList<>(); // List to hold employee data

    static class Employee {
        int id;
        String name;
        double salary; 

        Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Salary: $" + salary;
        }
    }

    public static void main(String[] args) {
        login();
        mainMenu();
    }

    private static void login() {
        String correctUsername = "ney";
        String correctPassword = "1111";
        while (true) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Correct username and password.");
                System.out.println("Welcome to Employee Management Software\n");
                break;
            } else {
                System.out.println("Your info is not correct, please input again.\n");
            }
        }
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("Main Menu");
            System.out.println("1) Add a new employee");
            System.out.println("2) View all the employees");
            System.out.println("3) Update employee");
            System.out.println("4) Delete employee");
            System.out.println("5) Find the highest and lowest salaries");
            System.out.println("6) Sort employees by ID");
            System.out.println("0) Exit Program");
            System.out.print("Please select an option (0-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    findSalaryExtremes();
                    break;
                case 6:
                    sortEmployeesById();
                    break;
                case 0:
                    System.out.println("Exiting Program... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please select between 0-6.");
            }
        }
    }

    private static void addEmployee() {
        while (true) {
            System.out.print("Enter Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Employee Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            employees.add(new Employee(id, name, salary));
            System.out.print("Do you want to input another (Y/N): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    private static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("\nEmployee List:");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }
private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        boolean found = false;

        for (Employee emp : employees) {
            if (emp.id == id) {
                System.out.print("Enter new Name: ");
                emp.name = scanner.nextLine();

                System.out.print("Enter new Salary: ");
                emp.salary = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                System.out.println("Employee updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        boolean found = false;

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.id == id) {
                iterator.remove();
                System.out.println("Employee deleted successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    private static void findSalaryExtremes() {
        if (employees.isEmpty()) {
            System.out.println("No employees to calculate salaries.");
            return;
        }

        Employee highest = employees.get(0);
        Employee lowest = employees.get(0);

        for (Employee emp : employees) {
            if (emp.salary > highest.salary) {
                highest = emp;
            }
            if (emp.salary < lowest.salary) {
                lowest = emp;
            }
        }

        System.out.println("Employee with Highest Salary: " + highest);
        System.out.println("Employee with Lowest Salary: " + lowest);
    }

    private static void sortEmployeesById() {
        if (employees.isEmpty()) {
            System.out.println("No employees to sort.");
            return;
        }

        employees.sort(Comparator.comparingInt(emp -> emp.id));
        System.out.println("Employees sorted by ID.");
        viewEmployees();
    }
}