package org.pdxse.gtf.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pdxse.gtf.model.WebDriverType;
import org.pdxse.gtf.web.WebNavigator;

/**
 * Created with IntelliJ IDEA.
 * User: ryandavis
 * Date: 3/17/13
 * Time: 12:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class WebTestExecutor {

    private static final Logger logger = Logger.getLogger(WebTestExecutor.class);

    /**
     * Test Executor compatible with Ryan's test.html page that determines the Browser Name based on the contents of
     * the Browser Name and User Agent fields.
     * (test.html @http://pojorisin.github.com/pojorisin/test/test.html)
     *
     * @param webDriverType Enum representing the WebDriver instance to be created
     * @param url URL to the test.html page
     * @return String containing the name of the Browser
     */
    public static String determineWebBrowserType(WebDriverType webDriverType, String url){

        WebNavigator navigator = new WebNavigator(webDriverType);
        navigator.navigateBrowserTo(url);

        WebElement browserName = navigator.getWebElement(By.id("browserNameTextBoxID"));
        String name = browserName.getAttribute("value");

        WebElement userAgent = navigator.getWebElement(By.id("userAgentTextBoxID"));
        String agent = userAgent.getAttribute("value");

        navigator.quit();

        if(name.equals("Microsoft Internet Explorer")){
            return "Internet Explorer";
        }else if(agent.contains("Chrome")){
            return "Chrome";
        }else if(agent.contains("Firefox")){
            return "Firefox";
        }else{
            return "ERROR";
        }

    }


    /**
     * Test Executor compatible with Ryan's test.html page that reads the Browser Name and User Agent fields and
     * returns a String that consists of their concatenated and formatted values.
     * (test.html @http://pojorisin.github.com/pojorisin/test/test.html)
     *
     * @param webDriverType Enum representing the WebDriver instance to be created
     * @param url URL to the test.html page
     * @return String of the formatted and concatenated Browser Name and User Agent
     */
    public static String getWebBrowserNameAndUserAgent(WebDriverType webDriverType, String url){

        WebNavigator navigator = new WebNavigator(webDriverType);
        navigator.navigateBrowserTo(url);

        WebElement browserName = navigator.getWebElement(By.id("browserNameTextBoxID"));
        String name = browserName.getAttribute("value");

        WebElement userAgent = navigator.getWebElement(By.id("userAgentTextBoxID"));
        String agent = userAgent.getAttribute("value");

        navigator.quit();

        String browserNaneAndUserAgent = "Browser Name: " + name + " - " + "User Agent: " + agent;
        return browserNaneAndUserAgent;
    }


    /**
     * Test Executor compatible with Ryan's test.html page that enters the specified text into the test input text
     * field, clicks a button to transfer the input text to the test result text field, reads the text from the test
     * result text field and compares it to the input text.
     * (test.html @http://pojorisin.github.com/pojorisin/test/test.html)
     *
     * @param webDriverType Enum representing the WebDriver instance to be created
     * @param url URL to the test.html page
     * @param textFieldInput String value to enter into the text field
     */
    public static void testTextFieldEntry(WebDriverType webDriverType, String url, String textFieldInput){

        WebNavigator navigator = new WebNavigator(webDriverType);
        navigator.navigateBrowserTo(url);

        assert navigator.setText(By.id("textFieldTestInputControlID"), textFieldInput);

        assert navigator.clickElement(By.id("textFieldTestProcessButtonID"));

        WebElement element = navigator.getWebElement(By.id("textFieldTestOutputControlID"));
        assert element.getAttribute("value").equals(textFieldInput);

        navigator.quit();
    }

}
