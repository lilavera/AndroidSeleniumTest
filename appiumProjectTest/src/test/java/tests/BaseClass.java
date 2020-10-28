package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

public class BaseClass {
    public  AndroidDriver<MobileElement> driver;
    public RemoteWebDriver remoteWebDriver;
    public WebDriverWait wait;
    public AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    Logger log = Logger.getLogger(BaseClass.class);

    public boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }


    @BeforeTest
    public void setup() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/test/resources/appMobile.properties"));
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 2 API 25");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "7.1.1");
        caps.setCapability("appActivity", prop.getProperty("appWaitActivity"));
        caps.setCapability("appPackage", prop.getProperty("appWaitPackage"));
        caps.setCapability("appWaitPackage", prop.getProperty("appWaitPackage"));
        caps.setCapability("appWaitActivity", prop.getProperty("appWaitActivity"));
        //service.start();
        if (!checkIfServerIsRunnning(4723)) {
            builder = new AppiumServiceBuilder();
            builder.withIPAddress("127.0.0.1");
            builder.usingPort(4723);
            builder.withCapabilities(caps);
            AppiumDriverLocalService service = AppiumDriverLocalService
                    .buildService(builder);
            service.start();
        } else {
            log.info("Appium is already running");
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            wait = new WebDriverWait(driver, 20);

        }
    }

        @AfterTest
        public void teardown () {
            service.stop();
            driver.quit();
        }
    }

