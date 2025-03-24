package com.solvd.pages.ios;

import com.solvd.pages.common.CartPage;
import com.solvd.pages.common.ProductPage;
import com.solvd.pages.common.SelectionPage;
import com.solvd.pages.common.elements.Footer;
import com.solvd.pages.common.elements.Header;
import com.solvd.pages.common.elements.Product;
import com.solvd.pages.ios.elements.FooterIOS;
import com.solvd.pages.ios.elements.HeaderIOS;
import com.solvd.pages.ios.elements.ProductIOS;
import com.solvd.utilis.Constants;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPage.class)
public class ProductPageIOS extends ProductPage {

    @ExtendedFindBy(iosClassChain = Constants.HEADER_IOS)
    private HeaderIOS headerIOS;
    @ExtendedFindBy(iosPredicate = Constants.FOOTER_IOS)
    private FooterIOS footerIOS;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == \"PRODUCTS\"`]")
    private ExtendedWebElement productText;
    @ExtendedFindBy(iosPredicate = "name == \"test-Item\"")
    private List<ProductIOS> products;
    @ExtendedFindBy(iosPredicate = "name == \"test-Modal Selector Button\"")
    private ExtendedWebElement selectorButton;
    @ExtendedFindBy(iosPredicate = "name == \"test-Cart\"")
    private ExtendedWebElement cartButton;

    public ProductPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(productText);
    }

    @Override
    public List<? extends Product> getProducts() {
        return products;
    }

    @Override
    public SelectionPage clickSelectionButton() {
        selectorButton.click();
        return initPage(getDriver(), SelectionPage.class);
    }

    @Override
    public CartPage cartButton() {
        cartButton.click();
        return initPage(getDriver(), CartPage.class);
    }

    @Override
    public Header getHeader() {
        return headerIOS;
    }

    @Override
    public Footer getFooter() {
        return footerIOS;
    }


}
