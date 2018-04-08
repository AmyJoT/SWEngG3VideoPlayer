package sample;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VideoPlayer {

    private MediaPlayer player;
    private MediaView mediaView;

    public VideoPlayer(StackPane root, Scene scene) {

        player = new MediaPlayer( new Media(getClass().getResource("RickAstley.mp4").toExternalForm()));
        mediaView = new MediaView(player);

        root.getChildren().add( mediaView);

        VideoControl controls = new VideoControl(player, mediaView);
        scene.setRoot(controls);

        player.play();

    }

}
