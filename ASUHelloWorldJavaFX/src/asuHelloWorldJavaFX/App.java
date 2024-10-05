package asuHelloWorldJavaFX;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class App extends Application {
	
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 700;
	
	public static ArrayList<User> users;
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage) {
    	
    	users = new ArrayList<User>();
    	User first = new User();
    	first.password = "first".toCharArray();
    	first.isAdmin = true;
    	users.add(first);
    	
    	
    	System.out.println("ASU Hello World!");
    	System.out.println("It started!");
    	
    	InitialPage initPage = new InitialPage();
    	SetUserUpPage setUpPage = new SetUserUpPage();
    	LoginPage loginPage = new LoginPage();
    	HomePage homePage = new HomePage();
    	OtpPage otpPage = new OtpPage();

    	        
        initPage.btn.setOnAction(e -> {
        	//done
        	loginPage.clearFields();
        	primaryStage.setTitle(loginPage.title);
        	primaryStage.setScene(loginPage.scene);
        });   
        
        
        setUpPage.btn.setOnAction(e -> {
        	//need to do alerts if invalid name or password
        	setUpPage.updateUserInfo();
        	homePage.u = setUpPage.u;
			homePage.role = setUpPage.role;
			homePage.setSceneFromRole();
        	primaryStage.setTitle(homePage.title);
        	primaryStage.setScene(homePage.scene);
        });

        homePage.logout.setOnAction(e ->{
        	//probably done
        	loginPage.clearFields();
        	primaryStage.setTitle(loginPage.title);
        	primaryStage.setScene(loginPage.scene);
        });
        
        loginPage.btn.setOnAction(e ->{
        	
        	int res = loginPage.login(users,loginPage.userField.getText(),loginPage.passwordField.getText(),loginPage.comboBox.getSelectionModel().getSelectedItem());
        	if(res == -1) {
        		//error message
        		Alert alert = new Alert(AlertType.ERROR);
        		alert.setHeaderText("Error");
        		alert.setContentText("Invalid username, password or role selection");
        		alert.showAndWait();

        	} else {
            	//need to check if to be routed to set up user page
        		User u = users.get(res);
        		if(u.infoSetup) {
        			homePage.u = u;
        			homePage.role = loginPage.comboBox.getSelectionModel().getSelectedItem();
		    		//role selection logic needed as well
		    		//homepage render function
		    		primaryStage.setTitle(homePage.title);
            		primaryStage.setScene(homePage.scene);
        		} else {
        			setUpPage.u=u;
        			setUpPage.role = loginPage.comboBox.getSelectionModel().getSelectedItem();
        			setUpPage.clearFields();
        			primaryStage.setTitle(setUpPage.title);
            		primaryStage.setScene(setUpPage.scene);
        		}
        	}
        	
        });
        loginPage.otplogin.setOnAction(e ->{
        	
        	int res = otpPage.confirm(users,loginPage.otpField.getText());
        	if(res == -1) {
        		//error message
        		Alert alert = new Alert(AlertType.ERROR);
        		alert.setHeaderText("Error");
        		alert.setContentText("Incorrect OTP");
        		alert.showAndWait();
        	} else {
        		otpPage.u = users.get(res);
        		otpPage.clearFields();
	        	primaryStage.setTitle(otpPage.title);
	        	primaryStage.setScene(otpPage.scene);
        	}
        });
        
        otpPage.btn.setOnAction(e ->{
        	String temp = otpPage.updateUserInfo();
        	if (temp.equals("valid")) {
        		loginPage.clearFields();
        		primaryStage.setTitle(loginPage.title);
            	primaryStage.setScene(loginPage.scene);
        	} else {
        		//error message
        		Alert alert = new Alert(AlertType.ERROR);
        		alert.setHeaderText("Error");
        		alert.setContentText(temp);
        		alert.showAndWait();
        	}
        	
        });
        
    	primaryStage.setTitle("Welcome Page");
        primaryStage.setScene(initPage.scene); // Start with Scene 1
        primaryStage.show();
        
        
    }
    
    public int indexFromUsername(String s) {
    	for(int i=0;i<users.size();i++) {
    		if(users.get(i).username.equals(s)) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    public static boolean containsUsername(String s) {
    	for(int i=0;i<users.size();i++) {
    		if(users.get(i).username.equals(s)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    
    
    
    
    
    
}