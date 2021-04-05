package ex06;

import ex06.Time;
import org.junit.Test;

import static ex06.Time.durationInHours;
import static ex06.Time.durationInSeconds;
import static org.junit.Assert.*;

public class TimeTest {
    @Test
    public void testTime(){
        Time t = Time.convertSeconds(3662);
        assertTrue(t.hours == 1);
        assertTrue(t.minutes == 1);
        assertTrue(t.seconds == 2);
    }

    @Test
    public void constructorTest(){
        Time t = new Time(3612);
        assertTrue(t.seconds == 12);
        assertTrue(t.hours == 1);
    }

    @Test
    public void durationInHoursTest() {
        Time t1 = new Time(3, 2, 1 );
        Time t2 = new Time(1, 0, 0);

        assertEquals(2, durationInHours(t1, t2));
    }

    @Test
    public void durationInSecondsTest() {
        Time t1 = new Time(50);
        Time t2 = new Time(45);

        assertEquals(5, durationInSeconds(t1, t2));
    }
}