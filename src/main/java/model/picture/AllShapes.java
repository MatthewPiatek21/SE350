package model.picture;

import controller.command.CreateShapeCommand;
import java.awt.Graphics2D;
import java.awt.Shape;
import view.gui.PaintCanvas;

public class AllShapes {

  PaintCanvas canvas;
  static Graphics2D graphics2d;
  static DrawShape drawShape;

  public DrawShape(PaintCanvas canvas) {
    graphics2d = canvas.getGraphics2D();
  }

  public static void drawShapeStrategy(CreateShapeCommand shape, AllShapes drawShape) {
    CreateShapeCommand shapeStrategy;

    switch(Shape.ShapeType) {
      case Ellipse:
        shapeStrategy = new Ellipse();
        break;
      case Triangle:
        shapeStrategy = new Triangle();
        break;
      case Rectangle:
        shapeStrategy = new Rectangle();
        break;
      default:
        throw new IllegalArgumentException("Invalid shape type");
    }

    shapeStrategy.onDraw(shape, graphics2d);

  }


}