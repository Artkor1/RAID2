package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WindowRandom {

    Scene scene;

    public WindowRandom(){
        /**scene = new Scene(gridPane);
        gridPane.setMinSize(800, 600);
        gridPane.setVgap(4);
        gridPane.setHgap(4);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(randomDataPane, 0, 0);
        gridPane.add(diskCalculations, 1, 0);**/
    }

    GridPane gridPane = new GridPane();
    RandomDataPane randomDataPane = new RandomDataPane();
    public static DiskCalculations diskCalculations = new DiskCalculations();

    public void show(){
        Main.stage.setScene(scene);
        Main.stage.setTitle("RAID2");
        Main.stage.show();
    }
}
