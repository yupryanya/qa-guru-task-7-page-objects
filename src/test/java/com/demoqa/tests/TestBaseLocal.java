package com.demoqa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Configuration.*;

public class TestBaseLocal {
    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://demoqa.com";
        browserSize = "1920x1080";
        pageLoadStrategy = "eager";
    }

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}

