package ru.academits.vasilev.temperature;

import ru.academits.vasilev.temperature.scales.Scale;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Objects;

public class View {
    private Model model;

    private final static int WIDTH = 450;
    private final static int HEIGHT = 250;
    private final static String NAME = "Temperatures Conversion";

    private JButton convertButton;
    private JTextField inputTemperatureField;
    private JLabel outputTemperatureField;
    private JComboBox<Scale> fromScales;
    private JComboBox<Scale> toScales;

    public View(Model model) {
        this.model = model;
        SwingUtilities.invokeLater(() -> {
            initMainFrame();
            initListeners();
        });
    }

    private void initMainFrame() {
        JFrame mainFrame = new JFrame(NAME);
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);

        mainFrame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.ipadx = 10;
        c.insets = new Insets(7, 7, 7, 7);

        JLabel label1 = new JLabel("Select input scale:");
        c.gridx = 0;
        c.gridy = 0;

        mainFrame.add(label1, c);

        fromScales = new JComboBox<>(model.getScales());
        c.gridx = 0;
        c.gridy = 1;
        mainFrame.add(fromScales, c);

        JLabel label2 = new JLabel("Select output scale:");
        c.gridx = 2;
        c.gridy = 0;
        mainFrame.add(label2, c);

        toScales = new JComboBox<>(model.getScales());
        c.gridx = 2;
        c.gridy = 1;
        mainFrame.add(toScales, c);

        JLabel label3 = new JLabel("Input temperature:");
        c.gridx = 0;
        c.gridy = 4;
        mainFrame.add(label3, c);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

        inputTemperatureField = new JTextField(5);
        c.gridx = 0;
        c.gridy = 5;
        inputTemperatureField.setToolTipText("Input field");
        inputTemperatureField.setBorder(border);
        mainFrame.add(inputTemperatureField, c);

        outputTemperatureField = new JLabel();
        c.gridx = 2;
        c.gridy = 5;
        c.ipadx = 2;
        outputTemperatureField.setToolTipText("Output field");
        outputTemperatureField.setBackground(Color.white);
        outputTemperatureField.setOpaque(true);
        outputTemperatureField.setBorder(border);
        mainFrame.add(outputTemperatureField, c);

        convertButton = new JButton("Convert");
        c.gridx = 1;
        c.gridy = 4;
        mainFrame.add(convertButton, c);
    }

    private void initListeners() {
        convertButton.addActionListener(e -> {
            double temperature;

            try {
                temperature = Double.parseDouble(inputTemperatureField.getText());
            } catch (NumberFormatException exception) {
                outputTemperatureField.setText("Incorrect input!");
                return;
            }
            Object from = fromScales.getSelectedItem();
            Object to = toScales.getSelectedItem();

            if (from.equals(to)) {
                outputTemperatureField.setText(Double.toString(temperature));
            } else {
                outputTemperatureField.setText(Double.toString(model.convert((Scale) fromScales.getSelectedItem(), (Scale) toScales.getSelectedItem(), temperature)));
            }
        });
    }
}