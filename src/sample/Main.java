package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args)  {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        loadScreen(stage, "sample.fxml");
    }

    public void loadScreen(Stage primaryStage, String file_path) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(file_path));
        AnchorPane anchorPane = loader.load();
        Scene scene = new Scene(anchorPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("RAID 2");
        primaryStage.show();
    }
}
