package main.java;

import main.java.controller.DateController;
import main.java.model.DateModel;
import main.java.view.DateView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ignored) {}

            DateModel model = new DateModel();
            DateView view = new DateView();
            DateController controller = new DateController(model, view);
            view.setVisible(true);
        });
    }
}
