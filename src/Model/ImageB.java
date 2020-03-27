package Model;

import javafx.scene.image.Image;

public class ImageB {

    private Image[] bonbon = new Image[26];
    private Image btnVide;
    private Image[] etoile = new Image[4];
    public ImageB(){

    }
    public int ChargeImage(){
        try {
            //simple bonbon
            bonbon[0] = new Image("/Assets/bonbons/bonbon/vert.png");
            bonbon[1] = new Image("/Assets/bonbons/bonbon/bleue.png");
            bonbon[2] = new Image("/Assets/bonbons/bonbon/orange.png");
            bonbon[3] = new Image("/Assets/bonbons/bonbon/jaune.png");
            bonbon[4] = new Image("/Assets/bonbons/bonbon/rouge.png");
            bonbon[5] = new Image("/Assets/bonbons/bonbon/violet.png");
            //bonbon rayé horizontale
            bonbon[6] = new Image("/Assets/bonbons/bonbonRayeH/vertH.png");
            bonbon[7] = new Image("/Assets/bonbons/bonbonRayeH/bleueH.png");
            bonbon[8] = new Image("/Assets/bonbons/bonbonRayeH/orangeH.PNG");
            bonbon[9] = new Image("/Assets/bonbons/bonbonRayeH/jauneH.PNG");
            bonbon[10] = new Image("/Assets/bonbons/bonbonRayeH/rougeH.PNG");
            bonbon[11] = new Image("/Assets/bonbons/bonbonRayeH/violetH.PNG");
            //bonbon rayé verticale
            bonbon[12] = new Image("/Assets/bonbons/bonbonRayeV/vertV.PNG");
            bonbon[13] = new Image("/Assets/bonbons/bonbonRayeV/bleueV.png");
            bonbon[14] = new Image("/Assets/bonbons/bonbonRayeV/orangeV.png");
            bonbon[15] = new Image("/Assets/bonbons/bonbonRayeV/jauneV.PNG");
            bonbon[16] = new Image("/Assets/bonbons/bonbonRayeV/rougeV.PNG");
            bonbon[17] = new Image("/Assets/bonbons/bonbonRayeV/violetV.PNG");
            //bonbon emballé
            bonbon[18] = new Image("/Assets/bonbons/bonbonB/vertE.PNG");
            bonbon[19] = new Image("/Assets/bonbons/bonbonB/bleueE.PNG");
            bonbon[20] = new Image("/Assets/bonbons/bonbonB/orangeE.PNG");
            bonbon[21] = new Image("/Assets/bonbons/bonbonB/jauneE.PNG");
            bonbon[22] = new Image("/Assets/bonbons/bonbonB/rougeE.PNG");
            bonbon[23] = new Image("/Assets/bonbons/bonbonB/violetE.PNG");
            //bonbon disco
            bonbon[24] = new Image("/Assets/bonbons/bonbonMulti/disco.PNG");
            bonbon[25] = new Image("/Assets/bonbons/bonbonMulti/btnVide.png");


        }
        catch (IllegalArgumentException e2){
            System.out.println(e2.getMessage());
            return 0;

        }
        catch (RuntimeException e){
            System.out.println("fd");
            return 0;

        }
        return 1;
    }
    public Image getSampleBonbon(int i){
        return this.bonbon[i];
    }

}
