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

public class SetUserUpPage {

	public Scene scene;
	public Button btn;
	public String currUser;
	public SetUserUpPage() {
		btn = new Button("Testing");
        
        Label fNameLabel = new Label("First Name:");
        TextField fNameField = new TextField();
        
        Label mNameLabel = new Label("Middle Name:");
        TextField mNameField = new TextField();
        
        Label lNameLabel = new Label("Last Name:");
        TextField lNameField = new TextField();
        
        Label pNameLabel = new Label("Preferred Name:");
        TextField pNameField = new TextField();
        
        Label eLabel = new Label("email:");
        TextField eField = new TextField();
        
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        
        Label cPasswordLabel = new Label("confirm Password:");
        PasswordField cPasswordField = new PasswordField();
        
        btn.setOnAction(e -> {
            if (passwordField.getText().equals(cPasswordField.getText())) {
                System.out.println("User Information:");
                System.out.println("First Name: " + fNameField.getText());
                System.out.println("Middle Name: " + mNameField.getText());
                System.out.println("Last Name: " + lNameField.getText());
                System.out.println("Preferred Name: " + pNameField.getText());
                System.out.println("e: " + eField.getText());
            } else {
                System.out.println("Passwords not matching");	
            }
        });
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(fNameLabel, 0, 0);
        grid.add(fNameField, 1, 0);
        grid.add(mNameLabel, 0, 1);
        grid.add(mNameField, 1, 1);
        grid.add(lNameLabel, 0, 2);
        grid.add(lNameField, 1, 2);
        grid.add(pNameLabel, 0, 3);
        grid.add(pNameField, 1, 3);
        grid.add(eLabel, 0, 4);
        grid.add(eField, 1, 4);
        grid.add(passwordLabel, 0, 5);
        grid.add(passwordField, 1, 5);
        grid.add(cPasswordLabel, 0, 6);
        grid.add(cPasswordField, 1, 6);
        grid.add(btn, 1, 7);
        scene = new Scene(grid, App.WIDTH, App.HEIGHT);

        
	}
	
	public void updateUser(String s) {
		currUser = s;
	}        

   
}

