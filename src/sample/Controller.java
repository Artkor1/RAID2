package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Controller {

    @FXML
    private TextField inputFileField;
    @FXML
    private TextField outputFileField;
    @FXML
    private TextArea calculations;


    @FXML
    private Label D01;
    @FXML
    private Label D02;
    @FXML
    private Label D03;
    @FXML
    private Label D04;
    @FXML
    private Label D11;
    @FXML
    private Label D12;
    @FXML
    private Label D13;
    @FXML
    private Label D14;
    @FXML
    private Label D21;
    @FXML
    private Label D22;
    @FXML
    private Label D23;
    @FXML
    private Label D24;
    @FXML
    private Label D31;
    @FXML
    private Label D32;
    @FXML
    private Label D33;
    @FXML
    private Label D34;
    @FXML
    private Label D41;
    @FXML
    private Label D42;
    @FXML
    private Label D43;
    @FXML
    private Label D44;
    @FXML
    private Label D51;
    @FXML
    private Label D52;
    @FXML
    private Label D53;
    @FXML
    private Label D54;
    @FXML
    private Label D61;
    @FXML
    private Label D62;
    @FXML
    private Label D63;
    @FXML
    private Label D64;


    Raid raid = new Raid();

    //textarea - CALCULATIONS
    String str = "";

    public void initialize(){
    }

    public void refresh(){
        D01.setText(raid.getDiskTable(0,0));
        D02.setText(raid.getDiskTable(1,0));
        D03.setText(raid.getDiskTable(2,0));
        D04.setText(raid.getDiskTable(3,0));

        D11.setText(raid.getDiskTable(0,1));
        D12.setText(raid.getDiskTable(1,1));
        D13.setText(raid.getDiskTable(2,1));
        D14.setText(raid.getDiskTable(3,1));

        D21.setText(raid.getDiskTable(0,2));
        D22.setText(raid.getDiskTable(1,2));
        D23.setText(raid.getDiskTable(2,2));
        D24.setText(raid.getDiskTable(3,2));

        D31.setText(raid.getHammingDisks(0,0));
        D32.setText(raid.getHammingDisks(1,0));
        D33.setText(raid.getHammingDisks(2,0));
        D34.setText(raid.getHammingDisks(3,0));

        D41.setText(raid.getDiskTable(0,3));
        D42.setText(raid.getDiskTable(1,3));
        D43.setText(raid.getDiskTable(2,3));
        D44.setText(raid.getDiskTable(3,3));

        D51.setText(raid.getHammingDisks(0,1));
        D52.setText(raid.getHammingDisks(1,1));
        D53.setText(raid.getHammingDisks(2,1));
        D54.setText(raid.getHammingDisks(3,1));

        D61.setText(raid.getHammingDisks(0,2));
        D62.setText(raid.getHammingDisks(1,2));
        D63.setText(raid.getHammingDisks(2,2));
        D64.setText(raid.getHammingDisks(3,2));
    }

    @FXML
    public void calculate(){
        raid.fillDisks();
        raid.generateECC();
        addText(raid.toString() + "\n");

        refresh();
    }

    @FXML
    public void readFromFile() throws FileNotFoundException {
        String inputFileName = inputFileField.getText();
        Scanner scanner = new Scanner(new File(inputFileName));
        int temp[][]=new int[4][4];
        try
        {
            for(int i=0; i<4; i++)
            {
                for(int j=0; j<4; j++)
                {
                    temp[i][j]=scanner.nextInt();
                }
            }
            raid.disks = temp;
            raid.generateECC();
            addText("Data imported from file " + inputFileName);
            scanner.close();
        }
        catch (Exception e)
        {
            addText("Error in read data from file");
        }
        refresh();
    }

    @FXML
    public void mainDiskError(){
        addText(raid.errorInDisks());
        addText(raid.toString() + "\n");
        refresh();
    }

    @FXML
    public void hammingDiskError(){
        addText(raid.errorInHammingDisks());
        addText(raid.toString() + "\n");
        refresh();
    }

    @FXML
    public void correctErrors(){
        addText(raid.fixBits());
        addText(raid.toString() + "\n");
        refresh();
    }

    @FXML
    public void writeToFile() throws FileNotFoundException{
        String outputFileName = outputFileField.getText();
        PrintWriter writer = new PrintWriter(outputFileName);
        try{
            for(int i=0; i<4; i++)
            {
                for(int j=0; j<4; j++)
                    writer.print(raid.disks[i][j]+"\t");
            }
            addText("Data saved in file " + outputFileName);
            writer.close();
        }
        catch(Exception e){
            addText("Error in write data to file");
        }
    }

    public void addText(String text){
        str += text;
        calculations.setText(str);
    }

}
