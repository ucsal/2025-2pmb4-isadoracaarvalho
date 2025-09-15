package br.com.mariojp.figureeditor;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}

            JFrame frame = new JFrame("Figure Editor — Clique para inserir figuras");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            DrawingPanel panel = new DrawingPanel();

            frame.setLayout(new BorderLayout());
            frame.add(panel, BorderLayout.CENTER);

            JPanel bottomPanel = new JPanel();
            JButton colorButton = new JButton("COR");

            colorButton.addActionListener(e -> {
                Color newColor = JColorChooser.showDialog(frame, "Escolha uma cor", Color.BLUE);
                if (newColor != null) {
                    panel.setShapeColor(newColor);
                }
            });

            bottomPanel.add(colorButton);

            frame.setLayout(new BorderLayout());
            frame.add(bottomPanel, BorderLayout.SOUTH);
            frame.add(panel, BorderLayout.CENTER);

            frame.setSize(900, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
