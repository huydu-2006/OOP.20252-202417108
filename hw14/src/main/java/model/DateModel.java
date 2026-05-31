package main.java.model;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.java.controller.DateController;

public class DateModel {
    private LocalDate date;
    private StringProperty dateStringProperty = new SimpleStringProperty();

    public DateModel() {
        this.date = LocalDate.now();
        dateStringProperty.setValue(date.toString());
    }

    public LocalDate getDate() {
        return date;
    }

    public void addDays(int days) {
        this.date = this.date.plusDays(days);
        refreshDateStringProperty();
    }

    public void subtractDays(int days) {
        this.date = this.date.minusDays(days);
        refreshDateStringProperty();
    }

    public void addMonths(int months) {
        this.date = this.date.plusMonths(months);
        refreshDateStringProperty();
    }

    public void subtractMonths(int months) {
        this.date = this.date.minusMonths(months);
        refreshDateStringProperty();
    }

    public void addYears(int years) {
        this.date = this.date.plusYears(years);
        refreshDateStringProperty();
    }

    public void subtractYears(int years) {
        this.date = this.date.minusYears(years);
        refreshDateStringProperty();
    }

    private void refreshDateStringProperty() {
        dateStringProperty.setValue(date.toString());
    }

    public StringProperty getDateStringProperty() {
        return dateStringProperty;
    }

    public void setDate(LocalDate date) {
        this.date = date;
        refreshDateStringProperty();
    }
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date.toString());
    }
}
