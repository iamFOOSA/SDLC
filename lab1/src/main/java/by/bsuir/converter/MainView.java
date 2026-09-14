package by.bsuir.converter;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame implements CurrencyModel.ModelListener {

    private final CurrencyController controller;
    private final CurrencyModel model;

    private final JLabel lblAmount = new JLabel("Сумма: -");
    private final JLabel lblRate = new JLabel("Курс евро: -");
    private final JLabel lblResult = new JLabel("Результат: -");

    public MainView(CurrencyController controller, CurrencyModel model) {
        this.controller = controller;
        this.model = model;

        this.model.addListener(this);

        initView();
    }

    private void initView() {
        setTitle("Конвертер BYN -> EUR");
        setSize(420, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 15));

        JPanel panelInfo = new JPanel(new GridLayout(3, 1, 8, 8));
        panelInfo.setBorder(BorderFactory.createEmptyBorder(25, 30, 15, 30));

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 15);
        lblAmount.setFont(labelFont);
        lblRate.setFont(labelFont);
        lblResult.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblResult.setForeground(new Color(90, 0, 255, 255));

        panelInfo.add(lblAmount);
        panelInfo.add(lblRate);
        panelInfo.add(lblResult);
        add(panelInfo, BorderLayout.CENTER);

        JButton btnOpenInput = new JButton("Ввод чисел");
        btnOpenInput.setPreferredSize(new Dimension(150, 40));
        btnOpenInput.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JPanel panelButton = new JPanel();
        panelButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        panelButton.add(btnOpenInput);
        add(panelButton, BorderLayout.SOUTH);

        btnOpenInput.addActionListener(e -> controller.openInputDialog(this));
    }

    @Override
    public void onModelChanged() {
        lblAmount.setText(String.format("Сумма: %.2f BYN", model.getAmountByn()));
        lblRate.setText(String.format("Курс евро: %.4f BYN/EUR", model.getRateEurToByn()));
        lblResult.setText(String.format("Результат: %.2f EUR", model.getResultEur()));
    }
}
