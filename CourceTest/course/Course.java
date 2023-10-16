package course;
import department.Major;

public class Course {
    int no;
    int grade;
    Major major;
    String name;
    private int serialNumber;
    private static int counter = 0;

    public Course(){
        counter++;
        serialNumber=counter;
        System.out.println(serialNumber);
    }


}
