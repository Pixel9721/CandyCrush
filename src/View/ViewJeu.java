package View;

import Controller.ControllerJeu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;


public class ViewJeu {
    private Group root;
    private Button btnBackMenu;
    private ViewHandler vhJeu;
    private ImageView pluto;
    private Label titre;

    //score et fond
    private HBox hboxScore;
    private VBox vBoxBackground, vBoxButton;

    //plateau du jeu
    private StackPane plateauCentral;

    public ViewJeu(ViewHandler vhJeu, Group root) {
        this.vhJeu = vhJeu;
        this.root = root;


        //Vbox du fond
        vBoxBackground = new VBox();
        vBoxBackground.setLayoutX(0);
        vBoxBackground.setLayoutY(0);
        vBoxBackground.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBoxBackground.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBoxBackground.setAlignment(Pos.CENTER);
        vBoxBackground.setBackground(new Background( new BackgroundImage(new
                Image("Assets/images/jaune.jpg"),BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

        titre = initLabel("CECI EST LA VUE DU JEUX ", 60);
        VBox.setMargin(titre, new Insets(150,0,0,0));

        vBoxButton = new VBox();
        vBoxButton.setLayoutX(0);
        vBoxButton.setLayoutY(0);
        vBoxButton.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBoxButton.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBoxButton.setAlignment(Pos.BOTTOM_LEFT);
        btnBackMenu = initButton("Retour", 20);
        VBox.setMargin(btnBackMenu, new Insets(20, 20,20,20));

        pluto = new ImageView("Assets/images/fillette1.gif");
        pluto.setFitWidth(250);
        pluto.setFitHeight(250);
        VBox.setMargin(pluto, new Insets(450,0,0,1000));
        pluto.getStyleClass().add("fillette");


        //stackPane du plateau
        plateauCentral = new StackPane();
        plateauCentral.setAlignment(Pos.TOP_CENTER);
        vBoxBackground.getChildren().addAll(titre, pluto);
        vBoxButton.getChildren().addAll(btnBackMenu);
    }

    void initView(){
        root.getChildren().clear();
        root.getChildren().addAll(vBoxBackground);
        root.getChildren().addAll(vBoxButton);

    }
    public Button initButton(String texteBoutton, int size){
        Button b = new Button();
        b.setText(texteBoutton);
        b.setFont(Font.font(size));
        b.getStyleClass().add("btnMenu");
        return b;
    }
    private Label initLabel(String texteLabel, int size){
        Label l = new Label();
        l.setTextFill(Color.WHITE);
        l.setFont(Font.font(size));
        l.setText(texteLabel);
        l.getStyleClass().add("labelMenu");
        return l;
    }

    public void setEventsBack(ControllerJeu cm){ btnBackMenu.setOnMouseClicked((cm));}

    public Button getBtnBckMenu() { return btnBackMenu; }
    public void getBtnBckMenu(ControllerJeu cJ){ btnBackMenu.setOnMouseClicked(cJ); }

}
