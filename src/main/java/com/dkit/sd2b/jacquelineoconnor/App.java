//JACQUELINE O'CONNOR D00233669 SD2B
package com.dkit.sd2b.jacquelineoconnor;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        //variables
        File inputFile = new File("JC_Results.txt");
        int[] codes = new int[8];
        int[] grades = new int[8];

        //double averageGrade = 0;

        try {
            Scanner input = new Scanner(inputFile);
            input.useDelimiter("[,\r\n]+");

            while (input.hasNext()) {

                int studentNumber = input.nextInt();
                for (int i = 0; i < 8; i++) {
                    codes[i] = input.nextInt();
                    grades[i] = input.nextInt();
                }
                selectFiveGrades(codes, grades);
                //System.out.println(calculateAverage(selectedGrades));

                //testing
                System.out.println(studentNumber);
                System.out.println(Arrays.toString(codes));
                System.out.println(Arrays.toString(grades));
            }
            input.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int[] selectFiveGrades(int[] codes, int[] grades) {

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

        //testing
        System.out.println(Arrays.toString(selectedGrades));


        //variables used to store grades when finding 2 largest
        //int largestGrade = 0;
        //int secondLargest = 0;
        //int thirdLargest = 0; //in case of CSPE code=218
        //largestGrade = Math.max(largestGrade, studentData[i+1]);

        return selectedGrades;

    }

    private double calculateAverage(int[] selectedGrades) {

        // to calculate the average
        int sum = 0;
        for (int grade : selectedGrades) {
            sum += grade;
        }

        return sum / 5;
    }

}
