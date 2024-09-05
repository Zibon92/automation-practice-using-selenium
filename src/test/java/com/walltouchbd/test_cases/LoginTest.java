package com.walltouchbd.test_cases;

import com.walltouchbd.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import com.walltouchbd.page_object.LoginPage;

public class LoginTest extends DriverSetup {
    String phoneNumber = bundle.getString("PHONE_NUMBER");
    String password = bundle.getString("PASSWORD");
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        openBrowser();
    }

    @Test
    public void verifyLoginAndSearchItem() {
//      Step1: LogIn_To_The_Website

        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.loginToAccount(phoneNumber, password);
        WebElement success = driver.findElement(By.xpath("//small[text()='Hello, demo']"));
        String successText = success.getText();
        String expectedText= "Hello, demo";
        Assert.assertEquals(successText,expectedText);

//      Step2: Search_For_Toys

        loginPage.searchItems("toys");
        Assert.assertTrue(loginPage.getTotalSearchItem() > 0);

//      Step3: Access_the_first_item

        loginPage.selectFirstItem();
        loginPage.navigateToItem();
        Assert.assertEquals("Slimy smooth spinning yoyo-yellow- baby toys","Slimy smooth spinning yoyo-yellow- baby toys");
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}
