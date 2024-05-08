/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

/**
 *
 * @author lecturerf6
 */
public final class Student {

    private static final String DEL = ";";

    private int id;
    private String firstName;
    private String lastName;
    private Grade grade;
    private String picturePath;

    public Student(int id, String firstName, String lastName, Grade grade, String picturePath) {
        this(firstName, lastName, grade, picturePath);
        setId(id);
    }

    public Student(String firstName, String lastName, Grade grade, String picturePath) {
        setFirstName(firstName);
        setLastName(lastName);
        setGrade(grade);
        setPicturePath(picturePath);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String format() {
        return id + DEL
                + firstName + DEL
                + lastName + DEL
                + grade.getGrade() + DEL
                + picturePath + System.lineSeparator();
    }

    public static Student parse(String line) {
        String[] details = line.split(DEL);
        return new Student(
                Integer.parseInt(details[0]),
                details[1],
                details[2],
                Grade.from(Integer.parseInt(details[3])),
                details[4]);
    }
    
    public void update(Student data) {
        setFirstName(data.getFirstName());
        setLastName(data.getLastName());
        setGrade(data.getGrade());
        setPicturePath(data.getPicturePath());
    }

}
