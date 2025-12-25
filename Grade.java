package sms;

public class Grade implements Identifiable{
    int id;
    Subject subject;
    double grade;
    private static int counter = 101;
    Grade(Subject subject, double grade) {
        id = counter++;
        this.subject = subject;
        this.grade = grade;
    }

    public String getSubject() {
        return subject.getSubject();
    }

    public int getSubjectId() {
        return subject.getId();
    }

    public int getSubjectGrade() {
        return subject.getGrade();
    }

    public double getGrade() {
        return grade;
    }

    public int getCreditHours(){
        return subject.getCreditHours();
}

    public int getId() {
        return id;
    }
}
