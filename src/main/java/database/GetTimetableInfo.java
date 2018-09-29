package database;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetTimetableInfo {

    public static String DBPass = "//";


    //GETS TIMETABLE TITLES --------------------------------

    //P1 Title ----- CI:3
    public static String getP1Title(String username) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpsdb?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", DBPass);
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(String.format("select * from ttimetables where TeacherUsername=\"%s\"", username));
            while (result.next()) {
                if (result.getString(2).equals(username)) {
                    String P1 = result.getString(3);
                    return P1;
                }
            }
        }
        catch (Exception e) {
            windows.Popup.AlertBox("Error, Username may be incorrect. Could not find Data!");
        }
        return "Error";
    }
    //P2 Title ----- CI:4
    public static String getP2Title(String username) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpsdb?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", DBPass );
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(String.format("select * from ttimetables where TeacherUsername=\"%s\"", username));
            while (result.next()) {
                if (result.getString(2).equals(username)) {
                    String P2 = result.getString(4);
                    return P2;
                }
            }
        }
        catch (Exception e) {
            windows.Popup.AlertBox("Error, Username may be incorrect. Could not find Data!");
        }
        return "Error";
    }
    //P3 Title ----- CI:5
    public static String getP3Title(String username) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpsdb?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", DBPass);
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(String.format("select * from ttimetables where TeacherUsername=\"%s\"", username));
            while (result.next()) {
                if (result.getString(2).equals(username)) {
                    String P3 = result.getString(5);
                    return P3;
                }
            }
        }
        catch (Exception e) {
            windows.Popup.AlertBox("Error, Username may be incorrect. Could not find Data!");
        }
        return "Error";
    }
    //P4 Title ----- CI:6
    public static String getP4Title(String username) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpsdb?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", DBPass);
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(String.format("select * from ttimetables where TeacherUsername=\"%s\"", username));
            while (result.next()) {
                if (result.getString(2).equals(username)) {
                    String P4 = result.getString(6);
                    return P4;
                }
            }
        }
        catch (Exception e) {
            windows.Popup.AlertBox("Error, Username may be incorrect. Could not find Data!");
        }
        return "Error";
    }
    //P5 Title ----- CI:7
    public static String getP5Title(String username) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpsdb?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", DBPass);
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(String.format("select * from ttimetables where TeacherUsername=\"%s\"", username));
            while (result.next()) {
                if (result.getString(2).equals(username)) {
                    String P5 = result.getString(7);
                    return P5;
                }
            }
        }
        catch (Exception e) {
            windows.Popup.AlertBox("Error, Username may be incorrect. Could not find Data!");
        }
        return "Error";
    }
    //P4 Title ----- CI:8
    public static String getP6Title(String username) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpsdb?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", DBPass);
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(String.format("select * from ttimetables where TeacherUsername=\"%s\"", username));
            while (result.next()) {
                if (result.getString(2).equals(username)) {
                    String P6 = result.getString(8);
                    return P6;
                }
            }
        }
        catch (Exception e) {
            windows.Popup.AlertBox("Error, Username may be incorrect. Could not find Data!");
        }
        return "Error";
    }

    //GETS TIMETABLE CLASS --------------------------------

    //P1 Class ----- CI:9
    public static String getP1Class(String username) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpsdb?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", DBPass);
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(String.format("select * from ttimetables where TeacherUsername=\"%s\"", username));
            while (result.next()) {
                if (result.getString(2).equals(username)) {
                    String P1 = result.getString(9);
                    return P1;
                }
            }
        }
        catch (Exception e) {
            windows.Popup.AlertBox("Error, Username may be incorrect. Could not find Data!");
        }
        return "Error";
    }
    //P2 Class ----- CI:10
    public static String getP2Class(String username) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpsdb?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", DBPass );
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(String.format("select * from ttimetables where TeacherUsername=\"%s\"", username));
            while (result.next()) {
                if (result.getString(2).equals(username)) {
                    String P2 = result.getString(10);
                    return P2;
                }
            }
        }
        catch (Exception e) {
            windows.Popup.AlertBox("Error, Username may be incorrect. Could not find Data!");
        }
        return "Error";
    }
    //P3 Class ----- CI:11
    public static String getP3Class(String username) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpsdb?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", DBPass);
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(String.format("select * from ttimetables where TeacherUsername=\"%s\"", username));
            while (result.next()) {
                if (result.getString(2).equals(username)) {
                    String P3 = result.getString(11);
                    return P3;
                }
            }
        }
        catch (Exception e) {
            windows.Popup.AlertBox("Error, Username may be incorrect. Could not find Data!");
        }
        return "Error";
    }
    //P4 Class ----- CI:12
    public static String getP4Class(String username) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpsdb?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", DBPass);
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(String.format("select * from ttimetables where TeacherUsername=\"%s\"", username));
            while (result.next()) {
                if (result.getString(2).equals(username)) {
                    String P4 = result.getString(12);
                    return P4;
                }
            }
        }
        catch (Exception e) {
            windows.Popup.AlertBox("Error, Username may be incorrect. Could not find Data!");
        }
        return "Error";
    }
    //P5 Class ----- CI:13
    public static String getP5Class(String username) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpsdb?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", DBPass);
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(String.format("select * from ttimetables where TeacherUsername=\"%s\"", username));
            while (result.next()) {
                if (result.getString(2).equals(username)) {
                    String P5 = result.getString(13);
                    return P5;
                }
            }
        }
        catch (Exception e) {
            windows.Popup.AlertBox("Error, Username may be incorrect. Could not find Data!");
        }
        return "Error";
    }
    //P4 Class ----- CI:14
    public static String getP6Class(String username) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpsdb?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", DBPass);
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(String.format("select * from ttimetables where TeacherUsername=\"%s\"", username));
            while (result.next()) {
                if (result.getString(2).equals(username)) {
                    String P6 = result.getString(14);
                    return P6;
                }
            }
        }
        catch (Exception e) {
            windows.Popup.AlertBox("Error, Username may be incorrect. Could not find Data!");
        }
        return "Error";
    }

    //GETS TIMETABLE INFO --------------------------------

    //P1 Info ----- CI:15
    public static String getP1Info(String username) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpsdb?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", DBPass);
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(String.format("select * from ttimetables where TeacherUsername=\"%s\"", username));
            while (result.next()) {
                if (result.getString(2).equals(username)) {
                    String P1 = result.getString(15);
                    return P1;
                }
            }
        }
        catch (Exception e) {
            windows.Popup.AlertBox("Error, Username may be incorrect. Could not find Data!");
        }
        return "Error";
    }
    //P2 Info ----- CI:16
    public static String getP2Info(String username) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpsdb?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", DBPass );
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(String.format("select * from ttimetables where TeacherUsername=\"%s\"", username));
            while (result.next()) {
                if (result.getString(2).equals(username)) {
                    String P2 = result.getString(16);
                    return P2;
                }
            }
        }
        catch (Exception e) {
            windows.Popup.AlertBox("Error, Username may be incorrect. Could not find Data!");
        }
        return "Error";
    }
    //P3 Info ----- CI:17
    public static String getP3Info(String username) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpsdb?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", DBPass);
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(String.format("select * from ttimetables where TeacherUsername=\"%s\"", username));
            while (result.next()) {
                if (result.getString(2).equals(username)) {
                    String P3 = result.getString(17);
                    return P3;
                }
            }
        }
        catch (Exception e) {
            windows.Popup.AlertBox("Error, Username may be incorrect. Could not find Data!");
        }
        return "Error";
    }
    //P4 Info ----- CI:18
    public static String getP4Info(String username) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpsdb?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", DBPass);
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(String.format("select * from ttimetables where TeacherUsername=\"%s\"", username));
            while (result.next()) {
                if (result.getString(2).equals(username)) {
                    String P4 = result.getString(18);
                    return P4;
                }
            }
        }
        catch (Exception e) {
            windows.Popup.AlertBox("Error, Username may be incorrect. Could not find Data!");
        }
        return "Error";
    }
    //P5 Info ----- CI:19
    public static String getP5Info(String username) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpsdb?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", DBPass);
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(String.format("select * from ttimetables where TeacherUsername=\"%s\"", username));
            while (result.next()) {
                if (result.getString(2).equals(username)) {
                    String P5 = result.getString(19);
                    return P5;
                }
            }
        }
        catch (Exception e) {
            windows.Popup.AlertBox("Error, Username may be incorrect. Could not find Data!");
        }
        return "Error";
    }
    //P4 Info ----- CI:20
    public static String getP6Info(String username) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/simpsdb?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", DBPass);
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(String.format("select * from ttimetables where TeacherUsername=\"%s\"", username));
            while (result.next()) {
                if (result.getString(2).equals(username)) {
                    String P6 = result.getString(20);
                    return P6;
                }
            }
        }
        catch (Exception e) {
            windows.Popup.AlertBox("Error, Username may be incorrect. Could not find Data!");
        }
        return "Error";
    }
}