package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MyFirstTest {

    IOSDriver driver;

    @Before
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone XR");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/user/Library/Developer/Xcode/DerivedData/Depositphotos-dngujcpxdotlrzealqemqrzpipqw/Build/Products/Debug-iphonesimulator/Depositphotos.app");
        capabilities.setCapability(MobileCapabilityType.UDID, "DA377806-5192-44F1-8B51-7A59EA5DDEFF");
        capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, "com.dephotos.Depositphotos");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, "True");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "600");

        URL remoteUrl = new URL("http://127.0.0.01:4723/wd/hub");
        driver = new IOSDriver(remoteUrl,capabilities);
        System.out.println("Appium server started successfully");


    }

    @After
    public void teardown() {
        driver.quit();
    }


    @Test
    public void loginWithValidCredentials () throws InterruptedException {

        int xPoint = 30;
        int yPoint = 60;

        TouchAction openMenu = new TouchAction(driver).tap(PointOption.point(xPoint,yPoint)).perform();

        MobileElement loginPanel = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Log In\"]")); //*[@id="selectedElementContainer"]/div/div[2]/div/div[3]/div/div/div/div/div/div/table/tbody/tr[2]/td[2]/text()
        loginPanel.click();

        MobileElement loginButtonPage = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Log In\"]"));
        loginButtonPage.click();

        MobileElement inputLogin = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Depositphotos\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField"));
        inputLogin.click();
        inputLogin.sendKeys("qa.mob.com");

        MobileElement inputPasword = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Depositphotos\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField"));
        inputPasword.click();
        inputPasword.sendKeys("qwe123");

        MobileElement loginButton = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Log In\"]"));
        loginButton.click();


    }


}



