package by.bsuir.converter;

import javax.swing.*;

public class CurrencyController {

    private final CurrencyModel model;
    private InputDialog inputDialog;

    public CurrencyController(CurrencyModel model) {
        this.model = model;
    }

    public void openInputDialog(JFrame parent) {
        if (inputDialog == null || !inputDialog.isDisplayable()) {
            inputDialog = new InputDialog(parent, this);
        }

        if (model.isDataEntered()) {
            inputDialog.setValues(model.getAmountByn(), model.getRateEurToByn());
        }

        inputDialog.setVisible(true);
    }

    public void processInput(String amountStr, String rateStr) {
        try {
            double amount = Double.parseDouble(amountStr.trim().replace(',', '.'));
            double rate = Double.parseDouble(rateStr.trim().replace(',', '.'));

            model.setData(amount, rate);

            if (inputDialog != null) {
                inputDialog.dispose();
            }
        } catch (NumberFormatException e) {
            showError("Ошибка: сумма и курс должны быть числами!");
        } catch (IllegalArgumentException e) {
            showError("Ошибка: " + e.getMessage());
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(inputDialog, message, "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
    }
}
