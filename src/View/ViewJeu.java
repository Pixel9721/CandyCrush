package View;

import Controller.ControllerJeu;
import Model.ImageB;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ViewJeu {
    private Group root;
    private Button btnBackMenu;
    private ViewHandler vhJeu;
    private ImageView fillette, homme;
    private Rectangle rectangle1;
    final GaussianBlur gaussianBlur = new GaussianBlur(15);// pour l opacite du fond d ecran
    //fond
    private VBox vBoxBackground, vBoxButton, vBoxLogo, vBoxGus;
    //plateau du jeu
    private StackPane plateauCentral;

    //initialisation du tableau nombre de ligne et de colonne ainsi que la taille
    private static final int H = 5;
    private static final int W = 5;
    private static final int SIZE = 100;

    //création des couleurs des cercle qui seront mis aléatoirement par la suite
    private Color[] colors = new Color[] {
            Color.LIGHTBLUE, Color.PINK, Color.GREENYELLOW, Color.ROSYBROWN, Color.AQUA, Color.BLUEVIOLET
    };
    //
    private Bonbon selected = null;
    private List<Bonbon> bonbons;

    //le score
    private IntegerProperty score = new SimpleIntegerProperty();

    //création du jeu
    private Parent createContent(){
        StackPane plateauCentral = new StackPane();
        plateauCentral.setAlignment(Pos.TOP_CENTER);
        StackPane.setMargin(plateauCentral, new Insets(260, 0, 0,70));
        plateauCentral.setPrefSize(W * SIZE + 150, H * SIZE);

        //calcul la taille du tableau et renvois une valeur d objet  on multpli la largeur par la hauteur
        bonbons = IntStream.range(0, W * H)
                .mapToObj(i -> new Point2D(i % W, i /H))
                .map(point -> new Bonbon(point))
                .collect(Collectors.toList());

        plateauCentral.getChildren().addAll(bonbons);

        Text textScore = new Text();
        textScore.setTranslateX(650);
        textScore.setTranslateY(160);
        textScore.setFont(Font.font(60));
        //
        textScore.textProperty().bind(score.asString("Score: %d"));

        plateauCentral.getChildren().add(textScore);
        return plateauCentral;
    }
    //check si c est le même couleur sur la ligne ou la colonne
    private void check(){
        Map<Integer, List<Bonbon>> lignes = bonbons.stream().collect(Collectors.groupingBy(Bonbon::getLigne));
        Map<Integer, List<Bonbon>> colonnes = bonbons.stream().collect(Collectors.groupingBy(Bonbon::getColonne));

        lignes.values().forEach(this::Combo);
        colonnes.values().forEach(this::Combo);
    }
    //verifie si c est bien en ligne ou en colonne
    private void Combo(List<Bonbon> lignrDeBonbon) {
        Bonbon bonbon = lignrDeBonbon.get(0);
        // on compte le nombre de bonbon avec la meme couleur
        long count = lignrDeBonbon.stream().filter(j -> j.getColor() != bonbon.getColor()).count();
        if (count == 0){

            //pour le score on augment de 100 a chaque fois que la ligne est complete avec la meme couleur
            score.set(score.get() + 100);
            lignrDeBonbon.forEach(Bonbon::aleat);
        }
    }
    //interchange le bonbon a par rapport au bonbon b quand on veux le deplacer
    private void interchange(Bonbon a, Bonbon b){
        Paint color = a.getColor();
        a.setColor(b.getColor());
        b.setColor(color);
    }
    //création de la class bonbon
    private class Bonbon extends Parent {
        //creations des bonbons en forme de cercle et la  taille des cercle divise par la taille du tableau
        private Circle bonBon = new Circle(SIZE / 3);

        //on utilise point2D pour savoir ou placer les bonBons
        public Bonbon(Point2D point) {
            //centrer
            bonBon.setCenterX(SIZE / 2);
            bonBon.setCenterY(SIZE / 2);
            // aléatoire par rapport a la longeur du tableau
            bonBon.setFill(colors[new Random().nextInt(colors.length)]);


            //on multplie par 100 la hauteur et la largeur
            setTranslateX(point.getX() * SIZE);
            setTranslateY(point.getY() * SIZE);
            // on ajoute le bonBon
            getChildren().add(bonBon);

            //selection des bonbons
            setOnMouseClicked(event -> {
                if (selected == null) {
                    selected = this;
                } else {
                    interchange(selected, this);
                    //on controle les ligne ou colonne pour voir si c est les même couleur
                    check();
                    selected = null;
                }
            });
        }

        //change la couleur a chaque fois qu une ligne est rempli
        public void aleat() {
            bonBon.setFill(colors[new Random().nextInt(colors.length)]);
        }

        // on divise par la colonne par la taille
        public int getColonne() {
            return (int) getTranslateX() / SIZE ;
        }
        // on divise par la ligne par la taille
        public int getLigne() {
            return (int) getTranslateY() / SIZE;
        }
        public void setColor(Paint color) {
            bonBon.setFill(color);
        }
        public Paint getColor() {
            return bonBon.getFill();
        }
    }

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

        /*vbox bouton*/
        vBoxButton = new VBox();
        vBoxButton.setLayoutX(0);
        vBoxButton.setLayoutY(0);
        vBoxButton.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBoxButton.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBoxButton.setAlignment(Pos.BOTTOM_LEFT);
        btnBackMenu = initButton("Retour", 20);
        VBox.setMargin(btnBackMenu, new Insets(20, 20,20,20));

        //vbox du logo
        vBoxLogo = new VBox();
        vBoxLogo.setLayoutX(0);
        vBoxLogo.setLayoutY(0);
        vBoxLogo.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBoxLogo.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBoxLogo.setAlignment(Pos.BASELINE_CENTER);
        fillette = new ImageView("Assets/images/fillette1.gif");
        fillette.setFitWidth(250);
        fillette.setFitHeight(250);
        VBox.setMargin(fillette, new Insets(660,0,0,1000));
        fillette.getStyleClass().add("fillette");

        //vbox de l'ours
        vBoxGus = new VBox();
        vBoxGus.setLayoutX(0);
        vBoxGus.setLayoutY(0);
        vBoxGus.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBoxGus.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBoxGus.setAlignment(Pos.TOP_LEFT);
        homme = new ImageView("Assets/images/ours1.gif");
        homme.setFitWidth(280);
        homme.setFitHeight(280);
        VBox.setMargin(homme, new Insets(150,0,0,50));
        homme.getStyleClass().add("fillette");

        //stackPane du plateau
        plateauCentral = new StackPane();
        plateauCentral.setAlignment(Pos.TOP_CENTER);

        //jeu
        rectangle1 = new Rectangle();
        rectangle1.setWidth(520);
        rectangle1.setHeight(540);
        rectangle1.setFill(Color.GREY);
        StackPane.setMargin(rectangle1, new Insets(220,0,0,460));
        rectangle1.setStroke(Color.WHITE);
        rectangle1.setStrokeWidth(2);
        rectangle1.setArcWidth(20);
        rectangle1.setArcHeight(20);
        rectangle1.setOpacity(0.5);
        rectangle1.getStyleClass().add("grille");

        vBoxBackground.getChildren().addAll();
        vBoxLogo.getChildren().addAll(fillette);
        vBoxGus.getChildren().addAll(homme);
        vBoxButton.getChildren().addAll(btnBackMenu);
        plateauCentral.getChildren().addAll(rectangle1,createContent());
    }
    void initView(){
        root.getChildren().clear();
        root.getChildren().addAll(vBoxBackground);
        root.getChildren().addAll(vBoxLogo);
        root.getChildren().addAll(vBoxGus);
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

    public void setEventsBack(ControllerJeu cm){
        btnBackMenu.setOnMouseClicked((cm));
    }

    public Button getBtnBckMenu() { return btnBackMenu; }

}
