package sample;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DiskCalculations{

    Scene scene;
    Stage stage;

    public DiskCalculations(){

        gridPane.setMinSize(600, 600);
        gridPane.setVgap(4);
        gridPane.setHgap(4);

        gridPane.setAlignment(Pos.CENTER);
        //gridPane.add(diskPane, 0, 0);
        gridPane.add(textArea, 0, 1);

        stage = new Stage();
        scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.setTitle("Calculations");
        stage.show();
    }

    GridPane gridPane = new GridPane();
    //DiskPane diskPane = new DiskPane();
    String str = "";
    TextArea textArea = new TextArea(str);

    /**public void generateTable(){
        diskPane.generateTable();
    }**/

    public void addText(String text){
        str += text;
        textArea.setText(str);
    }

    public void show()
    {
        /**Main.stage.setScene(scene);
        Main.stage.setTitle("Calculations");
        Main.stage.show();**/
    }
}
