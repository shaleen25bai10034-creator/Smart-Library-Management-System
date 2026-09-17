package model;

public class Student extends User {
    private String course;

    public Student(int userId, String name, String email, String course) {
        super(userId, name, email);
        this.course = course;
    }

    public String getCourse() { return course; }

    @Override
    public String getRole() { return "Student"; }

    @Override
    public String toString() {
        return getUserId() + " | " + getName() + " | " + getEmail() + " | Student | " + course;
    }
}
