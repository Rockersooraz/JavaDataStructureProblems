package generic.course;

/*
Objective:
        Design and implement a generic class Course that can store and manage information about a course,
        including the students enrolled and their corresponding grades. The Course class should be versatile,
        allowing it to work with any type of student identifier and any numeric type for grades, such as Integer, Double, etc.

        Requirements:
        Generic Design:

        The Course class should use generics to handle different types of student identifiers (e.g., String for names,
        Integer for student IDs) and numeric grades (e.g., Integer, Double).
        The class should ensure type safety by working with these types and performing necessary operations without relying on
        specific implementations.

        Core Functionalities:

        Enrolling Students: The class should allow enrolling students in the course. Each student should be uniquely
        identified by an identifier of type S.
        Assigning Grades: The class should provide functionality to assign a grade of type G to a specific student.
        Retrieving Grades: The class should allow retrieval of a student's grade based on their identifier.
        Listing All Grades: The class should offer a way to retrieve a collection of all students and their corresponding grades.
*/

import java.util.*;

public class Course<S, T, G extends Number> {
    private List<Student<S,T, G>> students = new ArrayList<>();

    private Map<T, G> studentGrade = new HashMap<>();

    public Student<S,T, G> enrollStudentToCourse(Student<S,T, G> student) {
        this.students.add(student);
        return student;
    }

    public Student<S,T, G> assignGradeToStudent(G grade, S identifier) {
        Student<S,T, G> sgStudent = this.students.stream()
                .filter(student -> student.getStudentId().equals(identifier)).
                findAny().
                orElse(null);
        assert sgStudent != null;
            sgStudent.setGrades(grade);
        return sgStudent;
    }

    //    public static void main()
    public G retrieveGradeOfStudent(S identifier) {
        Student<S,T, G> sgStudent = this.students.stream()
                .filter(student -> student.getStudentId().equals(identifier)).
                findAny().
                orElse(null);
        return sgStudent.getGrades();
    }

    public Student<S,T, G> findStudent(S identifier) {
        return this.students.stream()
                .filter(student -> student.getStudentId().equals(identifier)).
                findAny().
                orElse(null);
    }


    public Map<T, G> listStudentAndGrade() {
        for (Student<S,T, G> student : students) {
            studentGrade.put(student.getStudentName(), student.getGrades());
        }
        return studentGrade;
    }

    public static void main(String[] args) {
        Student<Integer,String, Double> stringFloatStudent = new Student<>();
        stringFloatStudent.setStudentId(1);
        stringFloatStudent.setStudentName("Raman");

        Student<Integer,String, Double> stringFloatStudent1 = new Student<>();
        stringFloatStudent1.setStudentId(2);
        stringFloatStudent1.setStudentName("Charan");

        Course<Integer, String, Double> stringFloatCourse = new Course<>();
        System.out.println("enrollStudentToCourse = " + stringFloatCourse.enrollStudentToCourse(stringFloatStudent));
        System.out.println("AssignGradeToStudent"+ stringFloatCourse.assignGradeToStudent(90.00, 1));
        System.out.println("RetrieveGrades" + stringFloatCourse.retrieveGradeOfStudent(1));
        System.out.println("Retrieve student and grade" +  stringFloatCourse.listStudentAndGrade());


        System.out.println("enrollStudentToCourse1 = " + stringFloatCourse.enrollStudentToCourse(stringFloatStudent1));
        System.out.println("AssignGradeToStudent1"+ stringFloatCourse.assignGradeToStudent(85.00, 2));
        System.out.println("RetrieveGrades1" + stringFloatCourse.retrieveGradeOfStudent(2));
        System.out.println("Retrieve student and grade1" +  stringFloatCourse.listStudentAndGrade());
    }
}
