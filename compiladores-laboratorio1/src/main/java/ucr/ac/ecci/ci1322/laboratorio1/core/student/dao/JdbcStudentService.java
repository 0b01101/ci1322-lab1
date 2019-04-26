package ucr.ac.ecci.ci1322.laboratorio1.core.student.dao;

import ucr.ac.ecci.ci1322.laboratorio1.model.Student;

import java.sql.*;

public class JdbcStudentService implements StudentDao {

    private Connection conn;

    /**
     * Connects with the database, and creates a student table if it's necessary
     * 
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public JdbcStudentService() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/library?serverTimezone=GMT";
        conn = DriverManager.getConnection(url,"Daniel","1234");

        DatabaseMetaData dbm = conn.getMetaData();
        ResultSet tables = dbm.getTables(null, null, "student", null);
        if (!tables.next()) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(
                    "create table student(" +
                            "Student_ID int NOT NULL," +
                            " Name varchar(50)," +
                            "PRIMARY KEY (Student_ID)" +
                        ");"
            );
            System.out.println("Student Table created");
        }
    }

    public Student findById(String id) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet;
        resultSet = statement.executeQuery(
                "SELECT * FROM student WHERE Student_ID = " + id
        );
        if(resultSet.next()) {
            Integer ID = resultSet.getInt(1);
            String Name = resultSet.getString(2);
            return new Student(ID, Name);
        }else{
            return null;
        }
    }

    public String create(Student entity) throws SQLException {
        Statement statement = conn.createStatement();
        try {
            statement.executeUpdate(
                    "INSERT INTO student VALUES('"+
                            entity.getStudent_ID() + "','" +
                            entity.getName() +
                        "');"
            );
        } catch (SQLException e) {
            return null;
        }
        return "Student(" + entity.getStudent_ID() + "): " + entity.getName() + "; added.";
    }

    public void update(Student entity) {

    }

    public void remove(Student entity) {

    }
}
