package org.SeanMcavoy.CA1;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase; //
import org.junit.*;


import java.io.File;
import java.io.FileNotFoundException;

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
        System.out.println("\ntestSelectFiveGrades1() - Making Sure Math, English, Irish are included");
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
    }
    @Test
    public void testSelectFiveGrades5()
    {
        System.out.println("testSelectFiveGrades5() - Testing if Math eng and Irish was not included in codes" );
        int[] codes = {11,21,32,137,569,57,27,5};
        int[] grades = {80,90,30,60,83,83,70,66};
        int[] expResult = {90,83,0,0,0};
        int[] result = CA1.selectFiveGrades(codes,grades);
        assertArrayEquals(expResult, result);
    }

    /* All Test for calculatingAverage() */
    @Test
    public void testCalulateAverage1()
    {
        System.out.println("testCalulateAverage1() - Test if Average calculation is working Correctly");
        int [] selectedGrades = {90,50,30,80,70};
        double expResult = 64;
        double result = CA1.calulateAverage(selectedGrades);
        assertEquals(expResult,result);
    }
    @Test
    public void testCalulateAverage2()
    {
        System.out.println("testCalulateAverage2() - Testing all Zeros");
        int [] selectedGrades = {0,0,0,0,0};
        double expResult = 0;
        double result = CA1.calulateAverage(selectedGrades);
        assertEquals(expResult,result);
    }
    //Will Test what happends if wrong amount of grades inserted (should still get an average and not crash system only average wouldnt be eligible)
    @Test
    public void testCalulateAverage3()
    {
        System.out.println("testCalulateAverage3() - Testing if wrong array is passed in i.e 8 grade (should still return Array)");
        int [] selectedGrades = {80,90,30,60,83,83,70,66};
        double expResult = 70.25;
        double result = CA1.calulateAverage(selectedGrades);
        assertEquals(expResult,result);
        System.out.println();
    }

    /*Testing SortStudentData() */
    @Test
    public void testSortStudentData1()
    {
        System.out.println("testSortStudentData1 - Testing the correct data is passed into the correct Array gradeCode & grade");
        String[] studentRecord = {"891234","1","65","2","58","3","45","4","60","5","50","12","48","42","42","46","60"};
        int[] gradeCode = new int[8];
        int[] grade = new int[8];
        //This Method does not return values but updates the above arrays
        CA1.sortStudentData(studentRecord, gradeCode, grade);
        //the arrays should be updated to
        int[] gradeCodeExp = {1,2,3,4,5,12,42,46};
        int[] gradeExp = {65,58,45,60,50,48,42,60};

        assertArrayEquals(gradeCodeExp,gradeCode);
        assertArrayEquals(gradeExp,grade);
    }

    @Test
    public void testProcessStudentRecord1()
    {
        System.out.println("processStudentRecord1() - Test the try Catch works correctly if the Fail path has the wrong name/  wrong path");
        File jcRecords = new File("JC_Result.txt");

        try{
            CA1.processStudentsRecord(jcRecords);

        }catch (Exception exception){
            Assert.fail();
        }

    }

}