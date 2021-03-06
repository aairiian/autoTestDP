package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

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
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, "False");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");

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
        int x = 205, x1 = 194;
        int y = 635, y1 = 250;


        TouchAction openMenu = new TouchAction(driver);
        openMenu.tap(PointOption.point(xPoint, yPoint));
        openMenu.perform();

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

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/XCUIElementTypeApplication[@name=\"Depositphotos\"]")));

        TouchAction viewProfile = new TouchAction(driver);
        viewProfile.tap(PointOption.point(xPoint, yPoint));
        viewProfile.waitAction();
        viewProfile.release();
        viewProfile.perform();

        WebDriverWait forPanel = new WebDriverWait(driver,10);
        forPanel.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeApplication[@name=\"Depositphotos\"]")));

        MobileElement userNameString = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"qa.mob.com\"]"));
        userNameString.click();

        WebDriverWait forViewProfile = new WebDriverWait(driver,10);
        forViewProfile.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Profile\"]")));

        TouchAction backToPanel = new TouchAction(driver);
        backToPanel.tap(PointOption.point(xPoint,yPoint));
        backToPanel.waitAction();
        backToPanel.release();
        backToPanel.perform();

        WebDriverWait forHome = new WebDriverWait(driver,10);
        forHome.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Home\"]")));

        MobileElement pressHome = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Home\"]"));
        pressHome.click();

        WebDriverWait forViewHome = new WebDriverWait(driver,10);
        forViewHome.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeApplication[@name=\"Depositphotos\"]")));


        TouchAction swipeUp = new TouchAction(driver);
        swipeUp.press(PointOption.point(x, y));
        swipeUp.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)));
        swipeUp.moveTo(PointOption.point(x1,y1));
        swipeUp.release();
        swipeUp.perform();

        WebDriverWait forFreeFiles = new WebDriverWait(driver,10);
        forFreeFiles.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Free Files\"]")));




    }


}



