package ex04;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TriangleClassifierTest {

    @Test
    public void testScalene() throws Exception {
        int a = 5;
        int b = 7;
        int c = 9;

        String result = TriangleClassifier.classify(a, b, c);
        assertTrue(result.equalsIgnoreCase("SCALENE"));

    }

    @Test
    public void testIsosceles() throws Exception{
        int a = 5;
        int b = 5;
        int c = 7;

        String result = TriangleClassifier.classify(a, b, c);
        assertTrue(result.equalsIgnoreCase("ISOSCELES"));
        assertFalse(result.equalsIgnoreCase("SCALENE"));
    }

    @Test
    public void testWithAZero() throws Exception{
        int a = 0;
        int b = 5;
        int c = 5;

        String result = TriangleClassifier.classify(a, b, c);
        assertTrue(result.equalsIgnoreCase("NOT_A_TRIANGLE"));
    }

    @Test
    public void testCantMakeATriangleWithThat() throws Exception{
        int a = 100;
        int b = 1 ;
        int c = 5;

        String result = TriangleClassifier.classify(a, b, c);
        assertTrue(result.equalsIgnoreCase("NOT_A_TRIANGLE"));

    }

    @Test
    public void testEquilateral() throws Exception{
        int a = 42;
        String result = TriangleClassifier.classify(a, a, a);
        assertTrue(result.equalsIgnoreCase("EQUILATERAL"));
    }

    //Tester for å dekke de resterende true-verdiene

    @Test
    public void testSecondClause() throws Exception{
        int a = 5;
        int b = 0;
        int c = 5;

        String result = TriangleClassifier.classify(a, b, c);
        assertTrue(result.equalsIgnoreCase("NOT_A_TRIANGLE"));

    }

    @Test
    public void testThirdClause() throws Exception{
        int a = 8;
        int b = 3;
        int c = -2;

        String result = TriangleClassifier.classify(a, b, c);
        assertTrue(result.equalsIgnoreCase("NOT_A_TRIANGLE"));
    }

    @Test
    public void testSecondMax() throws Exception{
        int a = 8;
        int b = 50;
        int c = -2;

        String result = TriangleClassifier.classify(a, b, c);
        assertTrue(result.equalsIgnoreCase("NOT_A_TRIANGLE"));
    }

    @Test
    public void testThirddMax() throws Exception{
        int a = 8;
        int b = 50;
        int c = 200;

        String result = TriangleClassifier.classify(a, b, c);
        assertTrue(result.equalsIgnoreCase("NOT_A_TRIANGLE"));
    }

    @Test
    public void testSecondIsosceles() throws Exception{
        int a = 5;
        int b = 6;
        int c = 6;

        String result = TriangleClassifier.classify(a, b, c);
        assertTrue(result.equalsIgnoreCase("ISOSCELES"));
        assertFalse(result.equalsIgnoreCase("SCALENE"));
    }

    @Test
    public void testThirdIsosceles() throws Exception{
        int a = 5;
        int b = 6;
        int c = 5;

        String result = TriangleClassifier.classify(a, b, c);
        assertTrue(result.equalsIgnoreCase("ISOSCELES"));
        assertFalse(result.equalsIgnoreCase("SCALENE"));
    }
}

