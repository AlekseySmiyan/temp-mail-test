package smiyan.aleksey.tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import smiyan.aleksey.util.Config;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class BaseTest {

    protected Config config = Config.DEFAULT;

    @BeforeSuite
    public void setup() {
        config.init();
        System.setProperty(config.getNameChromeDriver(), config.getPathChromeDriver());
        Configuration.browser = config.getBrowserName();
    }

    protected <T>T openPage(String url, Class<T> page) {
        open(url);
        return page(page);
    }
}
