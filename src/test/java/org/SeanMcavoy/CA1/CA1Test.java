package org.SeanMcavoy.CA1;

import junit.framework.TestCase; //
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CA1Test extends TestCase
{

    /**
     * All Test For SelectFiveGrades()- Test takes math eng irish in & next two max, test doesnt take cepe etc...
     */
    @Test
    public void testSelectFiveGrades()
    {
        System.out.println("selectFiveGrades");
        int[] codes = {1,2,3,4,5,6,7,8};
        int[] grades = {1,50,3,4,5,0,0,0};
        int[] expResult = new int [] {1,50,3,5,4};
        int[] result = CA1.selectFiveGrades(codes,grades);
        assertArrayEquals(expResult, result);
    }
    /**@Test
    public void testSelectFiveGrades1()
    {
        System.out.println("selectFiveGrades");
        int[] codes = null;
        int[] grades = null;
        int[] expResult = null;
        int[] result = CA1.selectFiveGrades(codes,grades);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testCalulateAverage() {
    }

    @Test
    public void testSortStudentData() {
    }

    @Test
    public void testProcessStudentRecord() {
    }
    */
}