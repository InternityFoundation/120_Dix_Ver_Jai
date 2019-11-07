package com.example.maternity;

public class NannyDetails {
    String username;
    String DOB;
    String aadharNo;
    String education;
    String experience;
    String phone;
    String permanentAddress;
    String zipcode;
    String availablity;
    String profilePicture;
    String preferredDays;
    String aboutMe;
    String gender;
    String rateHr;
    String email;
    String latitude;
    String longitude;

   public NannyDetails(){}

    public NannyDetails(String username, String DOB, String aadharNo, String education, String experience, String phone, String permanentAddress, String zipcode, String availablity, String profilePicture, String preferredDays, String aboutMe, String gender, String rateHr, String email, String latitude, String longitude) {
        this.username = username;
        this.DOB = DOB;
        this.aadharNo = aadharNo;
        this.education = education;
        this.experience = experience;
        this.phone = phone;
        this.permanentAddress = permanentAddress;
        this.zipcode = zipcode;
        this.availablity = availablity;
        this.profilePicture = profilePicture;
        this.preferredDays = preferredDays;
        this.aboutMe = aboutMe;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
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

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

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

    public String getPreferredDays() {
        return preferredDays;
    }

    public void setPreferredDays(String preferredDays) {
        this.preferredDays = preferredDays;
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

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
