package com.solvd;

import org.testng.annotations.DataProvider;

public class TestDataProviders {

    @DataProvider(name = "wrongLoginData")
    public Object[][] wrongLoginCredentials() {
        return new Object[][] {
                {"standard", "wrong"},
                {"locked", "error"},
                {"problem", "bad"}
        };
    }
}
