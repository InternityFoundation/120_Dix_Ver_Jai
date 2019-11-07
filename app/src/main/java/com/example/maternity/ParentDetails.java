package com.example.maternity;

public class ParentDetails {

    String username;
    String email;
    String availablity;
    String prefferedDays;
    String genderOfBaby;
    String permanentAddress;
    String zipcode;
    String rateHr;
    String description;

    public ParentDetails(String username, String email, String availablity, String prefferedDays, String genderOfBaby, String permanentAddress, String zipcode, String rateHr, String description) {
        this.username = username;
        this.email = email;
        this.availablity = availablity;
        this.prefferedDays = prefferedDays;
        this.genderOfBaby = genderOfBaby;
        this.permanentAddress = permanentAddress;
        this.zipcode = zipcode;
        this.rateHr = rateHr;
        this.description = description;
    }
    public ParentDetails(){}

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

    public String getAvailablity() {
        return availablity;
    }

    public void setAvailablity(String availablity) {
        this.availablity = availablity;
    }

    public String getPrefferedDays() {
        return prefferedDays;
    }

    public void setPrefferedDays(String prefferedDays) {
        this.prefferedDays = prefferedDays;
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
}
