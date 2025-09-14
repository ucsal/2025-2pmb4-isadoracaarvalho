package br.com.mariojp.figureeditor.shapes;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle implements Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(new Color(30,144,255));
        g2.fill(new Ellipse2D.Double(x, y, radius, radius));
        g2.setColor(new Color(0,0,0,70));
        g2.setStroke(new BasicStroke(1.2f));
        g2.draw(new Ellipse2D.Double(x, y, radius, radius));
    }
}
