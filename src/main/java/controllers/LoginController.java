package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import database.VerifyLogin;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import windows.Popup;

public class LoginController
{
	@FXML AnchorPane root;
	@FXML TextField usernameInput;
	@FXML PasswordField passwordInput;
	
	public void initialize()
	{
	}
	
	@FXML 
	public void onLoginDown() {
		if (VerifyLogin.checkLogin(usernameInput.getText(), passwordInput.getText()))
		{
			try {
				startDashboard();
				((Stage)root.getScene().getWindow()).close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else
		{
			Popup.AlertBox("Account not found...");
		}
	}

	public void startDashboard() throws Exception {
		Stage window = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Dashboard.fxml"));
		Scene scene1 = new Scene(root);
		window.setScene(scene1);
		window.setTitle("Dashboard");
		window.setResizable(true);
		window.show();
	}
}