package sample;

import com.oracle.tools.packager.Log;
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

import java.io.File;

public class VideoPlayer {

    private Media media;
    private MediaPlayer player;
    private MediaView mediaView;
    private String fileName;
    private VBox vBox;
    private File file;

    // Example media player
    public VideoPlayer(Scene scene) {
        this(scene, "example");
    }

    // Creates a video player for the provided file.
    // Obtains video from the same directory as src
    public VideoPlayer(Scene scene, String fileName) {
        this(scene, fileName, System.getProperty("user.dir"));
    }

    // Creates a video player for the provided file and file path
    public VideoPlayer(Scene scene, String fileName, String filePath) {

        setFile(filePath);
        setFileName(fileName);

        vBox = new VBox();

        try{
            media = new Media(file.toURI().toURL().toString() + fileName + ".mp4");
            player = new MediaPlayer(media);
            mediaView = new MediaView(player);


            // Places media player into a new pane
            Pane mvPane = new Pane();
            mvPane.getChildren().add(mediaView);
            mvPane.setStyle("-fx-background-color: black;");
            vBox.getChildren().add(mvPane);

            // Adds the controls to the video player
            VideoControl controls = new VideoControl(player, mediaView, vBox);

            // Preserves aspect ratio while resizing the window
            mediaView.fitWidthProperty().bind(vBox.widthProperty());
            mediaView.fitHeightProperty().bind(vBox.heightProperty());
            mediaView.setPreserveRatio(true);

            playVideo();
        }
        catch (Exception e) {
            System.out.println("Error: Invalid file path");
        }

    }

    public File getFile() {
        return file;
    }

    public void setFile(String filePath) {
        this.file = new File(filePath);
    }

    public VBox getPane() {
        return vBox;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void stopVideo() {
        player.stop();
    }

    public void playVideo() {
        player.play();
    }

    public void pauseVideo() {
        player.pause();
    }


}
