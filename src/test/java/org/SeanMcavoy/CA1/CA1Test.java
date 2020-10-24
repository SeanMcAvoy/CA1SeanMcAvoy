package org.SeanMcavoy.CA1;

import junit.framework.TestCase; //
import org.junit.Test;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;


import static org.junit.Assert.assertArrayEquals;

public class CA1Test extends TestCase
{
    public CA1Test(){
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    /* All Test For SelectFiveGrades() */
    @Test
    public void testSelectFiveGrades1()
    {
        System.out.println("testSelectFiveGrades1() - Making Sure Math, English, Irish are included");
        int[] codes = {1,2,3,4,5,6,7,8};
        int[] grades = {1,50,3,4,5,70,80,0};
        int[] expResult = {1,50,3,80,70};
        int[] result = CA1.selectFiveGrades(codes,grades);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testSelectFiveGrades2()
    {
        System.out.println("testSelectFiveGrades2() - Test CSPE does not get included in the selected grades (even tho its the highest Grade)");
        int[] codes = {1,2,3,218,40,8,10,12};
        int[] grades = {90,20,30,95,30,70,80,40};
        int[] expResult = {90,20,30,80,70};
        int[] result = CA1.selectFiveGrades(codes,grades);
        assertArrayEquals(expResult, result);
    }
    @Test
    public void testSelectFiveGrades3()
    {
    System.out.println("testSelectFiveGrades3() - Test if the Two highest Grades (after Maths,Eng,Irish are taken in) " +
            "are Equal will both be included or will one be take in and other Skipped over");
    int[] codes = {1,2,3,137,569,57,27,5};
    int[] grades = {80,90,30,60,83,83,70,66};
    int[] expResult = {80,90,30,83,83};
    int[] result = CA1.selectFiveGrades(codes,grades);
    assertArrayEquals(expResult, result);
    }
    @Test
    public void testSelectFiveGrades4()
    {
        System.out.println("testSelectFiveGrades4() - Test if all grades = 0 (Boundary Testing)" );
        int[] codes = {1,2,3,137,569,57,27,5};
        int[] grades = {0,0,0,0,0,0,0,0};
        int[] expResult = {0,0,0,0,0};
        int[] result = CA1.selectFiveGrades(codes,grades);
        assertArrayEquals(expResult, result);
        System.out.println("\n");
    }



    /* All Test for calculatingAverage() */
    @Test
    public void testCalulateAverage()
    {

    }



    /**@Test


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