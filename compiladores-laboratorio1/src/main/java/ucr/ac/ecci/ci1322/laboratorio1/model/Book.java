package ucr.ac.ecci.ci1322.laboratorio1.model;

public class Book {
    private Integer Book_ID;
    private String Type;
    private String Title;

    public Book(Integer book_ID, String type, String title){
        Book_ID = book_ID;
        Type = type;
        Title = title;
    }

    public Integer getBook_ID() {
        return Book_ID;
    }

    public String getType() {
        return Type;
    }

    public String getTitle() {
        return Title;
    }
}
