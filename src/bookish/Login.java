package bookish;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.catalina.tribes.util.Logs;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport implements SessionAware{
	
	private Map<String, Object> userSession;
	
	public static final long serialVersionUID = 1L;
	
	private ArrayList<String> loginerrors;
	
	private String username;
	private String password;
	
	public Login(){
		this.loginerrors = new ArrayList<String>();
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.userSession = session;
	}
	
	public String execute() throws Exception{
		
		return INPUT;
	}

	
	public String process() throws Exception{
		Logger log = Logger.getLogger("login");
		log.info("username equals " + username);
		ArrayList<String> errors = this.getLoginerrors();
		if (this.getUsername().isEmpty()){
			errors.add("username");
		}
		if(password.isEmpty()){
			errors.add("password");
		}
		
		log.info("number of errors is" + String.valueOf(errors.size()));
		if(errors.size() == 0){
			userSession.put("LOGGEDIN", username);
			String url = "/";
			return SUCCESS;
		}
		return INPUT;
	}
	public ArrayList<String> getLoginerrors() {
		return this.loginerrors;
	}

	public void setLoginerrors(ArrayList<String> loginerrors) {
		this.loginerrors = loginerrors;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	

}
