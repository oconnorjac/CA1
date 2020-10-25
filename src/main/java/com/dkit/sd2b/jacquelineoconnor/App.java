//JACQUELINE O'CONNOR D00233669 SD2B
//https://github.com/oconnorjac/CA1.git
package com.dkit.sd2b.jacquelineoconnor;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <h1>App</h1>
 * <p>
 * The App program is a Java program to generate a weighting value
 * based on Junior Cert. results to be used in the calculation of
 * leaving certificate grades.
 * </p>
 *
 * @author Jacqueline O'Connor
 * @version 1.00
 * @since 13-10-2020
 */
public class App {

    /**
     * Main
     *
     * @param args
     */
    public static void main(String[] args) {

        //print table header to user
        System.out.println("Student Number:\t\tGrade:");

        readFile();

    }

    /**
     * Method to read in a file
     * <p>
     * Read in text file containing JC results. Store subject codes in
     * one array and their corresponding grades in another. Call function
     * selectFiveGrades to select the grades needed for calculation.
     * </p>
     */
    public static void readFile() {

        File inputFile = new File("JC_Results.txt");
        int[] codes = new int[8];
        int[] grades = new int[8];

        try {
            Scanner input = new Scanner(inputFile);
            input.useDelimiter("[,\r\n]+");

            while (input.hasNext()) {
                int studentNumber = input.nextInt();
                System.out.print(studentNumber + "\t\t\t\t");
                //read in codes & grades and store in two separate arrays
                for (int i = 0; i < 8; i++) {
                    codes[i] = input.nextInt();
                    grades[i] = input.nextInt();
                }
                selectFiveGrades(codes, grades);

                //for testing purposes
                //System.out.println("studentNumber = " + studentNumber);
                //System.out.println("codes = " + Arrays.toString(codes));
                //System.out.println("grades = " + Arrays.toString(grades));
            }
            input.close();
        } catch (IOException e) {  //in case the file is not found
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to accept the eight available subject codes and corresponding
     * grades and return an array selectedGrades based on the selection algorithm
     * <p>
     * Using a for loop to go through the arrays, when they pass condition in the if
     * statement, they are added to a temporary grade array. This array is then
     * sorted to then retrieve the last 2 elements as these are the two largest grades.
     * Do not include the grade for subject CSPE code = 218.
     * These two elements are then added to the selectedGrades array along with the
     * grades of the core subjects (ie: irish, english & maths) and this is used in a
     * separate method to calculate the overall average grade.
     * </p>
     *
     * @param codes array of subject codes
     * @param grades array of corresponding grades
     * @return selectedGrades the array of selected grades for calculation
     */
    public static int[] selectFiveGrades(int[] codes, int[] grades) {

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
        //now find 2 largest grades -> sort array & take the last 2 elements
        Arrays.sort(tempGrades);
        //put them into remaining spaces in selectedGrades array
        selectedGrades[3] = tempGrades[tempGrades.length - 1];
        selectedGrades[4] = tempGrades[tempGrades.length - 2];

        //call method to calculate average grade
        System.out.println(calculateAverage(selectedGrades));

        //for testing purposes
        //System.out.println("selectedGrades = " + Arrays.toString(selectedGrades));
        //System.out.println("tempGrades = " + Arrays.toString(tempGrades));
        //System.out.println("average = " + calculateAverage(selectedGrades));

        return selectedGrades;

    }

    /**
     * Method to calculate the overall average grade
     * <p>
     * Using an enhanced for loop, get the sum of all the grades.
     * Divide this total by 5 and return.
     * Changed this method from private to public in order to test
     * it with jUnit.
     * </p>
     *
     * @param selectedGrades array of grades from previous method
     * @return calculated average grade, cast sum to double
     */
    public static double calculateAverage(int[] selectedGrades) {

        // use for each to calculate the sum of grades
        int sum = 0;
        for (int grade : selectedGrades) {
            sum += grade;
        }

        return (double) sum / 5;   //cast int to a double for accuracy
    }

}
