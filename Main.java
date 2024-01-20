import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PayrollSystem payrollSystem = new PayrollSystem();
        System.out.println("Employee Payroll System");
        System.out.print("1. Add New Employee (Full Time)\n2. Add New Employee (Part Time)\n3. Remove Employee\n4. Show all employees\nEnter your choice : ");
        int choice = sc.nextInt();
        switch (choice){
            case 1 -> {
                System.out.print("enter employee name : ");
                String name = sc.next();
                System.out.print("enter id : ");
                int id = sc.nextInt();
                System.out.print("enter monthly salary : ");
                double salary = sc.nextDouble();
                FullTimeEmployee emp = new FullTimeEmployee(name,id,salary);
                payrollSystem.addEmployee(emp);
            }
            case 2 -> {
                System.out.print("enter employee name : ");
                String name = sc.next();
                System.out.print("enter id : ");
                int id = sc.nextInt();
                System.out.print("enter hours worked : ");
                int hours = sc.nextInt();
                System.out.print("enter rate : ");
                double rate = sc.nextDouble();
                PartTimeEmployee emp = new PartTimeEmployee(name,id,hours,rate);
                payrollSystem.addEmployee(emp);
            }
            case 3 -> {
                payrollSystem.displayEmployees();
                System.out.print("enter employee id : ");
                int id = sc.nextInt();
                System.out.print("removing employee..");
                payrollSystem.removeEmployee(id);
            }
            case 4 -> {
                System.out.println("* Employees *");
                payrollSystem.displayEmployees();
            }
        }

//        FullTimeEmployee emp1 = new FullTimeEmployee("Vikas Kumar",1,70000);
//        PartTimeEmployee emp2 = new PartTimeEmployee("Ravi Kisan",2,100,300.0);
//
//        payrollSystem.addEmployee(emp1);
//        payrollSystem.addEmployee(emp2);
//        System.out.println("Initial Employees Details : ");
//        payrollSystem.displayEmployees();
//        System.out.println("Removing Employee ..");
//        payrollSystem.removeEmployee(2);
//        System.out.println("Remaining Employees Details : ");
//        payrollSystem.displayEmployees();
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

