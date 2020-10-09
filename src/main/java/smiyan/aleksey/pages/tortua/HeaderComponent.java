package smiyan.aleksey.pages.tortua;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HeaderComponent {

    private static final String OPEN_LOGIN = ".openLogin";

    public LoginPopup openLoginPopup() {
        $(OPEN_LOGIN).shouldBe(visible).click();
        return page(LoginPopup.class);
    }
}
