package part3;

import java.util.ArrayList;
import java.util.stream.Collectors;

enum Subjects {
    MATH,
    IT,
    GEOGRAPHY,
    HISTORY,
    ENGLISH
}

class Student {

    private String name;
    private Subjects favoriteSubject;
    private ArrayList<Integer> grades;

    public Student(String name, Subjects favoriteSubject, ArrayList<Integer> grades) {
        this.name = name;
        this.favoriteSubject = favoriteSubject;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subjects getFavoriteSubject() {
        return favoriteSubject;
    }

    public void setFavoriteSubject(Subjects favoriteSubject) {
        this.favoriteSubject = favoriteSubject;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Integer> grades) {
        this.grades = grades;
    }

    Double averageGrades() {
        /**
         * Calculate average grade
         */
        return grades
                .stream().mapToDouble(number -> number).sum()
                /grades.size();
    }
    void print(){
        System.out.println("Name " + getName() + " favorite subject " + getFavoriteSubject());
    }
}
