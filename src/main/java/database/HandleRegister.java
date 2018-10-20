package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import scripts.Day;
import scripts.Week;
import sun.nio.ch.Net;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class HandleRegister
{
    public static ObservableList<Week> retrieveWeeksRegister(String weekStarting, String className) throws SQLException
    {
        long startTime = System.currentTimeMillis();

        ObservableList<Week> data = FXCollections.observableArrayList();

        Statement state = Networker.connection.createStatement();

        ResultSet result = state.executeQuery(String.format("SELECT * FROM register%s AS r JOIN students AS s ON r.StudentID=s.StudentID WHERE s.Class=\'%s\' ORDER BY s.Surname,s.Name ASC", weekStarting, className));

        while (result.next())
        {
            int id = result.getInt(1);

            String name = result.getString(29) + ", " + result.getString(28);

            ArrayList<Day> days = new ArrayList<>();

            for (int i = 0; i < 5; i++)
            {
                ArrayList<String> a = new ArrayList<>();
                a.add(0, result.getString((5 * i) + 2));
                a.add(1, result.getString((5 * i) + 3));
                a.add(2, result.getString((5 * i) + 4));
                a.add(3, result.getString((5 * i) + 5));
                a.add(4, result.getString((5 * i) + 6));
                Day d = new Day(a);
                days.add(d);
            }
            Week w = new Week(name, id, days);
            data.add(w);
        }

        long stopTime = System.currentTimeMillis();
        long runTime = stopTime - startTime;
        System.out.println("Register loaded in time: " + (float) runTime / 1000 + " seconds");

        return data;
    }

    public static void setEditedRegister(ObservableList<Week> newRegister, String weekStarting, String className) throws SQLException
    {
        long startTime = System.currentTimeMillis();

        for (Week student : newRegister)
        {
            int id = student.getId();

            ArrayList<Day> days = student.getDays();

            for (Day day : days)
            {
                String d = day.getDay();

                PreparedStatement pstate = Networker.connection.prepareStatement(String.format("UPDATE register%s SET " + d + "P1=?, " + d + "P2=?, " + d + "P3=?, " + d + "P4=?, " + d + "P5=? WHERE StudentID=%d", weekStarting, id));
                pstate.setString(1, day.getP1());
                pstate.setString(2, day.getP2());
                pstate.setString(3, day.getP3());
                pstate.setString(4, day.getP4());
                pstate.setString(5, day.getP5());

                pstate.executeUpdate();
            }
        }

        long stopTime = System.currentTimeMillis();
        long runTime = stopTime - startTime;
        System.out.println("Register saved in time: " + (float) runTime / 1000 + " seconds");
    }

    public static ArrayList<Object> retrieveStudentInfo(int studentID) throws SQLException, IOException
    {
        Statement state = Networker.connection.createStatement();

        ResultSet result = state.executeQuery(String.format("SELECT * FROM students WHERE StudentID=%d", studentID));

        result.next();

        ResultSet result2 = Networker.connection.createStatement().executeQuery(String.format("SELECT Image FROM sImages WHERE StudentID=%d", studentID));

        result2.next();

        BufferedImage bufferedImage = ImageIO.read(result2.getBinaryStream("Image"));

        Image imageFinal = SwingFXUtils.toFXImage(bufferedImage, null);

        ArrayList genericStudentInfo = new ArrayList();
        genericStudentInfo.add(imageFinal);
        genericStudentInfo.add(result.getString(2));
        genericStudentInfo.add(result.getString(3));
        genericStudentInfo.add(result.getString(4));
        genericStudentInfo.add(result.getInt(5));
        genericStudentInfo.add(result.getInt(6));
        genericStudentInfo.add(result.getInt(7));

        return genericStudentInfo;
    }

    public static void createWeekTable(String weekStarting) throws SQLException
    {
        Statement state = Networker.connection.createStatement();

        String sql = "CREATE TABLE `register%s` (\n" +
                "  `StudentID` int(11) NOT NULL,\n" +
                "  `MonP1` varchar(1) DEFAULT ' ',\n" +
                "  `MonP2` varchar(1) DEFAULT ' ',\n" +
                "  `MonP3` varchar(1) DEFAULT ' ',\n" +
                "  `MonP4` varchar(1) DEFAULT ' ',\n" +
                "  `MonP5` varchar(1) DEFAULT ' ',\n" +
                "  `TueP1` varchar(1) DEFAULT ' ',\n" +
                "  `TueP2` varchar(1) DEFAULT ' ',\n" +
                "  `TueP3` varchar(1) DEFAULT ' ',\n" +
                "  `TueP4` varchar(1) DEFAULT ' ',\n" +
                "  `TueP5` varchar(1) DEFAULT ' ',\n" +
                "  `WedP1` varchar(1) DEFAULT ' ',\n" +
                "  `WedP2` varchar(1) DEFAULT ' ',\n" +
                "  `WedP3` varchar(1) DEFAULT ' ',\n" +
                "  `WedP4` varchar(1) DEFAULT ' ',\n" +
                "  `WedP5` varchar(1) DEFAULT ' ',\n" +
                "  `ThuP1` varchar(1) DEFAULT ' ',\n" +
                "  `ThuP2` varchar(1) DEFAULT ' ',\n" +
                "  `ThuP3` varchar(1) DEFAULT ' ',\n" +
                "  `ThuP4` varchar(1) DEFAULT ' ',\n" +
                "  `ThuP5` varchar(1) DEFAULT ' ',\n" +
                "  `FriP1` varchar(1) DEFAULT ' ',\n" +
                "  `FriP2` varchar(1) DEFAULT ' ',\n" +
                "  `FriP3` varchar(1) DEFAULT ' ',\n" +
                "  `FriP4` varchar(1) DEFAULT ' ',\n" +
                "  `FriP5` varchar(1) DEFAULT ' ' \n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

        state.execute(String.format(sql, weekStarting));

        ResultSet result = Networker.connection.createStatement().executeQuery("SELECT StudentID FROM students");

        while (result.next())
        {
            Networker.connection.createStatement().execute(String.format("INSERT INTO register%s (StudentID) VALUES (%d)", weekStarting, result.getInt(1)));
        }
    }

    public static void addMerit(int studentID, int merits) throws SQLException
    {
        Statement state = Networker.connection.createStatement();

        ResultSet resultSet = Networker.connection.createStatement().executeQuery(String.format("SELECT Merits FROM students WHERE StudentID=%d", studentID));

        resultSet.next();

        int newMeritValue = resultSet.getInt(1) + merits;

        state.execute(String.format("UPDATE students SET Merits=%d WHERE StudentID=%d", newMeritValue, studentID));
    }

    public static void addDemerit(int studentID, int demerits) throws SQLException
    {
        Statement state = Networker.connection.createStatement();

        ResultSet resultSet = Networker.connection.createStatement().executeQuery(String.format("SELECT Dmerits FROM students WHERE StudentID=%d", studentID));

        resultSet.next();

        int newDemeritValue = resultSet.getInt(1) + demerits;

        state.execute(String.format("UPDATE students SET Dmerits=%d WHERE StudentID=%d", newDemeritValue, studentID));
    }

    public static LinkedHashMap[] getMeritsAndDemerits(String classID) throws SQLException
    {
        LinkedHashMap[] values = new LinkedHashMap[2];
        LinkedHashMap merits = new LinkedHashMap();
        LinkedHashMap demerits = new LinkedHashMap();

        ResultSet results = Networker.connection.createStatement().executeQuery(String.format("SELECT * FROM students WHERE Class='%s'", classID));

        while (results.next())
        {
            demerits.put(String.format("%s, %s", results.getString(3), results.getString(2)), results.getFloat(7));
            merits.put(String.format("%s, %s", results.getString(3), results.getString(2)), results.getFloat(6));
        }

        values[0] = merits;
        values[1] = demerits;

        return values;
    }
}