package com.solvd.pages.ios;

import com.solvd.pages.common.LoginPage;
import com.solvd.pages.common.MenuPage;
import com.solvd.pages.common.ProductPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MenuPage.class)
public class MenuPageIOS extends MenuPage {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name BEGINSWITH \"ALL\"`][4]/*")
    private List<ExtendedWebElement> menuButtons;

    public MenuPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(menuButtons.getFirst());
    }

    //Contains 9 buttons
    @Override
    public void clickButton(int buttonNumber) {
        menuButtons.get(buttonNumber).click();
    }

    @Override
    public LoginPage clickLogout() {
        menuButtons.get(7).click();
        return initPage(getDriver(), LoginPage.class);
    }

    @Override
    public ProductPage clickResetApp() {
        menuButtons.get(8).click();
        return initPage(getDriver(), ProductPage.class);
    }

}
