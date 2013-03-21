package org.pdxse.gtf.drivers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.pdxse.gtf.model.WebDriverType;

import java.net.URL;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: ryandavis
 * Date: 3/13/13
 * Time: 9:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class WebDriverFactory {

    private static final Logger logger      = Logger.getLogger(WebDriverFactory.class);
    private static String seleniumGridHubURL;

    static{

        try{
            Properties seleniumGridProperties = new Properties();
            URL url = WebDriverFactory.class.getResource("/pdxse-gtf.properties");
            seleniumGridProperties.load(url.openStream());

            seleniumGridHubURL = seleniumGridProperties.getProperty("selenium.grid.hub.url");

        }catch (Exception ex)
        {
            logger.error(ex);
        }
    }

    /**
     * Returns a new WebDriver instance compatible with the requested browser, browser version and operating system
     *
     * @param webDriverType Enum representing the requested browser, browser version and operating system
     * @return WebDriver       new WebDriver instance
     */
    public static WebDriver getNewWebDriver(WebDriverType webDriverType){
        WebDriver webDriver = null;
        DesiredCapabilities capabilities = webDriverType.getDriverCapabilities();
        try{
            webDriver = new RemoteWebDriver(new URL(seleniumGridHubURL), capabilities);
            return webDriver;
        }catch (Exception ex){
            logger.error(ex);
            return webDriver;
        }

    }

}
