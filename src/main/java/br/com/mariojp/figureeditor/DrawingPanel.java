
package br.com.mariojp.figureeditor;

import br.com.mariojp.figureeditor.factory.ShapeFactory;
import br.com.mariojp.figureeditor.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

class DrawingPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_SIZE = 60;
    private final List<Shape> shapes = new ArrayList<>();
    private String shapeName = "circle";

    DrawingPanel() {
        
        setBackground(Color.WHITE);
        setOpaque(true);
        setDoubleBuffered(true);

        var mouse = new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) {
                Shape shape = ShapeFactory.createShape(
                        shapeName,
                        e.getX(),
                        e.getY(),
                        DEFAULT_SIZE
                );

                if(shape != null) {
                    shapes.add(shape);
                    repaint();
                }
            }
        };
        addMouseListener(mouse);        
        addMouseMotionListener(mouse);

    }

    void clear() {
        shapes.clear();
        repaint();
    }

    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Shape s : shapes) {
            s.draw(g2);
        }

        g2.dispose();
    }

}
