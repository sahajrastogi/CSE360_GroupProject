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
    	
    	
    	
    	//There are 100 dummy admin users with username a followed by a number and password a
    	for(int i=0;i<100;i++) {
	    	User convenience = new User();
	    	convenience.password = "a".toCharArray();
	    	convenience.username = ("a" + i);
	    	convenience.isAdmin = true;
	    	convenience.infoSetup = true;
	    	convenience.passwordIsInviteCode = false;
	    	users.add(convenience);
    	}
    	
    	System.out.println("ASU Hello World!");
    	System.out.println("It started!");
    	
    	//Initialize all pages in the flow of the program
    	InitialPage initPage = new InitialPage();
    	SetUserUpPage setUpPage = new SetUserUpPage();
    	LoginPage loginPage = new LoginPage();
    	HomePage homePage = new HomePage();
    	InvitePage invitePage = new InvitePage();
    	PasswordResetPage prPage = new PasswordResetPage();

    	
    	//Sets the action of the initialization page to go the login Page        
        initPage.btn.setOnAction(e -> {
        	System.out.println("Going to LoginPage");
        	loginPage.clearFields();
        	primaryStage.setTitle(loginPage.title);
        	primaryStage.setScene(loginPage.scene);
        });   
        
        
        //Sets the transition for the set up page to the home page and passes along user information
        setUpPage.btn.setOnAction(e -> {
        	//need to do alerts if invalid name or password
        	System.out.println("Going to HomePage");

        	setUpPage.updateUserInfo();
        	homePage.u = setUpPage.u;
			homePage.role = setUpPage.role;
			homePage.setSceneFromRole();
        	primaryStage.setTitle(homePage.title);
        	primaryStage.setScene(homePage.scene);
        });

        //sets transition for the home page
        homePage.logout.setOnAction(e ->{
        	System.out.println("Going to LoginPage");
        	loginPage.clearFields();
        	primaryStage.setTitle(loginPage.title);
        	primaryStage.setScene(loginPage.scene);
        });
        
        
        //Sets the transition for the normal login page
        loginPage.btn.setOnAction(e ->{
        	
        	//Attempt to login
        	int res = loginPage.login(users,loginPage.userField.getText(),loginPage.passwordField.getText(),loginPage.comboBox.getSelectionModel().getSelectedItem());
        	if(res == -1) {
        		//Error message
        		Alert alert = new Alert(AlertType.ERROR);
        		alert.setHeaderText("Error");
        		alert.setContentText("Invalid username, password or role selection");
        		alert.showAndWait();

        	} else if(res >= 0){
        		//Successful login
            	//Check if to be routed to set up user page
        		User u = users.get(res);
        		if(u.infoSetup) {
        			
        			//Pass information to home page
                	System.out.println("Going to HomePage - passing user information along");

        			homePage.u = u;

        			homePage.role = loginPage.comboBox.getSelectionModel().getSelectedItem();
        			homePage.setSceneFromRole();


		    		primaryStage.setTitle(homePage.title);
            		primaryStage.setScene(homePage.scene);
        		} else {
        			//Pass information to set up page
                	System.out.println("Going to SetUserUpPage - passing user information along");

        			setUpPage.u=u;
        			setUpPage.role = loginPage.comboBox.getSelectionModel().getSelectedItem();
        			setUpPage.clearFields();
        			primaryStage.setTitle(setUpPage.title);
            		primaryStage.setScene(setUpPage.scene);
        		}
        	} else {
        		if(res == -2) {
        			Alert alert = new Alert(AlertType.ERROR);
            		alert.setHeaderText("Error");
            		alert.setContentText("Reset password expired.");
            		alert.showAndWait();

        		} else {
        		res += 10;
        		res = -res;
        		User u = users.get(res);

        		//send to password reset page
            	System.out.println("Going to PasswordResetPage - passing user information along");

        		prPage.u=u;
        		prPage.clearFields();
    			primaryStage.setTitle(prPage.title);
        		primaryStage.setScene(prPage.scene);
        		}
        	}
        	
        });
        
        //Set the invite button for the login page
        loginPage.inviteLogin.setOnAction(e ->{
        	
        	//Confirm valid invite code
        	int res = invitePage.confirm(users,loginPage.inviteField.getText());
        	if(res == -1) {
        		//error message
        		Alert alert = new Alert(AlertType.ERROR);
        		alert.setHeaderText("Error");
        		alert.setContentText("Incorrect invite code");
        		alert.showAndWait();
        	} else {
        		//Pass information to Invite page
            	System.out.println("Going to Invite Page - passing user information along");

        		invitePage.u = users.get(res);
        		invitePage.clearFields();
	        	primaryStage.setTitle(invitePage.title);
	        	primaryStage.setScene(invitePage.scene);
        	}
        });
        
        //Set action for submit button on Invite page
        invitePage.btn.setOnAction(e ->{
        	
        	//confirm valid set up 
        	String temp = invitePage.updateUserInfo();
        	if (temp.equals("valid")) {
        		//Route to login page
            	System.out.println("Going to LoginPage");

        		loginPage.clearFields();
        		primaryStage.setTitle(loginPage.title);
            	primaryStage.setScene(loginPage.scene);
        	} else {
        		//Error message
        		Alert alert = new Alert(AlertType.ERROR);
        		alert.setHeaderText("Error");
        		alert.setContentText(temp);
        		alert.showAndWait();
        	}
        	
        });
        
        
        prPage.btn.setOnAction(e -> {
        	String temp = prPage.updateUserInfo();
        	if (temp.equals("valid")) {
        		//Route to login page
            	System.out.println("Going to LoginPage");
        		loginPage.clearFields();
        		primaryStage.setTitle(loginPage.title);
            	primaryStage.setScene(loginPage.scene);
        	} else {
        		//Error message
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
    
    //Find index of user from their username
    public static int indexFromUsername(String s) {
    	for(int i=0;i<users.size();i++) {
    		if(users.get(i).username.equals(s)) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    //Check whether the current list of Users contains a certain username
    public static boolean containsUsername(String s) {
    	for(int i=0;i<users.size();i++) {
    		if(users.get(i).username.equals(s)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    
    
    
    
    
    
}