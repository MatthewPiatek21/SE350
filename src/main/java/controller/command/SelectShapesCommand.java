package controller.command;

import controller.interfaces.Command;
import model.interfaces.Region;
import view.interfaces.Picture;

public class SelectShapesCommand implements Command {
  private Picture picture;
  private Region region;

  public SelectShapesCommand(Picture picture, Region region) {
    this.picture = picture;
    this.region = region;
  }
 
  @Override
  public void run() {
    picture.select(region);
  }
}
