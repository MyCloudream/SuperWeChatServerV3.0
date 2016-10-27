package cn.ucai.superwechat.pojo;

public class Contact {
    private Integer mContactId;

    private String mContactUserName;

    private String mContactCname;

    public Integer getmContactId() {
        return mContactId;
    }

    public void setmContactId(Integer mContactId) {
        this.mContactId = mContactId;
    }

    public String getmContactUserName() {
        return mContactUserName;
    }

    public void setmContactUserName(String mContactUserName) {
        this.mContactUserName = mContactUserName == null ? null : mContactUserName.trim();
    }

    public String getmContactCname() {
        return mContactCname;
    }

    public void setmContactCname(String mContactCname) {
        this.mContactCname = mContactCname == null ? null : mContactCname.trim();
    }
}