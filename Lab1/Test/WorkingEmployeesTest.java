import lab1.WorkSchedule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WorkingEmployeesTest {
    WorkSchedule ws;
    String employee1,employee2;
    String[] res;

    @Before
    public void initTest(){
        ws = new WorkSchedule(24);
        ws.setRequiredNumber(5,0,23);
        res = new String[2];
        employee1 = "Employee1";
        employee2 = "Employee2";
        res[0] = employee1;
        res[1] = employee2;
        ws.addWorkingPeriod(employee1,2,17);
        ws.addWorkingPeriod(employee2,4,23);

    }

    /* Partition #1
     * Test for starttime <= endtime
     */
    @Test
    public void workingEmployees1(){
        Assert.assertArrayEquals(res,ws.workingEmployees(0,23));
    }

    /* Partition #2
     * Test for starttime > endtime
     */
    @Test
    public void workingEmployees2(){
        Assert.assertArrayEquals(new String[]{},ws.workingEmployees(23,0));
    }
}
