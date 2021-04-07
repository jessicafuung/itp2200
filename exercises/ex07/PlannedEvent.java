package ex07;

public class PlannedEvent extends Event {

    public PlannedEvent(String name) {
        super(name);
    }

    public PlannedEvent(String name, Date date) {
        super(name, date);
        checkDate(date);
    }

    public PlannedEvent(String name, Date start, Date end) {
        super(name, start, end);
        checkDate(end);
    }

    //Denne metoden er for å sørge for at startdatoen til en PlannedEvent ikke er i fortiden
    @Override
    public void setEndDate(Date EndDate) {
        checkDate(endDate);
        this.endDate = endDate;
    }

    //Method for checking that a date is not in the future
    private void checkDate(Date d){
        if (d.isBefore(new Date()))
            throw new IllegalArgumentException("A PlannedEvent cannot happen in the past.");
    }
}
