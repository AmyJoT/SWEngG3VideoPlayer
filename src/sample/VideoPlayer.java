package sample;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VideoPlayer {

    private MediaPlayer player;
    private MediaView mediaView;
    private String fileName;
    private String url;
    private BorderPane borderPane;

    // Example media player
    public VideoPlayer(Scene scene) {
        this(scene, "RickAstley");
    }

    // Create a video player for the provided file
    public VideoPlayer(Scene scene, String fileName) {

        borderPane = new BorderPane();
        player = new MediaPlayer( new Media(getClass().getResource(fileName+".mp4").toExternalForm()));
        mediaView = new MediaView(player);

        setVideoPath(fileName);

        // Places media player into a new plan
        Pane mvPane = new Pane();
        mvPane.getChildren().add(mediaView);
        mvPane.setStyle("-fx-background-color: black;");
        borderPane.setCenter(mvPane);

        // Adds the controls to the video player
        VideoControl controls = new VideoControl(player, mediaView, borderPane);

        // Preserves aspect ratio while resizing the window
        mediaView.fitWidthProperty().bind(borderPane.widthProperty());
        mediaView.fitHeightProperty().bind(borderPane.heightProperty());


        playVideo();

    }

    public BorderPane getPane() {
        return borderPane;
    }

    public void setVideoPath(String fileName) {
        this.fileName = fileName;
    }

    public void stopVideo () {
        player.stop();
    }

    public void playVideo () {
        player.play();
    }

    public void pauseVideo () {
        player.pause();
    }

}
