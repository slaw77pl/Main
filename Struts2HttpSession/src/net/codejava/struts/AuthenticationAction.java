package net.codejava.struts;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AuthenticationAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7913172000682287411L;
	private Map<String, Object> sessionMap;
	private String userName;
	private String password;

	public String login() {
		String loggedUserName = null;

		// check if the userName is already stored in the session 
		if (sessionMap.containsKey("userName")) {
			loggedUserName = (String) sessionMap.get("userName");
		}
		if (loggedUserName != null && loggedUserName.equals("slawek")) {
			return SUCCESS;	// return welcome page
		}
		
		// if no userName stored in the session, 
		// check the entered userName and password
		if (userName != null && userName.equals("slawek") 
				&& password != null && password.equals("korman")) {
			
			// add userName to the session
			sessionMap.put("userName", userName);
			
			return SUCCESS;	// return welcome page
		}
		
		// in other cases, return login page
		return INPUT;
	}
	
	public String logout() {
		// remove userName from the session
		if (sessionMap.containsKey("userName")) {
			sessionMap.remove("userName");
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}