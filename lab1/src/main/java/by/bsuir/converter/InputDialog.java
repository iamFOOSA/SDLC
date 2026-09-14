package by.bsuir.converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InputDialog extends JDialog {

    private final JTextField txtAmount = new JTextField(10);
    private final JTextField txtRate = new JTextField(10);

    public InputDialog(JFrame parent, CurrencyController controller) {
        super(parent, "Ввод чисел", true);
        setSize(360, 200);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(3, 2, 10, 10));
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        add(new JLabel("Сумма, BYN:"));
        add(txtAmount);

        add(new JLabel("Курс евро (BYN за 1 EUR):"));
        add(txtRate);

        JButton btnSubmit = new JButton("OK");
        add(new JLabel());
        add(btnSubmit);

        ActionListener submitAction = e -> controller.processInput(
                txtAmount.getText(), txtRate.getText()
        );

        btnSubmit.addActionListener(submitAction);
        txtAmount.addActionListener(submitAction);
        txtRate.addActionListener(submitAction);
    }

    public void setValues(double amount, double rate) {
        txtAmount.setText(amount == 0 ? "" : String.valueOf(amount));
        txtRate.setText(rate == 0 ? "" : String.valueOf(rate));
    }
}
