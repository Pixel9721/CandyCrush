package View;

import Controller.ControllerJeu;
import Controller.ControllerMenu;
import Controller.ControllerOption;
import Model.ModelJeu;
import Model.ModelMenu;
import Tools.Music;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewHandler extends Application {

    public Stage primaryStage;
    private Scene scene;
    private Group root;

    private ViewMenuPrincipal vMenu;
    private ViewJeu vJeu;
    private ViewOption vOption;

    private ModelMenu modelMenu;
    private ModelJeu modelJeu;
    private ModelJeu modelOption;

    private ControllerMenu controllerMenu;
    private ControllerJeu controllerJeu;
    private ControllerOption controllerOption;




    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        root = new Group();
        scene = new Scene(root);
        scene.getStylesheets().add("Assets/css/styles.css");

        modelMenu = new ModelMenu();
        modelJeu = new ModelJeu();
        modelOption = new ModelJeu();

        vMenu = new ViewMenuPrincipal(this, root);
        vJeu = new ViewJeu(this, root);
        vOption = new ViewOption(this, root);

        controllerMenu = new ControllerMenu(this, modelMenu);
        controllerJeu = new ControllerJeu(this, modelJeu);
        controllerOption = new ControllerOption(this, modelOption);

        //edition de la scene
        Music.startMusic();
        primaryStage.setTitle("Candy Crush");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setEventHandlerMenu(ControllerMenu cm) { vMenu.setEvents(cm); }
    public void setEventHandlerJeu(ControllerJeu cm) { vJeu.setEventsBack(cm);}
    public void setEventOptionView(ControllerOption cm){ vOption.setEventsBack(cm);}

    public ViewMenuPrincipal getvMenu() { return vMenu; }
    public ViewJeu getvJeu() { return vJeu; }

    public void setJeuView(){ vJeu.initView(); }
    public void setMenuView(){ vMenu.initView();}
    public void setOptionView(){ vOption.initView(); }

    public ViewOption getvOption() { return vOption; }
}
