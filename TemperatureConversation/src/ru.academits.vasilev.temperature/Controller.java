package ru.academits.vasilev.temperature;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller {
    private View view;
    private Model model;
    private StringBuilder stringBuilder;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        initController();
    }

    private void initController() {
        stringBuilder = new StringBuilder();
        initConvertButton();
        initTextField();
    }

    private void initConvertButton() {
        view.getConvertButton().addActionListener(e -> {
            if (stringBuilder.length() == 0) {
                return;
            }
            sendToModel();
            modifyView(model.convert());
        });
    }

    private void initTextField() {
        view.getInputTemperatureField().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //если е не равно систем лайн сепаратор, то чар с = и так далее..

                char c = e.getKeyChar();

                if (!Character.isDigit(c) && !Character.toString(c).equals("-")) {
                    modifyView("Please input digits!");
                }

                stringBuilder.append(c);

                if (stringBuilder.lastIndexOf("-") >= 1) {
                    modifyView("Please input digits!");
                }
            }
        });
    }

    private void sendToModel() {
        double temperature = Double.parseDouble(stringBuilder.toString());

        model.setInputTemperature(temperature);
        model.setFromScale(view.getRadioGroupFrom().getSelection().getActionCommand());
        model.setToScale(view.getRadioGroupTo().getSelection().getActionCommand());
    }

    private void modifyView(String text) {
        stringBuilder.replace(0, stringBuilder.length(), "");
        view.getInputTemperatureField().setText("");
        view.getOutputTemperatureField().setText(text);
    }
}
