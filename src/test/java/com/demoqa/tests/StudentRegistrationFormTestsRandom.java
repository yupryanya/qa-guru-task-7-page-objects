package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.components.ProfilePreviewModal;
import com.demoqa.utils.RegistrationPageDataGenerator;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;

public class StudentRegistrationFormTestsRandom extends TestBase {

    @Test
    void fillFormTest() {

        RegistrationPage registrationPage = new RegistrationPage();
        ProfilePreviewModal profilePreviewModal = new ProfilePreviewModal();

        RegistrationPageDataGenerator randomData = new RegistrationPageDataGenerator();

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

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
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
                .clickSubmitButton();

        profilePreviewModal.textIsVisible(firstName + " " + lastName)
                .textIsVisible(userEmail)
                .textIsVisible(gender)
                .textIsVisible(userPhoneNumber)
                .dateIsVisible(birthDate)
                .listItemsAreVisible(subjects)
                .listItemsAreVisible(hobbies)
                .textIsVisible(pictureFileFromClassPath)
                .textIsVisible(currentAddress)
                .textIsVisible(stateName + " " + cityName);
    }
}

