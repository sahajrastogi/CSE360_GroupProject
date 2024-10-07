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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class InvitePage {

	public Scene scene;
	public Button btn;
	public String currUser;
	public String title = "Invite Page";

	// public int currUserIndex;
	public User u;

	public TextField userField;
	public PasswordField passwordField;
	public PasswordField cPasswordField;

	public InvitePage() {
		btn = new Button("Create Account");

		Label userLabel = new Label("Username:");
		userField = new TextField();

		Label passwordLabel = new Label("Password:");
		passwordField = new PasswordField();

		Label cPasswordLabel = new Label("Confirm Password:");
		cPasswordField = new PasswordField();

		Label create = new Label("Create a username and password:");

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));

		grid.setVgap(10);
		grid.setHgap(10);

		grid.add(create, 0, 0);

		grid.add(userLabel, 0, 1);
		grid.add(userField, 1, 1);
		grid.add(passwordLabel, 0, 2);
		grid.add(passwordField, 1, 2);
		grid.add(cPasswordLabel, 0, 3);
		grid.add(cPasswordField, 1, 3);
		grid.add(btn, 1, 4);

		BorderPane totalPage = new BorderPane();
		totalPage.setCenter(grid);
		grid.setAlignment(Pos.CENTER);
		scene = new Scene(totalPage, App.WIDTH, App.HEIGHT);

	}

	public void updateUser(String s) {
		currUser = s;
	}

	public int confirm(ArrayList<User> users, String invite) {
		for (int i = 0; i < users.size(); i++) {
			User us = users.get(i);

			// need to check expire time here
			if (us.passwordIsInviteCode && (new String(us.password)).equals(invite)) {
				return i;
			}
		}
		return -1;
	}

	public String updateUserInfo() {
		// retrieve username
		String username = userField.getText();

		// retrieve password
		String password = passwordField.getText();
		String cpassword = cPasswordField.getText();

		// Username and password checks
		if (App.containsUsername(username)) {
			return "Username taken";
		}

		if (username.length() < 5)
			return "Username must be at least 5 characters long";

		if (!username.matches("[a-zA-Z0-9]+"))
			return "Username must only contain letters and numbers";

		if (password.length() < 8)
			return "Password must be at least 8 characters long";

		if (!password.matches(".*[A-Z].*"))
			return "Password must contain at least one uppercase character";

		if (password.contains(" "))
			return "Password may not contain any spaces";

		if (password.matches("[a-zA-Z0-9]+"))
			return "Password must contain at least one special character";

		if (password.equals(cpassword)) {
			// User u = users.get(currUserIndex);
			u.username = username;
			u.password = password.toCharArray();
			u.passwordIsInviteCode = false;
			return "valid";
		}
		return "Password and confirmation don't match";
	}

	public void clearFields() {
		userField.clear();
		passwordField.clear();
		cPasswordField.clear();
	}

}
