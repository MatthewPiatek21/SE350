package controller.command;

import view.gui.PaintCanvas;
import view.interfaces.Picture;
import view.interfaces.Shape;

public class DeleteManager {

  private final PaintCanvas canvas;
  private final Picture picture;

  public DeleteManager(PaintCanvas canvas, Picture picture) {
    this.canvas = canvas;
    this.picture = picture;
  }

    public void delete() {
    for (Shape s : picture.getSelected()){
      picture.remove(s);
    }
    canvas.repaint();
    }
}
