package sms;

public class Exam implements Identifiable{
    Subject subject;
    String day;
    String time;
    int seatNumber;
    private static int counter = 101;

    Exam(Subject subject, String time, String day) {
        this.subject = subject;
        this.day = day;
        this.time = time;
        this.seatNumber = counter++;
    }

    public int getId() {
        return 0;
    }

    public String getSubject() {
        return subject.getSubject();
    }

    public int getSubjectId() {
        return subject.getId();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
