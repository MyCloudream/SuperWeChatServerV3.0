package cn.ucai.superwechat.pojo;

public class User {
	private String username;
	private String password;
	private String nick;
	private String suffix;
	private String uptime;
	public User() {
		super();
	}

	public User(String username, String password, String nick) {
		super();
		this.username = username;
		this.password = password;
		this.nick = nick;
	}

	public User(String username, String password, String nick, String suffix,String uptime) {
		super();
		this.username = username;
		this.password = password;
		this.nick = nick;
		this.suffix = suffix;
		this.uptime = uptime;
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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getUptime() {
		return uptime;
	}

	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", nick=" + nick + ", suffix=" + suffix
				+ ", uptime=" + uptime + "]";
	}
	
}