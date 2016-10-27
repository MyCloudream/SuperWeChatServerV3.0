package cn.ucai.superwechat.pojo;

public class Location {
    private Integer mLocationId;

    private String mLocationUserName;

    private Double mLocationLatitude;

    private Double mLocationLongitude;

    private Integer mLocationIsSearched;

    private String mLocationLastUpdateTime;

    public Integer getmLocationId() {
        return mLocationId;
    }

    public void setmLocationId(Integer mLocationId) {
        this.mLocationId = mLocationId;
    }

    public String getmLocationUserName() {
        return mLocationUserName;
    }

    public void setmLocationUserName(String mLocationUserName) {
        this.mLocationUserName = mLocationUserName == null ? null : mLocationUserName.trim();
    }

    public Double getmLocationLatitude() {
        return mLocationLatitude;
    }

    public void setmLocationLatitude(Double mLocationLatitude) {
        this.mLocationLatitude = mLocationLatitude;
    }

    public Double getmLocationLongitude() {
        return mLocationLongitude;
    }

    public void setmLocationLongitude(Double mLocationLongitude) {
        this.mLocationLongitude = mLocationLongitude;
    }

    public Integer getmLocationIsSearched() {
        return mLocationIsSearched;
    }

    public void setmLocationIsSearched(Integer mLocationIsSearched) {
        this.mLocationIsSearched = mLocationIsSearched;
    }

    public String getmLocationLastUpdateTime() {
        return mLocationLastUpdateTime;
    }

    public void setmLocationLastUpdateTime(String mLocationLastUpdateTime) {
        this.mLocationLastUpdateTime = mLocationLastUpdateTime == null ? null : mLocationLastUpdateTime.trim();
    }
}