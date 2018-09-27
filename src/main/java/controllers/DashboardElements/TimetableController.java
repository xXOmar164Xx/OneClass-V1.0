package controllers.DashboardElements;

import database.GetTimetableInfo;
import javafx.fxml.FXML;
import java.awt.*;

public class TimetableController {

    @FXML public static Label P1T;
    @FXML public static Label P2T;
    @FXML public static Label P3T;
    @FXML public static Label P4T;
    @FXML public static Label P5T;
    @FXML public static Label P6T;

    public static void fillTimetable(String username){
        P1T.setText("Hia");
        P2T.setText(GetTimetableInfo.getP2Title(username));
        P3T.setText(GetTimetableInfo.getP3Title(username));
        P4T.setText(GetTimetableInfo.getP4Title(username));
        P5T.setText(GetTimetableInfo.getP5Title(username));
        P6T.setText(GetTimetableInfo.getP6Title(username));
    }
}
