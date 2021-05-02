package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Raid raid = new Raid();

    //gridpane OPTIONS
    GridPane options = new GridPane();

    //gridpane - BITS
    GridPane bits = new GridPane();

    //textarea - CALCULATIONS
    String str = "";
    TextArea calculations = new TextArea(str);

    @Override
    public void start(Stage primaryStage) throws Exception{

        //gridpane OPTIONS
        Label method = new Label("Choose the method of obtaining data:");
        Label randomData = new Label("GENERATING RANDOM DATA");
        Button calculate = new Button("Calculate");
        Label fileData = new Label("READING DATA FROM FILE");
        Label inputFileInfo = new Label("Write down name of input file:");
        TextField inputFileName = new TextField();
        Button readFile = new Button("Read from file");
        Label typeOfError = new Label("Choose the type of error:");
        Button mainDiskError = new Button("Main disk error");
        Button hDiskError = new Button("Hamming disk error");
        Button correctErrors = new Button("Correct errors");
        Label outputFileInfo = new Label("Write down name of output file:");
        TextField outputFileName = new TextField();
        Button writeToFile = new Button("Write to file");

        options.setAlignment(Pos.CENTER);
        options.add(method, 0, 0);
        options.add(randomData, 0, 1);
        options.add(calculate, 0, 2);
        options.add(fileData, 0, 3);
        options.add(inputFileInfo, 0, 4);
        options.add(inputFileName, 0, 5);
        options.add(readFile, 1, 5);
        options.add(typeOfError, 0, 6);
        options.add(mainDiskError, 0, 7);
        options.add(hDiskError, 1, 7);
        options.add(correctErrors, 0, 8);
        options.add(outputFileInfo, 0, 9);
        options.add(outputFileName, 0, 10);
        options.add(writeToFile, 1, 10);

        //reactions on buttons
        calculate.setOnAction(e -> {
            raid.fillDisks();
            raid.generateECC();
            addText(raid.toString());
            generateBits();
        });

        readFile.setOnAction(e -> {

        });

        mainDiskError.setOnAction(e -> {
            addText(raid.errorInDisks());
            addText(raid.toString());
            generateBits();
        });

        hDiskError.setOnAction(e -> {
            addText(raid.errorInHammingDisks());
            addText(raid.toString());
            generateBits();
        });

        correctErrors.setOnAction(e -> {
            addText(raid.fixBits());
            addText(raid.toString());
            generateBits();
        });

        writeToFile.setOnAction(e -> {

        });

        Label bitsInDisksLabel = new Label("Bits in disks:");

        Label calculationsLabel = new Label("Calculations:");

        //vbox - APPLICATION
        VBox application = new VBox(options, bitsInDisksLabel, bits, calculationsLabel, calculations);

        Scene scene = new Scene(application, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Redundant arrays of independent disks - RAID2");
        primaryStage.show();
    }

    //adding bits to gridpane BITS
    public void generateBits(){

        //generate labels
        Label l1 = new Label("Disk 1");
        Label l2 = new Label("Disk 2");
        Label l3 = new Label("Disk 3");
        Label l4 = new Label("Disk 4");
        Label l5 = new Label("Hamming disk 1");
        Label l6 = new Label("Hamming disk 2");
        Label l7 = new Label("Hamming disk 3");
        Label l8 = new Label(raid.getDiskTable(0, 0));
        Label l9 = new Label(raid.getDiskTable(0, 1));
        Label l10 = new Label(raid.getDiskTable(0, 2));
        Label l11 = new Label(raid.getDiskTable(0, 3));
        Label l12 = new Label(raid.getDiskTable(1, 0));
        Label l13 = new Label(raid.getDiskTable(1, 1));
        Label l14 = new Label(raid.getDiskTable(1, 2));
        Label l15 = new Label(raid.getDiskTable(1, 3));
        Label l16 = new Label(raid.getDiskTable(2, 0));
        Label l17 = new Label(raid.getDiskTable(2, 1));
        Label l18 = new Label(raid.getDiskTable(2, 2));
        Label l19 = new Label(raid.getDiskTable(2, 3));
        Label l20 = new Label(raid.getDiskTable(3, 0));
        Label l21 = new Label(raid.getDiskTable(3, 1));
        Label l22 = new Label(raid.getDiskTable(3, 2));
        Label l23 = new Label(raid.getDiskTable(3, 3));
        Label l24 = new Label(raid.getHammingDisks(0, 0));
        Label l25 = new Label(raid.getHammingDisks(0, 1));
        Label l26 = new Label(raid.getHammingDisks(0, 2));
        Label l27 = new Label(raid.getHammingDisks(1, 0));
        Label l28 = new Label(raid.getHammingDisks(1, 1));
        Label l29 = new Label(raid.getHammingDisks(1, 2));
        Label l30 = new Label(raid.getHammingDisks(2, 0));
        Label l31 = new Label(raid.getHammingDisks(2, 1));
        Label l32 = new Label(raid.getHammingDisks(2, 2));
        Label l33 = new Label(raid.getHammingDisks(3, 0));
        Label l34 = new Label(raid.getHammingDisks(3, 1));
        Label l35 = new Label(raid.getHammingDisks(3, 2));

        //add labels to gridpane BITS
        bits.setAlignment(Pos.CENTER);
        bits.add(l1, 0, 0);
        bits.add(l2, 1, 0);
        bits.add(l3, 2, 0);
        bits.add(l4, 3, 0);
        bits.add(l5, 4, 0);
        bits.add(l6, 5, 0);
        bits.add(l7, 6, 0);
        bits.add(l8, 0, 1);
        bits.add(l9, 1, 1);
        bits.add(l10, 2, 1);
        bits.add(l11, 3, 1);
        bits.add(l12, 4, 1);
        bits.add(l13, 5, 1);
        bits.add(l14, 6, 1);
        bits.add(l15, 0, 2);
        bits.add(l16, 1, 2);
        bits.add(l17, 2, 2);
        bits.add(l18, 3, 2);
        bits.add(l19, 4, 2);
        bits.add(l20, 5, 2);
        bits.add(l21, 6, 2);
        bits.add(l22, 0, 3);
        bits.add(l23, 1, 3);
        bits.add(l24, 2, 3);
        bits.add(l25, 3, 3);
        bits.add(l26, 4, 3);
        bits.add(l27, 5, 3);
        bits.add(l28, 6, 3);
        bits.add(l29, 0, 4);
        bits.add(l30, 1, 4);
        bits.add(l31, 2, 4);
        bits.add(l32, 3, 4);
        bits.add(l33, 4, 4);
        bits.add(l34, 5, 4);
        bits.add(l35, 6, 4);
    }

    //addind new text to textarea - CALCULATIONS
    public void addText(String text){
        str += text;
        calculations.setText(str);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
