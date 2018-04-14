package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

// Video player example
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Video player example");

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1000, 768);

        VideoPlayer video = new VideoPlayer(scene);
        //VideoPlayer video = new VideoPlayer(scene);

        root.setCenter(video.getPane());


        // 5 pixels space between child nodes
        VBox test = new VBox(5);
        // 1 pixel padding between child nodes only
        test.setPadding(new Insets(1));
        Rectangle r1 = new Rectangle(10, 10);
        Rectangle r2 = new Rectangle(20, 100);
        Rectangle r3 = new Rectangle(50, 20);
        Rectangle r4 = new Rectangle(20, 50);

        test.getChildren().addAll(r1, r2, r3, r4);

        root.setBottom(test);
        root.setTop(addHBox());
        root.setLeft(addHBox());
        root.setRight(addHBox());

        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 25, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button buttonCurrent = new Button("Current");

        Button buttonProjected = new Button("Projected");
        hbox.getChildren().addAll(buttonCurrent, buttonProjected);

        return hbox;
    }

}
