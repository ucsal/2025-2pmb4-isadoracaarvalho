package br.com.mariojp.figureeditor.factory;

import br.com.mariojp.figureeditor.shapes.Circle;
import br.com.mariojp.figureeditor.shapes.Shape;

import java.awt.*;

public class ShapeFactory {
    public static Shape createShape(String shapeName, int x, int y, int size, Color shapeColor) {
        switch (shapeName) {
            case "circle":
                return new Circle(x, y, size, shapeColor);
        }

        return null;
    }
}
