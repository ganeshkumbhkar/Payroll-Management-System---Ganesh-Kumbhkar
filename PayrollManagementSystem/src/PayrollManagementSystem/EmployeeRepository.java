package PayrollManagementSystem;
import java.util.ArrayList;

public class EmployeeRepository {
    private ArrayList<Employee> employees;

    public EmployeeRepository() {
        employees = new ArrayList<>();
    }

    // Add employee to the list
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Get employee by ID
    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    // Get all employees
    public ArrayList<Employee> getAllEmployees() {
        return employees;
    }

    // Update employee
    public boolean updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == updatedEmployee.getId()) {
                employees.set(i, updatedEmployee);
                return true;
            }
        }
        return false;
    }
}

