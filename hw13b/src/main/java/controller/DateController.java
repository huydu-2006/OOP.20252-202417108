package main.java.controller;

import main.java.model.DateModel;
import main.java.view.DateView;

import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class DateController {
    private static final int MAX_INPUT = 100_000;

    private final DateModel model;
    private final DateView view;

    public DateController(DateModel model, DateView view) {
        this.model = model;
        this.view = view;
        model.addController(this);
        refreshDisplay();

        view.getSubtractDaysBtn().addActionListener(
                (ActionEvent e) -> handle(
                        () -> model.subtractDays(parseInput())));
        view.getAddDaysBtn().addActionListener(
                (ActionEvent e) -> handle(
                        () -> model.addDays(parseInput())));
        view.getSubtractMonthsBtn().addActionListener(
                (ActionEvent e) -> handle(
                        () -> model.subtractMonths(parseInput())));
        view.getAddMonthsBtn().addActionListener(
                (ActionEvent e) -> handle(
                        () -> model.addMonths(parseInput())));
    }

    public void refreshDisplay() {
        LocalDate d = model.getDate();
        view.setDateDisplay(String.format("Ngày %02d tháng %02d năm %04d",
                d.getDayOfMonth(), d.getMonthValue(), d.getYear()));
    }

    private void handle(Runnable action) {
        try {
            action.run();
            view.clearError();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            view.showError(e.getMessage());
        }
    }

    private int parseInput() throws IllegalArgumentException {
        String raw = view.getInputText().trim();
        if (raw.isEmpty()) {
            throw new IllegalArgumentException("Error : Empty input");
        }
        int value;
        try {
            value = Integer.parseInt(raw);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error : The input must be a positive integer less than or equal to " + MAX_INPUT);
        }
        if (value < 0) {
            throw new IllegalArgumentException("Error : The input must be a positive integer less than or equal to " + MAX_INPUT);
        }
        if (value > MAX_INPUT) {
            throw new IllegalArgumentException("Error : The input must be a positive integer less than or equal to " + MAX_INPUT);
        }
        return value;
    }
}
