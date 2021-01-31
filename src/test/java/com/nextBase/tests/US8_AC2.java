package com.nextBase.tests;

import com.nextBase.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//2. Verify users can see all the task on task page.
public class US8_AC2 {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://login2.nextbasecrm.com");
        driver.findElement(By.cssSelector("input[name='USER_LOGIN']")).sendKeys("marketing28@cybertekschool.com");
        driver.findElement(By.cssSelector("input[name='USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[title='Tasks']")).click();
    }
    @Test
    public void test_users_CanSeeTasks() throws InterruptedException {
        WebElement homeButton = driver.findElement(By.cssSelector("a[title='Home']"));
        homeButton.click();
        Thread.sleep(2000);
        WebElement taskModule = driver.findElement(By.cssSelector("a[title='Tasks']"));
        taskModule.click();
        Thread.sleep(2000);
        WebElement allButton=driver.findElement(By.cssSelector("div[id='tasks_panel_menu_view_all']"));
        allButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(allButton.isEnabled());


    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }

}
