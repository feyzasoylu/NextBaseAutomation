package com.nextBase.tests;

import com.nextBase.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US8_AC1 {
    //1. Verify only hr and marketing team members can access to Task module.
    WebDriver driver;
   @BeforeMethod
    public void beforeTest() throws InterruptedException {
       driver = WebDriverFactory.getDriver("chrome");
       driver.get("https://login2.nextbasecrm.com/");
       Thread.sleep(2000);
    }
    @Test
    public void test_hr_CanAccess() throws InterruptedException {
        driver.findElement(By.cssSelector("input[name='USER_LOGIN']")).sendKeys("hr27@cybertekschool.com");
        driver.findElement(By.cssSelector("input[name='USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(3000);
        WebElement taskModule = driver.findElement(By.cssSelector("a[title='Tasks']"));
        Assert.assertTrue(taskModule.isDisplayed());
    }
    @Test
    public void test_marketing_CanAccess() throws InterruptedException {
        driver.findElement(By.cssSelector("input[name='USER_LOGIN']")).sendKeys("marketing27@cybertekschool.com");
        driver.findElement(By.cssSelector("input[name='USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(3000);
        WebElement taskModule = driver.findElement(By.cssSelector("a[title='Tasks']"));
        Assert.assertTrue(taskModule.isDisplayed());
    }
    @Test
    public void test_helpDesk_CannotAccess() throws InterruptedException {
        driver.findElement(By.cssSelector("input[name='USER_LOGIN']")).sendKeys("helpdesk28@cybertekschool.com");
        driver.findElement(By.cssSelector("input[name='USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(3000);
        WebElement homeButton = driver.findElement(By.cssSelector("a[title='Home']"));
        homeButton.click();
        Thread.sleep(2000);
        WebElement taskModule = driver.findElement(By.cssSelector("a[title='Tasks']"));
        Assert.assertFalse(taskModule.isDisplayed());
    }

    @AfterMethod
    public void afterTest() throws InterruptedException {
       Thread.sleep(5000);
       driver.close();
    }
}
