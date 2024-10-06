package asuHelloWorldJavaFX;

import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HomePage {

	public Scene scene;
	public Button btn;
	public Button logout;

    public String role;
    public User u;
    public String title = "Home Page";

	public HomePage() {
		
		logout = new Button("Logout");

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
        
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(logout,0,1);

        scene = new Scene(grid, App.WIDTH, App.HEIGHT);
	}
	
	//Set scenes differently based on the role they logged in with
	public void setSceneFromRole(){
		if(role == "Student") {
			setStudentScene();
		} else if (role.equals("Admin")) {
			setAdminScene();
		} else if(role.equals("Instructor")) {
			setInstructorScene();
		}
	}
	
	
	public void setAdminScene() {

		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
        
        grid.setVgap(10);
        grid.setHgap(10);
        Label intro = new Label("Your name is " + u.preferredName + " and you are a " + role);

        
        Label otpGenerate = new Label("Generate a one-time code for a new user:");
        
        Label roleLabel = new Label("Select Role:");
        Label otpLabel = new Label("");

        ComboBox comboBox = new ComboBox<>();
		Button btn = new Button("Submit");
        comboBox.getItems().addAll("Student","Instructor","Admin");
        
        
        grid.add(otpGenerate, 0, 0);
        grid.add(otpLabel, 1, 0);

        grid.add(roleLabel,0,1);
        GridPane.setHalignment(roleLabel,HPos.RIGHT);

        grid.add(comboBox,1,1);
        grid.add(btn,1,2);
        
        btn.setOnAction(e ->{
        	
        	//check roleLabel selected
        	if(comboBox.getValue() == null) {
        		//Error message
        		Alert alert = new Alert(AlertType.ERROR);
        		alert.setHeaderText("Error");
        		alert.setContentText("Select a role for the user.");
        		alert.showAndWait();
        	} else {
	        	//generate OTP randomly
	        	Random random = new Random();
	        	String otp = "";
	        	String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	        	for(int i=0;i<10;i++) {
	        		int x = random.nextInt(chars.length());
	        		otp += (chars.charAt(x));
	        	}
	        	otpLabel.setText(otp);
	        	//add to Users array
	        	User next = new User();
	        	next.password = otp.toCharArray();
	        	next.passwordIsOTP = true;
	        	next.infoSetup = false;
	        	if(comboBox.getValue().equals("Admin")) {
	        		next.isAdmin = true;
	        	} else if (comboBox.getValue().equals("Student")){
	        		next.isStudent = true;
	        	} else if(comboBox.getValue().equals("Instructor")) {
	        		next.isInstructor = true;
	        	}
	        	App.users.add(next);	        	
        	}
        });


        grid.add(logout,0,10);
        
        BorderPane totalPage = new BorderPane();
        totalPage.setCenter(grid);
        grid.setAlignment(Pos.CENTER);
        scene = new Scene(totalPage, App.WIDTH, App.HEIGHT);
	}
	
	public void setStudentScene() {

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
        
        grid.setVgap(10);
        grid.setHgap(10);
        Label intro = new Label("Your name is " + u.preferredName + " and you are a " + role);

        grid.add(intro,0,0);
        grid.add(logout,0,1);
        
        BorderPane totalPage = new BorderPane();
        totalPage.setCenter(grid);
        grid.setAlignment(Pos.CENTER);
        scene = new Scene(totalPage, App.WIDTH, App.HEIGHT);
	}
	
	public void setInstructorScene() {

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
        
        grid.setVgap(10);
        grid.setHgap(10);
        Label intro = new Label("Your name is " + u.preferredName + " and you are a " + role);

        grid.add(intro,0,0);
        grid.add(logout,0,1);
        
        BorderPane totalPage = new BorderPane();
        totalPage.setCenter(grid);
        grid.setAlignment(Pos.CENTER);
        scene = new Scene(totalPage, App.WIDTH, App.HEIGHT);
	}
}

