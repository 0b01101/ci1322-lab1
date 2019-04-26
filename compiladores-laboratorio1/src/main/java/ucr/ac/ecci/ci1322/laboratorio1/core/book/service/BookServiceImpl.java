package ucr.ac.ecci.ci1322.laboratorio1.core.book.service;

import ucr.ac.ecci.ci1322.laboratorio1.core.book.dao.BookDao;
import ucr.ac.ecci.ci1322.laboratorio1.core.book.dao.JdbcBookService;
import ucr.ac.ecci.ci1322.laboratorio1.model.Book;

import java.sql.SQLException;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public BookServiceImpl() throws SQLException, ClassNotFoundException {
        bookDao = new JdbcBookService();
    }

    public Book findById(String id) throws SQLException {
        return bookDao.findById(id);
    }
    public String create(Book entity) throws SQLException {
        return bookDao.create(entity);
    }

    public void update(Book entity) {
        bookDao.update(entity);
    }

    public void remove(Book entity) {
        bookDao.remove(entity);
    }
}
