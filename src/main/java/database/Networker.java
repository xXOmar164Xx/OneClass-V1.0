package database;

import windows.Popup;

import java.sql.Connection;
import java.sql.DriverManager;

public class Networker
{
    public static String Chandru = "jdbc:mysql://127.0.0.1:8889/Registration";
    public static String Omar = "jdbc:mysql://127.0.0.1/simpsdb?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    public static String CONNECTION_STRING = Chandru;
    public static String USERNAME = "root";
    public static String PASSWORD = "root";

    public static Connection connection;

    public static void initiateConnection()
    {
        try
        {
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Popup.AlertBox("Connection Error");
        }
    }
}
