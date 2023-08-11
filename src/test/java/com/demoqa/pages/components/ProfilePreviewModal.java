package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePreviewModal {

    private SelenideElement tableResponsive = $(".table-responsive");
    SimpleDateFormat outputDate = new SimpleDateFormat("dd MMMM,yyyy");

    public ProfilePreviewModal textIsVisible(String text) {
        tableResponsive.shouldHave(text(text));
        return this;
    }

    public ProfilePreviewModal dateIsVisible(Date date) {
        tableResponsive.shouldHave(text(outputDate.format(date)));
        return this;
    }

    public ProfilePreviewModal listItemsAreVisible(List<String> items) {
        for (String item : items) {
            textIsVisible(item);
        }
        return this;
    }
}
