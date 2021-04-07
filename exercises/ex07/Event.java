package ex07;

public class Event {
    public Date startDate;
    public Date endDate;
    public String name;

    public Event(String name){
        this.name = name;
    }

    public Event(String name, Date date){
        this.name = name;
        this.startDate = date;
        this.endDate = date;
    }

    public Event(String name, Date start, Date end){
        this.name = name;
        this.startDate = start;
        this.endDate = end;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Method for checking that endDate is after startDate
}
