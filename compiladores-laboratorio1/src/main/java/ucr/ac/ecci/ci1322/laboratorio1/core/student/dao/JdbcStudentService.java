package ucr.ac.ecci.ci1322.laboratorio1.core.student.dao;

import ucr.ac.ecci.ci1322.laboratorio1.model.Student;

import java.sql.*;

public class JdbcStudentService implements StudentDao {

    private Connection conn;

    public JdbcStudentService() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/library";
        conn = DriverManager.getConnection(url,"root","");
        Statement stmt = conn.createStatement();
        DatabaseMetaData dbm = conn.getMetaData();
        ResultSet tables = dbm.getTables(null, null, "student", null);
        if (!tables.next()) {
            stmt = conn.createStatement();
            stmt.executeUpdate("create table student(Student_ID int, Name varchar(30));");
            System.out.println("Student Table created");
        }
    }

    public Student findById(String id) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet;
        resultSet = statement.executeQuery("SELECT * FROM student WHERE Student_ID = " + id );
        Integer ID = Integer.parseInt(resultSet.getString(1));
        String Name = resultSet.getString(2);
        return new Student(ID,Name);
    }

    public String create(Student entity) throws SQLException {
        Statement statement = conn.createStatement();
        statement.executeUpdate(
            "INSERT INTO book VALUES("+
                entity.getStudent_ID() + "," +
                entity.getName() +
            ");"
        );
        return "Student: " + entity.getStudent_ID() + ", " + entity.getName() + "; added.";
    }

    public void update(Student entity) {

    }

    public void remove(Student entity) {

    }
}
