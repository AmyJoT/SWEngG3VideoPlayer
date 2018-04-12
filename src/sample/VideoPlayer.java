package sample;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VideoPlayer {

    private MediaPlayer player;
    private MediaView mediaView;
    private String fileName;
    private String url;

    // TODO: remove this
    // Example media player
    public VideoPlayer(StackPane root, Scene scene) {

        player = new MediaPlayer( new Media(getClass().getResource("RickAstley.mp4").toExternalForm()));
        mediaView = new MediaView(player);

        root.getChildren().add(mediaView);

        VideoControl controls = new VideoControl(player, mediaView);
        scene.setRoot(controls);

        player.play();

    }

    // Create a video player for the provided file
    public VideoPlayer(StackPane root, Scene scene, String fileName) {

        player = new MediaPlayer( new Media(getClass().getResource(fileName).toExternalForm()));
        mediaView = new MediaView(player);

        root.getChildren().add(mediaView);

        VideoControl controls = new VideoControl(player, mediaView);
        scene.setRoot(controls);

        player.play();

        setVideoPath(fileName);

    }

    public void setVideoPath(String fileName) {
        this.fileName = fileName;
    }

}
