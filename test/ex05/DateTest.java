package ex05;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateTest {
    /*
        Discuss the set of test cases that we should add for the Time class
        1. - Inputs to use for the test cases:
            - Same dates
            - Same year different month and day
            - Different year
            - Same year, same month, different day, d1 > d2
            - Same year, same month, different day, d1 < d2
            - Different year, same month, same day, d1 > d2
            - Different year, same month, same day, d1 < d2

        2. - Type of oracles? Which one will we use? (implicit, human, specified, derived)
            - Specified

        3. Assertions on the outputs. For example, I will assert that the "seconds" attribute of the Time object returned is correct
            - Assert days difference
    */
    @Test
    public void testDayDiffSameDate(){
        Date d1 = new Date(2021, 2, 5);
        Date d2 = new Date(2021, 2, 5);

        System.out.println(Date.dayDiff(d1, d2));
        assertEquals(0, Date.dayDiff(d1, d2));
    }

    @Test
    public void testDayDiffsameDayDifferentYearAndMonth(){
        Date d1 = new Date(2021, 2, 5);
        Date d2 = new Date(2020, 5, 5);

        System.out.println(Date.dayDiff(d1, d2));
        assertEquals(0, Date.dayDiff(d1, d2));
    }

    @Test
    public void testDayDiffSameYearAndMonthDifferentDay(){
        Date d1 = new Date(2021, 2, 5);
        Date d2 = new Date(2021, 2, 3);

        System.out.println(Date.dayDiff(d1, d2));
        assertEquals(-2, Date.dayDiff(d1, d2));
    }

    @Test
    public void testDayDiffSameYearAndMonthDifferentDayFuture(){
        Date d1 = new Date(2021, 2, 1);
        Date d2 = new Date(2021, 2, 3);

        System.out.println(Date.dayDiff(d1, d2));
        assertEquals(2, Date.dayDiff(d1, d2));
    }

    @Test
    public void testDayDiffFebruary(){
        Date d1 = new Date(2021, 2, 5);
        Date d2 = new Date(2021, 3, 1);

        System.out.println(Date.dayDiff(d1, d2));
        assertEquals(24, Date.dayDiff(d1, d2));     //OBS! 28 dager i feb
    }

    @Test
    public void testDayDifffebruary2020(){
        Date d1 = new Date(2020, 2, 5);
        Date d2 = new Date(2020, 3, 1);

        System.out.println(Date.dayDiff(d1, d2));
        assertEquals(25, Date.dayDiff(d1, d2)); //Skuddår i 2020
    }
//DaySince
    @Test
    public void testDaysSinceToday(){
        Date d1 = new Date(2021, 4, 3);

        System.out.println(Date.daysSinceO(d1));
        assertEquals(0, Date.daysSinceO(d1));
    }

    @Test
    public void testDaysSinceTomorrow(){
        Date d1 = new Date(2021, 4, 4);

        System.out.println(Date.daysSinceO(d1));
        assertEquals(-1, Date.daysSinceO(d1));
    }

    @Test
    public void testDaysSinceMay(){
        Date d1 = new Date(2021, 5, 3);

        System.out.println(Date.daysSinceO(d1));
        assertEquals(0, Date.daysSinceO(d1));
    }

    @Test
    public void testDaysSinceMay1Day(){
        Date d1 = new Date(2021, 5, 2);

        System.out.println(Date.daysSinceO(d1));
        assertEquals(-29, Date.daysSinceO(d1));
    }
}

