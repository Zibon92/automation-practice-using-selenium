package com.walltouchbd.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage {
    WebDriver driver;
    By manIcon = By.xpath("//a[@class='navbar-tool ml-md-3']");
    By signIn = By.xpath("//a[@href='https://www.walltouchbd.com/customer/auth/login']");
    By phone = By.xpath( "//input[@name='user_id']");
    By pass = By.xpath( "//input[@id='si-password']");
    By signNowButton = By.xpath( "(//button[@type='submit'])[2]");
    By searchField = By.name("name");
    By searchResults = By.xpath("//li[@class='list-group-item']/a");
    List<WebElement> items;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        WebElement man = driver.findElement(manIcon);
        man.click();
        driver.findElement(signIn).click();

    }
    public void loginToAccount(String phoneNumber, String password) {
        driver.findElement(phone).sendKeys(phoneNumber);
        driver.findElement(pass).sendKeys(password);
        driver.findElement(signNowButton).click();

    }



    public void verifyLoginSuccessful() {

    }

    public void searchItems(String str) {
        driver.findElement(searchField).sendKeys(str);
        sleep(5);
    }

    public int getTotalSearchItem() {
        items = driver.findElements(searchResults);
        return items.size();
    }

    public void selectFirstItem() {
        items.get(0).click();
    }

    public void navigateToItem() {
        // do something
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
