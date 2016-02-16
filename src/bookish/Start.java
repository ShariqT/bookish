package bookish;

import java.util.Map;
import java.util.logging.Logger;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Start extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> userSession;
	private Logger log;
	
	public Start(){
		this.log = Logger.getLogger("start");
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.userSession = session;
		this.log.info("userSession is " + userSession.get("LOGGEDIN"));
	}
	
	public String execute(){
		return SUCCESS;
	}
	
	
	public String logout(){
		this.userSession.remove("LOGGEDIN");
		String url = "/";
		return SUCCESS;
	}

	public Map<String, Object> getSession(){
		return userSession;
	}
}
