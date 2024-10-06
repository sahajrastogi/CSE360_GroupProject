package asuHelloWorldJavaFX;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoginPage {

	public Scene scene;
	public Button btn;
	public Button otplogin;
	public String title = "Login Page";
	public String currUser;
	
	public TextField userField;
    public PasswordField passwordField;
    public PasswordField otpField;
    public ComboBox<String> comboBox;

	public LoginPage() {
		btn = new Button("Submit");
		otplogin = new Button("Create Account");

        
		Label ret = new Label("For returning users:");
		Label first = new Label("For first time users:");
        Label userLabel = new Label("Username:");
        userField = new TextField();
        
        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();
        
        Label otpLabel = new Label("OTP:");
        otpField = new PasswordField();
        
        Label roleLabel = new Label("Select Role:");
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Student","Instructor","Admin");

        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(ret, 1, 0);
        grid.add(userLabel, 0, 1);
        grid.add(userField, 1, 1);
        grid.add(passwordLabel, 0, 2);
        grid.add(passwordField, 1, 2);
        grid.add(roleLabel, 0, 3);
        grid.add(comboBox, 1, 3);

        grid.add(btn, 1, 4);
        
        grid.add(first, 1, 6);
        grid.add(otpLabel, 0, 7);
        grid.add(otpField, 1, 7);
        grid.add(otplogin, 1, 8);

        BorderPane totalPage = new BorderPane();
        totalPage.setCenter(grid);
        grid.setAlignment(Pos.CENTER);
        scene = new Scene(totalPage, App.WIDTH, App.HEIGHT);
	}
	
	public void updateUser(String s) {
		currUser = s;
	}        
	
	public void clearFields() {
		userField.clear();
		passwordField.clear();
		otpField.clear();
	}

	public int login(ArrayList<User> users, String username, String password,String role) {
//		System.out.println(App.containsUsername(username));
//		System.out.println(username);
		for(int i = 0; i<users.size();i++) {
			
			User u = users.get(i);
			
			//confirm valid role
			if (!((role.equals("Instructor") && u.isInstructor) || (role.equals("Student") && u.isStudent) || (role.equals("Admin") && u.isAdmin))){
				continue;
			}
			
			//confirm that username and password match
			if(!u.passwordIsOTP && (new String(u.password)).equals(password) && username.equals(u.username)) {
				return i;
			}
		}
		return -1;
	}
   
}

