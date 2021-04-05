package ex05;

public class Time {
    int hours;
    int minutes;
    int seconds;

    public Time (int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public static Time convertSeconds(int seconds){
        if (seconds < 0)        //Lager et unntak.
            throw new IllegalArgumentException("You cannot use a negative number for variable 'seconds'"); //Unntaket blir kastet hvis input er et negativt tall
        int sec = seconds % 60;
        int hour = seconds / 60;
        int mins = hour % 60;

        hour = hour / 60;

        return new Time(hour, mins, sec);
    }
/*
    public static Time showSeconds(int hours, int minutes, int seconds){
        int sec = seconds % 60;
        int hour = seconds / 60;
        int mins = hour % 60;


        return new;
    }*/
}
