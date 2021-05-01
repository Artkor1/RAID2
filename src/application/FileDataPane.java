package sample;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FileDataPane{

    Scene scene;
    Stage stage;

    public FileDataPane(){

        gridPane.setMinSize(200, 600);
        gridPane.setVgap(4);
        gridPane.setHgap(4);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(info, 0, 0);
        gridPane.add(nameOfInputFileLabel, 0, 1);
        gridPane.add(nameOfInputFile, 0, 2);
        gridPane.add(readFromFile, 1, 2);
        gridPane.add(typeOfErrorLabel, 0, 3);
        gridPane.add(mainDiskError, 0, 4);
        gridPane.add(hammingDiskError, 1, 4);
        gridPane.add(correctErrors, 0, 5);
        gridPane.add(nameOfOutputFileLabel, 0, 6);
        gridPane.add(nameOfOutputFile, 0, 7);
        gridPane.add(writeToFile, 1, 7);
        gridPane.add(back, 1, 8);

        stage = new Stage();
        scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.setTitle("Read data from file");
        stage.show();
    }

    //gridpane - read data from file
    GridPane gridPane = new GridPane();
    Label info = new Label("Reading data from file");
    Label nameOfInputFileLabel = new Label("Write down the name of input file:");
    TextField nameOfInputFile = new TextField();
    Button readFromFile = new Button("Read from file");
    Label typeOfErrorLabel = new Label("Choose the type of error:");
    Button mainDiskError = new Button("Main disk error");
    Button hammingDiskError = new Button("Hamming disk error");
    Button correctErrors = new Button("Correct errors");
    Label nameOfOutputFileLabel = new Label("Write down the name of output file:");
    TextField nameOfOutputFile = new TextField();
    Button writeToFile = new Button("Write to file");
    Button back = new Button("Back");

    public void choice(){

        //trzeba dodawac odpowiednie informacje w textarea
        readFromFile.setOnAction(e -> {
            //metody do odczytania z pliku, ktore musza byc w Raid
            //diskPane.generateTable();
            Main.diskPane = new DiskPane();
            //Main.diskPane.generateTable();
            //Main.diskPane.show();
            Main.diskCalculations = new DiskCalculations();
            Main.diskCalculations.addText(Main.raid.toString());
            //Main.diskCalculations.show();
        });

        mainDiskError.setOnAction(e -> {
            //Main.raid.errorInDisks();
            //WindowFile.diskCalculations.addText(Main.raid.toString());
            Main.diskCalculations.addText(Main.raid.errorInDisks());
            Main.diskCalculations.addText(Main.raid.toString());
        });

        hammingDiskError.setOnAction(e -> {
            //Main.raid.errorInHammingDisks();
            Main.diskCalculations.addText(Main.raid.errorInHammingDisks());
            Main.diskCalculations.addText(Main.raid.toString());
        });

        correctErrors.setOnAction(e -> {
            //Main.raid.fixBits();
            Main.diskCalculations.addText(Main.raid.fixBits());
            Main.diskCalculations.addText(Main.raid.toString());
        });

        //trzeba zrobic
        writeToFile.setOnAction(e -> {

        });

        back.setOnAction(e -> {
            Main.startWindow = new StartWindow();
            Main.startWindow.show();
        });
    }

    public void show()
    {
        /**Main.stage.setScene(scene);
        Main.stage.setTitle("Read data from file");
        Main.stage.show();**/
    }
}
