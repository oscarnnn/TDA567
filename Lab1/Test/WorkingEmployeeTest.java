import lab1.WorkSchedule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WorkingEmployeeTest {
    private WorkSchedule ws;
    String lars,patrik;
    String[] listWorkers = {"Patrik","Lars"};

    @Before
    public void init(){
        ws = new WorkSchedule(24);
        lars = "Lars";
        patrik = "Patrik";
        ws.addWorkingPeriod(lars,12,17);
        ws.addWorkingPeriod(patrik,8,11);
    }

    @Test
    public void testEmployeeScheduled(){
        Assert.assertArrayEquals(listWorkers,ws.workingEmployees(0,23));
    }

    @Test
    public void testEmployeesScheduledInvalidInput(){
        Assert.assertArrayEquals(listWorkers,ws.workingEmployees(23,0));
    }





}
