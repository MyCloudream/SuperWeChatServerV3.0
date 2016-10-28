package cn.ucai.superwechat.pojo;

public class User {
	private String username;
	private String password;
	private String nick;
	private Avatar avatar;

	public User() {
		super();
	}

	public User(String username, String password, String nick) {
		super();
		this.username = username;
		this.password = password;
		this.nick = nick;
	}

	public User(String username, String password, String nick, Avatar avatar) {
		super();
		this.username = username;
		this.password = password;
		this.nick = nick;
		this.avatar = avatar;
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

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", nick=" + nick + ", avatar=" + avatar + "]";
	}
	
}