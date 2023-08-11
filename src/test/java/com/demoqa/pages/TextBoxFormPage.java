package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxFormPage {
    private SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            userNameOutput = $("#output #name"),
            userEmailOutput = $("#output #email"),
            currentAddressOutput = $("#output #currentAddress"),
            permanentAddressOutput = $("#output #permanentAddress");

    public TextBoxFormPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxFormPage setUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxFormPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public void submitButtonClick() {
        submitButton.click();
    }

    public TextBoxFormPage checkUserName(String value) {
        userNameOutput.shouldHave(text(value));
        return this;
    }

    public TextBoxFormPage checkUserEmail(String value) {
        userEmailOutput.shouldHave(text(value));
        return this;
    }

    public TextBoxFormPage checkCurrentAddress(String value) {
        currentAddressOutput.shouldHave(text(value));
        return this;
    }

    public TextBoxFormPage checkPermanentAddress(String value) {
        permanentAddressOutput.shouldHave(text(value));
        return this;
    }
}
