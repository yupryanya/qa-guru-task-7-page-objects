package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.components.ProfilePreviewModal;
import org.junit.jupiter.api.Test;

public class StudentRegistrationFormTests extends TestBase {

    @Test
    void fillFormTest() {

        RegistrationPage registrationPage = new RegistrationPage();
        ProfilePreviewModal profilePreviewModal = new ProfilePreviewModal();

        String firstName = "John",
                lastName = "Doe",
                birthdayDay = "01",
                birthdayMonth = "May",
                birthdayYear = "1990",
                userEmail = "testmail@testmail.test",
                userPhoneNumber = "9876543210",
                gender = "Male",
                subject1 = "Maths",
                subject2 = "English",
                hobby1 = "Music",
                hobby2 = "Sports",
                currentAddress = "Gandhi Chowk Street, 10",
                pictureFileFromClassPath = "empty.jpg",
                stateName = "Uttar Pradesh",
                cityName = "Agra";

        registrationPage.openPage()
                .removeBanners()
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
                .setState(stateName)
                .setCity(cityName)
                .clickSubmitButton();

        profilePreviewModal.textIsVisible(firstName + " " + lastName)
                .textIsVisible(userEmail)
                .textIsVisible(gender)
                .textIsVisible(userPhoneNumber)
                .textIsVisible(birthdayDay + " " + birthdayMonth + "," + birthdayYear)
                .textIsVisible(subject1)
                .textIsVisible(subject2)
                .textIsVisible(hobby1)
                .textIsVisible(hobby2)
                .textIsVisible(pictureFileFromClassPath)
                .textIsVisible(currentAddress)
                .textIsVisible(stateName + " " + cityName);
    }
}

