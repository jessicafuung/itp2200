package ex07;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HistoricalEventNarratorTest {
/*
    @Test
    public void testElapsedTime(){
        // This tests the elapsed time method.
        HistoricalEvent e1 = new HistoricalEvent("Death of Caligula", new Date(41, 01, 24));
        EventNarrator en = new EventNarrator();

        String res = en.elapsedTime(e1);
        assertTrue(res.contains("Caligula"));
    }
*/

    //Her skal vi lage forskjellige tester som tester om det er:
    // - Under 30 dager
    // - Over 30 dager
    // - Over 1 år

    @Test
    public void testReq1_0(){   //Denne testen skal returnere en tom verdi. Hvis eventen er i fremtiden
        PlannedEvent e1 = new PlannedEvent("Example 1", new Date(2022, 4, 1));  //Oppretter/ henter inn obj og oppgir en PlannedEvent (fremtid)
        EventNarrator en = new EventNarrator(); //Oppretter/ henter inn EventNarrator-obj

        String res = en.elapsedTime(e1);        //Regner ut denne og skriver inn svaret under assertion
        assertEquals("", res);   //Om det er en PlannedEvent i HistoricalEvent, returner ingenting
    }

    @Test
    public void testReq1a(){
        // This tests the elapsed time method. under 30 days
        HistoricalEvent e1 = new HistoricalEvent("Example", new Date(2021, 4, 1));  //Oppretter/ henter inn obj og oppgir en HistoricalEvent som var i går
        EventNarrator en = new EventNarrator(); //Oppretter/ henter inn EventNarrator-obj

        String res = en.elapsedTime(e1);        //Regner ut denne og skriver inn svaret under assertion
        assertEquals("Example was 5 days ago", res);   //Her må vi skrive inn eksakt tekst med forventet differanse fra datoen som er skrevet inn. res skal gi lik resultat som expected
    }

    @Test
    public void testReq1b(){
        HistoricalEvent e1 = new HistoricalEvent("Party", new Date(2021, 2, 2)); //Oppretter obj, kaller den for "Party" og skriver input på Date
        EventNarrator en = new EventNarrator(); //Oppretter/ henter inn EventNarrator-obj

        String res = en.elapsedTime(e1);
        assertEquals("Party was 2 months ago", res);
    }

    @Test
    public void testReq1c(){
        HistoricalEvent e1 = new HistoricalEvent("Lectures", new Date(2019, 2, 2)); //Oppretter obj, kaller den for "Lectures" og skriver input på Date
        EventNarrator en = new EventNarrator(); //Oppretter/ henter inn EventNarrator-obj

        String res = en.elapsedTime(e1);
        assertEquals("Lectures was 2 years ago", res);
    }

    @Test
    public void testReq2a(){    //Tester hvis varigheten er over 1 dag og under 30 dager
        HistoricalEvent e1 = new HistoricalEvent("Second Party", new Date(2021, 4, 1), new Date(2021, 4, 5));
        EventNarrator en = new EventNarrator(); //Oppretter/ henter inn EventNarrator-obj

        String res = en.duration(e1);        //Regner ut denne og skriver inn svaret under assertion
        assertEquals("Second Party lasted for 4 days", res);
    }

    @Test
    public void testReq2b(){        //Tester hvis varigheten er over 1 måned
        HistoricalEvent e1 = new HistoricalEvent("Meeting with students", new Date(2021, 1, 1), new Date(2021, 4, 5));
        EventNarrator en = new EventNarrator(); //Oppretter/ henter inn EventNarrator-obj

        String res = en.duration(e1);        //Regner ut denne og skriver inn svaret under assertion
        assertEquals("Meeting with students lasted for 3 months", res);
    }

    @Test
    public void testReq2c(){        //Tester hvis varigheten er over 1 år
        HistoricalEvent e1 = new HistoricalEvent("ITP22 course", new Date(2021, 1, 1), new Date(2023, 4, 5));
        EventNarrator en = new EventNarrator(); //Oppretter/ henter inn EventNarrator-obj

        String res = en.duration(e1);        //Regner ut denne og skriver inn svaret under assertion
        assertEquals("ITP22 course lasted for 2 years", res);
    }

    @Test
    public void testReq2_0(){       //Tester hvis varigheten = 1 dag
        HistoricalEvent e1 = new HistoricalEvent("Third party", new Date(2021, 1, 1), new Date(2021, 1, 1));
        EventNarrator en = new EventNarrator(); //Oppretter/ henter inn EventNarrator-obj

        String res = en.duration(e1);        //Regner ut denne og skriver inn svaret under assertion
        assertEquals("", res);
    }

    @Test
    public void testReq3_0(){ //Hvis ikke det ikke er i kronologisk rekkefølge så skal det returenre ingenting
        HistoricalEvent e1 = new HistoricalEvent("Jessicas bursdag", new Date(1998, 5, 30), new Date(2020, 5, 30)); //event 1, start og slutt
        HistoricalEvent e2 = new HistoricalEvent("Oles bursdag", new Date(1994, 10, 30), new Date(2019, 10, 30)); //event 2, start og slutt
        EventNarrator en = new EventNarrator(); //Oppretter/ henter inn EventNarrator-obj

        String res = en.timeBetweenEvents(e1, e2);      //Metode i event-klassen som taes i bruk (og hvilken input som taes inn)
        assertEquals("", res);
    }

    @Test
    public void testReq3a(){ //Noen år i mellom eventene
        HistoricalEvent e1 = new HistoricalEvent("skolestart", new Date(2011, 8, 15), new Date(2011, 8, 30)); //event 1, start og slutt
        HistoricalEvent e2 = new HistoricalEvent("skoleslutt", new Date(2014, 6, 20), new Date(2014, 6, 22)); //event 2, start og slutt
        EventNarrator en = new EventNarrator(); //Oppretter/ henter inn EventNarrator-obj

        String res = en.timeBetweenEvents(e1, e2);      //Metode i eventNarrator-klassen som taes i bruk (og hvilken input som taes inn)
        assertEquals("There were 2 years between the start of skolestart and skoleslutt", res);
    }

    @Test
    public void testReq3b(){ //Noen måneder i mellom
        HistoricalEvent e1 = new HistoricalEvent("Fjelltur", new Date(2021, 1, 13), new Date(2021, 1, 15)); //event 1, start og slutt
        HistoricalEvent e2 = new HistoricalEvent("Festival", new Date(2021, 3, 15), new Date(2021, 3, 20)); //event 2, start og slutt
        EventNarrator en = new EventNarrator(); //Oppretter/ henter inn EventNarrator-obj

        String res = en.timeBetweenEvents(e1, e2);      //Metode i eventNarrator-klassen som taes i bruk (og hvilken input som taes inn)
        assertEquals("There were 2 months between the start of Fjelltur and Festival", res);
    }

    @Test
    public void testReq3c(){ //Noen dager i mellom
        HistoricalEvent e1 = new HistoricalEvent("Hyttetur", new Date(2021, 3, 1), new Date(2021, 3, 2)); //event 1, start og slutt
        HistoricalEvent e2 = new HistoricalEvent("Festival", new Date(2021, 3, 10), new Date(2021, 3, 12)); //event 2, start og slutt
        EventNarrator en = new EventNarrator(); //Oppretter/ henter inn EventNarrator-obj

        String res = en.timeBetweenEvents(e1, e2);      //Metode i eventNarrator-klassen som taes i bruk (og hvilken input som taes inn)
        assertEquals("There were 9 days between the start of Hyttetur and Festival", res);
    }

}
