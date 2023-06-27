package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest{

    String baseUrl ="https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setupBrowser(){

        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter “Admin” username
//       driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        //driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder = 'Username']")).sendKeys("Admin");
        //Enter "admin123" password
        driver.findElement(By.xpath("//input[@placeholder ='Password']")).sendKeys("admin123");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Verify the ‘Dashboard’ text is display
        String expectedMessage = "Dashboard";
        String actualMessage = driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']")).getText();
        Assert.assertEquals(" Dashboard text not on display",expectedMessage,actualMessage);
    }
    @After
    public void close(){
        closeBrowser();
    }
}
