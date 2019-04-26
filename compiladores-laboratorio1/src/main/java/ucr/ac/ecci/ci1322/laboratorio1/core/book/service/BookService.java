package ucr.ac.ecci.ci1322.laboratorio1.core.book.service;

import ucr.ac.ecci.ci1322.laboratorio1.model.Book;

import java.sql.SQLException;

public interface BookService {

    /**
     * wrapper method of findById from the class BookDao
     *
     * @param id  the book id
     * @return the found book.
     */
    Book findById(String id) throws SQLException;

    /**
     * wrapper method of create from the class BookDao
     *
     * @param entity  book entity
     * @return
     */
    String create(Book entity) throws SQLException;

    /**
     * wrapper method of update from the class BookDao
     *
     * @param entity  book entity
     */
    void update(Book entity);

    /**
     * wrapper method of remove from the class BookDao
     *
     * @param entity  book entity
     */
    void remove(Book entity);
}
