package cn.ucai.superwechat.pojo;

public class Avatar {
    private Integer mAvatarId;

    private String mAvatarUserName;

    private String mAvatarSuffix;

    private String mAvatarPath;

    private Integer mAvatarType;

    private String mAvatarLastUpdateTime;

    public Integer getmAvatarId() {
        return mAvatarId;
    }

    public void setmAvatarId(Integer mAvatarId) {
        this.mAvatarId = mAvatarId;
    }

    public String getmAvatarUserName() {
        return mAvatarUserName;
    }

    public void setmAvatarUserName(String mAvatarUserName) {
        this.mAvatarUserName = mAvatarUserName == null ? null : mAvatarUserName.trim();
    }

    public String getmAvatarSuffix() {
        return mAvatarSuffix;
    }

    public void setmAvatarSuffix(String mAvatarSuffix) {
        this.mAvatarSuffix = mAvatarSuffix == null ? null : mAvatarSuffix.trim();
    }

    public String getmAvatarPath() {
        return mAvatarPath;
    }

    public void setmAvatarPath(String mAvatarPath) {
        this.mAvatarPath = mAvatarPath == null ? null : mAvatarPath.trim();
    }

    public Integer getmAvatarType() {
        return mAvatarType;
    }

    public void setmAvatarType(Integer mAvatarType) {
        this.mAvatarType = mAvatarType;
    }

    public String getmAvatarLastUpdateTime() {
        return mAvatarLastUpdateTime;
    }

    public void setmAvatarLastUpdateTime(String mAvatarLastUpdateTime) {
        this.mAvatarLastUpdateTime = mAvatarLastUpdateTime == null ? null : mAvatarLastUpdateTime.trim();
    }
}