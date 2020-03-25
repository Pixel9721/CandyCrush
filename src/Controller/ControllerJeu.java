package Controller;


import Model.ModelJeu;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerJeu implements EventHandler<MouseEvent> {
    private ViewHandler launcher;
    private ModelJeu model;


    public ControllerJeu(ViewHandler viewHandler, ModelJeu model) {
        this.model = model;
        this.launcher = viewHandler;
        this.launcher.setEventHandlerJeu(this);

    }


    @Override
    public void handle(MouseEvent event) {
        if (event.getSource().equals(launcher.getvJeu().getBtnBckMenu())){
            launcher.setMenuView();
        }
    }
}

