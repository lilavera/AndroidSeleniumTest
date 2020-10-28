package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import page.HomePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class LogInToGoogle extends BaseClass {

    HomePage page;
    @Test(priority = 1, description="Login Scenario")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test to Android app.")
    @Story("Valid username and password login test")
    public void loginToTheApp () throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/test/resources/appMobile.properties"));
        page = new HomePage(super.driver,wait);
        page.clickOnProfile();
        page.signUpToGoogleProfile("email","pass");

    }
}
