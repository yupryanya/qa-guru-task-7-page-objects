package com.demoqa.tests;

import com.demoqa.pages.TextBoxFormPage;
import org.junit.jupiter.api.Test;

public class TextBoxFormTests extends TestBase {
    @Test
    void fillAllFieldsTest() {
        TextBoxFormPage textBoxPage = new TextBoxFormPage();
        String userName = "John Doe";
        String userEmail = "johndoe@testdomain.com";
        String currentAddress = "Sri Kumaran Children's Academy, 28/4, Kanakapura Road, Vasanthapura, Bengaluru";
        String permanentAddress = "Ghandhi Chowk Street, 10, Delhi";

        textBoxPage.openPage()
                    .setUserName(userName)
                    .setUserEmail(userEmail)
                    .setCurrentAddress(currentAddress)
                    .setPermanentAddress(permanentAddress)
                    .submitButtonClick();

        textBoxPage.checkUserName(userName)
                    .checkUserEmail(userEmail)
                    .checkCurrentAddress(currentAddress)
                    .checkPermanentAddress(permanentAddress);
    }
}
