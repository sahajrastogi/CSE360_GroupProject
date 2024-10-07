package asuHelloWorldJavaFX;

import java.time.LocalTime;

public class User {
	public boolean isAdmin = false;
	public boolean isStudent = false;
	public boolean isInstructor = false;
	public boolean passwordIsInviteCode;
	public boolean passwordIsResetOTP;
	public LocalTime expireTime;
	public boolean infoSetup;
	public String email = "";
	public String username = "";
	public char[] password;
	public String firstName = "";
	public String middleName = "";
	public String lastName = "";
	public String preferredName = "";

	public User() {
		passwordIsInviteCode = true;
		infoSetup = false;
		passwordIsResetOTP = false;
	}
	
	
}
