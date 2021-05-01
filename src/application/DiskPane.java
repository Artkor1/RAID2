package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import javafx.stage.Stage;

public class DiskPane{

    Scene scene;
    Stage stage;

    public DiskPane(){

        gridPane.setMinSize(300, 300);
        gridPane.setVgap(4);
        gridPane.setHgap(4);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(l1, 0, 0);
        gridPane.add(l2, 1, 0);
        gridPane.add(l3, 2, 0);
        gridPane.add(l4, 3, 0);
        gridPane.add(l5, 4, 0);
        gridPane.add(l6, 5, 0);
        gridPane.add(l7, 6, 0);
        gridPane.add(l8, 0, 1);
        gridPane.add(l9, 1, 1);
        gridPane.add(l10, 2, 1);
        gridPane.add(l11, 3, 1);
        gridPane.add(l12, 4, 1);
        gridPane.add(l13, 5, 1);
        gridPane.add(l14, 6, 1);
        gridPane.add(l15, 0, 2);
        gridPane.add(l16, 1, 2);
        gridPane.add(l17, 2, 2);
        gridPane.add(l18, 3, 2);
        gridPane.add(l19, 4, 2);
        gridPane.add(l20, 5, 2);
        gridPane.add(l21, 6, 2);
        gridPane.add(l22, 0, 3);
        gridPane.add(l23, 1, 3);
        gridPane.add(l24, 2, 3);
        gridPane.add(l25, 3, 3);
        gridPane.add(l26, 4, 3);
        gridPane.add(l27, 5, 3);
        gridPane.add(l28, 6, 3);
        gridPane.add(l29, 0, 4);
        gridPane.add(l30, 1, 4);
        gridPane.add(l31, 2, 4);
        gridPane.add(l32, 3, 4);
        gridPane.add(l33, 4, 4);
        gridPane.add(l34, 5, 4);
        gridPane.add(l35, 6, 4);

        stage = new Stage();
        scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.setTitle("Bits in disks");
        stage.show();
    }

    //gridpane - information about bits in disks
    GridPane gridPane = new GridPane();
    Label l1 = new Label("Disk 1");
    Label l2 = new Label("Disk 2");
    Label l3 = new Label("Disk 3");
    Label l4 = new Label("Disk 4");
    Label l5 = new Label("Hamming disk 1");
    Label l6 = new Label("Hamming disk 2");
    Label l7 = new Label("Hamming disk 3");
    Label l8 = new Label(Main.raid.getDiskTable(0, 0));
    Label l9 = new Label(Main.raid.getDiskTable(0, 1));
    Label l10 = new Label(Main.raid.getDiskTable(0, 2));
    Label l11 = new Label(Main.raid.getDiskTable(0, 3));
    Label l12 = new Label(Main.raid.getDiskTable(1, 0));
    Label l13 = new Label(Main.raid.getDiskTable(1, 1));
    Label l14 = new Label(Main.raid.getDiskTable(1, 2));
    Label l15 = new Label(Main.raid.getDiskTable(1, 3));
    Label l16 = new Label(Main.raid.getDiskTable(2, 0));
    Label l17 = new Label(Main.raid.getDiskTable(2, 1));
    Label l18 = new Label(Main.raid.getDiskTable(2, 2));
    Label l19 = new Label(Main.raid.getDiskTable(2, 3));
    Label l20 = new Label(Main.raid.getDiskTable(3, 0));
    Label l21 = new Label(Main.raid.getDiskTable(3, 1));
    Label l22 = new Label(Main.raid.getDiskTable(3, 2));
    Label l23 = new Label(Main.raid.getDiskTable(3, 3));
    Label l24 = new Label(Main.raid.getHammingDisks(0, 0));
    Label l25 = new Label(Main.raid.getHammingDisks(0, 1));
    Label l26 = new Label(Main.raid.getHammingDisks(0, 2));
    Label l27 = new Label(Main.raid.getHammingDisks(1, 0));
    Label l28 = new Label(Main.raid.getHammingDisks(1, 1));
    Label l29 = new Label(Main.raid.getHammingDisks(1, 2));
    Label l30 = new Label(Main.raid.getHammingDisks(2, 0));
    Label l31 = new Label(Main.raid.getHammingDisks(2, 1));
    Label l32 = new Label(Main.raid.getHammingDisks(2, 2));
    Label l33 = new Label(Main.raid.getHammingDisks(3, 0));
    Label l34 = new Label(Main.raid.getHammingDisks(3, 1));
    Label l35 = new Label(Main.raid.getHammingDisks(3, 2));

    //Label label = new Label();

    /**public void generateTable(){
        //main disks
        for (int i = 0; i < 4; i++){
            for (int j = 0;  j < 4; j++){
                label.setText(Main.raid.getDiskTable(i, j));
                gridPane.add(label, j, i + 1);
            }
        }

        //hamming disks
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 3; j++){
                label.setText(Main.raid.getHammingDisks(i, j));
                gridPane.add(label,  j + 4, i + 1);
            }
        }
    }**/

    public void show()
    {
        /**Main.stage.setScene(scene);
        Main.stage.setTitle("Bits in disks");
        Main.stage.show();**/
    }
}
