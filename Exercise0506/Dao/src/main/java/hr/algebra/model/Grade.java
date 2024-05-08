/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

/**
 *
 * @author lecturerf6
 */
public enum Grade {
    
    EXCELLENT(5),
    VERY_GOOD(4),
    GOOD(3),
    SATISFACTORY(2),
    FAIL(1);
    
    private final int grade;

    private Grade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }
    
    public static Grade from(int grade) {
        for (Grade value : values()) {
            if (value.grade == grade) {
                return value;
            }
        }
        // FAIL FAST
        throw new RuntimeException("no such grade");
    }
    
    
}
