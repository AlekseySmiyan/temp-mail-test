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
import smiyan.aleksey.util.Config;
import smiyan.aleksey.util.HashCreator;
import smiyan.aleksey.util.NameCreator;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static smiyan.aleksey.data.Mail.*;

public class TempMailTest extends BaseTest{

    private TempMailClient tempMailClient;
    private String emailHash;
    private Account account;

    @BeforeClass
    void setupClass() {
        tempMailClient = new TempMailClient(RequestSpecifications.getTempMailSpecification());
        String email = NameCreator.getName("aqa") + tempMailClient.getDomains().get(0);
        emailHash = HashCreator.getMD5Hash(email).toLowerCase();
        account = AccountFactory.getRandomAccount(email);
    }

    @Test
    void getMessageAfterRegistration() {

        createAccount(account);

        List<Mail> mails = tempMailClient.getMails(emailHash);
        assertTrue(mails.size() > 0, "Mail not found");
        checkMailData(mails.get(0));
    }

    private void createAccount(Account account) {
        openPage(Config.getBaseUIUrl(), HomePage.class)
                .getHeaderComponent()
                .openLoginPopup()
                .clickSignUp()
                .createAccount(account)
                .waitSuccessMessage();
    }

    private void checkMailData(Mail actualMail) {
        System.out.println("Actual mail: " + actualMail);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualMail.getMailFrom(), MAIL_FROM.getValue(), "Mail from not expected");
        softAssert.assertEquals(actualMail.getMailSubject(), MAIL_SUBJECT.getValue(), "Mail subject not expected");
        softAssert.assertEquals(actualMail.getMailText(), getExpectedMailText(), "Mail text not expected");
        softAssert.assertAll();
    }

    private String getExpectedMailText() {
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
