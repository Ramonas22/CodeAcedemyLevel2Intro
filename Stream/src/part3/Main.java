package part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Tom", Subjects.ENGLISH, new ArrayList<>(Arrays.asList(6, 7, 8, 8, 5)));
        Student student2 = new Student("Julia", Subjects.GEOGRAPHY, new ArrayList<>(Arrays.asList(8, 8, 8, 8, 9)));
        Student student3 = new Student("Sofia", Subjects.MATH, new ArrayList<>(Arrays.asList(10, 7, 6, 9, 7)));
        Student student4 = new Student("Will", Subjects.IT, new ArrayList<>(Arrays.asList(7, 7, 8, 8, 10)));
        Student student5 = new Student("Lukas", Subjects.HISTORY, new ArrayList<>(Arrays.asList(6, 7, 6, 10, 8)));
        Student student6 = new Student("Lukas", Subjects.IT, new ArrayList<>(Arrays.asList(10, 10, 10, 10, 9)));


        List<Student> studentList = new ArrayList<>(Arrays.asList(student1, student2, student3, student4, student5,student6));

        System.out.println("Is there Tom in the class " + isThereTom(studentList));
        System.out.println("How many students in the class like IT " + howManyStudentsLikeIT(studentList));
        System.out.println("Unique names in class " + uniqueNamesList(studentList));
        System.out.println("\n\nSorted students names in ascending order ");
        sortedListByNamesAscendingOrder(studentList)
                .stream()
                .forEach(student -> student.print());
        System.out.println("\n\nStudents with average grades higher than 7 ");
        studentsWithAverageGradeHigherThan7(studentList)
                .stream()
                .forEach(student -> {
                    student.print();
                    System.out.println("average grade: " + student.averageGrades()+"\n");

                });

    }

    static boolean isThereTom(List<Student> students) {
        /**
         * Is there a student with name Tom
         */
        boolean flag =
                students
                        .stream()
                        .anyMatch(object -> object.getName().equals("Tom"));
        return flag;
    }

    static long howManyStudentsLikeIT(List<Student> students) {
        /***
         * How many students favorite subject is IT
         */
        return students
                .stream()
                .filter(object -> object.getFavoriteSubject().equals(Subjects.IT))
                .count();
    }

    static List<String> uniqueNamesList(List<Student> students) {
        /**
         * Return list of students with unique names
         */
        return students
                .stream()
                .map(Student::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    static List<Student> sortedListByNamesAscendingOrder(List<Student> students) {
        /**
         * Return sorted list of students by names in ascending order
         */
        return students
                .stream()
                .sorted(Comparator.comparing(Student::getName, Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    static List<Student> studentsWithAverageGradeHigherThan7(List<Student> students) {
        /**
         * Return list of students which average grades is higher than 7
         */
        return students
                .stream()
                .filter(object -> object.averageGrades() > 7)
                .collect(Collectors.toList());
    }

}
