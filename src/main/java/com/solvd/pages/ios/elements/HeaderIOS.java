package com.solvd.pages.ios.elements;

import com.solvd.pages.common.CartPage;
import com.solvd.pages.common.MenuPage;
import com.solvd.pages.common.elements.Header;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = Header.class)
public class HeaderIOS extends Header {

    @ExtendedFindBy(iosPredicate = "name == \"test-Menu\"")
    private ExtendedWebElement hamburgerMenu;
    @ExtendedFindBy(iosPredicate = "name == \"test-Cart\"")
    private ExtendedWebElement cartButton;

    public HeaderIOS(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    @Override
    public MenuPage clickHamburgerMenu() {
        clickIOS(hamburgerMenu);
        return initPage(getDriver(), MenuPage.class);
    }

    @Override
    public ExtendedWebElement getCartButton() {
        return cartButton;
    }

    @Override
    public CartPage clickCart() {
        clickIOS(cartButton);
        return initPage(getDriver(), CartPage.class);
    }

    private void clickIOS(ExtendedWebElement element) {
        Point point = element.getLocation();
        Dimension size = element.getSize();
        tap(point.getX() + size.getWidth() / 2, point.getY() + size.getHeight() / 2 + 4);
    }
}
