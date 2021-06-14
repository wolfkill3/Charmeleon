package com.wolfkill.charmeleon.application.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserData {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String login;
    private String password;
    private String link;
    private String email;
    private String firstName;
    private String secondName;
    private String thirdName;
    private Sex sex;
    private Integer dayOfBirth;
    private Integer monthOfBirth;
    private Integer yearOfBirth;

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getLink() {
        return link;
    }

    public void setLink(final String link) {
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(final String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(final String thirdName) {
        this.thirdName = thirdName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(final Sex sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Integer getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(final Integer dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Integer getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(final Integer monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(final Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "UserData{" +
               "id=" + id +
               ", login='" + login + '\'' +
               ", password='" + password + '\'' +
               ", link='" + link + '\'' +
               ", email='" + email + '\'' +
               ", firstName='" + firstName + '\'' +
               ", secondName='" + secondName + '\'' +
               ", thirdName='" + thirdName + '\'' +
               ", sex=" + sex +
               ", dayOfBirth=" + dayOfBirth +
               ", monthOfBirth=" + monthOfBirth +
               ", yearOfBirth=" + yearOfBirth +
               '}';
    }
}
