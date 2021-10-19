package controller.command;

import controller.interfaces.Command;
import model.interfaces.Picture;
import model.interfaces.UserChoices;
import model.picture.Point;
import view.gui.PaintCanvas;

/**
 * CommandController is responsible for creating new Commands based on
 * current user input.  The new Command is normally executed as well.
 */
public class CommandController {
  private final PaintCanvas canvas;
  private final UserChoices choices;
  private final Picture picture;

  public CommandController(PaintCanvas canvas, UserChoices choices, Picture picture) {
    this.choices = choices;
    this.canvas = canvas;
    this.picture = picture;
  }

  public void onDraw(Point start, Point end) {

    Command cmd = new CreateShapeCommand(choices, canvas, picture, start, end);

    cmd.run();

    canvas.repaint();
  }

  public void onUndo() {
    CommandHistory.undo();
    canvas.repaint();
  }
  public void onRedo() {
    CommandHistory.redo();
    canvas.repaint();
  }
}