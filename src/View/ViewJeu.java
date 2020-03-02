package View;

import Controller.ControllerJeu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Screen;


public class ViewJeu {
    private Group root;
    private Button btnBackMenu;
    private ViewHandler vhJeu;
    private ImageView pluto;
    private Label titre;
    private Rectangle rectangle1, rectangle2, rectangle3;
    final GaussianBlur gaussianBlur = new GaussianBlur(15);// pour l opacite du fond d ecran


    //score et fond
    private HBox hboxScore;
    private VBox vBoxBackground, vBoxButton, vBoxLogo;

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
                Image("Assets/images/chamallowKawai.jpg"),BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        vBoxBackground.setEffect(gaussianBlur);

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

        vBoxLogo = new VBox();
        vBoxLogo.setLayoutX(0);
        vBoxLogo.setLayoutY(0);
        vBoxLogo.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBoxLogo.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBoxLogo.setAlignment(Pos.BASELINE_CENTER);

        pluto = new ImageView("Assets/images/fillette1.gif");
        pluto.setFitWidth(250);
        pluto.setFitHeight(250);
        VBox.setMargin(pluto, new Insets(450,0,0,1000));
        pluto.getStyleClass().add("fillette");


        //stackPane du plateau
        plateauCentral = new StackPane();
        plateauCentral.setAlignment(Pos.TOP_CENTER);

        rectangle1 = new Rectangle();
        rectangle1.setWidth(490);
        rectangle1.setHeight(580);
        rectangle1.setFill(Color.GREY);
        StackPane.setMargin(rectangle1, new Insets(250,0,0,460));
        rectangle1.setArcWidth(20);
        rectangle1.setArcHeight(20);
        rectangle1.setOpacity(0.5);
        rectangle1.getStyleClass().add("grille");

        rectangle2 = new Rectangle();
        rectangle2.setWidth(490);
        rectangle2.setHeight(580);
        rectangle2.setFill(Color.GREY);
        StackPane.setMargin(rectangle2, new Insets(250,0,0,460));
        rectangle2.setOpacity(0.5);
        rectangle2.setStroke(Color.WHITE);
        rectangle2.setFill(null);
        rectangle2.setStrokeWidth(2);
        rectangle2.setArcWidth(20);
        rectangle2.setArcHeight(20);

        vBoxBackground.getChildren().addAll();
        vBoxLogo.getChildren().addAll(titre, pluto);
        vBoxButton.getChildren().addAll(btnBackMenu);
        plateauCentral.getChildren().addAll(rectangle1,rectangle2);
    }

    void initView(){
        root.getChildren().clear();
        root.getChildren().addAll(vBoxBackground);
        root.getChildren().addAll(vBoxLogo);
        root.getChildren().addAll(vBoxButton);
        root.getChildren().addAll(plateauCentral);

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
