package view.strategy;

import java.awt.Graphics2D;
import model.interfaces.Region;

/**
 * Implements the methods that interacts with the graphics
 * system to draw Rectangles.  Can the the base for a decorator.
 */
public class RectangleDrawer extends BasicDrawer {

  @Override
  public void drawShape(Graphics2D graphics, Region region) {
    graphics.fillRect(region.getX(), region.getY(), region.getWidth(), region.getHeight());
  }

  @Override
  public void drawBorder(Graphics2D graphics, Region region) {
    graphics.drawRect(region.getX(), region.getY(), region.getWidth(), region.getHeight());
  }
}






