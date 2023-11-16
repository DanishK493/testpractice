import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Student student = new Student("raphael", 106);
        student.addCourse("Math", 100);
        student.printattributes();
    }
}

class Course {
    String coursename;
    int grade;
    Course(String coursename, int grade) {
      this.coursename = coursename;
      this.grade = grade;  
    }
}

class Student {
    String name;
    int id;
    Course course;
    ArrayList<Course> courses = new ArrayList<>();
    Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.course = course;
    }
    void addCourse(String coursename, int grade) {
        Course course = new Course(coursename, grade);
        courses.add(course);
    }
    void printattributes() {
        System.out.println("Student name: " + name);
        System.out.println("Student id" + id);
        for (Course course : courses) {
            System.out.println(course.coursename);
            System.out.println(course.grade);
        }
    }
}