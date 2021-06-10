package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

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
    private Button[] diskButtons;
    
    @FXML
    private Button D01;
    @FXML
    private Button D02;
    @FXML
    private Button D03;
    @FXML
    private Button D04;
    @FXML
    private Button D11;
    @FXML
    private Button D12;
    @FXML
    private Button D13;
    @FXML
    private Button D14;
    @FXML
    private Button D21;
    @FXML
    private Button D22;
    @FXML
    private Button D23;
    @FXML
    private Button D24;
    @FXML
    private Button D31;
    @FXML
    private Button D32;
    @FXML
    private Button D33;
    @FXML
    private Button D34;
    @FXML
    private Button D41;
    @FXML
    private Button D42;
    @FXML
    private Button D43;
    @FXML
    private Button D44;
    @FXML
    private Button D51;
    @FXML
    private Button D52;
    @FXML
    private Button D53;
    @FXML
    private Button D54;
    @FXML
    private Button D61;
    @FXML
    private Button D62;
    @FXML
    private Button D63;
    @FXML
    private Button D64;


    Raid raid = new Raid();

    //textarea - CALCULATIONS
    String str = "";

    public void initialize(){
    	diskButtons = new Button[] {
    			D01,D02,D03,D04,
    			D11,D12,D13,D14,
    			D21,D22,D23,D24,
    			D31,D32,D33,D34,
    			D41,D42,D43,D44,
    			D51,D52,D53,D54,
    			D61,D62,D63,D64
    			};
    }
    
    public void refreshColor() {
    	
    	for(int i=0; i<4; i++)
    	{
    		if(!diskButtons[i].getText().equals(raid.getDiskTable(i, 0)))
    		{
    			changeColor(i);
    			diskButtons[i].setText(raid.getDiskTable(i, 0));
    		}
    		
    		if(!diskButtons[i+4].getText().equals(raid.getDiskTable(i, 1)))
    		{
    			changeColor(i+4);
    			diskButtons[i+4].setText(raid.getDiskTable(i, 1));
    		}
    		
    		if(!diskButtons[i+8].getText().equals(raid.getDiskTable(i, 2)))
    		{
    			changeColor(i+8);
    			diskButtons[i+8].setText(raid.getDiskTable(i, 2));
    		}
    		
    		if(!diskButtons[i+12].getText().equals(raid.getHammingDisks(i, 0)))
    		{
    			changeColor(i+12);
    			diskButtons[i+12].setText(raid.getHammingDisks(i, 0));
    		}
    		
    		if(!diskButtons[i+16].getText().equals(raid.getDiskTable(i, 3)))
    		{
    			changeColor(i+16);
    			diskButtons[i+16].setText(raid.getDiskTable(i, 3));
    		}
    		
    		if(!diskButtons[i+20].getText().equals(raid.getHammingDisks(i, 1)))
    		{
    			changeColor(i+20);
    			diskButtons[i+20].setText(raid.getHammingDisks(i, 1));
    		}
    		
    		if(!diskButtons[i+24].getText().equals(raid.getHammingDisks(i, 2)))
    		{
    			changeColor(i+24);
    			diskButtons[i+24].setText(raid.getHammingDisks(i, 2));
    		}

    	}
    }
    
    public void changeColor(int i)
    {
    	if(diskButtons[i].getStyleClass().remove("red")) 
    	{
			diskButtons[i].setStyle("-fx-background-color: lightgreen;");
		    diskButtons[i].getStyleClass().add("green");
		} 
    	else 
    	{
			diskButtons[i].setStyle("-fx-background-color: indianred;");
			diskButtons[i].getStyleClass().remove("green");
			diskButtons[i].getStyleClass().add("red");
		}
    }
    
    public void resetColorTags()
    {
    	for(int i=0; i<28; i++)
    	{
    		diskButtons[i].getStyleClass().remove("red");
    		diskButtons[i].getStyleClass().remove("green");
    	}
    }
    
    		
    public void refresh(){
    	
    	for(int i=0; i<4; i++)
    	{
    		diskButtons[i].setText(raid.getDiskTable(i, 0));
    		diskButtons[i+4].setText(raid.getDiskTable(i, 1));
    		diskButtons[i+8].setText(raid.getDiskTable(i, 2));
    		diskButtons[i+12].setText(raid.getHammingDisks(i, 0));
    		diskButtons[i+16].setText(raid.getDiskTable(i, 3));
    		diskButtons[i+20].setText(raid.getHammingDisks(i, 1));
    		diskButtons[i+24].setText(raid.getHammingDisks(i, 2));
    		
    		diskButtons[i].setStyle(null);
    		diskButtons[i+4].setStyle(null);
    		diskButtons[i+8].setStyle(null);
    		diskButtons[i+12].setStyle(null);
    		diskButtons[i+16].setStyle(null);
    		diskButtons[i+20].setStyle(null);
    		diskButtons[i+24].setStyle(null); 		
    	}
    }
    
    @FXML
    public void changeSpecificBit(ActionEvent event)
    {
    	Node node = (Node) event.getSource();
    	String bitText = (String) node.getUserData();
    	int bit = Integer.parseInt(bitText);
    	addText(raid.errorSpecific(bit));
        addText(raid.toString() + "\n");
    	refreshColor();
    }

    @FXML
    public void calculate(){
        raid.fillDisks();
        raid.generateECC();
        addText(raid.toString() + "\n");
        resetColorTags();
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
        resetColorTags();
        refresh();
    }

    @FXML
    public void mainDiskError(){
        addText(raid.errorInDisks());
        addText(raid.toString() + "\n");
        refreshColor();
    }

    @FXML
    public void hammingDiskError(){
        addText(raid.errorInHammingDisks());
        addText(raid.toString() + "\n");
        refreshColor();
    }

    @FXML
    public void correctErrors(){
        addText(raid.fixBits());
        addText(raid.toString() + "\n");
        refreshColor();
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
