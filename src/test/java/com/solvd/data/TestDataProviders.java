package com.solvd.data;

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

    @DataProvider(name = "correctLoginData")
    public Object[][] correctLoginCredentials() {
        String password = "secret_sauce";
        return new Object[][] {
                {"standard_user", password},
                {"problem_user", password}
        };
    }
}
