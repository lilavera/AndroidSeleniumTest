package page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
public AndroidDriver<MobileElement> driver;
@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Account\"]")
public AndroidElement loginIcon;


@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]\n")
public AndroidElement loginButton;

@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View\n")
public AndroidElement emailTextField;

@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.widget.Button\n")
public AndroidElement signUpButtonToConfirmEmail;

@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View\n")
public AndroidElement emailPasswordTextField;

@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View\n")
public AndroidElement nextButtonInPasswordView;

    public HomePage(AndroidDriver<MobileElement> driver, WebDriverWait waitDriver) {
        super(driver, waitDriver);
        PageFactory.initElements(new AppiumFieldDecorator(super.driver), this);

    }

    public void clickOnProfile(){
        waitForVisibility(loginIcon);
        loginIcon.click();
    }

    public void signUpToGoogleProfile(String email,String password){
        loginButton.click();
        waitForVisibility(emailTextField);
        emailTextField.sendKeys(email);
        signUpButtonToConfirmEmail.click();
        waitForVisibility(emailPasswordTextField);
        emailPasswordTextField.sendKeys(password);
        nextButtonInPasswordView.click();
    }

}
