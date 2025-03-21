package com.solvd.pages.ios;

import com.solvd.pages.common.ProductPage;
import com.solvd.pages.common.SelectionPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SelectionPage.class)
public class SelectionPageIOS extends SelectionPage {

    @ExtendedFindBy(iosPredicate = "name == \"Name (A to Z)\"")
    private ExtendedWebElement sortAtoZButton;
    @ExtendedFindBy(iosPredicate = "name == \"Name (Z to A)\"")
    private ExtendedWebElement sortZtoAButton;
    @ExtendedFindBy(iosPredicate = "name == \"Price (low to high)\"")
    private ExtendedWebElement sortPriceLowToHigh;
    @ExtendedFindBy(iosPredicate = "name == \"Price (high to low)\"")
    private ExtendedWebElement sortPriceHighToLow;
    @ExtendedFindBy(iosPredicate = "**/XCUIElementTypeOther[`name == \"Cancel\"`][1]")
    private ExtendedWebElement cancelButton;

    public SelectionPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(cancelButton);
    }

    @Override
    public ProductPage sortAtoZButton() {
        sortAtoZButton.click();
        return getBackToProductPage();
    }

    @Override
    public ProductPage sortZtoAButton() {
        sortZtoAButton.click();
        return getBackToProductPage();
    }

    @Override
    public ProductPage sortPriceLowToHigh() {
        sortPriceLowToHigh.click();
        return getBackToProductPage();
    }

    @Override
    public ProductPage sortPriceHighToLow() {
        sortPriceHighToLow.click();
        return getBackToProductPage();
    }

    @Override
    public ProductPage clickCancelButton() {
        cancelButton.click();
        return getBackToProductPage();
    }

    private ProductPage getBackToProductPage() {
        return initPage(getDriver(), ProductPage.class);
    }


}
