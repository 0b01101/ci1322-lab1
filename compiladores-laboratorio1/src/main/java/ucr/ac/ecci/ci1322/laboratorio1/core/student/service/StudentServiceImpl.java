package ucr.ac.ecci.ci1322.laboratorio1.core.student.service;

import ucr.ac.ecci.ci1322.laboratorio1.core.student.dao.JdbcStudentService;
import ucr.ac.ecci.ci1322.laboratorio1.core.student.dao.StudentDao;
import ucr.ac.ecci.ci1322.laboratorio1.model.Student;

import java.sql.SQLException;

public class StudentServiceImpl implements StudentService{
    private StudentDao studentDao;

    public StudentServiceImpl() throws SQLException, ClassNotFoundException {
        studentDao = new JdbcStudentService();
    }

    public Student findById(String id) throws SQLException {
        return studentDao.findById(id);
    }

    public String create(Student entity) throws SQLException {
        return studentDao.create(entity);
    }

    public void update(Student entity) {
        studentDao.update(entity);
    }

    public void remove(Student entity) {
        studentDao.remove(entity);
    }
}
