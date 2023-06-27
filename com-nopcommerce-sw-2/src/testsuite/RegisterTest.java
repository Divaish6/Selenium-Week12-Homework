package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    @Before
    public void setup(){
        openBrowser();
    }
    @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){
        //click on the ‘Register’ link
        WebElement linktext = driver.findElement(By.linkText("Register"));
        linktext.click();

        //Verify the text ‘Register’
        String expectedText = "Register";
        String actualText = driver.findElement(By.linkText("Register")).getText();
        Assert.assertEquals("Register text is not found", expectedText, actualText);
    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){
        //click on the ‘Register’ link
        WebElement linktext = driver.findElement(By.linkText("Register"));
        linktext.click();

        //Select gender radio button
        WebElement radiobutton = driver.findElement(By.xpath("//input[@value='M']"));
        radiobutton.click();

        //Enter First name
        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstNameField.sendKeys("Divaish");

        //Enter Last name
        WebElement lastNameField = driver.findElement(By.xpath("//input[@name='LastName']"));
        lastNameField.sendKeys("Roman");

        //Select Day Month and Year
        WebElement day = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        day.sendKeys("10");

        WebElement month = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        month.sendKeys("June");

        WebElement year = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        year.sendKeys("1999");

        //Enter Email address
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("Divaish@gmail.com");

        //Enter Password
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("1234Divash");

        //Enter Confirm password
        WebElement confirmPasswordField = driver.findElement(By.id("ConfirmPassword"));
        confirmPasswordField.sendKeys("1234Divash");

        //Click on REGISTER button
        WebElement Registerbutton = driver.findElement(By.xpath("//button[@id='register-button']"));
        Registerbutton.click();
    }
    @After
    public void close(){
        closeBrowser();
    }

}
