package smiyan.aleksey.tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import smiyan.aleksey.util.Config;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class BaseTest {

    @BeforeSuite
    public void setup() {
        System.setProperty(Config.getNameChromeDriver(), Config.getPathChromeDriver());
        Configuration.browser = Config.getBrowserName();
    }

    protected <T>T openPage(String url, Class<T> page) {
        open(url);
        return page(page);
    }
}
