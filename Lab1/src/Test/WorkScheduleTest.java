package Test;


import lab1.WorkSchedule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WorkScheduleTest {

   private lab1.WorkSchedule ws;
   String test1;

   @Before
   public  void initTest(){
       ws = new WorkSchedule(24);
       test1 = "Lars";
       ws.setRequiredNumber(5,0,23);
   }

   /*
    *  Test for starttime < 0
    */
    @Test
    public void testInvalidStartime(){
        Assert.assertTrue(!ws.addWorkingPeriod(test1,-1,3));
    }
}
