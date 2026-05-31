package main.java.controller;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import main.java.model.DateFormat;
import main.java.model.DateModel;
import main.java.model.TimeUnit;

public class DateController {

    @FXML private ComboBox<DateFormat> cbbDateType;
    @FXML private TextField dateTf;
    @FXML private TextField enterXTf;
    @FXML private Label lblError;
    @FXML private Label lblResult;
    @FXML private DatePicker datePicker;
    @FXML private Button btnApply;
    @FXML private ToggleGroup Direction;
    @FXML private ToggleGroup Unit;

    private final DateModel dateModel = new DateModel();

    @FXML
    public void initialize() {
        cbbDateType.setItems(FXCollections.observableArrayList(DateFormat.values()));
        cbbDateType.valueProperty().bindBidirectional(dateModel.dateFormatProperty());

        datePicker.valueProperty().bindBidirectional(dateModel.selectedDateProperty());

        dateTf.textProperty().bind(dateModel.selectedDateTextBinding());
        lblResult.textProperty().bind(dateModel.resultDateTextBinding());

        StringBinding errorBinding = Bindings.createStringBinding(
                this::validate,
                enterXTf.textProperty(),
                datePicker.valueProperty(),
                Direction.selectedToggleProperty(),
                Unit.selectedToggleProperty());
        lblError.textProperty().bind(errorBinding);
        btnApply.disableProperty().bind(errorBinding.isNotEmpty());
    }

    private String validate() {
        if (datePicker.getValue() == null) {
            return "Please pick a base date.";
        }
        String raw = enterXTf.getText();
        if (raw == null || raw.isBlank()) {
            return "Please enter a value for x.";
        }
        int v;
        try {
            v = Integer.parseInt(raw.trim());
        } catch (NumberFormatException e) {
            return "x must be a positive integer between 1 and 100000.";
        }
        if (v <= 0 || v > 100000) {
            return "x must be a positive integer between 1 and 100000.";
        }
        if (Direction.getSelectedToggle() == null) {
            return "Please choose a direction (Before / After).";
        }
        if (Unit.getSelectedToggle() == null) {
            return "Please choose a time unit (Days / Months / Years).";
        }
        return "";
    }

    @FXML
    private void applyOperation() {
        int x = Integer.parseInt(enterXTf.getText().trim());
        Toggle dirToggle  = Direction.getSelectedToggle();
        Toggle unitToggle = Unit.getSelectedToggle();

        String dirText  = ((RadioButton) dirToggle).getText();
        String unitText = ((RadioButton) unitToggle).getText();

        main.java.model.Direction direction = "Before".equals(dirText)
                ? main.java.model.Direction.BEFORE
                : main.java.model.Direction.AFTER;
        TimeUnit unit = switch (unitText) {
            case "Days"   -> TimeUnit.DAYS;
            case "Months" -> TimeUnit.MONTHS;
            default       -> TimeUnit.YEARS;
        };
        dateModel.applyOperation(x, direction, unit);
    }
}