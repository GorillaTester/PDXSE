package org.pdxse.gtf.web;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pdxse.gtf.drivers.WebDriverFactory;
import org.pdxse.gtf.model.WebDriverType;
import org.pdxse.gtf.utilities.Duration;

/**
 * Created with IntelliJ IDEA.
 * User: ryandavis
 * Date: 3/14/13
 * Time: 5:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class WebNavigator {

    private static final Logger logger = Logger.getLogger(WebNavigator.class);

    private WebDriver webDriver = null;

    public WebNavigator(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //takes a WebDriverType Enum
    public WebNavigator(WebDriverType webDriverType) {
        this.webDriver = WebDriverFactory.getNewWebDriver(webDriverType);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void navigateBrowserTo(String url){
        webDriver.get(url);
    }

    public void close(){
        webDriver.close();
    }

    public void quit(){
        webDriver.quit();
    }


    public boolean setText(By by, String text){
        Duration duration = new Duration();
        duration.startClock();

        WebElement element = null;
        element = getWebElement(by);

        if(element != null){
            if(element.isEnabled()){
                try{

                    // MobileWeb forms use type="tel" to account for differences
                    // between text input and numeric input to display the appropriate
                    // keyboards on the handsets.
                    if (element.getAttribute("type").contains("text")
                            || element.getAttribute("type").contains("tel")) {
                        element.clear();
                    }
                    element.sendKeys(text);
                    duration.stopClock();
                    logger.debug("Method 'setText' completed in " + duration.getCalculatedDuration());
                    return true;
                }catch (Exception ex){
                    logger.error(ex);
                    duration.stopClock();
                    logger.debug("Method 'setText' completed in " + duration.getCalculatedDuration());
                    return false;
                }

            }else{
                logger.error("Method 'setText' - WebElement representing the Button Control is Not Enabled");
                duration.stopClock();
                logger.debug("Method 'setText' completed in " + duration.getCalculatedDuration());
                return false;
            }
        }else{
            logger.error("Method 'setText' - unable to find the WebElement representing the Button Control" );
            duration.stopClock();
            logger.debug("Method 'setText' completed in " + duration.getCalculatedDuration());
            return false;
        }
    }


    public boolean clickElement(By by){
        Duration duration = new Duration();
        duration.startClock();

        WebElement element = null;
        element = getWebElement(by);

        if(element != null){
            if(element.isEnabled()){
                try{
                    element.click();
                    duration.stopClock();
                    logger.debug("Method 'clickElement' completed in " + duration.getCalculatedDuration());
                    return true;
                }catch (Exception ex){
                    logger.error(ex);
                    duration.stopClock();
                    logger.debug("Method 'clickElement' completed in " + duration.getCalculatedDuration());
                    return false;
                }

            }else{
                logger.error("Method 'clickElement' - WebElement representing the Button Control is Not Enabled");
                duration.stopClock();
                logger.debug("Method 'clickElement' completed in " + duration.getCalculatedDuration());
                return false;
            }
        }else{
            logger.error("Method 'clickElement' - unable to find the WebElement representing the Button Control");
            duration.stopClock();
            logger.debug("Method 'clickElement' completed in " + duration.getCalculatedDuration());
            return false;
        }
    }


    public WebElement getWebElement(By by)
    {
        Duration duration = new Duration();
        duration.startClock();

        WebElement returnElement = null;

        try
        {
            returnElement = webDriver.findElement(by);

        } catch (NoSuchElementException ex)
        {
            logger.warn("No Element Could be Found using \"" + by.toString() + "\"");
        }

        duration.stopClock();
        logger.debug("Method \"getWebElement\" completed in " + duration.getCalculatedDuration());

        return returnElement;
    }


}
