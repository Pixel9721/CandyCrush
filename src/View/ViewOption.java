package View;

import Controller.ControllerOption;
import Tools.Music;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class ViewOption {
    private Group root;
    private Button btnBackMain2, btnControlSon;
    private ViewHandler vhOption;
    private Text titreOption;
    private Slider musicSlider;
    final GaussianBlur gaussianBlur = new GaussianBlur(20);// pour l opacite du fond d ecran
    private VBox vBoxBackground, vBoxButton, vBoxTitre;

    public ViewOption(ViewHandler vhOption, Group root) {
        this.vhOption = vhOption;
        this.root = root;

        //bouton pour le volume
        btnVolume(40,60);

        //Vbox du fond
        vBoxBackground = new VBox();
        vBoxBackground.setLayoutX(0);
        vBoxBackground.setLayoutY(0);
        vBoxBackground.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBoxBackground.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBoxBackground.setAlignment(Pos.CENTER);
        vBoxBackground.setBackground(new Background( new BackgroundImage(new
                Image("Assets/images/chamallowKawai.jpg"), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        vBoxBackground.setEffect(gaussianBlur);

        //vBox pour le titre
        vBoxTitre = new VBox();
        vBoxTitre.setLayoutX(0);
        vBoxTitre.setLayoutY(0);
        vBoxTitre.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBoxTitre.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBoxTitre.setAlignment(Pos.TOP_CENTER);
        titreOption = iniTitre("OPTION", 20 );
        VBox.setMargin(titreOption, new Insets(150,0,0,0));

        //vBox pour le bouton retour
        vBoxButton = new VBox();
        vBoxButton.setLayoutX(0);
        vBoxButton.setLayoutY(0);
        vBoxButton.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBoxButton.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBoxButton.setAlignment(Pos.BOTTOM_LEFT);
        btnBackMain2 = initButton("Retour");
        VBox.setMargin(btnBackMain2, new Insets(20, 20,20,20));

        //titre du bouton
        btnControlSon = initButtonV("Volume", 20);
        btnControlSon.setLayoutX(650);
        btnControlSon.setLayoutY(400);

        vBoxBackground.getChildren().addAll();
        vBoxButton.getChildren().addAll(btnBackMain2);
        vBoxTitre.getChildren().addAll(titreOption);

    }
    void initView(){
        root.getChildren().clear();
        root.getChildren().addAll(vBoxBackground);
        root.getChildren().addAll(vBoxTitre);
        root.getChildren().addAll(vBoxButton);
        root.getChildren().add(btnControlSon);
        root.getChildren().add(musicSlider);
        root.getStylesheets().add(getClass().getResource("../Assets/css/slider.css").toExternalForm());
    }
    private void btnVolume(int largeur, int longueur){
        musicSlider= new Slider(0,100,100);
        musicSlider.setBlockIncrement(10);
        musicSlider.setShowTickLabels(true);
        musicSlider.valueProperty().addListener((observable, oldValue, newValue) -> Music.setVolume(newValue.intValue() / 100.));
        musicSlider.setLayoutX(650);
        musicSlider.setLayoutY(450);
    }
    public Button initButtonV(String texteBoutton, int size){
        Button b = new Button();
        b.setText(texteBoutton);
        b.setFont(Font.font(size));
        b.setBackground(null);
        b.getStyleClass().add("btnV");
        return b;
    }
    private Button initButton(String texteButton) {
        Button b = new Button();
        b.setText(texteButton);
        b.getStyleClass().add("btnMenu");
        b.setFont (Font.font ("Aclonica", 20));
        return b;
    }
    private Text iniTitre(String texteTitre, int size){
        Text ti = new Text();
        ti.setText(texteTitre);
        ti.setFont(Font.font(size));
        ti.getStyleClass().add("titre");
        ti.setFont (Font.font ("Aclonica", 190));
        return ti;
    }

    public void setEventsBack(ControllerOption cm){
        btnBackMain2.setOnMouseClicked(cm);
    }

    public Button getBtnBackMain2() {
        return btnBackMain2;
    }


}
