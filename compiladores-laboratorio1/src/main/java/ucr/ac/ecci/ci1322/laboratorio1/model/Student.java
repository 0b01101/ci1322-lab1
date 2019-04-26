package ucr.ac.ecci.ci1322.laboratorio1.model;

public class Student {
    private Integer Student_ID;
    private String Name;

    public Student(Integer student_ID, String name){
        Student_ID = student_ID;
        Name = name;
    }
    public Integer getStudent_ID() {
        return Student_ID;
    }

    public String getName() {
        return Name;
    }
}
