//JACQUELINE O'CONNOR D00233669 SD2B
//https://github.com/oconnorjac/CA1
package com.dkit.sd2b.jacquelineoconnor;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        readFile();

    }

    public static void readFile() {

        //variables
        File inputFile = new File("JC_Results.txt");
        int[] codes = new int[8];
        int[] grades = new int[8];

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

                //testing
                System.out.println("studentNumber = " + studentNumber);
                System.out.println("codes = " + Arrays.toString(codes));
                System.out.println("grades = " + Arrays.toString(grades));
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
        int[] tempGrades = new int[8];

        for (int i = 0; i < 8; i++) {
            //put grades into a temporary array for calculation later - do not include grade belonging to CSPE
            if (codes[i] != 1 && codes[i] != 2 && codes[i] != 3 && codes[i] != 218) {
                tempGrades[i] = grades[i];
            }
            //get core subject grades (irish, english & maths) & add to selectedGrades array
            if (codes[i] == 1) {
                selectedGrades[0] = grades[i];
            }
            if (codes[i] == 2) {
                selectedGrades[1] = grades[i];
            }
            if (codes[i] == 3) {
                selectedGrades[2] = grades[i];
            }
        }
        //now find 2 largest grades -> sort array & take last 2 elements
        //put them into selectedGrades array
        Arrays.sort(tempGrades);
        selectedGrades[3] = tempGrades[tempGrades.length - 1];
        selectedGrades[4] = tempGrades[tempGrades.length - 2];

        //for testing purposes
        //System.out.println("selectedGrades = " + Arrays.toString(selectedGrades));
        //System.out.println("tempGrades = " + Arrays.toString(tempGrades));
        //System.out.println("average = " + calculateAverage(selectedGrades));

        //call function to calculate the average of the selected grades
        calculateAverage(selectedGrades);

        return selectedGrades;

    }

    private static double calculateAverage(int[] selectedGrades) {

        // to calculate the average grades
        int sum = 0;
        for (int grade : selectedGrades) {
            sum += grade;
        }

        return (double) sum / 5;   //cast int to a double for accuracy
    }

}
