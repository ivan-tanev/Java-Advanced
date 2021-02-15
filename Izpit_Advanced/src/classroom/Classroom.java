package classroom;

import java.util.ArrayList;
import java.util.List;

public class Classroom {

    private List<Student> students;
    private int capacity;
    private List<Student> data;

    public Classroom(int capacity){
        this.capacity = capacity;
        this.students = new ArrayList<>();
        this.data = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getStudentCount(){
        return this.students.size();
    }

    public String registerStudent(Student student){
        String message;
        if (this.capacity > data.size()){
            if (data.contains(student)){
                message = "Student is already in the classroom";
                return message;
            } else {
                data.add(student);
                message = String.format("Added student %s %s",
                        student.getFirstName(), student.getLastName());
                return message;
            }
        }
        return message = "No seats in the classroom";
    }

    public String dismissStudent(Student student){
        String message;
        if (data.contains(student)){
            data.remove(student);
            message = String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
            return message;
        }
        return message = "Student not found";
    }

    public String getSubjectInfo(String subject){

        Student[] studentsByTheSubject = data.stream()
                .filter(student -> student.getBestSubject().equals(subject))
                .toArray(Student[]::new);

        StringBuilder info = new StringBuilder();

        if (studentsByTheSubject.length == 0){
            info.append("No students enrolled for the subject");
        } else {
            info.append("Subject: ").append(subject);
            info.append(System.lineSeparator());
            info.append("Students:");
            info.append(System.lineSeparator());
            for (Student student : studentsByTheSubject) {
                info.append(student.getFirstName()).append(" ").append(student.getLastName());
                info.append(System.lineSeparator());
            }
        }

        return info.toString().trim();
    }

    public String getStudent(String firstName, String lastName){
        StringBuilder info = new StringBuilder();

        for (Student student : data) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                //info.append(student.getFirstName()).append(" ").append(student.getLastName());
                info.append(String.format("Student: First Name= %s, Last Name= %s, Subject= %s",
                        student.getFirstName(), student.getLastName(), student.getBestSubject()));
                info.append(System.lineSeparator());
            }
        }
        return info.toString().trim();
    }

    public String getStatistics(){
        StringBuilder info = new StringBuilder();

        info.append(String.format("Classroom size: %d", students.size()));
        info.append(System.lineSeparator());
        for (Student student : students) {
            info.append(String.format("Student: First Name= %s, Last Name= %s, Subject= %s",
                    student.getFirstName(), student.getLastName(), student.getBestSubject()));
            info.append(System.lineSeparator());
        }
        return info.toString().trim();
    }

}
