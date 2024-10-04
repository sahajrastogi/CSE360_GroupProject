package asuHelloWorldJavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HomePage {

	public Scene scene;
	public Button btn;
	public Button logout;

    public TextField textField;
    public String role;
    public User us;

	public HomePage() {
		logout = new Button("Logout");

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
        
        grid.setVgap(10);
        grid.setHgap(10);
        textField = new TextField();

        grid.add(textField,0,0);
        grid.add(logout,0,1);

        scene = new Scene(grid, App.WIDTH, App.HEIGHT);
        
        
	}
}
