package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;

import java.util.Date;
import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitButton = $("#submit");

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String year, String month, String day) {
        calendarInput.click();
        calendar.setDate(year, month, day);
        return this;
    }

    public RegistrationPage setBirthDate(Date birthDate) {
        calendarInput.click();
        calendar.setDate(birthDate);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    private void setSubjects(String value) {
        subjectsInput.setValue(value);
        subjectsInput.pressEnter();
    }

    public RegistrationPage setSubject(String value) {
        setSubjects(value);
        return this;
    }

    public RegistrationPage setSubject(List<String> values) {
        values.forEach(this::setSubjects);
        return this;
    }

    public RegistrationPage setHobby(String value) {
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage setHobby(List<String> values) {
        values.forEach(value -> $(byText(value)).click());
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.setValue(value);
        stateInput.pressEnter();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.setValue(value);
        cityInput.pressEnter();
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
