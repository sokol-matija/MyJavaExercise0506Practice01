/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal.file;

import hr.algebra.dal.Repository;
import hr.algebra.model.Student;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class FileRepository implements Repository {

    private static final String DIR = "files";
    private static final Path DIR_PATH = Paths.get(DIR);
    private static final Path STUDENTS_PATH
            = Paths.get(DIR + File.separator + "students.txt");

    public FileRepository() throws IOException {
        if (!Files.exists(STUDENTS_PATH)) {
            Files.createDirectories(DIR_PATH);
            Files.createFile(STUDENTS_PATH);
        }
    }

    @Override
    public int createStudent(Student student) throws Exception {

        int maxId = selectStudents()
                .stream()
                .mapToInt(Student::getId)
                .max()
                .orElse(0);

        student.setId(++maxId);
        Files.write(
                STUDENTS_PATH,
                student.format().getBytes(),
                StandardOpenOption.APPEND);

        return maxId;

    }

    @Override
    public void updateStudent(int id, Student data) throws Exception {
        writeStudents(
                selectStudents()
                        .stream()
                        .map(s -> {
                            if (s.getId() == id) {
                                s.update(data);
                            }
                            return s;
                        })
                        .collect(Collectors.toList()));

    }

    @Override
    public void deleteStudent(int id) throws Exception {

        writeStudents(
                selectStudents()
                .stream()
                .filter(s -> s.getId() != id)
                .collect(Collectors.toList()));
        
    }

    @Override
    public Student selectStudent(int id) throws Exception {
        return 
                selectStudents()
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Student> selectStudents() throws Exception {

        return Files.readAllLines(STUDENTS_PATH)
                .stream()
                .map(Student::parse)
                .collect(Collectors.toList());
    
        
    }

    private void writeStudents(List<Student> students) throws IOException {

        Files.write(
                STUDENTS_PATH,
                students
                        .stream()
                        .map(Student::format)
                        .collect(Collectors.joining())
                        .getBytes());

    }

}
