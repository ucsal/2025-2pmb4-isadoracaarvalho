package br.com.mariojp.figureeditor.factory;

import br.com.mariojp.figureeditor.shapes.Circle;
import br.com.mariojp.figureeditor.shapes.Shape;

public class ShapeFactory {
    public static Shape createShape(String shapeName, int x, int y, int size) {
        switch (shapeName) {
            case "circle":
                return new Circle(x, y, size);
        }

        return null;
    }
}
