package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage extends Utility {

    
    @CacheLookup
            @FindBy(xpath = "//input[@name='user-name']")
    WebElement userNameField;
    //By userNameField = By.xpath("//input[@name='user-name']");

    @CacheLookup
            @FindBy(xpath = "//input[@name='password']")
            WebElement passwordField;
    //By passwordField= By.xpath("//input[@name='password']");

    @CacheLookup
            @FindBy(xpath = "//input[@id='login-button']")
            WebElement clickOnLogin;
    //By clickOnLogin = By.xpath("//input[@id='login-button']");


    @CacheLookup
    @FindBy(xpath = "//span[@class='title']")
    WebElement verifyProducts;

    public void enterUsername(String username) {
        Reporter.log("Enter “standard_user” username");
        sendTextToElement(userNameField, username);
        CustomListeners.test.log(Status.PASS, "Enter “standard_user” username" + username);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter “secret_sauce” password");
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "Enter “secret_sauce” password" + password);
    }

    public void clickOnLoginButton(){
        Reporter.log("Click on Login Button");
        clickOnElement(clickOnLogin);
        CustomListeners.test.log(Status.PASS, "Click on Login Button");
    }

    public void verifyProduct(){
        Reporter.log("Verify the text “PRODUCTS”");
        String expectedMessage ="Products";
        String actualMessage = getTextFromElement(verifyProducts);
        Assert.assertEquals(actualMessage, expectedMessage);
        CustomListeners.test.log(Status.PASS, "Verify the text “PRODUCTS”");

    }




}
