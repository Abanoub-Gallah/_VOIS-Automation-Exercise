package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.net.MalformedURLException;
import java.net.URL;

import static data.URL.WEBSITE_URL;

public class TestBase {

    protected ThreadLocal<RemoteWebDriver> driver = null ;

    @BeforeClass
    @Parameters(value= {"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException
    {
        driver = new ThreadLocal<>();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", browser);

        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps));

        getDriver().navigate().to(WEBSITE_URL);
    }

    public WebDriver getDriver()
    {
        return driver.get();
    }

    @AfterClass
    public void stopDriver()
    {
        getDriver().quit();
        driver.remove();
    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenshot(getDriver(), result.getName());
        }
    }

}
