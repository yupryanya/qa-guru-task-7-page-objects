package com.demoqa.tests;

import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxTests extends TestBase {
    @Test
    void fillFormTest() {

        TextBoxPage textBoxPage = new TextBoxPage();

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
                    .setCurrentAddress(currentAddress)
                    .checkPermanentAddress(permanentAddress);
    }
}
