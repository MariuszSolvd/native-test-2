package com.solvd.pages.common;

import com.solvd.pages.common.elements.Footer;
import com.solvd.pages.common.elements.Header;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CommonPage extends AbstractPage {

    public CommonPage(WebDriver driver) {
        super(driver);
    }

    public abstract Header getHeader();

    public abstract Footer getFooter();
}
