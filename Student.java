package studentsystem;

public class Student {
    int studentID;
    String studentName;
    double studentGPA;

    public Student(int studentID, String studentName, double studentGPA) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentGPA = studentGPA;
    }

    public String toString() {
         return "ID:" + studentID +
                " - Name:" + studentName +
                " - GPA:" + studentGPA;
    }
    
}
