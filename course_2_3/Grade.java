public class Grade {
    private String studentName;
    private String courseName;
    private Double courseScore;

    public Grade(String studentName, String courseName, Double courseScore) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.courseScore = courseScore;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getCourseScore() {
        return courseScore;
    }

    public void setCourseScore(Double courseScore) {
        this.courseScore = courseScore;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "studentName='" + studentName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseScore=" + courseScore +
                '}';
    }
}
