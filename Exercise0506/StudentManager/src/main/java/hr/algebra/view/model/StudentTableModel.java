/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.view.model;

import hr.algebra.model.Student;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lecturerf6
 */
public class StudentTableModel extends AbstractTableModel{

    private static final String[] COLUMNS = {
        "Id",
        "First name",
        "Last name", 
        "Grade",
        "Picture path"
    };
    // DEP
    private List<Student> students;

    // DI
    public StudentTableModel(List<Student> students) {
        this.students = students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
        // trigger refresha
        fireTableDataChanged();
    }
    
    
    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNS[column];
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return students.get(rowIndex).getId();
            case 1:
                return students.get(rowIndex).getFirstName();
            case 2:
                return students.get(rowIndex).getLastName();
            case 3:
                return students.get(rowIndex).getGrade();
            case 4:
                return students.get(rowIndex).getPicturePath();
            default:
                throw new AssertionError();
        }
    }
    
}
