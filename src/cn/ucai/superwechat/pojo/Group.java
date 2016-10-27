package cn.ucai.superwechat.pojo;

public class Group {
    private Integer mGroupId;

    private String mGroupHxid;

    private String mGroupName;

    private String mGroupDescription;

    private String mGroupOwner;

    private String mGroupLastModifiedTime;

    private Integer mGroupMaxUsers;

    private Integer mGroupAffiliationsCount;

    private Integer mGroupIsPublic;

    private Integer mGroupAllowInvites;

    public Integer getmGroupId() {
        return mGroupId;
    }

    public void setmGroupId(Integer mGroupId) {
        this.mGroupId = mGroupId;
    }

    public String getmGroupHxid() {
        return mGroupHxid;
    }

    public void setmGroupHxid(String mGroupHxid) {
        this.mGroupHxid = mGroupHxid == null ? null : mGroupHxid.trim();
    }

    public String getmGroupName() {
        return mGroupName;
    }

    public void setmGroupName(String mGroupName) {
        this.mGroupName = mGroupName == null ? null : mGroupName.trim();
    }

    public String getmGroupDescription() {
        return mGroupDescription;
    }

    public void setmGroupDescription(String mGroupDescription) {
        this.mGroupDescription = mGroupDescription == null ? null : mGroupDescription.trim();
    }

    public String getmGroupOwner() {
        return mGroupOwner;
    }

    public void setmGroupOwner(String mGroupOwner) {
        this.mGroupOwner = mGroupOwner == null ? null : mGroupOwner.trim();
    }

    public String getmGroupLastModifiedTime() {
        return mGroupLastModifiedTime;
    }

    public void setmGroupLastModifiedTime(String mGroupLastModifiedTime) {
        this.mGroupLastModifiedTime = mGroupLastModifiedTime == null ? null : mGroupLastModifiedTime.trim();
    }

    public Integer getmGroupMaxUsers() {
        return mGroupMaxUsers;
    }

    public void setmGroupMaxUsers(Integer mGroupMaxUsers) {
        this.mGroupMaxUsers = mGroupMaxUsers;
    }

    public Integer getmGroupAffiliationsCount() {
        return mGroupAffiliationsCount;
    }

    public void setmGroupAffiliationsCount(Integer mGroupAffiliationsCount) {
        this.mGroupAffiliationsCount = mGroupAffiliationsCount;
    }

    public Integer getmGroupIsPublic() {
        return mGroupIsPublic;
    }

    public void setmGroupIsPublic(Integer mGroupIsPublic) {
        this.mGroupIsPublic = mGroupIsPublic;
    }

    public Integer getmGroupAllowInvites() {
        return mGroupAllowInvites;
    }

    public void setmGroupAllowInvites(Integer mGroupAllowInvites) {
        this.mGroupAllowInvites = mGroupAllowInvites;
    }
}