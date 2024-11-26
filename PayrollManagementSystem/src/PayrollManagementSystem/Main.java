package PayrollManagementSystem;
import java.util.Scanner;

import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Initialize repository and service
        EmployeeRepository repository = new EmployeeRepository();
        PayrollService service = new PayrollService(repository);

        while (true) {
            System.out.println("\n---------------------------");
            System.out.println("Press:\n1 For Add Employee\n2 For Apply Leave\n3 For Record Overtime\n4 For Display Pay Slip\n5 For Update Employee\n6 For Display All Pay Slips\n7 For Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Add Employee
                    System.out.println("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.println("Enter Employee Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Basic Salary: ");
                    double basicSalary = sc.nextDouble();
                    System.out.println("Enter Hourly Rate: ");
                    double hourlyRate = sc.nextDouble();
                    System.out.println("Enter Tax Rate: ");
                    double taxRate = sc.nextDouble();
                    System.out.println("Enter Bonus: ");
                    double bonus = sc.nextDouble();
                    System.out.println("Enter Leave Balance: ");
                    double leaveBalance = sc.nextDouble();
                    service.addEmployee(id, name, basicSalary, hourlyRate, taxRate, bonus, leaveBalance);
                    break;

                case 2:
                    // Apply Leave
                    System.out.println("Enter Employee ID to apply leave: ");
                    id = sc.nextInt();
                    System.out.println("Enter number of days for leave: ");
                    double leaveDays = sc.nextDouble();
                    service.applyLeave(id, leaveDays);
                    break;

                case 3:
                    // Record Overtime
                    System.out.println("Enter Employee ID to record overtime: ");
                    id = sc.nextInt();
                    System.out.println("Enter number of overtime hours: ");
                    double overtimeHours = sc.nextDouble();
                    service.recordOvertime(id, overtimeHours);
                    break;

                case 4:
                    // Display Pay Slip for a single employee
                    System.out.println("Enter Employee ID to display pay slip: ");
                    id = sc.nextInt();
                    service.displayPaySlip(id);
                    break;

                case 5:
                    // Update Employee details
                    System.out.println("Enter Employee ID to update: ");
                    id = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.println("Enter New Employee Name: ");
                    name = sc.nextLine();
                    System.out.println("Enter New Basic Salary: ");
                    basicSalary = sc.nextDouble();
                    System.out.println("Enter New Hourly Rate: ");
                    hourlyRate = sc.nextDouble();
                    System.out.println("Enter New Tax Rate: ");
                    taxRate = sc.nextDouble();
                    System.out.println("Enter New Bonus: ");
                    bonus = sc.nextDouble();
                    System.out.println("Enter New Leave Balance: ");
                    leaveBalance = sc.nextDouble();
                    service.updateEmployee(id, name, basicSalary, hourlyRate, taxRate, bonus, leaveBalance);
                    break;

                case 6:
                    // Display Pay Slips for all employees
                    service.displayAllPaySlips();
                    break;

                case 7:
                    // Exit the program
                    System.out.println("Exiting the program. Thank you!");
                    sc.close();
                    return;  // Exit the loop and end the program

                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
            
