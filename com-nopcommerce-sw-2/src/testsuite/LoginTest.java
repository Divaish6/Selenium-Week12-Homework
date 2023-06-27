package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

@Before
   public void setup(){

    openBrowser();
   }

@Test
    public void userShouldNavigateToLoginPageSuccessfully() {
    //click on the ‘Login’ link
    WebElement linktext = driver.findElement(By.linkText("Log in"));
    linktext.click();

    //Verify the text ‘Welcome, Please Sign In!’
    String expectedText = "Welcome, Please Sign In!";
    String actualText = driver.findElement(By.tagName("h1")).getText();
    Assert.assertEquals("Not redirected to Login page", expectedText, actualText);
}
@Test
   public void userShouldLoginSuccessfullyWithValidCredentials() {
    //click on the ‘Login’ link
    WebElement linktext = driver.findElement(By.linkText("Log in"));
    linktext.click();

    //Enter email field
    driver.findElement(By.id("Email")).sendKeys("divyeshvish@gmail.com");
    //Enter password field
    driver.findElement(By.name("Password")).sendKeys("143Vaishali");

    //Click on Login Button
    driver.findElement(By.xpath("//button[text() ='Log in']")).click();


    //Verify the text ‘Log out’
    String expectedText = "Log out";
    String actualText = driver.findElement(By.linkText("Log out")).getText();
    Assert.assertEquals("Log out text is not found ", expectedText, actualText);


}

@Test
        public void verifyTheErrorMessage(){
    //click on the ‘Login’ link
    WebElement linktext = driver.findElement(By.linkText("Log in"));
    linktext.click();

    //Enter invalid Email
    driver.findElement(By.id("Email")).sendKeys("Divaish@gmail.com");

    //Enter invalid
    driver.findElement(By.name("Password")).sendKeys("1234Divash");

    //Click on Login Button
    driver.findElement(By.xpath("//button[text() ='Log in']")).click();

    String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
            "No customer account found";
    String actualMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
    Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);


}

    @After
    public void teardown(){

    closeBrowser();
    }
}


