package windows;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Popup 
{
	public static void AlertBox(String text) 
	{
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		
		VBox root = new VBox();
		root.getStyleClass().add("back");
		root.setPadding(new Insets(5, 5, 5, 5));
		root.setSpacing(5);

		Label label = new Label(text);
		HBox buttons = new HBox();

		Button closeButton = new Button("Ok");
		closeButton.setOnAction(e -> stage.close());

		buttons.setAlignment(Pos.CENTER);
		buttons.getChildren().add(closeButton);

		root.getChildren().addAll(label, buttons);
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/style/login.css");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.showAndWait();
	}
}
