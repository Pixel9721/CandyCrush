package View;

import Controller.ControllerJeu;
import Controller.ControllerMenu;
import Model.ModelJeu;
import Model.ModelMenu;
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

    private ModelMenu modelMenu;
    private ModelJeu modelJeu;

    private ControllerMenu controllerMenu;
    private ControllerJeu controllerJeu;




    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        root = new Group();
        scene = new Scene(root);
        scene.getStylesheets().add("Assets/css/styles.css");

        modelMenu = new ModelMenu();
        modelJeu = new ModelJeu();

        vMenu = new ViewMenuPrincipal(this, root);
        vJeu = new ViewJeu(this, root);

        controllerMenu = new ControllerMenu(this, modelMenu);
        controllerJeu = new ControllerJeu(this, modelJeu);

        //edition de la scene
        primaryStage.setTitle("Candy Crush");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public void setEventHandlerMenu(ControllerMenu cm) { vMenu.setEvents(cm); }
    public void setEventHandlerJeu(ControllerJeu cm) { vJeu.setEventsBack(cm);}

    public ViewMenuPrincipal getvMenu() { return vMenu; }
    public ViewJeu getvJeu() { return vJeu; }



    public void setJeuView() { vJeu.initView(); }
    public void setMenuView(){ vMenu.initView();}
}
