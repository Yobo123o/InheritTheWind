/**
 * Worker class represents an hourly-paid employee.
 * Inherits from Person and adds an hourly pay rate.
 */
public class Worker extends Person {
    private double hourlyPayRate; // Hourly wage rate

    /**
     * Constructor for Worker.
     * Calls the super constructor and sets the hourly pay rate.
     *
     * @param firstName First name
     * @param lastName Last name
     * @param ID Unique identifier
     * @param title Prefix (Mr., Dr., etc.)
     * @param YOB Year of birth
     * @param hourlyPayRate Hourly wage
     */
    public Worker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate) {
        super(firstName, lastName, ID, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    /**
     * Calculates weekly pay.
     * Regular pay applies up to 40 hours, overtime at 1.5x rate.
     *
     * @param hoursWorked Hours worked in a week
     * @return Total pay for the week
     */
    public double calculateWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(40, hoursWorked);
        double overtimeHours = Math.max(0, hoursWorked - 40);
        return (regularHours * hourlyPayRate) + (overtimeHours * hourlyPayRate * 1.5);
    }

    /**
     * Displays weekly pay breakdown including overtime.
     *
     * @param hoursWorked Hours worked in a week
     */
    public void displayWeeklyPay(double hoursWorked) {
        System.out.printf("%s: Regular: %.2f, Overtime: %.2f, Total Pay: $%.2f%n",
                fullName(), Math.min(40, hoursWorked), Math.max(0, hoursWorked - 40), calculateWeeklyPay(hoursWorked));
    }

    /** Converts worker data to CSV format */
    @Override
    public String toCSV() { return super.toCSV() + "," + hourlyPayRate; }

    /** Converts worker data to JSON format */
    @Override
    public String toJSON() { return super.toJSON().replace("}", ", \"HourlyPayRate\":" + hourlyPayRate + "}"); }

    /** Converts worker data to XML format */
    @Override
    public String toXML() { return super.toXML().replace("</Person>", "<HourlyPayRate>" + hourlyPayRate + "</HourlyPayRate></Person>"); }
}
