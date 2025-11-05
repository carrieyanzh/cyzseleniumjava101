package org.lambdatest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
  private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

  //protected WebDriver driver;
  public static String username = System.getenv("LT_USERNAME");
  public static String accesskey = System.getenv("LT_ACCESS_KEY");
  public static final String HUB_URL =
    "https://" + username + ":" + accesskey + "@hub.lambdatest.com/wd/hub";

  public WebDriver getDriver() {
    return driverThread.get();
  }

  @Parameters({"browser", "version", "platform"})
  @BeforeMethod(alwaysRun = true)
  public void setUp(String browser, String version, String platform) throws Exception {

    Map<String, Object> ltOptions = new HashMap<>();
    ltOptions.put("username", username);
    ltOptions.put("accessKey", accesskey);
    ltOptions.put("platformName", platform);
    ltOptions.put("browserVersion", version);
    ltOptions.put("build", "Selenium Java 101 Modern Capabilities");
    ltOptions.put("name", browser + " Parallel Run");
    ltOptions.put("project", "LambdaTest Certification");
    ltOptions.put("selenium_version", "4.38.0");
    ltOptions.put("w3c", true);

    ltOptions.put("video", true);
    ltOptions.put("network", true);
    ltOptions.put("console", true);
    ltOptions.put("visual", true);
    ltOptions.put("capture_screenshots", true);

    MutableCapabilities browserOptions;

    switch (browser.toLowerCase()) {
      case "chrome":
        browserOptions = new ChromeOptions();
        break;
      case "microsoftedge":
        browserOptions = new EdgeOptions();
        break;
      case "firefox":
        browserOptions = new FirefoxOptions();
        break;
      case "internet explorer":
        EdgeOptions ieEdgeOptions = new EdgeOptions();
        browserOptions = ieEdgeOptions;
        ltOptions.put("ie.compatibility", true); // Enables IE Mode
        if ("11.0".equals(version)) {
          ltOptions.put("browserVersion", "127.0"); // Example Edge version supporting IE Mode
        } else {
          ltOptions.put("browserVersion", version);
        }
        break;
      default:
        throw new IllegalArgumentException("Unsupported browser: " + browser);
    }

    browserOptions.setCapability("LT:Options", ltOptions);

    driverThread.set(new RemoteWebDriver(new URL(HUB_URL), browserOptions));
    //driver = driverThread.get();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    if(getDriver() != null) {
      getDriver().quit();
    }
    driverThread.remove(); // clean up ThreadLocal
  }
}
