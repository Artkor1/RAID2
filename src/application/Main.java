package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage stage;
    public static StartWindow startWindow;
    public static WindowRandom windowRandom;
    public static WindowFile windowFile;
    public static RandomDataPane randomDataPane;
    public static FileDataPane fileDataPane;
    public static DiskPane diskPane;
    public static DiskCalculations diskCalculations;
    public static Raid raid;

    @Override
    public void start(Stage primaryStage) throws Exception{
        raid = new Raid();
        stage = primaryStage;
        startWindow = new StartWindow();
        startWindow.show();
    }

    public static void main(String[] args) {
        /**Raid raid= new Raid();
        raid.fillDisks();
        raid.generateECC();
        System.out.println(raid.toString());

        raid.errorInDisks();
        //raid.errorInHammingDisks();
        System.out.println(raid.toString());
        raid.fixBits();
        System.out.println(raid.toString());**/

        launch(args);
    }
}
