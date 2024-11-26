package PayrollManagementSystem;

public class Employee {
    private int id;
    private String name;
    private double basicSalary;
    private double hourlyRate;  // For overtime calculations
    private double taxRate;
    private double bonus;
    private double overtimeHours;
    private double leaveTaken;
    private double leaveBalance;

    // Constructor
    public Employee(int id, String name, double basicSalary, double hourlyRate, double taxRate, double bonus, double leaveBalance) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
        this.hourlyRate = hourlyRate;
        this.taxRate = taxRate;
        this.bonus = bonus;
        this.leaveBalance = leaveBalance;
        this.leaveTaken = 0; // Initially no leave taken
        this.overtimeHours = 0; // Initially no overtime hours
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public double getLeaveTaken() {
        return leaveTaken;
    }

    public void setLeaveTaken(double leaveTaken) {
        this.leaveTaken = leaveTaken;
    }

    public double getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(double leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    // Method to apply leave
    public void applyLeave(double days) {
        if (days <= leaveBalance) {
            leaveBalance -= days;
            leaveTaken += days;
        } else {
            System.out.println("Insufficient leave balance.");
        }
    }

    // Method to record overtime
    public void recordOvertime(double hours) {
        overtimeHours += hours;
    }

    // Method to calculate and display pay slip
    public void displayPaySlip() {
        double grossSalary = basicSalary + (overtimeHours * hourlyRate) + bonus;
        double tax = grossSalary * taxRate;
        double netSalary = grossSalary - tax;

        System.out.println("Pay Slip for " + name + " (ID: " + id + ")");
        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("Tax: " + tax);
        System.out.println("Net Salary: " + netSalary);
        System.out.println("Overtime Hours: " + overtimeHours);
        System.out.println("Leave Taken: " + leaveTaken);
        System.out.println("Leave Balance: " + leaveBalance);
    }
}
