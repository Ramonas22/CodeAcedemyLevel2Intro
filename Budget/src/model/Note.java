package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Note {
    private int id;
    private double sum;
    private LocalDate date = LocalDate.from(LocalDateTime.now());
    private Const.MoneyDirection direction;
    private String additionalInfo;

    public Note( double sum, String date, Const.MoneyDirection direction, String additionalInfo) {
        this.id = Const.id;
        Const.id++;
        this.sum = sum;
        this.direction = direction;
        this.additionalInfo = additionalInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public LocalDate getDate() {
        return date;
    }

    public Const.MoneyDirection getDirection() {
        return direction;
    }

    public void setDirection(Const.MoneyDirection direction) {
        this.direction = direction;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o){
        return ((Integer) o) == id;
    }
}
