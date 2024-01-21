import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PayrollSystem payrollSystem = new PayrollSystem();
        int choice;
        do {
            System.out.println("\nEmployee Payroll System");
            System.out.println("1. Add New Employee (Full Time)");
            System.out.println("2. Add New Employee (Part Time)");
            System.out.println("3. Remove Employee");
            System.out.println("4. Show all employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addFullTimeEmployee(sc, payrollSystem);
                    break;
                case 2:
                    addPartTimeEmployee(sc, payrollSystem);
                    break;
                case 3:
                    removeEmployee(sc, payrollSystem);
                    break;
                case 4:
                    payrollSystem.displayEmployees();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
    private static void addFullTimeEmployee(Scanner sc, PayrollSystem payrollSystem) {
        System.out.print("Enter employee name: ");
        String name = sc.nextLine();
        System.out.print("Enter employee id: ");
        int id = sc.nextInt();
        System.out.print("Enter monthly salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        FullTimeEmployee emp = new FullTimeEmployee(name, id, salary);
        payrollSystem.addEmployee(emp);
        System.out.println("Full-time employee added successfully.");
    }

    private static void addPartTimeEmployee(Scanner sc, PayrollSystem payrollSystem) {
        System.out.print("Enter employee name: ");
        String name = sc.nextLine();
        System.out.print("Enter employee id: ");
        int id = sc.nextInt();
        System.out.print("Enter hours worked: ");
        int hours = sc.nextInt();
        System.out.print("Enter hourly rate: ");
        double rate = sc.nextDouble();
        sc.nextLine();

        PartTimeEmployee emp = new PartTimeEmployee(name, id, hours, rate);
        payrollSystem.addEmployee(emp);
        System.out.println("Part-time employee added successfully.");
    }

    private static void removeEmployee(Scanner sc, PayrollSystem payrollSystem) {
        payrollSystem.displayEmployees();
        System.out.print("Enter employee id to remove: ");
        int id = sc.nextInt();
        sc.nextLine();

        payrollSystem.removeEmployee(id);
        System.out.println("Employee with ID " + id + " removed successfully.");
    }
}


abstract class Employee {
    private String empName;
    private int empId;
    public Employee(String empName, int empId){
        this.empName = empName;
        this.empId = empId;
    }
    // getEmpName and getEmpId
    public String getEmpName(){
        return empName;
    }
    public int getEmpId(){
        return empId;
    }
    // abstract method
    public abstract double calculateSalary();

    // overriding toString() method.
    @Override
    public String toString(){
        return "Employee,[name="+empName+",id="+empId+",salary="+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String empName, int empId, double monthlySalary){
        super(empName,empId);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}
class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String empName, int empId, int hoursWorked, double hourlyRate){
        super(empName,empId);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double calculateSalary(){
        return (hourlyRate * hoursWorked);
    }
}

class PayrollSystem{
    private List<Employee> employeeList;
    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int empId){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
             if(employee.getEmpId() == empId){
                 employeeToRemove = employee;
                 break;
             }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployees(){
        for(Employee employee : employeeList){
            System.out.println(employee);
        }
    }
}
