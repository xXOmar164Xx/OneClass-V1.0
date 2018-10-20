package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dashboard {

    public String currentPannel;
    @FXML private Pane BasePane;

    public void initialize() {
        OverviewMerge();
    }

    public void onOverviewClicked(){
        ClearMain();
        OverviewMerge();
    }

    public  void onClassesClicked(){
        ClearMain();
        LoadClasses();
    }

    public void onTimetableClicked(){
        ClearMain();
        System.out.println("Timetable Was Clicked");
    }

    public void onMeetingsClicked(){
        ClearMain();
        MeetingsMerge();
    }

    public void onReportsClicked(){
        ClearMain();
        System.out.println("Reports Was Clicked");
    }

    public void onDatabasemanagementClicked(){
        ClearMain();
        System.out.println("Database Management Was Clicked");
    }

    public void ClearMain(){
        BasePane.getChildren().clear();
    }

    public void LoadTimetable(Pane panee){
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getResource("/fxml/DashboardElements/DashboardTimetable.fxml"));
            panee.getChildren().add(root);
        } catch (IOException ex){
            Logger.getLogger(TimetableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LoadStatistics(Pane panee){
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getResource("/fxml/DashboardElements/DashboardStatistics.fxml"));
            panee.getChildren().add(root);
        } catch (IOException ex){
            Logger.getLogger(TimetableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void OverviewMerge(){
        VBox OM_Main_Pane = new VBox();
        OM_Main_Pane.minHeight(724);
        OM_Main_Pane.minWidth(525);

        Pane OMPaneTop = new Pane();
        OMPaneTop.minHeight(724);
        OMPaneTop.minWidth(262.5);

        Pane OMPaneBottom = new Pane();
        OMPaneBottom.minHeight(724);
        OMPaneBottom.minWidth(262.5);

        LoadStatistics(OMPaneTop);
        LoadTimetable(OMPaneBottom);

        OM_Main_Pane.getChildren().add(OMPaneTop);
        OM_Main_Pane.getChildren().add(OMPaneBottom);

        BasePane.getChildren().add(OM_Main_Pane);
        currentPannel = "Overview";
    }

    public void MeetingsMerge(){
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getResource("/fxml/DashboardElements/Meetings.fxml"));
            BasePane.getChildren().add(root);
        } catch (IOException ex){
            Logger.getLogger(TimetableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LoadClasses()
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/DashboardElements/ClassView.fxml"));
            BasePane.getChildren().add(root);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
