//JACQUELINE O'CONNOR D00233669 SD2B
package com.dkit.sd2b.jacquelineoconnor;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        File inputFile = new File("JC_Results.txt");
        readFile(inputFile);

    }

    public static void readFile(File inputFile){

        //int[] codes = new int[8];
        //int[] grades = new int[8];
        //double averageGrade = 0;


        try {
            Scanner input = new Scanner(inputFile);
            input.useDelimiter("[,\r\n]+");

            while (input.hasNext()) {
                String student = input.nextLine();
                System.out.println(student);
            }
            input.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //variables used to store grades when finding 2 largest
        //int largestGrade = 0;
        //int secondLargest = 0;
        //int thirdLargest = 0; //in case of CSPE code=218
        //largestGrade = Math.max(largestGrade, studentData[i+1]);

    }

    public int[] selectFiveGrades(int[] codes, int[] grades) {

        // to accept the eight available codes and corresponding grades, and return an array of the
        //five selected grades (based on the selection algorithm)

        int[] selectedGrades = new int[5];

        for (int i = 0; i < 8; i++) {
            //get core subject grades (irish, english & maths)
            if (codes[i] == 1) {
                selectedGrades[0] += grades[i];
            }
            if (codes[i] == 2) {
                selectedGrades[1] += grades[i];
            }
            if (codes[i] == 3) {
                selectedGrades[3] += grades[i];
            }
        }


        return selectedGrades;

    }

    private double calculateAverage(int[] selectedGrades) {
        // to calculate the average

        return 0;
    }

}
