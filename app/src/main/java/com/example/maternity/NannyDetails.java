package com.example.maternity;

public class NannyDetails {
    String username;
    String DOB;
    String aadharNo;
    String phone;
    String permanentAddress;
    String availablity;
    String profilePicture;
    String aboutMe;
    String gender;
    String password;
    String rateHr;
    String email;
    String latitude;
    String longitude;

   public NannyDetails(){}

    public NannyDetails(String username, String DOB, String aadharNo, String phone, String permanentAddress, String availablity, String profilePicture, String aboutMe, String password, String gender, String rateHr, String email, String latitude, String longitude) {
        this.username = username;
        this.DOB = DOB;
        this.aadharNo = aadharNo;
        this.phone = phone;
        this.permanentAddress = permanentAddress;
        this.availablity = availablity;
        this.profilePicture = profilePicture;
        this.aboutMe = aboutMe;
        this.password = password;
        this.gender = gender;
        this.rateHr = rateHr;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) { this.permanentAddress = permanentAddress; }

    public String getAvailablity() {
        return availablity;
    }

    public void setAvailablity(String availablity) {
        this.availablity = availablity;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRateHr() {
        return rateHr;
    }

    public void setRateHr(String rateHr) {
        this.rateHr = rateHr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String password) {
        this.longitude = longitude;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
