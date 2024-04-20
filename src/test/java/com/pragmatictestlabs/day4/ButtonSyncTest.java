package com.pragmatictestlabs.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ButtonSyncTest {
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://eviltester.github.io/synchole/buttons.html");

    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void testCollapseDiv() throws InterruptedException {

        //Click the button 1
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#easy00"))).click();
        //driver.findElement(By.cssSelector("#easy00")).click();
        //Click the button 2
//        driver.findElement(By.cssSelector("#easy01")).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#easy01"))).click();

        //Click the button 3
//        driver.findElement(By.cssSelector("#easy02")).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#easy02"))).click();

        //Click the button 4
//        driver.findElement(By.cssSelector("#easy03")).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#easy03"))).click();

        //Verify that the URL contains about.html
        Assert.assertEquals(driver.findElement(By.id("easybuttonmessage")).getText(), "All Buttons Clicked");

    }


    @Test
    public void testHardToSyncButton() throws InterruptedException {

        //Click the button 1
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#button00"))).click();

        //driver.findElement(By.cssSelector("#button00")).click();
        //Click the button 2

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button01"))).click();

        //driver.findElement(By.cssSelector("#button01")).click();

        //Click the button 3
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button02"))).click();

//         driver.findElement(By.cssSelector("#button02")).click();

        //Click the button 4
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button03"))).click();

//         driver.findElement(By.cssSelector("#button03")).click();

        //Verify that the URL contains about.html
        Assert.assertEquals(driver.findElement(By.id("buttonmessage")).getText(), "All Buttons Clicked");

    }


}
