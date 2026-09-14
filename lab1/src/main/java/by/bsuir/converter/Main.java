package by.bsuir.converter;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CurrencyModel model = new CurrencyModel();
            CurrencyController controller = new CurrencyController(model);
            MainView view = new MainView(controller, model);
            view.setVisible(true);
        });
    }
}
