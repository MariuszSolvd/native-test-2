package com.solvd.service;

import com.solvd.pages.common.LoginPage;
import com.solvd.pages.common.ProductPage;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class LoginService implements ICustomTypePageFactory {

    public static ProductPage login() {
        LoginService loginService = new LoginService();
        LoginPage loginPage = loginService.initPage(loginService.getDriver(), LoginPage.class);
        return loginPage.login(R.TESTDATA.get("user.standard"), R.TESTDATA.get("user.password"));
    }
}
