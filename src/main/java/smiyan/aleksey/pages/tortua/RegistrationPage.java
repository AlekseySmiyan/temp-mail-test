package smiyan.aleksey.pages.tortua;

import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.WebElement;
import smiyan.aleksey.data.Account;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class RegistrationPage extends BasePage{

    private static final String PHONE_INPUT = "#phone";
    private static final String EMAIL_INPUT = "#usermail";
    private static final String PASSWORD_INPUT = "#password1";
    private static final String REPEAT_PASSWORD_INPUT = "#password2";
    private static final String NAME_INPUT = "#name";
    private static final String SUBMIT_BUTTON = ".basketSubmit";
    private static final String SUCCESS_MESSAGE = ".ok";

    public RegistrationPage createAccount(Account account) {
        inputPhone(account.getPhone());
        input(EMAIL_INPUT, account.getEmail());
        input(PASSWORD_INPUT, account.getPassword());
        input(REPEAT_PASSWORD_INPUT, account.getPassword());
        input(NAME_INPUT, account.getFullName());
        $(SUBMIT_BUTTON).click();
        return this;
    }

    public void inputPhone(String value) {
        WebElement field = $(PHONE_INPUT).shouldBe(visible);
        Arrays.asList(value.toCharArray())
                .forEach(ch -> {
                    field.click();
                    sleep(500);
                    field.sendKeys(String.valueOf(ch));
                });
    }

    public RegistrationPage waitSuccessMessage() {
        $(SUCCESS_MESSAGE).shouldBe(visible);
        return this;
    }
}
