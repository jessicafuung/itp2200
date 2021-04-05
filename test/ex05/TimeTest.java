package ex05;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {
    /*
     * 1. Inputs to use for the test cases:
     * - < 60
     * - < 0
     * - 0
     * - 60
     * - 3600
     * - < 3600
     * - 100000
     *
     * 2. Type of oracles? Which one will we use? (implicit, human, specified, derived)
     * - Specified
     *
     * 3. Assertions on the outputs. For example, I will assert that the "secons" attributs of the Time object returned is correct
     * - assert seconds.
     * - assert minutes.
     * - assert hours.
     *
     * */

    @Test
    public void testTime(){
        Time t = Time.convertSeconds(3660);

        System.out.println(t.seconds);
    }

    @Test
    public void testTimeLessThan60(){
        Time t = Time.convertSeconds(55);

        //Assertions (hva vi kan forvente svaret skal bli) Betingelser
        assertEquals(0, t.hours);
        assertEquals(0, t.minutes);
        assertEquals(55, t.seconds);
    }

    @Test(expected = IllegalArgumentException.class)    //!! Viktig å skrive at man forventer et unntak på testen også
    public void testTimeLessThan0(){
        Time t = Time.convertSeconds(-1);
        //Å kjøre testen vil gi feilmelding. Det er ikke en bug når det er selvlaget.
        //Trenger ikke assertions når det er forventet unntak
    }

    @Test
    public void testTimeZero(){
        Time t = Time.convertSeconds(0);

        assertEquals(0, t.hours);
        assertEquals(0, t.minutes);
        assertEquals(0, t.seconds);
    }

    @Test
    public void testTime60(){
        Time t = Time.convertSeconds(60);

        assertEquals(0, t.hours);
        assertEquals(1, t.minutes);
        assertEquals(0, t.seconds);
    }

    @Test
    public void testTime3600(){
        Time t = Time.convertSeconds(3600);

        assertEquals(1, t.hours);
        assertEquals(0, t.minutes);
        assertEquals(0, t.seconds);
    }

    @Test
    public void testTimeBetween1Minute1Hour(){
        Time t = Time.convertSeconds(500);

        assertEquals(0, t.hours);
        assertEquals(8, t.minutes);
        assertEquals(20, t.seconds);
    }

    @Test
    public void testTimeOver3600(){
        Time t = Time.convertSeconds(3662);

        assertEquals(1, t.hours);
        assertEquals(1, t.minutes);
        assertEquals(2, t.seconds);
    }

    @Test
    public void testTimeOver7300(){
        Time t = Time.convertSeconds(7300);

        assertEquals(2, t.hours);
        assertEquals(1, t.minutes);
        assertEquals(40, t.seconds);
    }
}
