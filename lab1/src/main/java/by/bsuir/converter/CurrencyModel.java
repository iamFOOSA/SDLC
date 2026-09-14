package by.bsuir.converter;

import java.util.ArrayList;
import java.util.List;

public class CurrencyModel {

    private double amountByn;

    private double rateEurToByn;

    private double resultEur;

    private boolean dataEntered = false;

    private final List<ModelListener> listeners = new ArrayList<>();

    public interface ModelListener {
        void onModelChanged();
    }

    public void addListener(ModelListener listener) {
        listeners.add(listener);
    }

    private void notifyListeners() {
        for (ModelListener listener : listeners) {
            listener.onModelChanged();
        }
    }

    public void setData(double amount, double rate) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма в BYN должна быть положительным числом!");
        }
        if (rate <= 0) {
            throw new IllegalArgumentException("Курс евро должен быть положительным числом!");
        }
        if (amount > 1_000_000_000) {
            throw new IllegalArgumentException("Введена слишком большая сумма!");
        }

        this.amountByn = amount;
        this.rateEurToByn = rate;
        this.resultEur = amount / rate;
        this.dataEntered = true;

        notifyListeners();
    }

    public double getAmountByn() {
        return amountByn;
    }

    public double getRateEurToByn() {
        return rateEurToByn;
    }

    public double getResultEur() {
        return resultEur;
    }

    public boolean isDataEntered() {
        return dataEntered;
    }
}
