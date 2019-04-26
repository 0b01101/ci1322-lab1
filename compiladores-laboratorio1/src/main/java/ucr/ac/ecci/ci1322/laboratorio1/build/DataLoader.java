package ucr.ac.ecci.ci1322.laboratorio1.build;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ucr.ac.ecci.ci1322.laboratorio1.core.book.dao.JdbcBookService;
import ucr.ac.ecci.ci1322.laboratorio1.core.book.service.BookService;
import ucr.ac.ecci.ci1322.laboratorio1.core.book.service.BookServiceImpl;
import ucr.ac.ecci.ci1322.laboratorio1.core.student.service.StudentService;
import ucr.ac.ecci.ci1322.laboratorio1.core.student.service.StudentServiceImpl;

import javax.xml.crypto.Data;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;


public class DataLoader {
    private BookService bookService;
    private StudentService studentService;

    public DataLoader() throws SQLException, ClassNotFoundException {
        bookService = new BookServiceImpl();
        //studentService = new StudentServiceImpl();
    }

    private void loadBooks(XSSFSheet bookSheet){
        int n = bookSheet.getPhysicalNumberOfRows();
        for(int i = 1; i < n; i++){
            XSSFRow row = bookSheet.getRow(i);
            XSSFCell ID = row.getCell(0);
            XSSFCell type = row.getCell(1);
            XSSFCell title = row.getCell(2);
            System.out.println(ID);
            System.out.println(type);
            System.out.println(title);
            System.out.println('\n');
        }
    }

    private void loadStudents(XSSFSheet studentSheet){
        int n = studentSheet.getPhysicalNumberOfRows();
        for(int i = 1; i < n; i++){
            XSSFRow row = studentSheet.getRow(i);
            XSSFCell ID = row.getCell(0);
            XSSFCell name = row.getCell(1);
            System.out.println(ID);
            System.out.println(name);
            System.out.println('\n');
        }
    }

    public void openWorkbook() throws IOException {
        FileInputStream fileIn = new FileInputStream("src\\main\\resources\\workbook.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fileIn);
        loadBooks(wb.getSheetAt(1));
        loadStudents(wb.getSheetAt(0));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        DataLoader dataLoader = new DataLoader();
        //dataLoader.openWorkbook();
    }
}

