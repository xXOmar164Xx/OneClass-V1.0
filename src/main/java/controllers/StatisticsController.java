package controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import ring_loader_java.RingProgressIndicator;

public class StatisticsController {

    @FXML StackPane SSP1;
    @FXML StackPane SSP2;
    @FXML StackPane SSP3;

    public void initialize(){
        LoadCircles();
    }

    private void LoadCircles(){

        makeACircle(SSP1);
    }

    private void makeACircle(StackPane pp){

        RingProgressIndicator rpi = new RingProgressIndicator();
        rpi.setRingWidth(100);
        rpi.makeIndeterminate();

        pp.getChildren().add(rpi);
    }
}
