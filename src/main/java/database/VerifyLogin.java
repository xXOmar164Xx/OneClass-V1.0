package database;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VerifyLogin 
{
	public static boolean checkLogin(String username, String password)
	{
		try
		{
			Statement state = Networker.connection.createStatement();
			
			ResultSet result = state.executeQuery(String.format("select * from taccounts where Username=\"%s\"", username));
			
			while (result.next()) 
			{
				if (result.getString(2).equals(password))
				{
					return true;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return false;
	}
}