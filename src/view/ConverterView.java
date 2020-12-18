package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ConverterView extends JFrame {
    private JComboBox<String> boxCurrencyNameFrom;
    private JComboBox<String> boxCurrencyNameTo;
    private JTextField amountField = new JTextField(23);
    private JTextField amountAfterConversionLabel = new JTextField();
    private JButton convertButton = new JButton();

    public ConverterView(String[] listCurrencyNames) {
        Container pane = getContentPane();
        GroupLayout groupLayout = new GroupLayout(pane);
        pane.setLayout(groupLayout);


        JLabel amountLabel = new JLabel();
        JLabel convertFromLabel = new JLabel();
        JLabel convertToLabel = new JLabel();
        JLabel afterConversionLabel = new JLabel();

        amountLabel.setText("Kwota:");
        convertFromLabel.setText("Przelicz z:");
        convertToLabel.setText("Przelicz do:");
        afterConversionLabel.setText("Po przeliczeniu:");

        boxCurrencyNameFrom = new JComboBox<String>(listCurrencyNames);
        boxCurrencyNameTo = new JComboBox<String>(listCurrencyNames);
        amountAfterConversionLabel.setEditable(false);
        convertButton.setText("Przelicz");

        groupLayout.setAutoCreateContainerGaps(true);
        groupLayout.setAutoCreateGaps(true);

        GroupLayout.SequentialGroup horizontalGroup = groupLayout.createSequentialGroup();

        horizontalGroup.addGroup(groupLayout.createParallelGroup()
            .addComponent(amountLabel)
            .addComponent(convertFromLabel)
            .addComponent(convertToLabel)
            .addComponent(afterConversionLabel));
        horizontalGroup.addGroup(groupLayout.createParallelGroup()
            .addComponent(amountField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(boxCurrencyNameFrom, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(boxCurrencyNameTo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(amountAfterConversionLabel)
            .addComponent(convertButton));
        groupLayout.setHorizontalGroup(horizontalGroup);

        GroupLayout.SequentialGroup verticalGroup = groupLayout.createSequentialGroup();

        verticalGroup.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(amountLabel)
            .addComponent(amountField));
        verticalGroup.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(convertFromLabel)
            .addComponent(boxCurrencyNameFrom, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));
        verticalGroup.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(convertToLabel)
            .addComponent(boxCurrencyNameTo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));
        verticalGroup.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(afterConversionLabel)
            .addComponent(amountAfterConversionLabel));
        verticalGroup.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(convertButton));

        groupLayout.setVerticalGroup(verticalGroup);

        pack();
    }

    public double getAmount() {
        try {
            return Double.parseDouble(amountField.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String getCurrencyNameFrom() {
        return (String) boxCurrencyNameFrom.getSelectedItem();
    }

    public String getCurrencyNameTo() {
        return (String) boxCurrencyNameTo.getSelectedItem();
    }

    public void setAmountAfterConversion(String amountAfterConversion) {
        amountAfterConversionLabel.setText(amountAfterConversion);
    }

    public void addConvertButtonListener(ActionListener actionListener) {
        convertButton.addActionListener(actionListener);
    }
}
