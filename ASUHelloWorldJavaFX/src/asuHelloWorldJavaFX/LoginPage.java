package asuHelloWorldJavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoginPage {

	public Scene scene;
	public Button btn;
	public Button otplogin;

	public String currUser;
	public LoginPage() {
		btn = new Button("Submit");
		otplogin = new Button("New User");

        
        Label userLabel = new Label("Username:");
        TextField userField = new TextField();
        
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        
        Label otpLabel = new Label("OTP:");
        PasswordField otpField = new PasswordField();
        
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(userLabel, 0, 0);
        grid.add(userField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);

        grid.add(btn, 1, 2);
        
        grid.add(otpLabel, 0, 4);
        grid.add(otpField, 1, 4);
        grid.add(otplogin, 1, 5);

        scene = new Scene(grid, App.WIDTH, App.HEIGHT);
        
	}
	
	public void updateUser(String s) {
		currUser = s;
	}        

   
}

