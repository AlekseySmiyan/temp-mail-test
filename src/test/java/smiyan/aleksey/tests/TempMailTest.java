package smiyan.aleksey.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import smiyan.aleksey.api.RequestSpecifications;
import smiyan.aleksey.api.TempMailClient;
import smiyan.aleksey.data.Account;
import smiyan.aleksey.pages.tortua.HomePage;
import smiyan.aleksey.pojo.Mail;
import smiyan.aleksey.util.AccountFactory;
import smiyan.aleksey.util.HashCreator;
import smiyan.aleksey.util.NameCreator;

import static smiyan.aleksey.data.Mail.*;

public class TempMailTest extends BaseTest{

    private TempMailClient tempMailClient;
    private String email;
    private String emailHash;

    @BeforeClass
    void setupClass() {
        tempMailClient = new TempMailClient(RequestSpecifications.getTempMailSpecification());
        email = NameCreator.getName("aqa") + tempMailClient.getDomains().get(0);
        emailHash = HashCreator.getMD5Hash(email).toLowerCase();
    }

    @Test
    void getMessageAfterRegistration() {

        Account account = AccountFactory.getRandomAccount(email);
        createAccount(account);

        checkMailData(tempMailClient.getMails(emailHash).get(0), getExpectedMailText(account));
    }

    private void createAccount(Account account) {
        openPage(config.getBaseUIUrl(), HomePage.class)
                .getHeaderComponent()
                .openLoginPopup()
                .clickSignUp()
                .createAccount(account)
                .waitSuccessMessage();
    }

    private void checkMailData(Mail actualMail, String expectedMailText) {
        System.out.println("Actual mail: " + actualMail);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualMail.getMailFrom(), MAIL_FROM.getValue(), "Mail from not expected");
        softAssert.assertEquals(actualMail.getMailSubject(), MAIL_SUBJECT.getValue(), "Mail subject not expected");
        softAssert.assertEquals(actualMail.getMailText(), expectedMailText, "Mail text not expected");
        softAssert.assertAll();
    }

    private String getExpectedMailText(Account account) {
        String accountPhone = account.getPhone();
        String phone = "(" + accountPhone.substring(0, 3) + ") " + accountPhone.substring(3, 6) + "-" + accountPhone.substring(6);
        return String.format(
                MAIL_TEXT.getValue(),
                account.getEmail(),
                account.getPassword(),
                account.getFullName(),
                phone);
    }
}
