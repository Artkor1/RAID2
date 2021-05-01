package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class StartWindow {

    Scene scene;

    public StartWindow(){
        scene = new Scene(gridPane);
        gridPane.setMinSize(400, 400);
        gridPane.setVgap(4);
        gridPane.setHgap(4);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(welcome, 0, 0);
        gridPane.add(random, 0, 3);
        gridPane.add(file, 1, 3);

        choice();
    }

    GridPane gridPane = new GridPane();

    Label welcome = new Label("Redundant arrays of independent disks - RAID2");
    Button random = new Button("Generate random data");
    Button file = new Button("Read data from file");

    public void choice(){
        random.setOnAction(e -> {
            /**Main.windowRandom = new WindowRandom();
            Main.windowRandom.show();**/

            Main.randomDataPane = new RandomDataPane();
            //Main.randomDataPane.show();
        });

        file.setOnAction(e -> {
            /**Main.windowFile = new WindowFile();
            Main.windowFile.show();**/

            Main.fileDataPane = new FileDataPane();
            //Main.fileDataPane.show();
        });
    }

    public void show(){
        Main.stage.setScene(scene);
        Main.stage.setTitle("RAID2");
        Main.stage.show();
    }
}
