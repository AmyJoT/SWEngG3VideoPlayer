package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;

public class VideoPlayer {

    private Media media;
    private MediaPlayer player;
    private MediaView mediaView;
    private String fileName;
    private String url;
    private VBox vBox;
    //private BorderPane borderPane;

    // Example media player
    public VideoPlayer(Scene scene) {
        this(scene, "RickAstley");
    }

    // Create a video player for the provided file
    public VideoPlayer(Scene scene, String fileName) {

        //borderPane = new BorderPane();
        vBox = new VBox();

        media = new Media(getClass().getResource(fileName+".mp4").toExternalForm());
        player = new MediaPlayer(media);
        mediaView = new MediaView(player);

        setVideoPath(fileName);

        // Places media player into a new pane
        Pane mvPane = new Pane();
        mvPane.getChildren().add(mediaView);
        mvPane.setStyle("-fx-background-color: black;");
        //borderPane.setCenter(mvPane);
        vBox.getChildren().add(mvPane);

        // Adds the controls to the video player
        // VideoControl controls = new VideoControl(player, mediaView, borderPane);
        VideoControl controls = new VideoControl(player, mediaView, vBox);

        // Preserves aspect ratio while resizing the window
        mediaView.fitWidthProperty().bind(vBox.widthProperty());
        mediaView.fitHeightProperty().bind(vBox.heightProperty());
        mediaView.setPreserveRatio(true);

        playVideo();

    }

    public VBox getPane() {
        return vBox;
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
