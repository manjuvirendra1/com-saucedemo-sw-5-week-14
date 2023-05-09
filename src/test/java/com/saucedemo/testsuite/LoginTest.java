package com.saucedemo.testsuite;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {

    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT(){
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        loginPage.verifyProduct();
    }

    @Test(groups = {"sanity", "smoke", "regression"} )
    public void verifyThatSixProductsAreDisplayedOnPage() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        int actualNumber = productsPage.verifyProductList();
        int expectedNumber = 6;
        Assert.assertEquals(actualNumber,expectedNumber);
    }

}
