package com.solvd.pages.ios;

import com.solvd.pages.common.ProductPage;
import com.solvd.pages.common.elements.Header;
import com.solvd.pages.common.elements.Product;
import com.solvd.pages.ios.elements.HeaderIOS;
import com.solvd.pages.ios.elements.ProductIOS;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPage.class)
public class ProductPageIOS extends ProductPage {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[$name == \"headerContainer\"$][-2]")
    private HeaderIOS headerIOS;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == \"PRODUCTS\"`]")
    private ExtendedWebElement productText;
    @ExtendedFindBy(iosPredicate = "name == \"test-Item\"")
    private List<ProductIOS> products;

    public ProductPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(productText);
    }

    @Override
    public List<? extends Product> getProducts() {
        return products;
    }

    @Override
    public Header getHeader() {
        return headerIOS;
    }


}
