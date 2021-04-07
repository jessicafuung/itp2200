package sem06;

    public class Time {
        int hours;
        int minutes;
        int seconds;

        public Time(int hours, int minutes, int seconds) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }

        public Time(int seconds) {
            ex06.Time t = convertSeconds(seconds);
            this.hours = t.hours;
            this.minutes = t.minutes;
            this.seconds = t.seconds;
        }

        public static ex06.Time convertSeconds(int seconds) {
            int sec = seconds % 60;
            int hour = seconds / 60;
            int mins = hour % 60;

            hour = hour / 60;

            return new ex06.Time(hour, mins, sec);
        }

        public static int durationInHours(ex06.Time t1, ex06.Time t2) {
            // Add code to compute the difference between the two given time objects.
            return Math.abs(t1.hours - t2.hours);
        }

        public static int durationInSeconds(ex06.Time t1, ex06.Time t2) {  //statis for å bruke fra adnre kalsser uten å lage obj
            // Add code to compute the difference between the time stored in the current object and the time in the input.
            return Math.abs(t1.seconds - t2.seconds);

        }
    }