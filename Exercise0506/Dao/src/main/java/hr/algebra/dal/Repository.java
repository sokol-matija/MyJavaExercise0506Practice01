/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal;

import hr.algebra.model.Student;
import java.util.List;

/**
 *
 * @author lecturerf6
 */
public interface Repository {
    int createStudent(Student student) throws Exception;
    void updateStudent(int id, Student data) throws Exception;
    void deleteStudent(int id) throws Exception;
    Student selectStudent(int id) throws Exception;
    List<Student> selectStudents() throws Exception;
    
}
