package controllers;

import com.sun.glass.ui.Size;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import javafx.animation.*;
import javafx.util.Duration;

public class Dashboard {

    @FXML private Pane ttablepane;
    @FXML private Pane statisticsPane;

    public void initialize() {
        LoadTimetable();
        LoadStatistics();
    }

    public void onOverviewClicked(){

        System.out.println("Overview Was Clicked");
    }

    public  void onClassesClicked(){

        System.out.println("Classes Was Clicked");
    }

    public void onTimetableClicked(){

        System.out.println("Timetable Was Clicked");
    }

    public void onMeetingsClicked(){

        System.out.println("Meetings Was Clicked");
    }

    public void onReportsClicked(){

        System.out.println("Reports Was Clicked");
    }

    public void onDatabasemanagementClicked(){

        System.out.println("Database Management Was Clicked");
    }


    public void LoadTimetable(){
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getResource("/fxml/DashboardElements/DashboardTimetable.fxml"));
            ttablepane.getChildren().add(root);
        } catch (IOException ex){
            Logger.getLogger(TimetableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LoadStatistics(){
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getResource("/fxml/DashboardElements/DashboardStatistics.fxml"));
            statisticsPane.getChildren().add(root);
        } catch (IOException ex){
            Logger.getLogger(TimetableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
