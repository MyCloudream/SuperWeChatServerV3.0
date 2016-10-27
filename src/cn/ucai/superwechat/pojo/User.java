package cn.ucai.superwechat.pojo;

public class User {
    private String mUserName;

    private String mUserPassword;

    private String mUserNick;

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName == null ? null : mUserName.trim();
    }

    public String getmUserPassword() {
        return mUserPassword;
    }

    public void setmUserPassword(String mUserPassword) {
        this.mUserPassword = mUserPassword == null ? null : mUserPassword.trim();
    }

    public String getmUserNick() {
        return mUserNick;
    }

    public void setmUserNick(String mUserNick) {
        this.mUserNick = mUserNick == null ? null : mUserNick.trim();
    }

	@Override
	public String toString() {
		return "User [mUserName=" + mUserName + ", mUserPassword=" + mUserPassword + ", mUserNick=" + mUserNick + "]";
	}
    
}