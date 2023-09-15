package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.pages.components.ProfilePreviewModal;
import com.demoqa.utils.RegistrationFormDataGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static io.qameta.allure.Allure.step;

@DisplayName("Registration form tests")
@Tag("regression")
public class RegistrationFormTests extends TestBaseRemote {
    @Test
    @Tag("smoke")
    @DisplayName("Successful registration with all fields validly filled")
    void successfulRegistrationWithValidFields() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();
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

        step("Open form", () ->
                registrationFormPage.openPage()
                        .removeBanners()
        );
        step("Fill all fields", () ->
                registrationFormPage.setFirstName(firstName)
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
                        .clickSubmitButton()
        );
        step("Verify results", () ->
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
                        .textIsVisible(stateName + " " + cityName)
        );
    }

    @Test
    @DisplayName("Successful registration with all fields validly filled (generated data)")
    void successfulRegistrationWithGeneratedData() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();
        ProfilePreviewModal profilePreviewModal = new ProfilePreviewModal();
        RegistrationFormDataGenerator randomData = new RegistrationFormDataGenerator();

        Date birthDate = randomData.generateBirthDate();
        List<String> hobbies = randomData.generateHobby(2);
        List<String> subjects = randomData.generateSubject(3);
        String firstName = randomData.generateFirstName(),
                lastName = randomData.generateLastName(),
                userEmail = randomData.generateUserEmail(),
                userPhoneNumber = randomData.generatePhoneNumber(),
                gender = randomData.generateGender(),
                currentAddress = randomData.generateAddress(),
                pictureFileFromClassPath = randomData.generatePicture(),
                stateName = randomData.generateState(),
                cityName = randomData.generateCity(stateName);

        step("Open form", () ->
                registrationFormPage.openPage()
                        .removeBanners()
        );
        step("Fill all fields", () ->
                registrationFormPage.setFirstName(firstName)
                        .setLastName(lastName)
                        .setUserEmail(userEmail)
                        .setGender(gender)
                        .setUserNumber(userPhoneNumber)
                        .setBirthDate(birthDate)
                        .setSubject(subjects)
                        .setHobby(hobbies)
                        .uploadPicture(pictureFileFromClassPath)
                        .setCurrentAddress(currentAddress)
                        .setState(stateName)
                        .setCity(cityName)
                        .clickSubmitButton()
        );
        step("Verify results", () ->
                profilePreviewModal.textIsVisible(firstName + " " + lastName)
                        .textIsVisible(userEmail)
                        .textIsVisible(gender)
                        .textIsVisible(userPhoneNumber)
                        .dateIsVisible(birthDate)
                        .listItemsAreVisible(subjects)
                        .listItemsAreVisible(hobbies)
                        .textIsVisible(pictureFileFromClassPath)
                        .textIsVisible(currentAddress)
                        .textIsVisible(stateName + " " + cityName)
        );
    }
}

