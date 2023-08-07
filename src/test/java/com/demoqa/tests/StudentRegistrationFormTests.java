package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.components.ProfilePreviewModal;
import org.junit.jupiter.api.Test;

public class StudentRegistrationFormTests extends TestBase {

    @Test
    void fillFormTest() {

        RegistrationPage registrationPage = new RegistrationPage();
        ProfilePreviewModal profilePreviewModal = new ProfilePreviewModal();

        String firstName = "John";
        String lastName = "Doe";
        String birthdayYear = "2023";
        String birthdayMonth = "August";
        String birthdayDay = "31"; // Формат хх, например 01, 05, 10, 25
        String userEmail = "testmail@testmail.test";
        String userPhoneNumber = "9876543210";
        String gender = "Male";
        String subject1 = "Maths";
        String subject2 = "English";
        String hobby1 = "Music";
        String hobby2 = "Sports";
        String currentAddress = "Gandhi Chowk Street, 10";
        String pictureFileFromClassPath = "empty.jpg";
        String stateName = "Uttar Pradesh";
        String cityName = "Agra";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userPhoneNumber)
                .setBirthDate(birthdayYear, birthdayMonth, birthdayDay)
                .setSubject(subject1)
                .setSubject(subject2)
                .setHobby(hobby1)
                .setHobby(hobby2)
                .uploadPicture(pictureFileFromClassPath)
                .setCurrentAddress(currentAddress)
                .setCurrentAddressState(stateName)
                .setCurrentAddressCity(cityName)
                .clickSubmitButton();

        profilePreviewModal.checkResultByText(firstName + " " + lastName)
                .checkResultByText(userEmail)
                .checkResultByText(gender)
                .checkResultByText(userPhoneNumber)
                .checkResultByText(birthdayDay + " " + birthdayMonth + "," + birthdayYear)
                .checkResultByText(subject1)
                .checkResultByText(subject2)
                .checkResultByText(hobby1)
                .checkResultByText(hobby2)
                .checkResultByText(pictureFileFromClassPath)
                .checkResultByText(currentAddress)
                .checkResultByText(stateName + " " + cityName);
    }
}

