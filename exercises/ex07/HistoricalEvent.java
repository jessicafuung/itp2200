package ex07;

public class HistoricalEvent extends Event {

    public HistoricalEvent(String name) {
        super(name);
    }

    public HistoricalEvent(String name, Date date) {
        super(name, date);
        checkDate(date);
    }

    public HistoricalEvent(String name, Date start, Date end) {
        super(name, start, end);
        checkDate(start);
    }

    //Denne metoden er for å sørge for at startdatoen til en HistoricalEvent ikke er i fremtiden
    @Override
    public void setStartDate(Date startDate) {
        checkDate(startDate);
        this.startDate = startDate;
    }

    //Method for checking that a date is not in the future
    private void checkDate(Date d){
        if (d.isAfter(new Date()))
            throw new IllegalArgumentException("A HistoricalEvent cannot happen in the future.");
    }
}
