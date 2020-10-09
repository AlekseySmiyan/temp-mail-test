package smiyan.aleksey.util;

import static smiyan.aleksey.util.PropertiesReader.getProperties;

public class Config {

    public static final Config DEFAULT = new Config();

    private String browserName;
    private String nameChromeDriver;
    private String pathChromeDriver;
    private String baseUIUrl;
    private String rapidApiHost;
    private String rapidApiKey;

    private Config() {}

    public String getBrowserName() {
        return browserName;
    }

    public String getNameChromeDriver() {
        return nameChromeDriver;
    }

    public String getPathChromeDriver() {
        return pathChromeDriver;
    }

    public String getBaseUIUrl() {
        return baseUIUrl;
    }

    public String getRapidApiHost() {
        return rapidApiHost;
    }

    public String getRapidApiKey() {
        return rapidApiKey;
    }

    public void init() {
        browserName = getProperties("browser.name");
        nameChromeDriver = getProperties("name.chromedriver");
        pathChromeDriver = getProperties("path.chromedriver");
        baseUIUrl = getProperties("base.ui.url");
        rapidApiHost = getProperties("rapid.api.host");
        rapidApiKey = getProperties("rapid.api.key");
    }
}
