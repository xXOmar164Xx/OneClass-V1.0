package controllers;

import controllers.DashboardElements.TimetableController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dashboard {

    @FXML private Pane ttablepane;

    public void onOverviewClicked(){

        System.out.println("Overview Was Clicked");
        LoadTimetable("DashboardTimetable");
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

    public void LoadTimetable(String Timetable){

        Parent root;
        try{
            root = FXMLLoader.load(getClass().getResource("/fxml/DashboardElements/DashboardTimetable.fxml"));
            ttablepane.getChildren().add(root);
            TimetableController.fillTimetable("Omar");
        } catch (IOException ex){
            Logger.getLogger(TimetableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
