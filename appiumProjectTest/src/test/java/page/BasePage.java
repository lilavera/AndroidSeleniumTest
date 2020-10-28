package page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    protected static Logger logger;
    protected AndroidDriver<MobileElement> driver;
    protected WebDriverWait waitDriver;
    public BasePage(AndroidDriver<MobileElement> driver,WebDriverWait waitDriver)    {
        this.waitDriver = waitDriver;
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        logger = LoggerFactory.getLogger(this.getClass());
        logger.info("Create " + this.getClass().getSimpleName());
    }

    protected void waitForVisibility(AndroidElement element) throws Error{
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
