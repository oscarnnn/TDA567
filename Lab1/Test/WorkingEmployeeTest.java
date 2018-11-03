import lab1.WorkSchedule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class WorkingEmployeeTest {
    private WorkSchedule ws;
    private String lars,patrik;
    private String[] listWorkers;

    @Before
    public void init(){
        lars = "Lars";
        patrik = "Patrik";
        listWorkers = new String[2];
        listWorkers[0] = patrik;
        listWorkers[1] = lars;
        ws = new WorkSchedule(24);
        ws.setRequiredNumber(5,0,23);
        ws.addWorkingPeriod(patrik,2,7);
        ws.addWorkingPeriod(lars,3,4);
        System.out.println(Arrays.toString(ws.workingEmployees(0,23)));
    }

    /* Partition #1
     * starttime <= endtime
     */
    @Test
    public void testEmployeeScheduled(){
        Assert.assertArrayEquals(listWorkers,ws.workingEmployees(0,23));
    }

    /* Partition #2
     * starttime > endtime
     */
    @Test
    public void testEmployeesScheduledInvalidInput(){
        Assert.assertArrayEquals(new String[0],ws.workingEmployees(23,0));
    }





}
