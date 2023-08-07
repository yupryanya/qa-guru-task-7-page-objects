package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePreviewModal {

    private SelenideElement tableResponsive = $(".table-responsive");

    public ProfilePreviewModal checkResultByText(String value) {
        tableResponsive.shouldHave(text(value));
        return this;
    }
}
