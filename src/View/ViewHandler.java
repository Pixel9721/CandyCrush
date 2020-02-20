package View;

import Controller.ControllerMenu;
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
    private ControllerMenu controllerMenu;
    private ModelMenu modelMenu;


    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        root = new Group();

        scene = new Scene(root);
        scene.getStylesheets().add("Assets/css/styles.css");

        vMenu = new ViewMenuPrincipal(this, root);

        controllerMenu = new ControllerMenu(this, modelMenu);

        //edition de la scene
        primaryStage.setTitle("Candy Crush");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public void setEventrMenu(ControllerMenu cm) { vMenu.setEvents(cm); }

    public ViewMenuPrincipal getvMenu() { return vMenu; }
}
