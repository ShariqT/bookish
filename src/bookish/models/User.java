package bookish.models;

import java.util.Date;

public class User {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int id;
	private String username;
	private String password;
	private Date joined;
	
	public User(){
		
		this.joined = new Date();
	}
	
	public User(String username, String password, Date date_joined){
		this.username = username;
		this.password = password;
		this.joined = date_joined;
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

	public Date getJoined() {
		return joined;
	}

	public void setJoined(Date joined) {
		this.joined = joined;
	}
	
	
}
