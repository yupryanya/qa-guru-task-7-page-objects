package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.pages.components.ProfilePreviewModal;
import com.demoqa.utils.RegistrationFormDataGenerator;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;

public class RegistrationFormRandomDataTests extends TestBase {
    @Test
    void fillAllFieldsTest() {
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

        registrationFormPage.openPage()
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

