package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import scripts.Day;
import scripts.Week;

import java.sql.*;
import java.util.ArrayList;

public class HandleRegister
{
    public static ObservableList<Week> retrieveWeeksRegister(String weekStarting, String className) throws SQLException
    {
        long startTime = System.currentTimeMillis();

        ObservableList<Week> data = FXCollections.observableArrayList();

        Statement state = Networker.connection.createStatement();

        ResultSet result = state.executeQuery(String.format("SELECT * FROM Register%s WHERE StudentID IN (SELECT StudentID FROM Students WHERE Class=\'%s\')", weekStarting, className));

        while (result.next())
        {
            Statement state2 = Networker.connection.createStatement();

            ResultSet result2 = state2.executeQuery(String.format("SELECT Name, Surname FROM Students WHERE StudentID=%d", result.getInt(1)));

            result2.next();

            int id = result.getInt(1);

            String name = result2.getString(2) + ", " + result2.getString(1);

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

                PreparedStatement pstate = Networker.connection.prepareStatement(String.format("UPDATE Register%s SET " + d + "P1=?, " + d + "P2=?, " + d + "P3=?, " + d + "P4=?, " + d + "P5=? WHERE StudentID=%d", weekStarting, id));
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
}