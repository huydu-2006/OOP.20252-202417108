package main.java.model;

import java.time.LocalDate;
import main.java.controller.DateController;

public class DateModel {
    private LocalDate date;
    private DateController controller;

    public DateModel() {
        this.date = LocalDate.now();
    }

    public LocalDate getDate() {
        return date;
    }

    public void addDays(int days) {
        this.date = this.date.plusDays(days);
        controller.refreshDisplay();
    }

    public void subtractDays(int days) {
        this.date = this.date.minusDays(days);
        controller.refreshDisplay();
    }

    public void addMonths(int months) {
        this.date = this.date.plusMonths(months);
        controller.refreshDisplay();
    }

    public void subtractMonths(int months) {
        this.date = this.date.minusMonths(months);
        controller.refreshDisplay();
    }

    public void addController(DateController controller) {
        this.controller = controller;
    }
}
