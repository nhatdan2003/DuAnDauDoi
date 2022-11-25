package Utils;

import Entity.Account;

public class Auth {
	  public static Account userName = null;
	  
	  public static void clear() {
	    userName = null;
	  }
	  
	  public static boolean isLogin() {
	    return (userName != null);
	  }
	  
	  public static boolean isAdmin() {
	    return (isLogin() && userName.isRole());
	  }
	}