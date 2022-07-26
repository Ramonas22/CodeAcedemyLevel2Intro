package students;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\sanom\\Desktop\\Coding Academy\\Level2\\Level2Intro\\ReadWrite\\src\\students\\studentData.txt";

        List<Student> studentList = readStudents(path);
        writeFiles(collectStudentsThatAreNotFirstCourse(studentList),"Results1","Collect students that are not first course");
        writeFiles(collectStudentGirls(studentList),"Results2","Collect girl students");
        writeFiles(sortStudents(studentList),"Results3","Sorted list of students by name");

    }

    /**
     * Reading using Scanner
     */
    static List<Student> readStudents(String path) throws FileNotFoundException {
        List<Student> students = new ArrayList<>();
        File file = new File(path);
        Scanner scanner = new Scanner(file);


        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] fields = line.split(",");
            students.add(new Student(fields[0],fields[1],Integer.valueOf(fields[2]),fields[3]));
        }
        return students;
    }

    /**
     * 1 Collect students that are not first course
     */
    static List<Student> collectStudentsThatAreNotFirstCourse(List<Student> list){
        return list
                .stream()
                .filter(student -> student.getCourse() != 1)
                .collect(Collectors.toList());
    }
    /**
     *2 Collect student girls
     */
    static List<Student> collectStudentGirls(List<Student> students){
        return students
                .stream()
                .filter(student -> student.getName().charAt(student.getName().length()-1) == 'a' || student.getName().charAt(student.getName().length()-1) == 'e')
                .collect(Collectors.toList());
    }
    /**
     *3 Sort students alphabetically
     */
    static List<Student> sortStudents(List<Student> students){
        return students
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }
    /**
     *4 Write Students to file
     */
    static void writeFiles(List<Student> studentList, String filename, String message) throws IOException {
        File file = new File("C:\\Users\\sanom\\Desktop\\Coding Academy\\Level2\\Level2Intro\\ReadWrite\\src\\students\\"+filename+"txt");
        FileWriter fileWriter = new FileWriter(file, false);
        fileWriter.write(message+"\n");
        studentList
                .stream()
                .forEach(student -> {
                    try {
                         fileWriter.write(student.getName()+","+student.getID()+","+student.getCourse()+","+student.getPhoneNumber()+"\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
        fileWriter.close();
    }
}
