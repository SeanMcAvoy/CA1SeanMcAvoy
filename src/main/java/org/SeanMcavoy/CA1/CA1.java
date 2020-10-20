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
    public static int [] selectFiveGrades(int [] codes, int [] grades)
    {
        //Stores the Five highest Grades excluding CSPE
        int [] selectedGrades = new int[5];


        for (int i = 0; i < codes.length ; i++)
        {
            int n = 0; // Stop elements replacing each other.
            //adding Math, English and Irish to the array
            if(codes[i] == 1 || codes[i] == 2 || codes[i] == 3)
            {
                grades[i] = selectedGrades[n];
                n++;
            }
        }



        return selectedGrades;
    }

    /**
     * Calulates Average of the Grades
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
