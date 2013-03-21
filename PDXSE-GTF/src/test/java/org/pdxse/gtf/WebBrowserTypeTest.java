package org.pdxse.gtf;

import org.apache.log4j.Logger;
import org.pdxse.gtf.data.TestDataProvider;
import org.pdxse.gtf.model.WebDriverType;
import org.pdxse.gtf.test.WebTestExecutor;
import org.pdxse.gtf.utilities.Duration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: ryandavis
 * Date: 3/17/13
 * Time: 12:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class WebBrowserTypeTest {

    private static final Logger logger = Logger.getLogger(WebBrowserTypeTest.class);

    private static ArrayList<String> testExecutionResults = new ArrayList<String>();
    private static String testSiteURL;
    private static Duration duration;

    static{

        try{
            Properties gtfProperties = new Properties();
            URL url = WebTextFieldTest.class.getResource("/pdxse-gtf.properties");
            gtfProperties.load(url.openStream());
            testSiteURL = gtfProperties.getProperty("test.website.url");

        }catch (Exception ex)
        {
            logger.error(ex);
        }
    }

    @BeforeClass
    public void setUp(){
        duration = new Duration();
        duration.startClock();
    }


    @AfterClass
    public void tearDown(){
        duration.stopClock();

        logger.info("All Tests completed in: " + duration.getCalculatedDuration());
        for(String s : testExecutionResults){
            logger.info("  " + s);
        }
    }

    @Test(dataProvider = "LocalGridDriverSet_003", dataProviderClass = TestDataProvider.class, description = "Test Entry of Text into a Web Text Field")
    public void test_WebBrowserType(int testNumber, WebDriverType webDriverType){

        assert webDriverType.getDriverBrowserName().equals(WebTestExecutor.determineWebBrowserType(webDriverType, testSiteURL));

        String testDescription;
        testDescription = String.format("%03d", testNumber) + " - " + webDriverType.getDriverBrowserName();
        testExecutionResults.add(testDescription);
    }



}
