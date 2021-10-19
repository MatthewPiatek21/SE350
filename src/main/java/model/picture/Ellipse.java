package model.picture;

import java.awt.Graphics2D;
import model.ShapeColor;
import model.interfaces.Shape;

public class Ellipse implements Shape {

  private Point start;
  private Point end;
  private ShapeColor color;

  public void ShapeImpl(Point start, Point end, ShapeColor color) {
    normalizePoints(start, end);
    this.color = color;
  }

  public Point getStart() {
    return start;
  }

  public Point getEnd() {
    return end;
  }

  @Override
  public void draw(Graphics2D graphics) {
    graphics.setColor(color.value);
    graphics.fillRect(start.getX(), start.getY(), getWidth(), getHeight());
  }

  private int getWidth() {
    return end.getX() - start.getX();
  }

  private int getHeight() {
    return end.getY() - start.getY();
  }

  private void normalizePoints(Point firstPoint, Point endPoint) {
    int newStartX;
    int newStartY;
    int newEndX;
    int newEndY;

    // Calculated new X values
    if (firstPoint.getX() > endPoint.getX()) {
      newStartX = endPoint.getX();
      newEndX = firstPoint.getX();
    } else {
      newStartX = firstPoint.getX();
      newEndX = endPoint.getX();
    }

    // Calculate new Y values
    if (firstPoint.getY() > endPoint.getY()) {
      newStartY = endPoint.getY();
      newEndY = firstPoint.getY();
    } else {
      newStartY = firstPoint.getY();
      newEndY = endPoint.getY();
    }

    start = new Point(newStartX, newStartY);
    end = new Point(newEndX, newEndY);
  }
}
