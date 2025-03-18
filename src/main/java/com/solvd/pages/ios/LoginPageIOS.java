package com.solvd.pages.ios;

import com.solvd.pages.common.LoginPage;
import com.solvd.pages.common.ProductPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPage.class)
public class LoginPageIOS extends LoginPage {

    @ExtendedFindBy(iosPredicate = "name == \"test-Username\"")
    private ExtendedWebElement usernameForm;
    @ExtendedFindBy(iosPredicate = "name == \"test-Password\"" )
    private ExtendedWebElement passwordForm;
    @ExtendedFindBy(iosPredicate = "name == \"test-LOGIN\"")
    private ExtendedWebElement buttonLogin;
    @ExtendedFindBy(iosPredicate = "name == \"test-Error message\"")
    private ExtendedWebElement errorPopup;

    public LoginPageIOS(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductPage login(String username, String password) {
        usernameForm.type(username);
        passwordForm.type(password);
        buttonLogin.click();
        return initPage(getDriver(), ProductPage.class);
    }

    @Override
    public void clickLoginButton() {
        buttonLogin.click();
    }

    @Override
    public void inputUsername(String username) {
        usernameForm.type(username);
    }

    @Override
    public void inputPassword(String password) {
        passwordForm.type(password);
    }

    @Override
    public String getErrorName() {
        return errorPopup.getAttribute("label");
    }


}
