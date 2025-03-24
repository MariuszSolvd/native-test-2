package com.solvd.pages.ios;

import com.solvd.pages.common.CartPage;
import com.solvd.pages.common.elements.Footer;
import com.solvd.pages.common.elements.Header;
import com.solvd.pages.ios.elements.FooterIOS;
import com.solvd.pages.ios.elements.HeaderIOS;
import com.solvd.utilis.Constants;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPage.class)
public class CartPageIOS extends CartPage {

    @ExtendedFindBy(iosClassChain = Constants.HEADER_IOS)
    private HeaderIOS headerIOS;
    @ExtendedFindBy(iosPredicate = Constants.FOOTER_IOS)
    private FooterIOS footerIOS;

    public CartPageIOS(WebDriver driver) {
        super(driver);
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
