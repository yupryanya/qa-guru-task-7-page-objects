package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            currentAddressStateInput = $("#react-select-3-input"),
            currentAddressCityInput = $("#react-select-4-input"),
            submitButton = $("#submit");

    private void removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        removeBanners();
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
        $("#dateOfBirthInput").click();
        calendar.setDate(year, month, day);
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

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value);
        subjectsInput.pressEnter();                  //Клавиатурой
        // $("#react-select-2-option-0").click();    //Мышью
        return this;
    }

    public RegistrationPage setHobby(String value) {
        $(byText(value)).click();
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

    public RegistrationPage setCurrentAddressState(String value) {
        currentAddressStateInput.setValue(value);
        currentAddressStateInput.pressEnter();
        return this;
    }

    public RegistrationPage setCurrentAddressCity(String value) {
        currentAddressCityInput.setValue(value);
        currentAddressCityInput.pressEnter();
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
