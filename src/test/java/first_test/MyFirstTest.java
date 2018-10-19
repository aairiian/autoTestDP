package appium;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

class MyFirstTest {

    IOSDriver driver;

    @Before
    public void setup() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone XR");
        capabilities.setCapability(MobileCapabilityType.APP, "//Users/user/Documents/Depositphotos.app");
        capabilities.setCapability(MobileCapabilityType.UDID, "DA377806-5192-44F1-8B51-7A59EA5DDEFF");
        capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, "com.dephotos.Depositphotos");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, "True");

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test

    public void selectScrollView() {
        driver.findElement(By.name("TypeScrollView")).click();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}