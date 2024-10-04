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

public class OTPSetupPage {

	public Scene scene;
	public Button btn;
	public String currUser;
	public OTPSetupPage() {
		btn = new Button("Submit");
        
        
        Label userLabel = new Label("Username:");
        TextField userField = new TextField();
        
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        
        Label cPasswordLabel = new Label("Confirm Password:");
        PasswordField cPasswordField = new PasswordField();
        
       // btn.setOnAction(e -> {
//            if (passwordField.getText().equals(cPasswordField.getText())) {
//                System.out.println("User Information:");
//                System.out.println("First Name: " + fNameField.getText());
//                System.out.println("Middle Name: " + mNameField.getText());
//                System.out.println("Last Name: " + lNameField.getText());
//                System.out.println("Preferred Name: " + pNameField.getText());
//                System.out.println("e: " + eField.getText());
//            } else {
//                System.out.println("Passwords not matching");	
//            }
        //});
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(userLabel, 0, 0);
        grid.add(userField, 1, 0);
        grid.add(passwordLabel, 0, 6);
        grid.add(passwordField, 1, 6);
        grid.add(cPasswordLabel, 0, 7);
        grid.add(cPasswordField, 1, 7);
        grid.add(btn, 1, 8);
        scene = new Scene(grid, App.WIDTH, App.HEIGHT);
        
	}
	
	public void updateUser(String s) {
		currUser = s;
	}        

   
}

