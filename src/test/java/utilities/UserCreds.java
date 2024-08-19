package utilities;

public class UserCreds {
	private static String email;
	private static String password;

	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		UserCreds.email = email;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		UserCreds.password = password;
	}

	public static void printcreds() {
		System.out.println("email" + getEmail());
		System.out.println("password" + getPassword());
	}
}