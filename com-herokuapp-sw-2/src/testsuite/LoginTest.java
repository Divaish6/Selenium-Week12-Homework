package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl ="http://the-internet.herokuapp.com/login";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        //Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");

        //Enter “SuperSecretPassword!” password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        //Click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();


        //Verify the text “Secure Area”
        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.xpath("//h2[text()=' Secure Area']")).getText();
        Assert.assertEquals("Secure Area text is not found",expectedText,actualText);

    }
    @Test
    public void verifyTheUsernameErrorMessage(){

        //Enter “tomsmith1” username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith1");

        //Enter “SuperSecretPassword!” password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        //Click on ‘LOGIN’ button
        WebElement loginbutton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginbutton.click();

        //Verify the error message “Your username is invalid!”
        String expectedMessage = "Your username is invalid!";
        String actualMessage = driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        Assert.assertEquals("your username is invalid message is not found",expectedMessage,actualMessage);


    }
    @Test
    public void verifyThePasswordErrorMessage(){

        //Enter “tomsmith” username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");

        //Enter “SuperSecretPassword” password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword");

        //Click on ‘LOGIN’ button
        WebElement loginbutton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginbutton.click();

        //Verify the error message “Your password is invalid!”
        String expectedMessage = "Your username is invalid!";
        String actualMessage = driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        Assert.assertEquals("Error message is not found",expectedMessage,actualMessage);

    }
    @After
    public void teardown(){
        closeBrowser();
    }
}
