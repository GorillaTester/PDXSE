package org.pdxse.gtf.model;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created with IntelliJ IDEA.
 * User: ryandavis
 * Date: 3/13/13
 * Time: 9:35 PM
 * To change this template use File | Settings | File Templates.
 */
public enum WebDriverType {

    CHROME("Chrome", "Not Specified", "Not Specified", DesiredCapabilities.chrome()),
    FIREFOX("Firefox","Not Specified", "Not Specified", DesiredCapabilities.firefox()),
    INTERNET_EXPLORER("Internet Explorer","Not Specified", "Not Specified", DesiredCapabilities.internetExplorer()),
    OPERA_12_WIN2008("Opera", "12", "Windows 2008",  DesiredCapabilities.opera(), new String[][] { {"version", "12"}, {"platform", "Windows 2008"} }),
    SAFARI_5_WIN2008("Safari", "5", "Windows 2008",  DesiredCapabilities.safari(), new String[][] { {"version", "5"}, {"platform", "Windows 2008"} }),
    IE_6_WIN2003("Internet Explorer", "6", "Windows 2003", DesiredCapabilities.internetExplorer(), new String[][] { {"version", "6"}, {"platform", "Windows 2003"} }),
    IE_7_WIN2003("Internet Explorer", "7", "Windows 2003", DesiredCapabilities.internetExplorer(), new String[][] { {"version", "7"}, {"platform", "Windows 2003"} }),
    IE_8_WIN2008("Internet Explorer", "8", "Windows 2008", DesiredCapabilities.internetExplorer(), new String[][] { {"version", "8"}, {"platform", "Windows 2008"} }),
    IE_9_WIN2008("Internet Explorer", "9", "Windows 2008", DesiredCapabilities.internetExplorer(), new String[][] { {"version", "9"}, {"platform", "Windows 2008"} }),
    IE_10_WIN2012("Internet Explorer", "10", "Windows 2012", DesiredCapabilities.internetExplorer(), new String[][] { {"version", "10"}, {"platform", "Windows 2012"} }),
    OPERA_12_LINUX("Opera", "12", "Linux", DesiredCapabilities.opera(), new String[][] { {"version", "12"}, {"platform", "Linux"} }),
    CHROME_LINUX("Chrome", "Current", "Linux", DesiredCapabilities.chrome(), new String[][] { {"platform", "Linux"} }),
    ANDROID_4_LINUX("Android", "4", "Linux", DesiredCapabilities.android(), new String[][] { {"version", "4"}, {"platform", "Linux"} }),
    FIREFOX_12_LINUX("Firefox", "19", "Linux", DesiredCapabilities.firefox(), new String[][] { {"version", "19"}, {"platform", "Linux"} }),
    IPHONE_6_MAC_10_8("iOS", "6", "Mac 10.8", DesiredCapabilities.iphone(), new String[][] { {"version", "6"}, {"platform", "Mac 10.8"} }),
    IPAD_6_MAC_10_8("iOS", "6", "Mac 10.8", DesiredCapabilities.ipad(), new String[][] { {"version", "6"}, {"platform", "Mac 10.8"} }),
    SAFARI_6_MAC_10_8("iOS", "6", "Mac 10.8", DesiredCapabilities.safari(), new String[][] { {"version", "6"}, {"platform", "Mac 10.8"} }),
    CHROME_MAC_10_8("Chrome", "6", "Mac 10.8", DesiredCapabilities.chrome(), new String[][] { {"platform", "Mac 10.8"} }),
    FIREFOX_19_MAC_10_6("iOS", "19", "Mac 10.6", DesiredCapabilities.firefox(), new String[][] { {"version", "19"}, {"platform", "Mac 10.6"} });


    private final String driverBrowserName;
    private final String driverBrowserVersion;
    private final String driverOS;
    private final DesiredCapabilities driverCapabilities;


    /**
     * WebDriverType constructor that uses the default DesiredCapabilities
     *
     * @param driverBrowserName String representing the Browser name
     * @param driverBrowserVersion String representing the Browser version
     * @param driverOS String representing both the OS name and version
     * @param driverCapabilities browser-specific instance of the DesiredCapabilities interface
     */
    private WebDriverType(String driverBrowserName, String driverBrowserVersion, String driverOS, DesiredCapabilities driverCapabilities) {
        this.driverBrowserName = driverBrowserName;
        this.driverBrowserVersion = driverBrowserVersion;
        this.driverOS = driverOS;
        this.driverCapabilities = driverCapabilities;
    }

    /**
     * WebDriverType constructor that configures the DesiredCapabilities options with the key-value pairs passed in as a
     * 2-dimensional array
     *
     * @param driverBrowserName String representing the Browser name
     * @param driverBrowserVersion String representing the Browser version
     * @param driverOS String representing both the OS name and version
     * @param driverCapabilities browser-specific instance of the DesiredCapabilities interface
     * @param capabilityKeyValuePairs 2-dimensional array of key-value pairs with which to configure the DesiredCapabilities
     */
    private WebDriverType(String driverBrowserName, String driverBrowserVersion, String driverOS, DesiredCapabilities driverCapabilities, String[][] capabilityKeyValuePairs) {
        this.driverBrowserName = driverBrowserName;
        this.driverBrowserVersion = driverBrowserVersion;
        this.driverOS = driverOS;
        this.driverCapabilities = driverCapabilities;

        for(String[] row : capabilityKeyValuePairs){

            this.driverCapabilities.setCapability(row[0], row[1]);
        }
    }


    /**
     * Returns the Browser Name of the WebBrowserType
     *
     * @return Browser Name of the WebBrowserType
     */
    public String getDriverBrowserName() {
        return driverBrowserName;
    }

    /**
     * Returns the Browser Version of the WebBrowserType
     *
     * @return Browser Version of the WebBrowserType
     */
    public String getDriverBrowserVersion() {
        return driverBrowserVersion;
    }

    /**
     * Returns the OS and OS Version of the WebBrowserType
     *
     * @return OS and OS Version of the WebBrowserType
     */
    public String getDriverOS() {
        return driverOS;
    }

    /**
     * Return the DesiredCapabilities of the WebBrowserType
     *
     * @return DesiredCapabilities of the WebBrowserType
     */
    public DesiredCapabilities getDriverCapabilities() {
        return driverCapabilities;
    }

    private static final Logger logger = Logger.getLogger(WebDriverType.class);

}
