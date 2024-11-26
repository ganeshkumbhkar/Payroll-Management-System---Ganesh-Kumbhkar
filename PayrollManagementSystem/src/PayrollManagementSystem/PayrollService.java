package PayrollManagementSystem;
import java.util.ArrayList;
public class PayrollService {
    private EmployeeRepository repository;

    public PayrollService(EmployeeRepository repository) {
        this.repository = repository;
    }

    // Add employee to the repository
    public void addEmployee(int id, String name, double basicSalary, double hourlyRate, double taxRate, double bonus, double leaveBalance) {
        Employee newEmployee = new Employee(id, name, basicSalary, hourlyRate, taxRate, bonus, leaveBalance);
        repository.addEmployee(newEmployee);
    }

    // Apply leave to an employee
    public void applyLeave(int id, double days) {
        Employee employee = repository.getEmployeeById(id);
        if (employee != null) {
            employee.applyLeave(days); // Update leave balance and taken days
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Record overtime for an employee
    public void recordOvertime(int id, double hours) {
        Employee employee = repository.getEmployeeById(id);
        if (employee != null) {
            employee.recordOvertime(hours); // Update overtime hours
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Calculate and display pay slip for an employee
    public void displayPaySlip(int id) {
        Employee employee = repository.getEmployeeById(id);
        if (employee != null) {
            employee.displayPaySlip();
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Display all employees' pay slips
    public void displayAllPaySlips() {
        ArrayList<Employee> employees = repository.getAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : employees) {
                employee.displayPaySlip();
            }
        }
    }

    // Update employee information
    public void updateEmployee(int id, String name, double basicSalary, double hourlyRate, double taxRate, double bonus, double leaveBalance) {
        Employee updatedEmployee = new Employee(id, name, basicSalary, hourlyRate, taxRate, bonus, leaveBalance);
        if (!repository.updateEmployee(updatedEmployee)) {
            System.out.println("Employee not found.");
        } else {
            System.out.println("Employee updated successfully.");
        }
    }
}
