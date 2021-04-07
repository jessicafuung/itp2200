package ex07;


import static ex07.Date.dayDiff;

/**
 * The [EventNarrator] generates documentary-style comments about specific events, when they happened, how long they
 * took and how much time passed between two events.
 *
 * This is a classroom exercise for ITP2200 - Introduction to Software Testing, held at Høyskolen Kristiania.
 */
public class EventNarrator {

    public void accessPoint(){
        // this simulates where our code will be used
        //Event mid1 = new Event("Midway");
        //Event mid2 = new Event("Midway", new Date(1942, 06, 04));
        //Event

        Event[] events = new Event[5];


        // For each event in an array:

        // TODO 1. Display the time since an event (print "This many years/months/days ago").

        // TODO 2. Print the duration of an event (print "This event took [x] years/months/days") IF the event took more than a day

        // TODO 3. Print the time that passed between the current event and the previous event ( e.g. "It was [x] years/months/days later that [y] happened") IF the previous event happened before.
    }


    // TODO Req. 1
    public String elapsedTime(Event e){     //Tar Event e som input. Type String
        String result = "";        //Hvis event er i fremtiden, returner ingenting

        if (e.getEndDate().isBefore(new Date())) {    //Hvis event sin sluttdato er før nådato...
            //Do something
            if(e.getEndDate().yearsSince() > 0)     //Hvis sluttdatoen til eventen har bikket 1 år eller mer
                result = e.getName() + " was " + e.getEndDate().yearsSince() + " years ago"; //=skriv ut antall år hvis det er over 1 år
            else if (e.getEndDate().monthsSince() > 0 )
                result = e.getName() + " was " + e.getEndDate().monthsSince() + " months ago"; //=skriv ut antall måned hvis det er over 1 måned
            else
                result = e.getName() + " was " + e.getEndDate().daysSince() + " days ago"; //=skriv ut antall dager hvis det er under 30 dager siden

        }
        return result;
    }

    // TODO req. 2
    public String duration(Event e) {
        String result = "";             //Lokal variabel som holder string

        if (e.getEndDate().isAfter(e.getStartDate())) { // kun hvis eventen sin sluttdato er etter startdatoen, hvis ikke return result
            if (e.getEndDate().yearsSince(e.getStartDate()) > 0)        //Hvis sluttdatoens år og (startdatoens år) har en diff på mer enn "1 år"
                result = e.getName() + " lasted for " + e.getEndDate().yearsSince(e.getStartDate()) + " years";
            else if (e.getEndDate().monthsSince(e.getStartDate()) > 0)
                result = e.getName() + " lasted for " + e.getEndDate().monthsSince(e.getStartDate()) + " months";
            else
                result = e.getName() + " lasted for " + dayDiff(e.getEndDate(), e.getStartDate()) + " days";
        }
        return result;      //returner resultatet
    }

    // TODO req. 3
    public String timeBetweenEvents(Event e1, Event e2) {
        String result = "";             //Tom lokal variabel som holder string

        if (e1.getStartDate().isBefore(e2.getStartDate())) { //Hvis event1 sin startdato er før event2 sin startdato, skjer dette... hvis ikke rett til result (pga kronologisk)
            if (e1.getStartDate().yearsSince(e2.getStartDate()) > 0) //hvis event1 sin startdato (år) (sammenligned med event2 sin startdato(år) er mer enn 0
                result = "There were " + e1.getStartDate().yearsSince(e2.getStartDate()) + " years between the start of " + e1.getName() + " and " + e2.getName();
            else if (e1.getStartDate().monthsSince(e2.getStartDate()) > 0)     //hvis event1 sin startmåned (sammenligned med event2 sin startmåned) er mer enn 0
                result = "There were " + e1.getStartDate().monthsSince(e2.getStartDate()) + " months between the start of " + e1.getName() + " and " + e2.getName();
         else
            result = "There were " + dayDiff(e2.getStartDate(), e1.getStartDate()) + " days between the start of " + e1.getName() + " and " + e2.getName();
        }
        return result;
    }



}
