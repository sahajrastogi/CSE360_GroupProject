package asuHelloWorldJavaFX;

public class User {
	public boolean isAdmin = false;
	public boolean isStudent = false;
	public boolean isInstructor = false;
	public boolean passwordIsOTP;
	public boolean infoSetup;
	public String email = "";
	public String username = "";
	public char[] password;
	public String expireTime;
	public String firstName = "";
	public String middleName = "";
	public String lastName = "";
	public String preferredName = "";

	public User() {
		passwordIsOTP = true;
		infoSetup = false;
	}
	
	
}
