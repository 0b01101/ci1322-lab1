package ucr.ac.ecci.ci1322.laboratorio1.build;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ucr.ac.ecci.ci1322.laboratorio1.core.book.service.BookService;
import ucr.ac.ecci.ci1322.laboratorio1.core.book.service.BookServiceImpl;
import ucr.ac.ecci.ci1322.laboratorio1.core.student.service.StudentService;
import ucr.ac.ecci.ci1322.laboratorio1.core.student.service.StudentServiceImpl;
import ucr.ac.ecci.ci1322.laboratorio1.model.Book;
import ucr.ac.ecci.ci1322.laboratorio1.model.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;


public class DataLoader {
    private BookService bookService;
    private StudentService studentService;

    /**
     * Starts the connection to the database schema "library"
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public DataLoader() throws SQLException, ClassNotFoundException {
        bookService = new BookServiceImpl();
        studentService = new StudentServiceImpl();
    }

    /**
     * Visits all the rows of the book sheet and insert the data into the book database table
     *
     * @param bookSheet The sheet where all the information of the books is.
     * @throws SQLException
     */
    private void loadBooks(XSSFSheet bookSheet) throws SQLException {
        int n = bookSheet.getPhysicalNumberOfRows();
        for(int i = 1; i < n; i++){
            XSSFRow row = bookSheet.getRow(i);
            XSSFCell ID_cell = row.getCell(0);
            XSSFCell type_cell = row.getCell(1);
            XSSFCell title_cell = row.getCell(2);
            Integer ID = (int) ID_cell.getNumericCellValue();
            String type = type_cell.getStringCellValue();
            String title = title_cell.getStringCellValue();
            String result = bookService.create(new Book(ID,type,title));
            if(result != null){
                System.out.println(result);
            }else{
                System.out.println("Book("+ID+") already on the database");
            }

        }
        System.out.println();
    }

    /**
     * Visits all the rows of the student sheet and insert the data into the student database table
     *
     * @param studentSheet the sheet where the student's information is
     * @throws SQLException
     */
    private void loadStudents(XSSFSheet studentSheet) throws SQLException {
        int n = studentSheet.getPhysicalNumberOfRows();
        for(int i = 1; i < n; i++){
            XSSFRow row = studentSheet.getRow(i);
            XSSFCell ID_cell = row.getCell(0);
            XSSFCell name_cell = row.getCell(1);
            Integer ID = (int) ID_cell.getNumericCellValue();
            String name = name_cell.getStringCellValue();
            String result = studentService.create(new Student(ID, name));
            if(result != null){
                System.out.println(result);
            }else{
                System.out.println("Student("+ID+") already on the database");
            }
        }
    }

    /**
     * Opens the file "workbook.xlsx" and load its data to the database schema "library"
     *
     * @throws IOException
     * @throws SQLException
     */
    public void openWorkbook() throws IOException, SQLException {
        FileInputStream fileIn = new FileInputStream("src\\main\\resources\\workbook.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fileIn);
        loadBooks(wb.getSheetAt(1));
        loadStudents(wb.getSheetAt(0));
    }

    /**
     * Finds a book by its id on the database and display the book information.
     *
     * @param Id, book id
     * @throws IOException
     * @throws SQLException
     */
    public void findBookbyId(String Id) throws IOException, SQLException {
        Book book = bookService.findById(Id);
        if(book != null){
            System.out.println("Book("+book.getBook_ID()+"): "+ book.getType() + ", "+ book.getTitle());
        }else{
            System.out.println("Book not found");
        }

    }

    /**
     * Starts a new connection and loads data from the file "workbook.xlsx" to the database schema "library"
     *
     * @param args
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        DataLoader dataLoader = new DataLoader();
        dataLoader.openWorkbook();
    }

    /**
     * Displays the information of the book identified by its id
     *
     * @param book, the book id
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public static void main(String book) throws SQLException, ClassNotFoundException, IOException {
        DataLoader dataLoader = new DataLoader();
        dataLoader.findBookbyId(book);
    }
}

