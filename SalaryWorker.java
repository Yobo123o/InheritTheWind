/**
 * SalaryWorker represents a worker with a fixed annual salary.
 * Inherits from Worker but overrides pay calculation and XML serialization.
 */
public class SalaryWorker extends Worker {
    private double annualSalary; // Fixed yearly salary

    /**
     * Constructor for SalaryWorker.
     * Calls the Worker constructor but ignores hourly pay rate.
     *
     * @param firstName   First name
     * @param lastName    Last name
     * @param ID          Unique identifier
     * @param title       Prefix (Mr., Dr., etc.)
     * @param YOB         Year of birth
     * @param annualSalary Fixed annual salary
     */
    public SalaryWorker(String firstName, String lastName, String ID, String title, int YOB, double annualSalary) {
        super(firstName, lastName, ID, title, YOB, 0); // Hourly rate irrelevant
        this.annualSalary = annualSalary;
    }

    /**
     * Calculates weekly salary.
     * Always returns (annualSalary / 52), ignoring hours worked.
     *
     * @param hoursWorked Ignored parameter (kept for polymorphism)
     * @return Weekly salary
     */
    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52;
    }

    /**
     * Displays fixed weekly salary.
     *
     * @param hoursWorked Ignored parameter
     */
    @Override
    public void displayWeeklyPay(double hoursWorked) {
        System.out.printf("%s: Weekly Salary: $%.2f%n", fullName(), calculateWeeklyPay(hoursWorked));
    }

    /** Converts salary worker data to CSV format */
    @Override
    public String toCSV() {
        return super.toCSV() + "," + annualSalary;
    }

    /** Converts salary worker data to JSON format */
    @Override
    public String toJSON() {
        return super.toJSON().replace("}", ", \"AnnualSalary\":" + annualSalary + "}");
    }

    /**
     * Converts salary worker data to XML format.
     * Ensures that `<HourlyPayRate>` is removed since SalaryWorker doesn't use it.
     */
    @Override
    public String toXML() {
        String xml = super.toXML();
        xml = xml.replaceAll("<HourlyPayRate>.*?</HourlyPayRate>", ""); // Remove hourly pay rate
        return xml.replace("</Person>", "<AnnualSalary>" + annualSalary + "</AnnualSalary></Person>");
    }
}
