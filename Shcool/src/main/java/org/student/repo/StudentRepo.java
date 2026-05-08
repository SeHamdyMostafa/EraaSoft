package org.student.repo;

import org.student.Database.DBConnection;
import org.student.models.StudentModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo {

    // GET ALL
    public List<StudentModel> getStudents() {
        List<StudentModel> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                StudentModel s = new StudentModel();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                students.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    // ADD
    public StudentModel addNewStudent(StudentModel student) {

        String sql = "INSERT INTO students (name, age) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                student.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    // GET BY ID
    public StudentModel getStudentById(int id) {

        String sql = "SELECT * FROM students WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                StudentModel s = new StudentModel();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                return s;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // DELETE
    public boolean deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // UPDATE
    public boolean updateStudent(int id, StudentModel student) {

        String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setInt(3, id);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}