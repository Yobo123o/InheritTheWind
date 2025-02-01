import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for SalaryWorker class.
 */
class SalaryWorkerTest {

    @Test
    void testCalculateWeeklyPay_FixedSalary() {
        SalaryWorker salariedWorker = new SalaryWorker("Alice", "Johnson", "S001", "Mrs.", 1975, 52000);
        assertEquals(1000.0, salariedWorker.calculateWeeklyPay(40), 0.01);
        assertEquals(1000.0, salariedWorker.calculateWeeklyPay(50), 0.01);
    }

    @Test
    void testSerialization_CSV() {
        SalaryWorker salariedWorker = new SalaryWorker("Charlie", "Wilson", "S002", "Mr.", 1988, 55000);
        assertTrue(salariedWorker.toCSV().contains("55000"));
    }

    @Test
    void testSerialization_JSON() {
        SalaryWorker salariedWorker = new SalaryWorker("Emma", "Davis", "S003", "Ms.", 1992, 50000);
        assertTrue(salariedWorker.toJSON().contains("\"AnnualSalary\":50000"));
    }

    @Test
    void testSerialization_XML() {
        SalaryWorker salariedWorker = new SalaryWorker("Alice", "Johnson", "S001", "Mrs.", 1975, 52000);

        String expectedXML = "<Person><ID>S001</ID><FirstName>Alice</FirstName><LastName>Johnson</LastName><Title>Mrs.</Title><YOB>1975</YOB><AnnualSalary>52000.0</AnnualSalary></Person>";
        String actualXML = salariedWorker.toXML();

        assertEquals(expectedXML, actualXML);
    }
}
