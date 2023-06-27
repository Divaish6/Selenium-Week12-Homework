package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {

    String baseUrl ="https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setupBrowser(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {

        //click on the ‘Forgot your password’ link
        WebElement ForgotPasswordLink = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        ForgotPasswordLink.click();

        //Verify the text ‘Reset Password’
        String expectedText = "Reset Password";
        String actualText = driver.findElement(By.xpath("//h6[text()='Reset Password']")).getText();
        Assert.assertEquals(" ‘Reset Password’ text not found",expectedText,actualText);
    }
    @After
    public void close(){
        closeBrowser();
    }
}
