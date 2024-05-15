package Hash;

public class Student {
    public int studentId;
    public String studentName;

    public Student(int i, String s) {
    }

    @Override
        public String toString() {
            return "Hash.Student{" +
                    "studentId=" + studentId +
                    ", studentName='" + studentName + '\'' +
                    '}';
        }
}
