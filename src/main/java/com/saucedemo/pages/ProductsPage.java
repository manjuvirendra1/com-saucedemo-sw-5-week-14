package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ProductsPage extends Utility {


    @CacheLookup
            @FindBy(linkText = "Products")
    WebElement productText;
    //By productText = By.linkText("Products");

//    @CacheLookup
//            @FindBy(xpath = "//div[@class='inventory_item']")
//            WebElement productList;
   // By productList = By.xpath("//div[@class='inventory_item']");

    public String verifyText() {
        Reporter.log("Verify Products");
        CustomListeners.test.log(Status.PASS, "Verify Products");
        return getTextFromElement(productText);


    }
    public int verifyProductList(){
        Reporter.log("Verify that six products are displayed");
        CustomListeners.test.log(Status.PASS, "Verify that six products are displayed");
       return getSize(By.xpath("//div[@class='inventory_item']"));

    }




}
