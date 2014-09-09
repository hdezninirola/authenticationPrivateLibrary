package ninirola;

public final class Authenticator {
	
	/**
	 * @param user User name
	 * @param pass User password
	 * @return true if login is correct
	 */
	public static boolean authenticate (String user, String pass) {
		if(user.equals("admin") && pass.equals("admin"))
			return true;
		return false;
	}

}
