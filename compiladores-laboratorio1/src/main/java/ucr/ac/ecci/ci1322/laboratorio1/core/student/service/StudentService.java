package ucr.ac.ecci.ci1322.laboratorio1.core.student.service;

import ucr.ac.ecci.ci1322.laboratorio1.model.Student;

import java.sql.SQLException;

public interface StudentService {

    /**
     * wrapper method of findById from the class StudentDao
     *
     * @param id  the student id
     * @return the found student.
     */
    Student findById(String id) throws SQLException;

    /**
     * wrapper method of create from the class StudentDao
     *
     * @param entity  student entity
     * @return
     */
    String create(Student entity) throws SQLException;

    /**
     * wrapper method of update from the class StudentDao
     *
     * @param entity  student entity
     */
    void update(Student entity);

    /**
     * wrapper method of remove from the class StudentDao
     *
     * @param entity  student entity
     */
    void remove(Student entity);
}
