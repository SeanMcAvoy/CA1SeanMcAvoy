package org.SeanMcavoy.CA1;
/*
 * CA1 JC results
 * D00233349
 * Sean McAvoy
 * GITHUB - https://github.com/SeanMcAvoy/CA1SeanMcAvoy.git
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CA1
{
    public static void main(String[] args)
    {
        System.out.println("Student Number \t Average Value"); //Header for the record table
        File jcRecords = new File("JC_Results.txt");
        processStudentsRecord(jcRecords); //processing all the Students data
    }

    /**
     * Accept All 8 available codes and Grades as two arrays
     * @param codes
     * @param grades
     * @return array of the top 5 Results
     */
    public static int [] selectFiveGrades(int [] codes, int [] grades)
    {
        //Stores the Five highest Grades excluding CSPE
        int [] selectedGrades = new int[5];
        //Finding the Two Highest Grades
        int max = 0;
        int secondMax = 0;
        int n = 0; // Stop elements replacing each other.
        for(int i = 0; i < codes.length ; i++)
        {
            //adding Math, English and Irish to the array
            if(codes[i] == 1 || codes[i] == 2 || codes[i] == 3)
            {
                selectedGrades[n] = grades[i];
                n++;
            }
            //if the subject is English, Math, Irish ot CSPE it will skip over and not look in at it
            else if(codes[i] != 1 && codes[i] != 2 && codes[i] != 3 && codes[i] != 218)
                {
                    //if grade is grater than the max number
                    if(grades[i] > max)
                    {
                        secondMax = max; //second max becomes the old max
                        max = grades[i]; // max is updated to the new int
                    }
                    else if(grades[i] > secondMax)//if the grade isnt bigger then max but bigger than second max will go in here
                    {
                        //second max updated
                        secondMax = grades[i];
                    }
                }
        }
        //adding the max and second max once the loop finished so it doesnt overflow the Array
        selectedGrades[n] = max;
        selectedGrades[n+1] = secondMax;

        return selectedGrades;
    }

    /**
     * Calculates Average of the Grades
     * @param selectedGrades from method selectFiveGrades()
     * @return average as Double
     */
    public static double calulateAverage(int[] selectedGrades)
    {
        int sum = 0;
        for (int elements : selectedGrades)
        {
            sum += elements;
        }
        //needs the (double) as sum is going from int to double
        double average = (double) sum / selectedGrades.length;
        return average;
    }

    /**
     * <h2>sortData</h2>
     * Will sort the gradecode and grades into the correct array
     * @param studentRecord is the students record of 8 subjects and 8 grades
     * @param gradeCode
     * @param grade
     */
    public static void sortStudentData(String[] studentRecord,int[] gradeCode,int[] grade)
    {
        //Arrays needed to save the data
        int g =0;
        int gc = 0;

        for (int i = 1; i <studentRecord.length; i++)//loops Starts from 1 as we don't want the student number included!
        {
            if(i % 2 != 0)//gradeCode
            {
                gradeCode[gc] = Integer.parseInt(studentRecord[i]);
                gc++; //gc goes up one so it doesn't put grade and code order out of place!
            }
            else if(i % 2 == 0)//grade (as its everySecond)
            {
                grade[g] = Integer.parseInt(studentRecord[i]);
                g++;
            }
        }
    }

    /**
     *Scans and processes the students record
     * @param jcRecords .txt file pathName
     * FilePath is passed in
     */
    public static void processStudentsRecord(File jcRecords)
    {
        try {
            Scanner sc = new Scanner(jcRecords);
            //Will continue until there is notting left in the file.
            while(sc.hasNext())
            {
                String jcData = sc.nextLine();//pulls a students full record in
                String[] dataSorter = jcData.split(","); //Splits the data by comas and makes it easier to sort.

                //changes string numbers to usable ints
                int studentNumber = Integer.parseInt(dataSorter[0]);

                //Arrays needed to save the data
                int[] gradeCode = new int[8];
                int[] grade = new int[8];
                sortStudentData(dataSorter,gradeCode,grade);//method (updates the Arrays gradeCode[] & grade[]) puts correct data into correct array


                int [] selected5Grades = selectFiveGrades(gradeCode,grade);//array returned of the students 5 subjects
                double studentAverage = calulateAverage(selected5Grades);//average calculated from the 5 grades.

                //print student number and average
                System.out.println(studentNumber+" \t\t\t "+studentAverage);
            }
            sc.close(); //Closes the Scanner

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("--File not Found--"); //inform the file cant be found
        }
    }
}
