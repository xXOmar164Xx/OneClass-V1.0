package controllers;

import java.sql.ResultSet;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import database.Networker;

public class meetingsController {

    @FXML ListView pastMeetingsLV;
    @FXML ListView upcommingMeetingsLV;
    @FXML ListView laterMeetingsLV;

    public void initialize(){
        fillPPF("Omar", "Past", pastMeetingsLV);
        fillPPF("Omar", "Upcomming", upcommingMeetingsLV);
        fillPPF("Omar", "Later", laterMeetingsLV);
    }

    public void fillPPF(String username, String checkFor, ListView lv){
        try {
            Statement state = Networker.connection.createStatement();
            ResultSet result = state.executeQuery(String.format("select * from tmeetings where teacherUsername=\"%s\"", username));
            while (result.next()){
                if (result.getString(7).toLowerCase().equals(checkFor.toLowerCase())){
                    lv.getItems().add(result.getString(4) + " -//- " + result.getString(3));
                }
            }
        }
        catch (Exception e){
            System.out.println("ERRORR");
        }
    }

    public void updateInfo(){

    }
}
