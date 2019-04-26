package ucr.ac.ecci.ci1322.laboratorio1.core.book.dao;

import ucr.ac.ecci.ci1322.laboratorio1.model.Book;

import java.sql.*;
import java.util.Properties;

public class JdbcBookService implements BookDao{

    private Connection conn;

    public JdbcBookService()throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/library";
        conn = DriverManager.getConnection(url,"root","");
        Statement stmt = conn.createStatement();
        DatabaseMetaData dbm = conn.getMetaData();
        ResultSet tables = dbm.getTables(null, null, "book", null);
        if (!tables.next()) {
            stmt = conn.createStatement();
            stmt.executeUpdate("create table book(Book_ID int,Type varchar(30),Title varchar(255));");
            System.out.println("Book Table created");
        }
    }

    public Book findById(String id)throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet;
        resultSet = statement.executeQuery("SELECT * FROM book WHERE Book_ID = " + id );
        Integer ID = Integer.parseInt(resultSet.getString(1));
        String Type = resultSet.getString(2);
        String Title = resultSet.getString(3);
        return new Book(ID,Type,Title);
    }

    public String create(Book entity) throws SQLException{
        Statement statement = conn.createStatement();
        statement.executeUpdate(
            "INSERT INTO book VALUES("+
                entity.getBook_ID() + "," +
                entity.getType() + "," +
                entity.getTitle() +
            ");"
        );
        return "Book: " + entity.getBook_ID() + ", " + entity.getType() + ", " + entity.getTitle() + "; added.";
    }

    public void update(Book entity) {

    }

    public void remove(Book entity) {

    }
}
