package view.interfaces;

import java.awt.Color;
import java.awt.Graphics2D;
import model.ShapeShadingType;
import model.interfaces.Region;

public interface Shape {
  void draw(Graphics2D graphics);
  void drawSelected(Graphics2D graphics);
  Color getPrimaryColor();
  Color getSecondaryColor();
  ShapeShadingType getShadingType();
  Region region();
  void move(int deltaX, int deltaY);
  Shape copy();
}

