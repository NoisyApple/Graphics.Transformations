package com.noisyapple;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Transformations extends JFrame {

  private int width = 700;
  private int height = 500;

  public Transformations() {

    setTitle("Transformations");
    setVisible(true);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    add(new CustomCanvas());
    pack();
    setLocationRelativeTo(null);

  }

  class CustomCanvas extends JPanel {

    protected void paintComponent(Graphics g) {

      Graphics2D g2d = (Graphics2D) g;

      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      g2d.setColor(Color.decode("#333333"));
      g2d.fillRect(0, 0, width, height);

      Point[] arrow = { new Point(100, 100), new Point(200, 100), new Point(200, 50), new Point(300, 150),
          new Point(200, 250), new Point(200, 200), new Point(100, 200) };

      // No transform.
      g2d.setColor(Color.decode("#FFFFAA"));
      drawShape(g2d, arrow);

      // Translating.
      g2d.setColor(Color.decode("#BBDDAA"));
      translate(arrow, 200, 200);
      drawShape(g2d, arrow);

      // Scaling.
      g2d.setColor(Color.decode("#BBAADD"));
      scale(arrow, 0.9f, 0.9f);
      drawShape(g2d, arrow);

    }

    public Dimension getPreferredSize() {
      return new Dimension(width, height);
    }

    public void translate(Point[] points, int tX, int tY) {
      for (int i = 0; i < points.length; i++) {
        points[i].setX(points[i].getX() + tX);
        points[i].setY(points[i].getY() + tY);
      }
    }

    public void scale(Point[] points, float sclX, float sclY) {
      for (int i = 0; i < points.length; i++) {
        points[i].setX((int) (points[i].getX() * sclX));
        points[i].setY((int) (points[i].getY() * sclY));
      }
    }

    public void drawShape(Graphics2D g2d, Point[] points) {
      for (int i = 0; i < points.length; i++) {
        int previousIndex = (i + points.length - 1) % (points.length);
        g2d.drawLine(points[i].getX(), points[i].getY(), points[previousIndex].getX(), points[previousIndex].getY());
      }
    }

  }

}
