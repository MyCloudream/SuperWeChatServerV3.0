package cn.ucai.superwechat.pojo;

public class Avatar {
	private Integer id;
	private String suffix;
	private String type;
	private String uptime;

	public Avatar() {
		super();
	}

	public Avatar(String suffix, String type, String uptime) {
		super();
		this.suffix = suffix;
		this.type = type;
		this.uptime = uptime;
	}
	
	public Avatar(Integer id, String suffix, String type, String uptime) {
		super();
		this.id = id;
		this.suffix = suffix;
		this.type = type;
		this.uptime = uptime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUptime() {
		return uptime;
	}

	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	@Override
	public String toString() {
		return "Avatar [id=" + id + ", suffix=" + suffix + ", type=" + type + ", uptime=" + uptime + "]";
	}

}