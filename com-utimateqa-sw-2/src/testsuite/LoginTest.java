package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public  void setUP(){

        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //click on the ‘Sign In’ link
        WebElement linkSignIN = driver.findElement(By.linkText("Sign In"));
        linkSignIN.click();

        //Verify the text ‘Welcome Back!’
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[@class = 'page__heading']")).getText();
        Assert.assertEquals("Welcome Back! text is not found",expectedText,actualText);

    }
    @Test
    public void verifyTheErrorMessage(){

        //click on the ‘Sign In’ link
        WebElement linkSignIN = driver.findElement(By.linkText("Sign In"));
        linkSignIN.click();

        //Enter invalid Email
        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.sendKeys("divajs@gmail.com");


        //Enter invalid password
        WebElement passwordField = driver.findElement(By.xpath("//input[@type= 'password']"));
        passwordField.sendKeys("123Divhajs");

        //Click on Signin button
        WebElement SigninButton = driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']"));
        SigninButton.click();

        //Verify the error message ‘Invalid email or password.’
        String expectedMessage ="Invalid email or password.";
        String actualMessage = driver.findElement(By.xpath("//ul[@class='form-error__list']")).getText();
        Assert.assertEquals("error message not found",expectedMessage,actualMessage);
    }
    @After
    public void teardown(){
        closeBrowser();
    }
}
