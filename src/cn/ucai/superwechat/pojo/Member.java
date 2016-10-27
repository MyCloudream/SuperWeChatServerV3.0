package cn.ucai.superwechat.pojo;

public class Member {
    private Integer mMemberId;

    private String mMemberUserName;

    private Integer mMemberGroupId;

    private String mMemberGroupHxid;

    private Integer mMemberPermission;

    public Integer getmMemberId() {
        return mMemberId;
    }

    public void setmMemberId(Integer mMemberId) {
        this.mMemberId = mMemberId;
    }

    public String getmMemberUserName() {
        return mMemberUserName;
    }

    public void setmMemberUserName(String mMemberUserName) {
        this.mMemberUserName = mMemberUserName == null ? null : mMemberUserName.trim();
    }

    public Integer getmMemberGroupId() {
        return mMemberGroupId;
    }

    public void setmMemberGroupId(Integer mMemberGroupId) {
        this.mMemberGroupId = mMemberGroupId;
    }

    public String getmMemberGroupHxid() {
        return mMemberGroupHxid;
    }

    public void setmMemberGroupHxid(String mMemberGroupHxid) {
        this.mMemberGroupHxid = mMemberGroupHxid == null ? null : mMemberGroupHxid.trim();
    }

    public Integer getmMemberPermission() {
        return mMemberPermission;
    }

    public void setmMemberPermission(Integer mMemberPermission) {
        this.mMemberPermission = mMemberPermission;
    }
}