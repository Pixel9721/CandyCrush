package View;

import Controller.ControllerMenu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Screen;

public class ViewMenuPrincipal {

    private ViewHandler vMenu;
    private Group root;
    private VBox vBoxButton, vBoxBackground;
    private Button btnPlay, btnQuit;
    private ImageView imgbonhomme, imgTitre;




    public ViewMenuPrincipal(ViewHandler vMemu, Group root) {
        this.vMenu = vMemu;
        this.root = root;

        vBoxButton = new VBox();
        vBoxButton.setLayoutX(0);
        vBoxButton.setLayoutY(0);
        vBoxButton.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBoxButton.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBoxButton.setAlignment(Pos.CENTER);

        vBoxBackground= new VBox();
        vBoxBackground.setLayoutX(0);
        vBoxBackground.setLayoutY(0);
        vBoxBackground.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBoxBackground.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBoxBackground.setAlignment(Pos.TOP_CENTER);
        vBoxBackground.setBackground(new Background( new BackgroundImage(new
                Image("assets/images/chamallowKawai.jpg"), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));


        btnPlay = initButton("PLAY");
        VBox.setMargin(btnPlay, new Insets(0,0,10,0));
        btnQuit = initButton("QUITTER");
        VBox.setMargin(btnQuit, new Insets(30,0,0,0));

        imgTitre = new ImageView("Assets/images/CandyCrush1.png");
        imgTitre.getStyleClass().add("banniere");


        imgbonhomme = new ImageView("Assets/images/CandyVache.png");
        VBox.setMargin(imgbonhomme, new Insets(450,0,0,1000));


        vBoxButton.getChildren().addAll(btnPlay,btnQuit);
        vBoxBackground.getChildren().addAll(imgTitre, imgbonhomme);
        initView();
    }

    public void initView(){
        root.getChildren().clear();
        root.getChildren().add(vBoxBackground);
        root.getChildren().add(vBoxButton);
    }

    private Button initButton(String texteButton) {
        Button b = new Button();
        b.setText(texteButton);
        b.getStyleClass().add("btnStyle");
        b.setFont (Font.font ("Aclonica", 20));
        return b;
    }
    public void setEvents(ControllerMenu cm){
        btnPlay.setOnMouseClicked(cm);
        btnQuit.setOnMouseClicked(cm);
    }


    //getter
    public Button getBtnPlay() { return btnPlay; }
    public Button getBtnQuit() { return btnQuit; }
}
