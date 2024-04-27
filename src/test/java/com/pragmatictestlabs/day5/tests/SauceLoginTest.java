package com.pragmatictestlabs.day5.tests;

import com.pragmatictestlabs.day5.BaseTest;
import com.pragmatictestlabs.day5.pages.LandingPage;
import com.pragmatictestlabs.day5.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceLoginTest extends BaseTest {


    @Test
    public void testLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.typeUsername("standard_user")
                .typePassword("secret_sauce")
                .clickLogin()
        ;

        //Work with the landing page
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertEquals(landingPage.getPageTitle(), "Products");

    }

    @Test
    public void testLoginWithValidCredentials2() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        //Work with the landing page
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertEquals(landingPage.getPageTitle(), "Products");

    }


    @Test
    public void testLoginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "test1234");
        Assert.assertEquals(loginPage.getError(), "Epic sadface: Username and password do not match any user in this service");
    }

  @Test
    public void testLoginWithBlankUsernameAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getError(), "Epic sadface: Username is required");
    }



}
