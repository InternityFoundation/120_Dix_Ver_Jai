package com.example.maternity;

public class DoctorDetails {

    String username;
    String registrationNumber;
    String experience;
    String phone;
    String permanentAddress;
    String zipcode;
    String profilePicture;
    String aboutMe;
    String gender;
    String email;
    String latitude;
    String longitude;

    public DoctorDetails(){}

    public DoctorDetails(String username, String registrationNumber, String experience, String phone, String permanentAddress, String zipcode, String profilePicture, String aboutMe, String gender, String email, String latitude, String longitude) {
        this.username = username;
        this.registrationNumber = registrationNumber;
        this.experience = experience;
        this.phone = phone;
        this.permanentAddress = permanentAddress;
        this.zipcode = zipcode;
        this.profilePicture = profilePicture;
        this.aboutMe = aboutMe;
        this.gender = gender;
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

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
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
