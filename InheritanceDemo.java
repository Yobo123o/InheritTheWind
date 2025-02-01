import java.util.ArrayList;

/**
 * InheritanceDemo runs payroll calculations for Workers and SalaryWorkers.
 * It simulates three weeks of pay with different working hours.
 */
public class InheritanceDemo {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();

        // Creating hourly workers
        workers.add(new Worker("John", "Doe", "W001", "Mr.", 1980, 20.0));
        workers.add(new Worker("Jane", "Smith", "W002", "Ms.", 1990, 22.5));
        workers.add(new Worker("Robert", "Brown", "W003", "Dr.", 1985, 18.75));

        // Creating salary workers
        workers.add(new SalaryWorker("Alice", "Johnson", "S001", "Mrs.", 1975, 60000));
        workers.add(new SalaryWorker("Charlie", "Wilson", "S002", "Mr.", 1988, 55000));
        workers.add(new SalaryWorker("Emma", "Davis", "S003", "Ms.", 1992, 50000));

        // Weekly hours for three simulated weeks
        double[] hoursWorked = {40, 50, 40};

        // Loop through each week and display worker salaries
        for (int week = 0; week < hoursWorked.length; week++) {
            System.out.println("\nWeek " + (week + 1) + " Pay:");
            for (Worker worker : workers) {
                worker.displayWeeklyPay(hoursWorked[week]);
            }
        }
    }
}
