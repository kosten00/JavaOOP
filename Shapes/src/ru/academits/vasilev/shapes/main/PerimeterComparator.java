package ru.academits.vasilev.shapes.main;

import ru.academits.vasilev.shapes.Shape;

import java.util.Comparator;

public class PerimeterComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        Shape s1 = (Shape) o1;
        Shape s2 = (Shape) o2;

        return Double.compare(s2.getPerimeter(), s1.getPerimeter());
    }
}