package com.solvd.pages.ios;

import com.solvd.pages.common.CartPage;
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

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPage.class)
public class CartPageIOS extends CartPage {

    @ExtendedFindBy(iosClassChain = Constants.HEADER_IOS)
    private HeaderIOS headerIOS;
    @ExtendedFindBy(iosPredicate = Constants.FOOTER_IOS)
    private FooterIOS footerIOS;
    @ExtendedFindBy(iosPredicate = "name == \"test-CONTINUE SHOPPING\"")
    private ExtendedWebElement shopButton;
    @ExtendedFindBy(iosPredicate = "name == \"test-CHECKOUT\"")
    private ExtendedWebElement checkoutButton;
    @ExtendedFindBy(iosPredicate = "name == \"test-Item\"")
    private List<ProductIOS> products;


    public CartPageIOS(WebDriver driver) {
        super(driver);
    }

    @Override
    public ExtendedWebElement getShoppingButton() {
        return shopButton;
    }

    @Override
    public ExtendedWebElement getCheckoutButton() {
        return checkoutButton;
    }

    @Override
    public List<? extends Product> getProducts() {
        return products;
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
