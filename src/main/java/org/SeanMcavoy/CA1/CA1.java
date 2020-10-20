package org.SeanMcavoy.CA1;

public class CA1
{
    public static void main(String[] args)
    {

    }

    /**
     * Accept All 8 available codes and Grades as two arrays
     * @param codes
     * @param grades
     * @return array of the top 5 Results
     */
    public int [] selectFiveGrades(int [] codes, int [] grades)
    {
        //Stores the Five highest Grades excluding CSPE
        int [] selectedGrades = new int[5];


        return selectedGrades;
    }

    private double calulateAverage(int[] selectedGrades)
    {
        int sum = 0;
        for (int elements : selectedGrades)
        {
            sum += elements;
        }

        double average = sum / selectedGrades.length;
        return average;
    }
}
