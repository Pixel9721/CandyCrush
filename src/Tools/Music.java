package Tools;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

public class Music {
    private static final String MusicCandy = "src/Assets/Music/douce.mp3";
    private static MediaPlayer mediaPlayer;
    private static double volume = 0.5;

    public static void startMusic(){
        if (mediaPlayer != null) mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(new Media(Paths.get(MusicCandy).toUri().toString()));
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }
    public static void setVolume(double volume) {
        Music.volume = volume;
        if(mediaPlayer!=null) mediaPlayer.setVolume(volume);
    }

}
