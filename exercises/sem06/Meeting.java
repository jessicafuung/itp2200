package sem06;

import ex06.Date;
import ex06.Person;
import ex06.Time;

public class Meeting {
    ex06.Person owner;
    ex06.Date date;
    ex06.Time time;
    int duration;

    public Meeting() {
    }

    public Meeting(Person p, ex06.Date d, ex06.Time t){
        this.owner = p;
        this.date = d;
        this.time = t;
    }

    public void setDate(int year, int month, int day){
        this.date = new Date(year, month, day);
    }

    public void setTime(int hour, int minute){
        this.time = new Time(hour, minute, 0);
    }

    //Change meeting owner
    //public void setOwner(Person owner);
    //  this.owner = owner;


}



