package Animations;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.util.Duration;

public class Papillon {
    private ImageView imgButerfly;
    private Timeline flyTimeline;
    private Group grpContainerImgButerfly;
    private Group root;
    private double vitesseRandom ;
    private boolean sensButerfly;

    public Papillon(Group root){
        this.root = root;
        grpContainerImgButerfly = new Group();
        imgButerfly = new ImageView("Assets/images/papillon.gif");
        imgButerfly.setPreserveRatio(true);
        if(Math.random() < 0.5){
            sensButerfly = false;
        }else{
            sensButerfly = true;
            imgButerfly.setRotationAxis(new Point3D(0,1,0));
            imgButerfly.setRotate(-180);
        }
        vitesseRandom = (Math.random() * 10000 ) + 5000;
        double startRandom = -1 * Math.random() * 250;
        double sizeRandom = (Math.random() *  80 ) + 10 ;
        imgButerfly.setFitWidth(sizeRandom);
        grpContainerImgButerfly.setLayoutX(startRandom);
        double hauteurRandom = Math.random() *  350  ;
        grpContainerImgButerfly.setLayoutY(hauteurRandom);
        grpContainerImgButerfly.getChildren().add(imgButerfly);

        initflyAnimation();

    }

    private void initflyAnimation(){
        flyTimeline = new Timeline();
        if (sensButerfly){
            flyTimeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO,new KeyValue(grpContainerImgButerfly.layoutXProperty(),-200)),
                    new KeyFrame(new Duration(vitesseRandom), new KeyValue(grpContainerImgButerfly.layoutXProperty(), Screen.getPrimary().getBounds().getWidth())));
        }else{
            flyTimeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO,new KeyValue(grpContainerImgButerfly.layoutXProperty(),Screen.getPrimary().getBounds().getWidth())),
                    new KeyFrame(new Duration(vitesseRandom), new KeyValue(grpContainerImgButerfly.layoutXProperty(),-200 )));
        }
        flyTimeline.setCycleCount(Animation.INDEFINITE);
    }

    public void startFlying(){
        root.getChildren().add(grpContainerImgButerfly);
        flyTimeline.play();
    }
    public void stopFlying(){
        root.getChildren().remove(grpContainerImgButerfly);
        flyTimeline.stop();
    }

}
