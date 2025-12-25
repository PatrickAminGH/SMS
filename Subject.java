package sms;

public class Subject implements Identifiable{
    private String subject;
    private int id;
    private int grade;
    private int creditHours;
    private Day day;
    private String time;
    private static int counter = 101;
    private LinkedList<Subject> requiredSubjects;
    Subject(String subject, int grade, int creditHours, String day, String time) {
        this.subject = subject;
        this.id = counter++;
        this.grade = grade;
        this.creditHours = creditHours;
        this.day = toDay(day);
        this.time = time;
    }

    public Day toDay(String day) {
        return switch (day.toLowerCase()) {
            case "monday" -> Day.MONDAY;
            case "tuesday" -> Day.TUESDAY;
            case "wednesday" -> Day.WEDNESDAY;
            case "thursday" -> Day.THURSDAY;
            case "friday" -> Day.FRIDAY;
            case "saturday" -> Day.SATURDAY;
            default -> Day.SUNDAY;
        };
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public LinkedList<Subject> getRequiredSubjects() {
        return requiredSubjects;
    }

    public void setRequiredSubjects(Subject subject) {
        requiredSubjects.add(subject);
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
