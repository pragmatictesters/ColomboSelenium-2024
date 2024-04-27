package com.pragmatictestlabs.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptPopupsTest {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.get("http://demosite.pragmatictestlabs.com/Alerts.html");
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void testAlertMessage(){
        //Test
        driver.findElement(By.id("alert")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "This is a simple Alert");
        alert.accept();
        Assert.assertEquals(driver.findElement(By.id("confirm-demo")).getText(), "Alert was closed!");
    }



}
