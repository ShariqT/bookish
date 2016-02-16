package bookish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import bookish.models.UserDAO;

public class Join extends ActionSupport implements SessionAware{
		private Map<String,Object> userSession;
		
		private String username;
		private String password;
		private ArrayList<String> joinerrors;
		
		public Join(){
			this.joinerrors = new ArrayList<String>();
		}
		
		public void setSession(Map<String,Object> session){
			this.userSession = session;
		}
		
		public String execute(){
			return INPUT;
		}
		
		public String process(){
			this.joinerrors.clear();
			if(username.isEmpty()){
				this.joinerrors.add("username");
			}
			
			if(password.isEmpty()){
				this.joinerrors.add("password");
			}
			
			if(this.joinerrors.size() == 0){
				String url = "/";
				try{
					addNewUser(username, password);
				}catch(Exception e){
					this.joinerrors.add("dberror");
					this.joinerrors.add("username");
					this.joinerrors.add("password");
					String errormsg = e.getMessage();
					ValueStack stack = ActionContext.getContext().getValueStack();
					Map<String, Object> context = new HashMap<String, Object>();
					context.put("errormsg", errormsg);
					stack.push(context);
					return INPUT;
				}
				this.userSession.put("LOGGEDIN", username);
				return SUCCESS;
			}
			
			
			return INPUT;
		}
		
		
		protected void addNewUser(String username, String password) throws Exception{
			try{
				UserDAO userDAO = new UserDAO();
				userDAO.addUser(username,  password);
			}catch(Exception e){
				throw e;
			}
			
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

		public ArrayList<String> getJoinerrors() {
			return joinerrors;
		}

		public void setJoinerrors(ArrayList<String> joinerrors) {
			this.joinerrors = joinerrors;
		}
		
		
		
		
		
		
		
}
