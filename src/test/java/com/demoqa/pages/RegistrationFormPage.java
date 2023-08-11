package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;

import java.util.Date;
import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    private CalendarComponent calendar = new CalendarComponent();
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

    public RegistrationFormPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setBirthDate(String year, String month, String day) {
        calendarInput.click();
        calendar.setDate(year, month, day);
        return this;
    }

    public RegistrationFormPage setBirthDate(Date birthDate) {
        calendarInput.click();
        calendar.setDate(birthDate);
        return this;
    }

    public RegistrationFormPage setUserEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        $(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    private void setSubjects(String value) {
        subjectsInput.setValue(value);
        subjectsInput.pressEnter();
    }

    public RegistrationFormPage setSubject(String value) {
        setSubjects(value);
        return this;
    }

    public RegistrationFormPage setSubject(List<String> values) {
        values.forEach(this::setSubjects);
        return this;
    }

    public RegistrationFormPage setHobby(String value) {
        $(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setHobby(List<String> values) {
        values.forEach(value -> $(byText(value)).click());
        return this;
    }

    public RegistrationFormPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setState(String value) {
        stateInput.setValue(value);
        stateInput.pressEnter();
        return this;
    }

    public RegistrationFormPage setCity(String value) {
        cityInput.setValue(value);
        cityInput.pressEnter();
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
