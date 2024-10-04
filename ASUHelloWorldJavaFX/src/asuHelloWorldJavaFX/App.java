package asuHelloWorldJavaFX;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class App extends Application {
	
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 700;
	
	public ArrayList<User> users;
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage) {
    	
    	System.out.println("ASU Hello World!");
    	System.out.println("It started!");
    	
    	InitialPage initPage = new InitialPage();
    	SetUserUpPage setUpPage = new SetUserUpPage();
    	LoginPage loginPage = new LoginPage();
    	HomePage homePage = new HomePage();
    	OTPSetupPage otpPage = new OTPSetupPage();

    	        
        initPage.btn.setOnAction(e -> {
        	primaryStage.setTitle("Set Up Page");
        	setUpPage.updateUser(initPage.textField.getText());
        	primaryStage.setScene(setUpPage.scene);
        });      
        setUpPage.btn.setOnAction(e -> {
        	primaryStage.setTitle("Home Page");
        	primaryStage.setScene(homePage.scene);
        });

        homePage.logout.setOnAction(e ->{
        	primaryStage.setTitle("Login Page");
        	primaryStage.setScene(loginPage.scene);
        });
        
        loginPage.btn.setOnAction(e ->{
        	//need to check if to be routed to set up user page
        	primaryStage.setTitle("Home Page");
        	primaryStage.setScene(homePage.scene);
        });
        loginPage.otplogin.setOnAction(e ->{
        	primaryStage.setTitle("OTP Page");
        	primaryStage.setScene(otpPage.scene);
        });
        
        otpPage.btn.setOnAction(e ->{
        	primaryStage.setTitle("Login Page");
        	primaryStage.setScene(loginPage.scene);
        });
        
    	primaryStage.setTitle("Initial Page");
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
    
    public boolean containsUsername(String s) {
    	for(int i=0;i<users.size();i++) {
    		if(users.get(i).username.equals(s)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    
    
    
    
    
    
}