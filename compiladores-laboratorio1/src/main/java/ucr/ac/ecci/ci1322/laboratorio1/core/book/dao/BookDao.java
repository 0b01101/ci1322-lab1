package ucr.ac.ecci.ci1322.laboratorio1.core.book.dao;

import ucr.ac.ecci.ci1322.laboratorio1.model.Book;

import java.sql.SQLException;

public interface BookDao {

    /**
     * Finds a book by its id.
     *
     * @param id the book id
     * @return the found book.
     */
    Book findById(String id) throws SQLException;

    /**
     * Adds an element to the book entity
     *
     * @param entity book entity.
     * @return
     */
    String create(Book entity) throws SQLException;

    /**
     * Updates an element of the book entity
     *
     * @param entity book entity.
     */
    void update(Book entity);

    /**
     * Removes an element from the book entity
     *
     * @param entity book entity.
     */
    void remove(Book entity);
}
