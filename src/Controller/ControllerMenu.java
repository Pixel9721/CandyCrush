package Controller;

import Animations.Papillon;
import Model.ModelMenu;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerMenu implements EventHandler<MouseEvent> {
    private ViewHandler launcher;
    private ModelMenu model;
    private Papillon papillon;


    public ControllerMenu(ViewHandler viewHandler, ModelMenu model) {
        this.model = model;
        this.launcher = viewHandler;
        this.launcher.setEventHandlerMenu(this);

        for (int i = 0; i < 35; i++) {
            Papillon buterfly = new Papillon(viewHandler.getvMenu().getRoot());
            buterfly.startFlying();
        }
}
    @Override
    public void handle(MouseEvent event) {
        if (event.getSource().equals(launcher.getvMenu().getBtnPlay())){
            launcher.setJeuView();
        }else if (event.getSource().equals(launcher.getvMenu().getBtnOption())){
            launcher.setOptionView();
        }else if (event.getSource().equals(launcher.getvMenu().getBtnQuit())){
            System.exit(0);
        }

    }
}
