package main.java.model;

import main.java.controller.DateController;
import java.time.LocalDate;

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
        LocalDate old = this.date;
        this.date = this.date.plusDays(days);
        controller.refreshDisplay();
    }

    public void subtractDays(int days) {
        LocalDate old = this.date;
        this.date = this.date.minusDays(days);
        controller.refreshDisplay();
    }

    public void addMonths(int months) {
        LocalDate old = this.date;
        this.date = this.date.plusMonths(months);
        controller.refreshDisplay();
    }

    public void subtractMonths(int months) {
        LocalDate old = this.date;
        this.date = this.date.minusMonths(months);
        controller.refreshDisplay();
    }

    public void addController(DateController controller) {
        this.controller = controller;
    }
}
