package org.SeanMcavoy.CA1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CA1
{
    public static void main(String[] args)
    {
        System.out.println("Student Number \t Average Value");

        File jcRecords = new File("JC_Results.txt");
        try {
            Scanner sc = new Scanner(jcRecords);
            //Will continue until there is notting left in the file.
            while(sc.hasNext())
            {
                //pulls a students full record in
                String jcData = sc.nextLine();
                String[] dataSorter = jcData.split(","); //Splits the data by comas and makes it easier to sort.

                //changes string numbers to useable ints
                int studentNumber = Integer.parseInt(dataSorter[0]);

                //Arrays needed to save the data
                int[] gradeCode = new int[8];
                int[] grade = new int[8];
                int g =0;
                int gc = 0;

                //loops Starts from 1 as we don't want the student number included!
                for (int i = 1; i <dataSorter.length; i++)
                {
                    if(i % 2 !=0)//gradeCode
                    {
                        gradeCode[gc] = Integer.parseInt(dataSorter[i]);
                        gc++; //gc goes up one so it doesn't put grade and code order out of place!
                    }
                    else if(i % 2 ==0)//grade (as its everySecond)
                    {
                        grade[g] = Integer.parseInt(dataSorter[i]);
                        g++;
                    }
                }
                //array returned of the students 5 subjects
                int [] selected5Grades = selectFiveGrades(gradeCode,grade);
                //average calculated from the 5 grades.
                double studentAverage = calulateAverage(selected5Grades);

                //print student number and average
                System.out.println(studentNumber+" \t\t\t "+studentAverage);
            }
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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

        int n = 0; // Stop elements replacing each other.
        for(int i = 0; i < codes.length ; i++)
        {
            //adding Math, English and Irish to the array
            if(codes[i] == 1 || codes[i] == 2 || codes[i] == 3)
            {
                selectedGrades[n] = grades[i];
                n++;
            }
        }
        //Finding the Two Highest Grades
        int max = 0;
        int secondMax = 0;
        for (int i = 0; i < grades.length ; i++)
        {
            //if the subject is English, Math, Irish ot CSPE it will skip over and not look in at it
            if(codes[i] != 1 && codes[i] != 2 && codes[i] != 3 && codes[i] != 218)
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

        //adding the max and second max once the loop looking for it is finished
        selectedGrades[n] = max;
        selectedGrades[n+1] = secondMax;

        return selectedGrades;
    }

    /**
     * Calculates Average of the Grades
     * @param selectedGrades from method selectFiveGrades()
     * @return average as Double
     */
    private static double calulateAverage(int[] selectedGrades)
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
}
