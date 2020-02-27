package Controller;

import Model.ModelMenu;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerMenu implements EventHandler<MouseEvent> {
    private ViewHandler launcher;
    private ModelMenu model;


    public ControllerMenu(ViewHandler viewHandler, ModelMenu model) {
        this.model = model;
        this.launcher = viewHandler;
        this.launcher.setEventHandlerMenu(this);
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource().equals(launcher.getvMenu().getBtnPlay())){
            launcher.setJeuView();
        }
        if (event.getSource().equals(launcher.getvMenu().getBtnQuit())){
            System.exit(0);
        }

    }
}
