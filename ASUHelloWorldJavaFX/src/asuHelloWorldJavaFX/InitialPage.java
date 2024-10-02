package asuHelloWorldJavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class InitialPage {

	public Scene scene;
	public Button btn;
    public TextField textField;

	public InitialPage() {
		btn = new Button("What would you like your username to be?");
		StackPane layout = new StackPane();
        textField = new TextField();
        textField.setLayoutX(500);
        textField.setLayoutY(500);


        layout.getChildren().add(textField);
        layout.getChildren().add(btn);
        scene = new Scene(layout, App.WIDTH, App.HEIGHT);
        
        
	}
}
