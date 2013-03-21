package org.pdxse.gtf.data;

import org.apache.log4j.Logger;
import org.pdxse.gtf.model.WebDriverType;
import org.testng.annotations.DataProvider;


/**
 * Created with IntelliJ IDEA.
 * User: ryandavis
 * Date: 3/17/13
 * Time: 10:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestDataProvider {

    private static final Logger logger = Logger.getLogger(TestDataProvider.class);


    /**
     * 3-record Data Provider that is compatible with both a local grid and the Sauce Labs grid that includes an
     * instance of the 3 most common Browsers that run on Windows
     *
     * @return TestNG DataProvider as two-dimensional Object Array for consumption by a TestNG Test
     */
    @DataProvider(parallel = true)
    public static Object[][] LocalGridDriverSet_003(){
        return new Object[][]{
                { 1, WebDriverType.CHROME}, { 2, WebDriverType.FIREFOX}, { 3, WebDriverType.INTERNET_EXPLORER},
        };
    }


    /**
     * 100-record Data Provider that is compatible with both a local grid and the Sauce Labs grid that includes an
     * 33 instances of each of the 3 most common Browsers that run on Windows
     *
     * @return TestNG DataProvider as two-dimensional Object Array for consumption by a TestNG Test
     */
    @DataProvider(parallel = true)
    public static Object[][] LocalGridDriverSet_100(){
        return new Object[][]{
                { 1, WebDriverType.CHROME}, { 2, WebDriverType.FIREFOX}, { 3, WebDriverType.INTERNET_EXPLORER},
                { 4, WebDriverType.INTERNET_EXPLORER}, { 5, WebDriverType.FIREFOX}, { 6, WebDriverType.CHROME},
                { 7, WebDriverType.CHROME}, { 8, WebDriverType.CHROME}, { 9, WebDriverType.CHROME},
                { 10, WebDriverType.FIREFOX}, { 11, WebDriverType.FIREFOX}, { 12, WebDriverType.FIREFOX},
                { 13, WebDriverType.INTERNET_EXPLORER}, { 14, WebDriverType.INTERNET_EXPLORER}, { 15, WebDriverType.INTERNET_EXPLORER},
                { 16, WebDriverType.FIREFOX}, { 17, WebDriverType.CHROME}, { 18, WebDriverType.INTERNET_EXPLORER},
                { 19, WebDriverType.INTERNET_EXPLORER}, { 20, WebDriverType.CHROME}, { 21, WebDriverType.FIREFOX},
                { 22, WebDriverType.FIREFOX}, { 23, WebDriverType.FIREFOX}, { 24, WebDriverType.FIREFOX},
                { 25, WebDriverType.CHROME}, { 26, WebDriverType.CHROME}, { 27, WebDriverType.CHROME},
                { 28, WebDriverType.INTERNET_EXPLORER}, { 29, WebDriverType.INTERNET_EXPLORER}, { 30, WebDriverType.INTERNET_EXPLORER},
                { 31, WebDriverType.INTERNET_EXPLORER}, { 32, WebDriverType.CHROME}, { 33, WebDriverType.FIREFOX},
                { 34, WebDriverType.FIREFOX}, { 35, WebDriverType.CHROME}, { 36, WebDriverType.INTERNET_EXPLORER},
                { 37, WebDriverType.INTERNET_EXPLORER}, { 38, WebDriverType.INTERNET_EXPLORER}, { 39, WebDriverType.INTERNET_EXPLORER},
                { 40, WebDriverType.CHROME}, { 41, WebDriverType.CHROME}, { 42, WebDriverType.CHROME},
                { 43, WebDriverType.FIREFOX}, { 44, WebDriverType.FIREFOX}, { 45, WebDriverType.FIREFOX},
                { 46, WebDriverType.INTERNET_EXPLORER}, { 47, WebDriverType.FIREFOX}, { 48, WebDriverType.CHROME},
                { 49, WebDriverType.CHROME}, { 50, WebDriverType.FIREFOX}, { 51, WebDriverType.INTERNET_EXPLORER},
                { 52, WebDriverType.INTERNET_EXPLORER}, { 53, WebDriverType.INTERNET_EXPLORER}, { 54, WebDriverType.INTERNET_EXPLORER},
                { 55, WebDriverType.FIREFOX}, { 56, WebDriverType.FIREFOX}, { 57, WebDriverType.FIREFOX},
                { 58, WebDriverType.CHROME}, { 59, WebDriverType.CHROME}, { 60, WebDriverType.CHROME},
                { 61, WebDriverType.CHROME}, { 62, WebDriverType.FIREFOX}, { 63, WebDriverType.FIREFOX},
                { 64, WebDriverType.FIREFOX}, { 65, WebDriverType.FIREFOX}, { 66, WebDriverType.CHROME},
                { 67, WebDriverType.FIREFOX}, { 68, WebDriverType.CHROME}, { 69, WebDriverType.CHROME},
                { 70, WebDriverType.CHROME}, { 71, WebDriverType.CHROME}, { 72, WebDriverType.FIREFOX},
                { 73, WebDriverType.INTERNET_EXPLORER}, { 74, WebDriverType.CHROME}, { 75, WebDriverType.CHROME},
                { 76, WebDriverType.CHROME}, { 77, WebDriverType.CHROME}, { 78, WebDriverType.INTERNET_EXPLORER},
                { 79, WebDriverType.INTERNET_EXPLORER}, { 80, WebDriverType.FIREFOX}, { 81, WebDriverType.FIREFOX},
                { 82, WebDriverType.FIREFOX}, { 83, WebDriverType.FIREFOX}, { 84, WebDriverType.INTERNET_EXPLORER},
                { 85, WebDriverType.CHROME}, { 86, WebDriverType.FIREFOX}, { 87, WebDriverType.INTERNET_EXPLORER},
                { 88, WebDriverType.INTERNET_EXPLORER}, { 89, WebDriverType.FIREFOX}, { 90, WebDriverType.CHROME},
                { 91, WebDriverType.CHROME}, { 92, WebDriverType.CHROME}, { 93, WebDriverType.CHROME},
                { 94, WebDriverType.FIREFOX}, { 95, WebDriverType.FIREFOX}, { 96, WebDriverType.FIREFOX},
                { 97, WebDriverType.INTERNET_EXPLORER}, { 98, WebDriverType.INTERNET_EXPLORER}, { 99, WebDriverType.INTERNET_EXPLORER},
                { 100, WebDriverType.CHROME},
        };
    }


    /**
     * Data Provider compatible with the Sauce Labs grid that includes versions of Internet Explorer 6-10
     *
     * @return TestNG DataProvider as two-dimensional Object Array for consumption by a TestNG Test
     */
    @DataProvider(parallel = true)
    public static Object[][] HistoricTourOfInternetExplorer(){
        return new Object[][]{
                { 1, WebDriverType.IE_6_WIN2003}, { 2, WebDriverType.IE_7_WIN2003}, { 3, WebDriverType.IE_8_WIN2008},
                { 4, WebDriverType.IE_9_WIN2008}, { 5, WebDriverType.IE_10_WIN2012}
        };
    }


    /**
     * Data Provider compatible with the Sauce Labs grid that includes an instance of each Browser that runs on Linux
     *
     * @return TestNG DataProvider as two-dimensional Object Array for consumption by a TestNG Test
     */
    @DataProvider(parallel = true)
    public static Object[][] BrowsersOfLinux(){
        return new Object[][]{
                { 1, WebDriverType.OPERA_12_LINUX}, { 2, WebDriverType.CHROME_LINUX}, { 3, WebDriverType.ANDROID_4_LINUX},
                { 4, WebDriverType.FIREFOX_12_LINUX}
        };
    }


    /**
     * Data Provider compatible with the Sauce Labs grid that includes an instance of each Browser that runs on a Mac.
     * !!!WARNING Sauce Labs Mac Minutes cost more than the Windows/Linux Minutes
     *
     * @return TestNG DataProvider as two-dimensional Object Array for consumption by a TestNG Test
     */
    @DataProvider(parallel = true)
    public static Object[][] SauceLabsMacMinutesBrowsers(){
        return new Object[][]{
                { 1, WebDriverType.IPHONE_6_MAC_10_8}, { 2, WebDriverType.IPAD_6_MAC_10_8}, { 3, WebDriverType.SAFARI_6_MAC_10_8},
                { 4, WebDriverType.CHROME_MAC_10_8}, { 5, WebDriverType. FIREFOX_19_MAC_10_6}
        };
    }




}
