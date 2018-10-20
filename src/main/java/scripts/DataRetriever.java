package scripts;

import database.HandleRegister;
import database.Networker;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;
import sun.nio.ch.Net;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class DataRetriever
{
    public static AreaChart getAttendanceValues(String weekStarting, String classID) throws SQLException
    {
        ArrayList<LinkedHashMap> values = new ArrayList<>();
        ObservableList<Week> weekData = HandleRegister.retrieveWeeksRegister(weekStarting, classID);

        String[] lineTypes = new String[]{"Lates(l)", "Presents(p)", "Ill(i)"};

        ArrayList<String> titles = new ArrayList<>();

        for (String type : lineTypes)
            titles.add(type.substring(0, type.length() - 3));

        // Iterates through each line type
        for (int i = 0; i < lineTypes.length; i++)
        {
            LinkedHashMap line = new LinkedHashMap();

            // Iterates through each day
            for (int j = 0; j < 5; j++)
            {
                // Iterates through each period
                for (int k = 0; k < 5; k++)
                {
                    float daysValue = i;

                    // Iterates through each student
                    for (int l = 0; l < weekData.size(); l++)
                    {
                        if (weekData.get(l).getDays().get(j).getPeriods().get(k).equals(String.valueOf(lineTypes[i].toString().charAt(lineTypes[i].length() - 2)))) {
                            daysValue++;
                        }
                    }
                    line.put((DayOfWeek.of(j + 1).toString().substring(0, 3).toLowerCase() + " p" + (k + 1)), (daysValue));
                }
            }
            values.add(line);
        }
        return ChartGenerator.createAreaChart("Weeks Attendance Summary", "Period of Week", "Students", titles, values);
    }

    public static StackedBarChart getMeritValues(String classID) throws SQLException
    {
        LinkedHashMap[] data = HandleRegister.getMeritsAndDemerits(classID);

        String[] names = new String[]{"Merit", "Demerit"};

        StackedBarChart stackedBarChart = ChartGenerator.createStackedBarChart("Student Achievement Statistics", "Student Name", "Merit / Demerit", names, data);

        return stackedBarChart;
    }

    public static BarChart getAttendance(String weekStarting, int studentID) throws SQLException
    {
        LinkedHashMap data = new LinkedHashMap();

        ResultSet resultSet = Networker.connection.createStatement().executeQuery(String.format("SELECT * FROM register%s WHERE studentID=%d", weekStarting, studentID));

        resultSet.next();

        for (int i = 2; i <= 26; i++)
        {
            String val = resultSet.getString(i);
            if (data.containsKey(val))
            {
                data.put(val, ((Float)data.get(val) + 1));
            }
            else {
                data.put(resultSet.getString(i), 1f);
            }
        }

        return ChartGenerator.createBarChart("Attendance", "Type", "Amount", data);
    }
}
