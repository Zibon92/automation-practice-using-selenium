package com.walltouchbd;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ResourceBundle;

public class DriverSetup {
    public static WebDriver driver;
    public static ResourceBundle bundle = ResourceBundle.getBundle("config");
    public static String baseUrl = bundle.getString("BASE_URL");

    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);
        driver.get(baseUrl);
    }

    public void closeBrowser() {
        driver.quit();
    }
}
