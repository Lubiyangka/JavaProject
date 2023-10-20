import java.util.*;

public class Main {
    public static void main(String[] args) {
        //随机数生成
        Random random = new Random();
        //课程，学生，成绩数据生成
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("张三", "322031404", "male", "B3"));
        studentList.add(new Student("李华", "322031117", "male", "B3"));
        studentList.add(new Student("李四", "322031118", "female", "B3"));
        studentList.add(new Student("王五", "322031119", "female", "B3"));
        studentList.add(new Student("胡军", "322031110", "male", "A11"));
        studentList.add(new Student("周好", "322031116", "female", "A11"));
        studentList.add(new Student("朱未", "322031115", "male", "A11"));
        studentList.add(new Student("叶俊", "322031114", "female", "A11"));
        studentList.add(new Student("符杨", "322031113", "male", "A11"));

        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course(1L, "语文", 2.0));
        courseList.add(new Course(2L, "数学", 5.0));
        courseList.add(new Course(3L, "英语", 1.0));

        List<Grade> gradeList = new ArrayList<>();
        for (Student student : studentList) {
            for (Course course : courseList) {
                gradeList.add(new Grade(student.getName(), course.getName(), random.nextDouble(30) + 70));
            }
        }


        //个人统计
        Map<String, Double> totalGrades = new HashMap<>();
        Map<String, Double> averageGrades = new HashMap<>();
        Map<String, Double> totalCredits = new HashMap<>();
        for (Student student : studentList) {
            double totalGrade = 0;
            double totalCredit = 0;
            int time = 0;
            for (Course course : courseList) {
                double score = 0;
                for (Grade grade : gradeList) {
                    if (grade.getStudentName().equals(student.getName()) && grade.getCourseName().equals(course.getName())) {
                        score = grade.getCourseScore();
                        time++;
                        break;
                    }
                }
                totalGrade += score * course.getScore();
                totalCredit += course.getScore();
            }
            totalGrades.put(student.getName(), totalGrade);
            averageGrades.put(student.getName(), totalGrade / time);
            totalCredits.put(student.getName(), totalCredit);
        }

        studentList.sort((studentA, studentB) -> {
            double a = averageGrades.get(studentA.getName());
            double b = averageGrades.get(studentB.getName());
            return Double.compare(b, a);
        });
        System.out.println("<----学生---->");
        for (Student student : studentList) {
            System.out.println(student.getName() + "的总成绩:" + totalGrades.get(student.getName()) + "  平均成绩:" + averageGrades.get(student.getName()) + "  总学分:" + totalCredits.get(student.getName()));
        }

        //班级统计
        Map<String, Double> classTotalGrades = new HashMap<>();
        for (Student student : studentList) {
            double totalGrade = totalGrades.get(student.getName());
            if (classTotalGrades.containsKey(student.getClassNumber())) {
                classTotalGrades.put(student.getClassNumber(), classTotalGrades.get(student.getClassNumber()) + totalGrade);
            } else {
                classTotalGrades.put(student.getClassNumber(), totalGrade);
            }
        }
        System.out.println("<----班级---->");
        for(String className:classTotalGrades.keySet()){
            System.out.println(className+"的总成绩:"+classTotalGrades.get(className));
        }

        //课程统计
        Map<String, Double> courseAverageGrades = new HashMap<>();
        Map<String, Double> courseTotalCredits = new HashMap<>();
        for (Course course : courseList) {
            double totalGrade = 0;
            int time = 0;
            for (Student student : studentList) {
                double score = 0;
                for (Grade grade : gradeList) {
                    if (grade.getStudentName().equals(student.getName()) && grade.getCourseName().equals(course.getName())) {
                        score = grade.getCourseScore();
                        break;
                    }
                }
                totalGrade += score * course.getScore();
                time++;
            }
            courseTotalCredits.put(course.getName(), totalGrade);
            courseAverageGrades.put(course.getName(), totalGrade / time);
        }
        System.out.println("<----课程---->");
        for(Course course:courseList){
            System.out.println(course.getName()+"总得分:"+courseTotalCredits.get(course.getName())+"  平均成绩:"+courseAverageGrades.get(course.getName()));
        }
    }
}
