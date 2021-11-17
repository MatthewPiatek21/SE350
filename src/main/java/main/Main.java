package main;

import controller.Clipboard;
import controller.EventConnectorImpl;
import controller.KeyboardInterface;
import controller.MouseHandler;
import controller.command.CommandController;
import controller.command.DeleteManager;
import controller.interfaces.EventConnector;
import model.interfaces.UserChoices;
import model.persistence.UserChoicesImpl;
import view.gui.Gui;
import view.gui.GuiWindowImpl;
import view.gui.PaintCanvas;
import view.interfaces.GuiWindow;
import view.interfaces.Picture;
import view.interfaces.UiModule;
import view.picture.PictureImpl;

/**
 * The class that contains the main method of tha application.  Performs
 * most of the dependency injection required by the system.
 */
public class Main {
    public static void main(String[] args){
        Picture picture = new PictureImpl();
        PaintCanvas paintCanvas = new PaintCanvas(picture);
        GuiWindow guiWindow = new GuiWindowImpl(paintCanvas);
        UiModule uiModule = new Gui(guiWindow);
        UserChoices userChoices = new UserChoicesImpl(uiModule);
        Clipboard clipboard = new Clipboard(picture, paintCanvas);
        DeleteManager delete = new DeleteManager(paintCanvas, picture);
        CommandController commandControl = new CommandController(paintCanvas, userChoices, picture, clipboard, delete);
        EventConnector controller = new EventConnectorImpl(uiModule, userChoices, commandControl);

        KeyboardInterface keys = new KeyboardInterface(paintCanvas, userChoices);
        keys.setup();

        MouseHandler mouse = new MouseHandler(commandControl);
        paintCanvas.addMouseListener(mouse);
        controller.setup();
    }
}

