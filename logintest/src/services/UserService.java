package services;

public class UserService {

	static String name = "lina";
	static String psw = "1234";

	public static boolean isValid(String username, String password) {
		if (username.equals(name) && password.equals(psw)) {
			return true;
		} else {
			return false;
		}
	}

}
