package com.solvd.pages.ios;

import com.solvd.pages.common.ProductPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPage.class)
public class ProductPageIOS extends ProductPage {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == \"PRODUCTS\"`]")
    private ExtendedWebElement productText;

    public ProductPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(productText);
    }
}
