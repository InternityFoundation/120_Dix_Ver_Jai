package com.example.maternity;

public class ParentDetails {

    String username;
    String email;
    String phone;
    String availablity;
    String genderOfBaby;
    String permanentAddress;
    String zipcode;
    String rateHr;
    String description;
    String profilePicture;
    String password;


    public ParentDetails(){}

    public ParentDetails(String username, String email, String phone, String availablity, String genderOfBaby, String permanentAddress, String zipcode, String rateHr, String description, String profilePicture, String password) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.availablity = availablity;
        this.genderOfBaby = genderOfBaby;
        this.permanentAddress = permanentAddress;
        this.zipcode = zipcode;
        this.rateHr = rateHr;
        this.description = description;
        this.profilePicture = profilePicture;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvailablity() {
        return availablity;
    }

    public void setAvailablity(String availablity) {
        this.availablity = availablity;
    }

    public String getGenderOfBaby() {
        return genderOfBaby;
    }

    public void setGenderOfBaby(String genderOfBaby) {
        this.genderOfBaby = genderOfBaby;
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

    public String getRateHr() {
        return rateHr;
    }

    public void setRateHr(String rateHr) {
        this.rateHr = rateHr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
