package View;

import Controller.ControllerMenu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Screen;

public class ViewMenuPrincipal {

    private ViewHandler vMenu;
    private Group root;
    private VBox vBoxButtonC, vBoxButtonQ,vBoxBackground, vBoxLogo;
    private Button btnPlay, btnQuit, btnOption;
    private ImageView imgbonhomme, imgTitre;
    final GaussianBlur gaussianBlur = new GaussianBlur(20);// pour l opacite du fond d ecran
    final GaussianBlur gaussianBlure = new GaussianBlur(15);// pour l opacite du fond d ecran

    public ViewMenuPrincipal(ViewHandler vMemu, Group root) {
        this.vMenu = vMemu;
        this.root = root;

        //vbox fond d'ecran
        vBoxBackground= new VBox();
        vBoxBackground.setLayoutX(0);
        vBoxBackground.setLayoutY(0);
        vBoxBackground.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBoxBackground.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBoxBackground.setAlignment(Pos.CENTER);
        vBoxBackground.setBackground(new Background( new BackgroundImage(new
                Image("assets/images/chamallowKawai.jpg"), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        vBoxBackground.setEffect(gaussianBlur);

        //vbox logo et petite fille
        vBoxLogo = new VBox();
        vBoxLogo.setLayoutX(0);
        vBoxLogo.setLayoutY(0);
        vBoxLogo.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBoxLogo.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBoxLogo.setAlignment(Pos.TOP_CENTER);
        imgTitre = new ImageView("Assets/images/CandyCrush1.png");
        VBox.setMargin(imgTitre, new Insets(50,0,0,0));
        imgTitre.getStyleClass().add("banniere");
        imgTitre.setEffect(gaussianBlure);
        imgbonhomme = new ImageView("Assets/images/fillette.gif");
        imgbonhomme.setFitWidth(250);
        imgbonhomme.setFitHeight(250);
        VBox.setMargin(imgbonhomme, new Insets(350,0,0,250));
        imgbonhomme.getStyleClass().add("fillette");

        //vbox bouton central
        vBoxButtonC = new VBox();
        vBoxButtonC.setLayoutX(0);
        vBoxButtonC.setLayoutY(0);
        vBoxButtonC.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBoxButtonC.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBoxButtonC.setAlignment(Pos.CENTER);
        btnPlay = initButton("PLAY");
        VBox.setMargin(btnPlay, new Insets(0,0,10,0));
        btnOption = initButton("Option");
        VBox.setMargin(btnOption, new Insets(30,0,0,0));

        //vbox bouton quitter
        vBoxButtonQ = new VBox();
        vBoxButtonQ.setLayoutX(0);
        vBoxButtonQ.setLayoutY(0);
        vBoxButtonQ.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBoxButtonQ.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBoxButtonQ.setAlignment(Pos.BOTTOM_LEFT);
        btnQuit = initButton("QUITTER");
        VBox.setMargin(btnQuit, new Insets(20,20,20,20));

        vBoxBackground.getChildren().addAll();
        vBoxLogo.getChildren().addAll(imgTitre, imgbonhomme);
        vBoxButtonC.getChildren().addAll(btnPlay, btnOption);
        vBoxButtonQ.getChildren().add(btnQuit);
        initView();
    }

    public void initView(){
        root.getChildren().clear();
        root.getChildren().add(vBoxBackground);
        root.getChildren().add(vBoxLogo);
        root.getChildren().add(vBoxButtonC);
        root.getChildren().add(vBoxButtonQ);
    }

    private Button initButton(String texteButton) {
        Button b = new Button();
        b.setText(texteButton);
        b.getStyleClass().add("btnMenu");
        b.setFont (Font.font ("Aclonica", 20));
        return b;
    }
    public void setEvents(ControllerMenu cm){
        btnPlay.setOnMouseClicked(cm);
        btnQuit.setOnMouseClicked(cm);
        btnOption.setOnMouseClicked(cm);
    }

    //getter
    public Button getBtnPlay() { return btnPlay; }
    public Button getBtnQuit() { return btnQuit; }
    public Button getBtnOption() { return btnOption; }

    public Group getRoot() { return root; }
}
