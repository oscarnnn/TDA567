import lab1.WorkSchedule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WorkScheduleTest {

   private WorkSchedule ws;
   String test1;

   @Before
   public  void initTest(){
       ws = new WorkSchedule(24);
       test1 = "Lars";
       ws.setRequiredNumber(5,0,23);

   }

   /* Partition #1
    * Test for starttime < 0
    */
    @Test
    public void testStarttime1(){
        Assert.assertTrue(!ws.addWorkingPeriod(test1,-1,3));
    }

    /* Partition #2
     * Test for starttime >= 0
     */
    @Test
    public void testStarttime2(){
        Assert.assertTrue(ws.addWorkingPeriod(test1,1,3));
    }

    /* Partition #3
     * Test for endtime >= size
     */
    @Test
    public void testEndtime1(){
        Assert.assertTrue(!ws.addWorkingPeriod(test1,1,24));
    }

    /* Partition #4
     * Test for endtime < size.
     */
    @Test
    public void testEndtime2(){
        Assert.assertTrue(ws.addWorkingPeriod(test1,1,3));
    }

    /* Partition #5
     * Test for starttime > endtime
     */
    @Test
    public void testStarttimeEndtime1(){
        Assert.assertTrue(!ws.addWorkingPeriod(test1,5,3));
    }

    /* Partition #6
     * Test for starttime <= endtime
     */
    @Test
    public void testStarttimeEndtime2(){
        Assert.assertTrue(ws.addWorkingPeriod(test1,1,1));
    }

    /* Partition #7
     * Test for hour.workingEmployees.length == requiredNumber
            between start and endtime
     */
    @Test
    public void testSomeHourFull(){
        ws.setRequiredNumber(0,0,10);
        Assert.assertTrue(!ws.addWorkingPeriod(test1,0,23));
    }
    /* Partition #8
     * Test for hour.workingEmployees.length != reuiredNumber
       between start and endtime
     */
    @Test
    public void testNoHourFull(){
       Assert.assertTrue(ws.addWorkingPeriod(test1,0,23));
    }

    /* Partition #9
     * Test for hour.workingEmployees.contains(employee)
     *        between start and endtime
     */
    @Test
    public void testEmployeeAlreadyScheduled(){
      ws.addWorkingPeriod(test1,0,5);
      Assert.assertFalse(ws.addWorkingPeriod(test1,0,5));
    }

    /* Partition #10
     * Test for !hour.workingEmployees.contains(employee)
     *        between start and endtime
     */
    @Test
    public void testEmployeeNotScheduled(){
        Assert.assertTrue(ws.addWorkingPeriod(test1,0,5));

    }
}
