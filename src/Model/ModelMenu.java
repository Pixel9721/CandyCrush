package Model;

public class ModelMenu {

    private ImageB imageB;

    public int loadImage(){
        imageB = new ImageB();
        if (imageB.ChargeImage() == 0){
            return 0;
        }
        else {
            return 1;
        }
    }
    public ImageB getImageB(){
        return this.imageB;
    }

}
