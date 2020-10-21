package org.SeanMcavoy.CA1;

import java.util.Arrays;

public class CA1
{
    public static void main(String[] args)
    {
        System.out.println("Student Number \t Average Value");

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
