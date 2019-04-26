package ucr.ac.ecci.ci1322.laboratorio1.core.student.dao;

import ucr.ac.ecci.ci1322.laboratorio1.model.Student;

import java.sql.SQLException;

public interface StudentDao {

    /**
     * Finds a student by its id.
     *
     * @param id the student id
     * @return the found student.
     */
    Student findById(String id) throws SQLException;

    /**
     * Adds an element to the student entity
     *
     * @param entity student entity.
     * @return
     */
    String create(Student entity) throws SQLException;

    /**
     * Updates an element of the student entity
     *
     * @param entity student entity.
     */
    void update(Student entity);

    /**
     * Removes an element from the student entity
     *
     * @param entity student entity.
     */
    void remove(Student entity);
}
