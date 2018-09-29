package controllers;

import database.GetTimetableInfo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class TimetableController {

    @FXML public Label P1T;
    @FXML public Label P2T;
    @FXML public Label P3T;
    @FXML public Label P4T;
    @FXML public Label P5T;
    @FXML public Label P6T;

    @FXML public Label CT1;
    @FXML public Label CT2;
    @FXML public Label CT3;
    @FXML public Label CT4;
    @FXML public Label CT5;
    @FXML public Label CT6;

    @FXML public Label EI1;
    @FXML public Label EI2;
    @FXML public Label EI3;
    @FXML public Label EI4;
    @FXML public Label EI5;
    @FXML public Label EI6;

    String Usern = "Omar";

    public void initialize() {
        fillTT(Usern);
    }

    public void fillTT(String User){
        P1T.setText(GetTimetableInfo.getP1Title(User));
        P2T.setText(GetTimetableInfo.getP2Title(User));
        P3T.setText(GetTimetableInfo.getP3Title(User));
        P4T.setText(GetTimetableInfo.getP4Title(User));
        P5T.setText(GetTimetableInfo.getP5Title(User));
        P6T.setText(GetTimetableInfo.getP6Title(User));

        CT1.setText(GetTimetableInfo.getP1Class(User));
        CT2.setText(GetTimetableInfo.getP2Class(User));
        CT3.setText(GetTimetableInfo.getP3Class(User));
        CT4.setText(GetTimetableInfo.getP4Class(User));
        CT5.setText(GetTimetableInfo.getP5Class(User));
        CT6.setText(GetTimetableInfo.getP6Class(User));

        EI1.setText(GetTimetableInfo.getP1Info(User));
        EI2.setText(GetTimetableInfo.getP2Info(User));
        EI3.setText(GetTimetableInfo.getP3Info(User));
        EI4.setText(GetTimetableInfo.getP4Info(User));
        EI5.setText(GetTimetableInfo.getP5Info(User));
        EI6.setText(GetTimetableInfo.getP6Info(User));
    }
}
