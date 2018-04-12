package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// Video player example
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Video player example");

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1024, 768);

        VideoPlayer video = new VideoPlayer(scene);
        root.setTop(video.getPane());

//        HBox hbox = addHBox();
//        root.setBottom(hbox);

        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button buttonCurrent = new Button("Current");

        Button buttonProjected = new Button("Projected");
        hbox.getChildren().addAll(buttonCurrent, buttonProjected);

        return hbox;
    }

}
