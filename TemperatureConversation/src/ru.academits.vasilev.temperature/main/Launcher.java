package ru.academits.vasilev.temperature.main;

import ru.academits.vasilev.temperature.Controller;
import ru.academits.vasilev.temperature.Model;
import ru.academits.vasilev.temperature.View;

import javax.swing.*;

/*
1. Литералы такого вида лучше не использовать 9.
2. Сейчас в программе нарушен open closed принцип.
Если понадобится добавить еще 1 шкалу, то придется сильно менять существующий код.
В том числе придется писать код для перевода из каждой шкалы в каждую.
Нужно будет придумать решение, в котором легко добавлять/удалять шкалы.
Если долго не будет получаться, то можно будет спросить подсказку
3. Вызов SwingUtilities.invokeLater должен делаться во view
4. Контроллер не должен ничего знать про кнопки и т.д.
5. View не должен наследоваться от JFrame, т.к. не переопределяется ни один виртуальный метод
6. Лучше не стирать значение при переводе
7. Лучше добавить горизонтальные отступы вокруг кнопки, чтобы она не сливалась с остальными элементами формы
8. Модель по смыслу должна выдавать число, а не строку.
При этом не стоит округлять результат.
Результат лучше чтобы округлялся во view
 */

public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Controller(new View(), new Model()));
    }
}