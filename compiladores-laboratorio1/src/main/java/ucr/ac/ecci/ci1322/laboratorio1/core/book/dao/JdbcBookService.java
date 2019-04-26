package ucr.ac.ecci.ci1322.laboratorio1.core.book.dao;

import ucr.ac.ecci.ci1322.laboratorio1.model.Book;

import java.sql.*;

public class JdbcBookService implements BookDao{

    private Connection conn;

    /**
     * Connects with the database, and creates a book table if it's necessary
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public JdbcBookService()throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/library?serverTimezone=GMT";
        conn = DriverManager.getConnection(url,"Daniel","1234");

        DatabaseMetaData dbm = conn.getMetaData();
        ResultSet tables = dbm.getTables(null, null, "book", null);
        if (!tables.next()) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(
            "create table book(" +
                    "Book_ID int NOT NULL," +
                    "Type varchar(30)," +
                    "Title varchar(255)," +
                    "PRIMARY KEY (Book_ID)" +
                ");"
            );
            System.out.println("Book Table created");
        }
    }

    public Book findById(String id)throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet;
        resultSet = statement.executeQuery(
                "SELECT * FROM book WHERE Book_ID = " + id
        );
        if(resultSet.next()) {
            Integer ID = (resultSet.getInt(1));
            String Type = resultSet.getString(2);
            String Title = resultSet.getString(3);
            return new Book(ID, Type, Title);
        }else{
            return null;
        }

    }

    public String create(Book entity) throws SQLException {
        Statement statement = conn.createStatement();
        try {
            statement.executeUpdate(
                    "INSERT INTO book VALUES('"+
                            entity.getBook_ID() + "','" +
                            entity.getType() + "','" +
                            entity.getTitle() +
                        "');"
            );
        } catch (SQLException e) {
            return null;
        }
        return "Book(" + entity.getBook_ID() + "): [" + entity.getType() + "]" + entity.getTitle() + "; added.";
    }

    public void update(Book entity) {

    }

    public void remove(Book entity) {

    }
}
