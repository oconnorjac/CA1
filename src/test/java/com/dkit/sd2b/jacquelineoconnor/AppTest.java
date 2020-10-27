//JACQUELINE O'CONNOR D00233669 SD2B
//https://github.com/oconnorjac/CA1.git
package com.dkit.sd2b.jacquelineoconnor;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.io.File;

import static org.junit.Assert.*;

/**
 * @author Jacqueline O'Connor
 */
public class AppTest {

    public AppTest() {
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

    /**
     * Test of main method, of class App.
     * <p>
     * This test demonstrates that the heading is printed correctly
     * and the method call to read the file works and the rest of
     * the program runs. The main is void.
     * </p>
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        App.main(args);
    }

    /**
     * Test of readFile method, of class App.
     * <p>
     * This test demonstrates that the file exists
     * and can be found using the pathname.
     * </p>
     */
    @Test
    public void testReadFile() {
        System.out.println("readFile");
        File inputFile = new File("JC_Results.txt");
        assertTrue(inputFile.exists());
    }

    /**
     * Test of selectFiveGrades method, of class App.
     * <p>
     * This test demonstrates the correct corresponding subject
     * grades are taken.
     * </p>
     */
    @Test
    public void testSelectFiveGrades() {
        System.out.println("selectFiveGrades");
        int[] codes = {1, 2, 3, 4, 5, 12, 42, 46};
        int[] grades = {65, 58, 45, 60, 50, 48, 42, 60};
        int[] expResult = {65, 58, 45, 60, 60};
        int[] result = App.selectFiveGrades(codes, grades);
        System.out.println("Expected = "+ Arrays.toString(expResult));
        System.out.println("Result = "+ Arrays.toString(result));
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of calculateAverage method, of class App.
     * <p>
     * This test uses the selected grades from previous test,
     * and returns the calculated average grade.
     * </p>
     */
    @Test
    public void testCalculateAverage() {
        System.out.println("calculateAverage");
        int[] selectedGrades = {65, 58, 45, 60, 60};
        System.out.println("selectedGrades = "+ Arrays.toString(selectedGrades));
        double expResult = 57.6;
        double result = App.calculateAverage(selectedGrades);
        System.out.println("Expected = "+expResult);
        System.out.println("Result = "+result);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of calculateAverage method, of class App.
     * <p>
     * This test demonstrates even if a student got a "high grade"
     * of zero, it will still work.
     * </p>
     */
    @Test
    public void testCalculateAverage1() {
        System.out.println("calculateAverage1");
        int[] selectedGrades = {65, 58, 45, 0, 60};
        System.out.println("selectedGrades = "+Arrays.toString(selectedGrades));
        double expResult = 45.6;
        double result = App.calculateAverage(selectedGrades);
        System.out.println("Expected = "+expResult);
        System.out.println("Result = "+result);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of selectFiveGrades method, of class App.
     * <p>
     * This test demonstrates that the grade for CSPE will not be
     * taken even though it is the highest grade.
     * </p>
     */
    @Test
    public void testSelectFiveGrades1() {
        System.out.println("selectFiveGrades1");
        int[] codes = {3, 218, 52, 40, 46, 2, 1, 27};
        int[] grades = {74, 100, 89, 67, 89, 55, 65, 98};
        int[] expResult = {65, 55, 74, 98, 89};
        int[] result = App.selectFiveGrades(codes, grades);
        System.out.println("Expected = "+ Arrays.toString(expResult));
        System.out.println("Result = "+ Arrays.toString(result));
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of selectFiveGrades method, of class App.
     * <p>
     * This test is the same data used from the previous test
     * but it will fail because the grade for CSPE has been
     * taken when it should not have been.
     * </p>
     */
    @Test
    public void testSelectFiveGrades2() {
        System.out.println("selectFiveGrades2");
        System.out.println("This test is designed to fail.");
        int[] codes = {3, 218, 52, 40, 46, 2, 1, 27};
        int[] grades = {74, 100, 89, 67, 89, 55, 65, 98};
        int[] expResult = {65, 55, 74, 100, 98};
        int[] result = App.selectFiveGrades(codes, grades);
        System.out.println("Expected = "+ Arrays.toString(expResult));
        System.out.println("Result = "+ Arrays.toString(result));
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of selectFiveGrades method, of class App.
     * <p>
     * This test demonstrates that the core subject grades will
     * be taken regardless of the order they are in or the position
     * in the array.
     * </p>
     */
    @Test
    public void testSelectFiveGrades3() {
        System.out.println("selectFiveGrades3");
        int[] codes = {27, 13, 52, 40, 46, 2, 1, 3};
        int[] grades = {74, 58, 73, 67, 89, 55, 65, 98};
        int[] expResult = {65, 55, 98, 89, 74};
        int[] result = App.selectFiveGrades(codes, grades);
        System.out.println("Expected = "+ Arrays.toString(expResult));
        System.out.println("Result = "+ Arrays.toString(result));
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of selectFiveGrades method, of class App.
     * <p>
     * This test demonstrates that the core subject grades will
     * be taken even though they are not in order and are separated.
     * </p>
     */
    @Test
    public void testSelectFiveGrades4() {
        System.out.println("selectFiveGrades4");
        int[] codes = {27, 1, 52, 3, 46, 2, 13, 40};
        int[] grades = {74, 58, 73, 67, 89, 55, 65, 98};
        int[] expResult = {58,55,67,98,89};
        int[] result = App.selectFiveGrades(codes, grades);
        System.out.println("Expected = "+ Arrays.toString(expResult));
        System.out.println("Result = "+ Arrays.toString(result));
        assertArrayEquals(expResult, result);
    }

}
