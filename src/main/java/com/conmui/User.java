package com.conmui;

public class User {
    private String username;
    private String email;
    private String title;
    private String password;
    private String day;
    private String month;
    private String year;
    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String address2;
    private String country;
    private String state;
    private String city;
    private String zipCode;
    private String mobileNumber;

    public User(String username, String email, String title, String password, String day, String month, String year, String firstName, String lastName, String company, String address, String address2, String country, String state, String city, String zipCode, String mobileNumber) {
        this.username = username;
        this.email = email;
        this.title = title;
        this.password = password;
        this.day = day;
        this.month = month;
        this.year = year;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.address = address;
        this.address2 = address2;
        this.country = country;
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
        this.mobileNumber = mobileNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public String getPassword() {
        return password;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}
