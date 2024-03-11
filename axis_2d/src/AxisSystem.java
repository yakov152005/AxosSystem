import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class AxisSystem {

    private JFrame frame;
    private int length = 500;
    private int width = 500;
    private JPanel panel;
    private List<Point> points1 = new ArrayList<>();
    private Graphics2D g2d;
    private Color color;

    public AxisSystem () {
        // Set the length and width of the window

        // Create a new frame
        frame = new JFrame();
        frame.setSize(length, width);
        frame.setResizable(false);
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics graphics1d) {
                g2d = (Graphics2D) graphics1d;
                // Set the center of the frame as the starting point for the axes
                int centerX = length / 2;
                int centerY = width / 2;

                // Set the length of the axes
                int axisLength = 500; // Adjust the length of the axes proportionally

                // Set the stroke width of the axes
                int strokeWidth = 2;

                // Set the color of the X-axis to black
                g2d.setColor(Color.BLACK);

                // Draw the X-axis
                g2d.drawLine(0, centerY, centerX + axisLength / 2, centerY);

                // Set the color of the Y-axis to blue

                // Draw the Y-axis
                g2d.drawLine(centerX, 0, centerX, centerY + axisLength / 2);
                g2d.setColor(color);

                // Set the stroke width for the points
                g2d.setStroke(new BasicStroke(strokeWidth));

                // Plot the points on the axis system
                for (Point point : points1) {
                    g2d.drawLine(centerX + point.x, centerY - point.y, centerX + point.x, centerY - point.y);
                }
                g2d.setColor(Color.RED); // Set the color of the point to red

// Draw the point at the beginning of the axis (0,0) with a radius of 10
                g2d.fillOval(centerX - 3, centerY - 3, 6, 6);
            }
        };
        frame.add(panel);

        // Set the frame to be visible
        frame.setVisible(true);

    }

    public class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void clear () {
        this.points1.clear();
        int[] data = new int[0];
        addMultiplePoints(data, "black");
    }

    public void addSinglePoint (int x, int y, String color) {
        int[] point = {x, y};
        addMultiplePoints(point, color);
    }

    public void addMultiplePoints(int[] data, String color) {
        if (panel.getGraphics() != null) {
            try {
                this.color = (Color) Color.class.getField(color.toUpperCase()).get(null);
            } catch (Exception e) {
            }
        }
        for (int i = 0; i < data.length - 1; i+=2) {
            int x = data[i];
            int y = data[i + 1];
            points1.add(new Point(x, y));
        }
        frame.repaint();
        panel.repaint();

        // Create a custom JPanel and add it to the frame

    }
}
