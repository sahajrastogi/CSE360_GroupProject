package asuHelloWorldJavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

        grid.add(intro,0,0);
        grid.add(logout,0,1);
        
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

