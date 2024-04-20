package com.pragmatictestlabs.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class IntroductionToSyncTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void testCollapseDiv() throws InterruptedException {

        driver = new ChromeDriver();
        driver.navigate().to("https://eviltester.github.io/synchole/collapseable.html");

        //Click the section
        driver.findElement(By.cssSelector("section.condense")).click();

        //Thread.sleep(5000); NEVER USE
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); Deprecated  and avoid using
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        //Click the About link
        driver.findElement(By.cssSelector("a#aboutlink")).click();


        //Verify that the URL contains about.html
        Assert.assertTrue(driver.getCurrentUrl().contains("about.html"));
    }


}
