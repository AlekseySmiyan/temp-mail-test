package smiyan.aleksey.pages.tortua;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class BasePage {

    protected HeaderComponent getHeaderComponent() {
        return page(HeaderComponent.class);
    }

    protected void input(String locator, String value) {
        $(locator).shouldBe(visible).val(value);
    }
}
