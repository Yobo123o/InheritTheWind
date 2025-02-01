import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for Worker class.
 */
class WorkerTest {

    @Test
    void testCalculateWeeklyPay_RegularHours() {
        Worker worker = new Worker("John", "Doe", "W001", "Mr.", 1980, 20.0);
        assertEquals(800.0, worker.calculateWeeklyPay(40), 0.01);
    }

    @Test
    void testCalculateWeeklyPay_OvertimeHours() {
        Worker worker = new Worker("Jane", "Smith", "W002", "Ms.", 1990, 25.0);
        assertEquals(1375.0, worker.calculateWeeklyPay(50), 0.01); // 40 * 25 + 10 * 37.5
    }

    @Test
    void testCalculateWeeklyPay_LessThan40Hours() {
        Worker worker = new Worker("Robert", "Brown", "W003", "Dr.", 1985, 18.75);
        assertEquals(375.0, worker.calculateWeeklyPay(20), 0.01);
    }

    @Test
    void testSerialization_CSV() {
        Worker worker = new Worker("John", "Doe", "W001", "Mr.", 1980, 20.0);
        assertTrue(worker.toCSV().contains("20.0"));
    }

    @Test
    void testSerialization_JSON() {
        Worker worker = new Worker("Jane", "Smith", "W002", "Ms.", 1990, 25.0);
        assertTrue(worker.toJSON().contains("\"HourlyPayRate\":25.0"));
    }

    @Test
    void testSerialization_XML() {
        Worker worker = new Worker("Robert", "Brown", "W003", "Dr.", 1985, 18.75);
        assertTrue(worker.toXML().contains("<HourlyPayRate>18.75</HourlyPayRate>"));
    }
}
