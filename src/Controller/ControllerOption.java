package Controller;

import Model.ModelJeu;
import Model.ModelOption;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerOption implements EventHandler<MouseEvent> {
    private ViewHandler launcher;
    private ModelJeu model;

    public ControllerOption(ViewHandler viewHandler, ModelJeu model) {
        this.model = model;
        this.launcher = viewHandler;
        this.launcher.setEventOptionView(this);
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource().equals(launcher.getvOption().getBtnBackMain2())){
            launcher.setMenuView();
        }
    }
}
