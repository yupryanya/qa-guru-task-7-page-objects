package com.demoqa.pages.components;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private void setCalendarDate(String year, String month, String day) {
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        String daySelector = "div.react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)";
        $(daySelector).click();
    }

    public void setDate(String year, String month, String day) {
        setCalendarDate(year, month, day);
    }

    public void setDate(Date date) {
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy"),
                monthFormat = new SimpleDateFormat("MMMM"),
                dayFormat = new SimpleDateFormat("dd");
        String year = yearFormat.format(date),
                month = monthFormat.format(date),
                day = dayFormat.format(date);
        setCalendarDate(year, month, day);
    }
}
