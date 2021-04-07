package ex07;

import java.time.LocalDate;
import java.time.Period;

/**
 * Note! The Date class assumes that you have checked the inputs. If this is not true,
 * A DateTimeException will be thrown.
 */
public class Date {
    LocalDate date;             //Forhåndsimplementert java-klasse med metoder
    public Date(){
            this.date = LocalDate.now();        //Oppretter obj og bruker .now metoden
        }
    public Date(int year, int month, int day){
            this.date = LocalDate.of(year, month, day);
        }


    /**
     * The method returns an int that describes the number of days between events.
     * Note! The number of days is in absolute value. If a sign is required, please implement another method.
     * @param d1
     * @param d2
     * @return
     */
    public static int dayDiff(Date d1, Date d2){
            Period period = Period.between(d1.date, d2.date);
            return Math.abs(period.getDays());
    }

    public static int daysSince(Date d){
        return dayDiff(d, new Date());
    }

    public int daysSince(){
        return dayDiff(this, new Date());
    }

    public int monthsSince(Date d){
        Period period = Period.between(this.date, d.date);
        return Math.abs(period.getMonths());
    }

    public int monthsSince(){
        Period period = Period.between(this.date, new Date().date);
        return Math.abs(period.getMonths());
    }

    public int yearsSince(){
        Period period = Period.between(this.date, new Date().date);
        return Math.abs(period.getYears());
    }

    public int yearsSince(Date d){
        Period period = Period.between(this.date, d.date);
        return Math.abs(period.getYears());
    }

    //Method to check if some date is after another
    public boolean isAfter(Date d){  //Tar en "Date" som input (d=ref), boolean = gir kun true/ false verdier
        if(date.isAfter(d.date))    //.isAfter er metode tilhørende LocalDate. Hvis dato er etter..(dato-obj)
            return true;               //Hvis det er sant = returner true;
        else
            return false;           //..Hvis ikke returner false;
    }

    public boolean isBefore(Date d){
        return !isAfter(d);     //Tar inn isAfter-metoden sin date, men returner omvendt resultat
    }

}
