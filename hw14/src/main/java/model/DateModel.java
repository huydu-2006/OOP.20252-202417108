package main.java.model;

import java.time.LocalDate;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class DateModel {
    private final ObjectProperty<LocalDate> selectedDate =
            new SimpleObjectProperty<>(LocalDate.now());

    private final ObjectProperty<LocalDate> resultDate =
            new SimpleObjectProperty<>(null);

    private final ObjectProperty<DateFormat> dateFormat =
            new SimpleObjectProperty<>(DateFormat.VIETNAM);

    private final StringBinding selectedDateText = Bindings.createStringBinding(
            () -> dateFormat.get().format(selectedDate.get()),
            selectedDate, dateFormat);

    private final StringBinding resultDateText = Bindings.createStringBinding(
            () -> resultDate.get() == null ? "—" : dateFormat.get().format(resultDate.get()),
            resultDate, dateFormat);

    public ObjectProperty<LocalDate> selectedDateProperty() { return selectedDate; }
    public ObjectProperty<LocalDate> resultDateProperty()   { return resultDate; }
    public ObjectProperty<DateFormat> dateFormatProperty()  { return dateFormat; }

    public StringBinding selectedDateTextBinding() { return selectedDateText; }
    public StringBinding resultDateTextBinding()   { return resultDateText; }

    public void applyOperation(int amount, Direction direction, TimeUnit unit) {
        LocalDate base = selectedDate.get();
        if (base == null) {
            return;
        }
        int signed = direction == Direction.BEFORE ? -amount : amount;
        LocalDate next = switch (unit) {
            case DAYS   -> base.plusDays(signed);
            case MONTHS -> base.plusMonths(signed);
            case YEARS  -> base.plusYears(signed);
        };
        resultDate.set(next);
    }
}