package smiyan.aleksey.util;

import static smiyan.aleksey.util.PropertiesReader.getProperties;

public class Config {

    private final static String BROWSER_NAME;
    private final static String NAME_CHROME_DRIVER;
    private final static String PATH_CHROME_DRIVER;
    private final static String BASE_UI_URL;
    private final static String RAPID_API_HOST;
    private final static String RAPID_API_KEY;

    private Config() {}

    static {
        BROWSER_NAME = getProperties("browser.name");
        NAME_CHROME_DRIVER = getProperties("name.chromedriver");
        PATH_CHROME_DRIVER = getProperties("path.chromedriver");
        BASE_UI_URL = getProperties("base.ui.url");
        RAPID_API_HOST = getProperties("rapid.api.host");
        RAPID_API_KEY = getProperties("rapid.api.key");
    }

    public static String getBrowserName() {
        return BROWSER_NAME;
    }

    public static String getNameChromeDriver() {
        return NAME_CHROME_DRIVER;
    }

    public static String getPathChromeDriver() {
        return PATH_CHROME_DRIVER;
    }

    public static String getBaseUIUrl() {
        return BASE_UI_URL;
    }

    public static String getRapidApiHost() {
        return RAPID_API_HOST;
    }

    public static String getRapidApiKey() {
        return RAPID_API_KEY;
    }
}
