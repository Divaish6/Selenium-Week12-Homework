package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public  void setUP(){
        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){

        //Enter “standard_user” username
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");

        //Enter “secret_sauce” password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("secret_sauce");

        //Click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        //Verify the text “PRODUCTS”
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[text()='Products']")).getText();
        Assert.assertEquals("Products text not found ",expectedText,actualText);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){

        //Enter “standard_user” username
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");

        //Enter “secret_sauce” password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("secret_sauce");

        //Click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        //Verify that six products are displayed on page
        List<WebElement> productList = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        System.out.println("Total products are : " + productList.size());

        int expectedText = 6;
        int actualText = productList.size();
        Assert.assertEquals("six product not displayed",expectedText,actualText);
    }
    @After
    public void teardown(){

        closeBrowser();
    }
}
