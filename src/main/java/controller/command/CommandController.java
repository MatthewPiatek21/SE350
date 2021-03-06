package controller.command;

import controller.Clipboard;
import controller.interfaces.Command;
import model.interfaces.Region;
import model.interfaces.UserChoices;
import model.picture.Point;
import model.picture.RegionImpl;
import view.gui.PaintCanvas;
import view.interfaces.Picture;

/**
 * CommandController is responsible for creating new Commands based on
 * current user input.  The new Command is normally executed as well.
 */
public class CommandController {

  private final PaintCanvas canvas;
  private final UserChoices choices;
  private final Picture picture;
  private final Clipboard clipboard;
  private final DeleteManager delete;

  public CommandController(PaintCanvas canvas, UserChoices choices, Picture picture, Clipboard clipboard, DeleteManager delete) {
    this.choices = choices;
    this.canvas = canvas;
    this.picture = picture;
    this.clipboard = clipboard;
    this.delete = delete;
  }

  public void onDraw(Point start, Point end) {
    Region region = new RegionImpl(start, end);
    Command cmd = CommandFactory.makeCommand(choices, canvas, picture, region);
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

  public void onCopy() {
    clipboard.copy();
  }

  public void onPaste() {
    clipboard.paste();
    canvas.repaint();
  }

  public void onDelete() {
    delete.delete();
  }
  }

