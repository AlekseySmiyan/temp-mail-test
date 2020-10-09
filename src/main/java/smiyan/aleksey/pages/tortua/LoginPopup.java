package smiyan.aleksey.pages.tortua;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class LoginPopup {

    private static final String SIGN_UP_LINK = "//a[contains(@href, 'registracziya-polzovatelya')]";

    public RegistrationPage clickSignUp() {
        $x(SIGN_UP_LINK).shouldBe(visible).click();
        return page(RegistrationPage.class);
    }
}
