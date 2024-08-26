package generic.course;

public class Student <S,T, G> {
    private S studentId;
    private T studentName;
    private G grades;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName=" + studentName +
                ", grades=" + grades +
                '}';
    }

    public S getStudentId() {
        return studentId;
    }

    public void setStudentId(S studentId) {
        this.studentId = studentId;
    }

    public T  getStudentName() {
        return studentName;
    }

    public void setStudentName(T  studentName) {
        this.studentName = studentName;
    }

    public G getGrades() {
        return grades;
    }

    public void setGrades(G grades) {
        this.grades = grades;
    }
}
