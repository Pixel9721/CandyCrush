package Controller;

import Model.ModelMenu;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerMenu implements EventHandler<MouseEvent> {
    private ViewHandler launcher;
    private ModelMenu model;


    public ControllerMenu(ViewHandler launcher, ModelMenu model) {
        this.launcher = launcher;
        this.launcher.setEventrMenu(this);
        this.model = model;
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource().equals(launcher.getvMenu().getBtnQuit())){
            System.exit(0);
        }

    }
}
