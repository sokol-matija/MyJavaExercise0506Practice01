package hr.algebra.dal.sql;

import hr.algebra.dal.Repository;
import hr.algebra.model.Grade;
import hr.algebra.model.Student;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class SqlRepository implements Repository {

    private static final String ID_STUDENT = "IDStudent";
    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    private static final String GRADE = "Grade";
    private static final String PICTURE_PATH = "PicturePath";

    private static final String CREATE_STUDENT = "{ CALL createStudent (?,?,?,?,?) }";
    private static final String UPDATE_STUDENT = "{ CALL updateStudent (?,?,?,?,?) }";
    private static final String DELETE_STUDENT = "{ CALL deleteStudent (?) }";
    private static final String SELECT_STUDENT = "{ CALL selectStudent (?) }";
    private static final String SELECT_STUDENTS = "{ CALL selectStudents }";

    @Override
    public int createStudent(Student student) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_STUDENT)) {

            stmt.setString(FIRST_NAME, student.getFirstName());
            stmt.setString(LAST_NAME, student.getLastName());
            stmt.setInt(GRADE, student.getGrade().getGrade());
            stmt.setString(PICTURE_PATH, student.getPicturePath());

            stmt.registerOutParameter(ID_STUDENT, Types.INTEGER);

            stmt.executeUpdate();

            return stmt.getInt(ID_STUDENT);
        }
    }

    @Override
    public void updateStudent(int id, Student student) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_STUDENT)) {

            stmt.setString(FIRST_NAME, student.getFirstName());
            stmt.setString(LAST_NAME, student.getLastName());
            stmt.setInt(GRADE, student.getGrade().getGrade());
            stmt.setString(PICTURE_PATH, student.getPicturePath());

            stmt.setInt(ID_STUDENT, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteStudent(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_STUDENT)) {
            stmt.setInt(ID_STUDENT, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Student selectStudent(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_STUDENT)) {
            stmt.setInt(ID_STUDENT, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                            rs.getInt(ID_STUDENT),
                            rs.getString(FIRST_NAME),
                            rs.getString(LAST_NAME),
                            Grade.from(rs.getInt(GRADE)),
                            rs.getString(PICTURE_PATH));
                }
            }
        }
        return null;
    }

    @Override
    public List<Student> selectStudents() throws Exception {
        List<Student> students = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_STUDENTS); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt(ID_STUDENT),
                        rs.getString(FIRST_NAME),
                        rs.getString(LAST_NAME),
                        Grade.from(rs.getInt(GRADE)),
                        rs.getString(PICTURE_PATH)));
            }

        }
        return students;
    }

}
