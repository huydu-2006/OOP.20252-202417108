package main.java.model;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Formater {
    public static String format(DateModel dateModel, DateFormat format) {
        if (dateModel == null) return null;
        LocalDate date = dateModel.getDate();
        String res = "";
        switch(format) {
            case DateFormat.VIETNAM ->  {
                res = String.format("%02d/%02d/%04d", date.getDayOfMonth(), date.getMonthValue(), date.getYear());
            }
            case DateFormat.AMERICA ->   {
                res = String.format("%02d/%02d/%04d", date.getMonthValue(), date.getDayOfMonth(), date.getYear());
            }
            case DateFormat.EU -> {
                res = String.format("%02d.%02d.%04d", date.getDayOfMonth(), date.getMonthValue(), date.getYear());
            }
        }

        return res;
    }
}
