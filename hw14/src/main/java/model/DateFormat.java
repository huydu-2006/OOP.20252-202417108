package main.java.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public enum DateFormat {
    VIETNAM("Vietnam format  (dd/MM/yyyy)", "dd/MM/yyyy"),
    AMERICA("America format  (MM/dd/yyyy)", "MM/dd/yyyy"),
    EU     ("EU format  (dd.MM.yyyy)",      "dd.MM.yyyy");

    private final String displayName;
    private final DateTimeFormatter formatter;

    DateFormat(String displayName, String pattern) {
        this.displayName = displayName;
        this.formatter = DateTimeFormatter.ofPattern(pattern);
    }

    public String format(LocalDate date) {
        return date == null ? "" : formatter.format(date);
    }

    @Override
    public String toString() {
        return displayName;
    }

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        DateFormat dateFormat = DateFormat.EU;
        System.out.println(dateFormat);
    }
}