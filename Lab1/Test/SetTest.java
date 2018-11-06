import lab1.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.Arrays;

public class SetTest {

    Set setA,setB;

    @Before
    public void init(){
        setA = new Set();
        setB = new Set();
    }

    @Test
    public void testInsertSetEmpty(){
        setA.insert(3);
        Assert.assertArrayEquals(new int[]{3},setA.toArray());
    }

    @Test
    public void testInsertMultipleElements(){
        setA.insert(3);
        setA.insert(2);
        setA.insert(4);
        Assert.assertArrayEquals(new int[]{2,3,4}, setA.toArray());
    }

    @Test
    public void testInsertDuplicate(){
        setA.insert(3);
        setA.insert(3);
        Assert.assertArrayEquals(new int[]{3},setA.toArray());
    }

    @Test
    public void testMemberContainsElement(){
        //our set is [2,3]
        setA.insert(3);
        setA.insert(2);

        //testing if numbers are in the set
        Assert.assertTrue(setA.member(3));
        Assert.assertTrue(setA.member(2));
    }

    @Test
    public void testMemberNotContainsElement(){
        //our set is [2,3]
        setA.insert(3);
        setA.insert(2);

        //testing numbers not in the set
        Assert.assertFalse(setA.member(9));
        Assert.assertFalse(setA.member(-5));
    }

    // Branch Coverage for member().
    @Test
    public void testMemberEmptyArray(){
        Assert.assertFalse(setA.member(3));
    }

    @Test
    public void testSection(){
        setA.insert(1);
        setA.insert(2);
        setA.insert(4);


        setB.insert(2);
        setB.insert(3);
        setA.section(setB);
        Assert.assertArrayEquals(new int[]{1,4},setA.toArray());

        //setB is [2,3], setA is now [1,4]
        setB.section(setA);
        Assert.assertArrayEquals(new int[]{2,3}, setB.toArray());

    }

    // Branch Coverage for section().
    @Test
    public void testSectionEmptyInput(){
        setA.insert(1);
        setB.section(setA);
        Assert.assertArrayEquals(new int[]{}, setB.toArray());
    }

    @Test
    public void testContainsArithTripleTrue(){
        setA.insert(0);
        setA.insert(5);
        setA.insert(10);

        Assert.assertTrue(setA.containsArithTriple());
    }

    @Test
    public void testContainsArithTripleFalse(){
        setA.insert(7);
        setA.insert(0);
        setA.insert(2);
        Assert.assertFalse(setA.containsArithTriple());
    }

    @Test
    public void testContainsArithTripleEmptyArray(){
        Assert.assertFalse(setA.containsArithTriple());
    }
}