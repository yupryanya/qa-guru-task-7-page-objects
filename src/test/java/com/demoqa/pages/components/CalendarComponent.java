package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public CalendarComponent setDate(String year, String month, String day) {
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        String daySelector = "div.react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)";
        $(daySelector).click();
        return this;
    }
}
