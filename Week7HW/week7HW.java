package Week7HW;

import java.util.ArrayList;

public class week7HW {
    public static void main(String[] args){
        School school = new School();

        Teacher t1 = new Teacher("T01", "王老師");

        Course c1 = new Course("CS101", "Java", 2, t1);
        Course c2 = new Course("CS102", "Python", 3, t1);

        Student s1 = new Student("S01", "小明");
        Student s2 = new Student("S02", "小華");
        Student s3 = new Student("S03", "小美");

        school.addStudent(s1);
        school.addStudent(s2);
        school.addStudent(s3);

        school.addCourse(c1);
        school.addCourse(c2);

        System.out.println(school.enroll(s1, c1));
        System.out.println(school.enroll(s2, c1));
        System.out.println(school.enroll(s3, c1));

        System.out.println(school.enroll(s1, c2));
        System.out.println(school.enroll(s1, c2)); 

        System.out.println("Java 選課名單：");

        for (Enrollment e : c1.getEnrollments()) {
            System.out.println(e.getStudent().getName());
        }
    }
}

class Student{
    private final String studentID;
    private final String name;
    public Student(String studentID,String name){
        this.studentID = studentID;
        this.name = name;
    }
    public String getID(){
        return studentID;
    }
    public String getName(){
        return name;
    }
}

class Teacher{
    private final String teacherID;
    private final String name;
    public Teacher(String teacherID,String name){
        this.teacherID = teacherID;
        this.name = name;
    }
    public String getID(){
        return teacherID;
    }
    public String getName(){
        return name;
    }
}

class Enrollment{
    private final Student student;
    private final Course course;
    public Enrollment(Student student,Course course){
        this.student = student;
        this.course = course;
    }
    public Student getStudent(){
        return student;
    }
    public Course getCourse(){
        return course;
    }
}

class Course{
    private final String CourseID;
    private final String name;
    private final int capacity;
    private final Teacher teacher;
    private final ArrayList<Enrollment> enrollments = new ArrayList<>();
    public Course(String CourseID,String name,int capacity,Teacher teacher){
        if(capacity <= 0){
            throw new IllegalArgumentException("名額上限必須大於0");
        }
        this.CourseID = CourseID;
        this.name = name;
        this.capacity = capacity;
        this.teacher = teacher;
    }
    public String getID(){
        return CourseID;
    }
    public String getName(){
        return name;
    }
    public Teacher getTeacher(){
        return teacher;
    }
    public boolean isFull(){
        return enrollments.size() >= capacity;
    }
    public boolean hasEnrolled(Student student){
        for(Enrollment e : enrollments){
            if(e.getStudent().getID().equals(student.getID())){
                return true;
            }
        }
        return false;
    }
    public boolean enroll(Student student){
        if(student == null){
            return false;
        }
        if(isFull()){
            System.out.print("人數已滿 -> ");
            return false;
        }
        if(hasEnrolled(student)){
            System.out.print("重複選課 -> ");
            return false;
        }
        enrollments.add(new Enrollment(student, this));
        return true;
    }
    public ArrayList<Enrollment> getEnrollments(){
        return new ArrayList<>(enrollments);
    }
}

class School{
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();
    public School(){};
    public void addStudent(Student student){
        students.add(student);
    }
    public void addCourse(Course course){
        courses.add(course);
    }
    public boolean enroll(Student student,Course course){
        if(student == null || course == null){
            return false;
        }
        if(!students.contains(student) || !courses.contains(course)){
            return false;
        }
        return course.enroll(student);
    }
}