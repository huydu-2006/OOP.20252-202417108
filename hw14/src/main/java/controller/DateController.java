package main.java.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import main.java.model.*;

import java.util.*;

public class DateController {
    private DateModel dateModel = new DateModel();
    private DateFormat dateFormat = DateFormat.VIETNAM;
    private StringProperty dateStringProperty = new SimpleStringProperty(Formater.format(dateModel, dateFormat));
    private boolean buttonBefore = false, buttonAfter = false;
    private boolean buttonDays = false, buttonMonths = false, buttonYears = false;
    @FXML
    private ComboBox<String> cbbDateType = new ComboBox();

    @FXML
    private TextField dateTf;

    @FXML
    private TextField enterXTf;

    @FXML
    private Label lblError;

    @FXML
    private DatePicker datePicker;

    private void pressDirection(String direction) {
        if (direction.equals("Before")) {
            buttonBefore = true;
            buttonAfter = false;
        } else {
            buttonAfter = true;
            buttonBefore = false;
        }
    }

    private void pressUnit(String unit) {
        if (unit.equals("Days")) {
            buttonDays = true;
            buttonMonths = false;
            buttonYears = false;
        } else if (unit.equals("Months")) {
            buttonMonths = true;
            buttonYears = false;
            buttonDays = false;
        } else if (unit.equals("Years")) {
            buttonDays = false;
            buttonMonths = false;
            buttonYears = true;
        }
    }

    @FXML
    void buttonListener(ActionEvent event) {
        String command = event.getSource().toString();
        command = command.substring(command.indexOf("'") + 1, command.length() - 1);
        switch (command) {
            case "Before" -> {
                pressDirection(command);
            }
            case "After" -> {
                pressDirection(command);
            }
            case "Days" -> {
                pressUnit(command);
            }
            case "Months" -> {
                pressUnit(command);
            }
            case "Years" -> {
                pressUnit(command);
            }
            case "Apply" -> {
                int x;
                try {
                    x = Integer.parseInt(enterXTf.getText());
                } catch (NumberFormatException e) {
                    lblError.setText("Enter a positive integer less than or equal to 100000");
                    lblError.setVisible(true);
                    return;
                }
                if (x <= 0 || x > 100000) {
                    lblError.setText("Enter a positive integer less than 100000");
                    lblError.setVisible(true);
                    return;
                }
                lblError.setText("");
                lblError.setVisible(false);
                if (buttonDays) {
                    if (buttonBefore) {
                        dateModel.subtractDays(x);
                    } else if (buttonAfter) {
                        dateModel.addDays(x);
                    }
                }
                if (buttonMonths) {
                    if (buttonBefore) {
                        dateModel.subtractMonths(x);
                    } else if (buttonAfter) {
                        dateModel.addMonths(x);
                    }
                }
                if (buttonYears) {
                    if (buttonBefore) {
                        dateModel.subtractYears(x);
                    } else if (buttonAfter) {
                        dateModel.addYears(x);
                    }
                }
                dateStringProperty.setValue(Formater.format(dateModel, dateFormat));
            }

        }
    }

    @FXML
    void cbbDateTypeListener(ActionEvent event) {
        String command = cbbDateType.getSelectionModel().getSelectedItem().toString();

        switch (command) {
            case "Vietnam format" -> dateFormat = DateFormat.VIETNAM;
            case "America format" -> dateFormat = DateFormat.AMERICA;
            case "EU format" -> dateFormat = DateFormat.EU;
        }
        dateStringProperty.setValue(Formater.format(dateModel, dateFormat));
    }

    @FXML
    void datePickerListener(ActionEvent event) {
        dateModel.setDate(datePicker.getValue());
        dateStringProperty.setValue(Formater.format(dateModel, dateFormat));
    }

    @FXML
    public void initialize() {
        List<String> dateTypes = List.of("Vietnam format", "America format", "EU format");
        cbbDateType.getItems().addAll(dateTypes);
        cbbDateType.getSelectionModel().select(0);
        dateTf.textProperty().bindBidirectional(dateStringProperty);
    }
}