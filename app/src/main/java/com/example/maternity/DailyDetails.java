package com.example.maternity;

public class DailyDetails {

    String ageGroup, whatToFeed, otherInfo;

    public DailyDetails(){}

    public DailyDetails(String ageGroup, String whatToFeed, String otherInfo) {
        this.ageGroup = ageGroup;
        this.whatToFeed = whatToFeed;
        this.otherInfo = otherInfo;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getWhatToFeed() {
        return whatToFeed;
    }

    public void setWhatToFeed(String whatToFeed) {
        this.whatToFeed = whatToFeed;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }
}
