package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {

    @Before
    public void setup(){
        openBrowser();
    }
    @Test
    public void userShouldNavigateToComputerPageSuccessfully(){
        //click on the ‘Computers’ Tab
        WebElement linkText = driver.findElement(By.linkText("Computers"));
        linkText.click();

        //Verify the text ‘Computers’
        String expectedText = "Computers";
        String actualText = driver.findElement(By.xpath("//h1[text()='Computers']")).getText();
        Assert.assertEquals("Computer text is not found", expectedText, actualText);
    }
    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully(){
        //click on the ‘Electronics’ Tab
        WebElement linkText = driver.findElement(By.linkText("Electronics"));
        linkText.click();

        //Verify the text ‘Electronics’
        String expectedText = "Electronics";
        String actualText = driver.findElement(By.xpath("//h1[text()='Electronics']")).getText();
        Assert.assertEquals("Electronics text is not found", expectedText, actualText);
    }
    @Test
    public void userShouldNavigateToApparelPageSuccessfully(){
        //click on the ‘Apparel’ Tab
        WebElement linkText = driver.findElement(By.linkText("Apparel"));
        linkText.click();

        //Verify the text ‘Apparel’
        String expectedText = "Apparel";
        String actualText = driver.findElement(By.xpath("//h1[text()='Apparel']")).getText();
        Assert.assertEquals("Apparel text is not found", expectedText, actualText);
    }
    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully(){
        //click on the ‘Digital downloads ’ Tab
        WebElement linkText = driver.findElement(By.linkText("Digital downloads"));
        linkText.click();

        //Verify the text ‘Digital downloads ’
        String expectedText = "Digital downloads";
        String actualText = driver.findElement(By.xpath("//h1[text()='Digital downloads']")).getText();
        Assert.assertEquals("Digital downloads text is not found", expectedText, actualText);
    }
    @Test
    public void userShouldNavigateToBooksPageSuccessfully(){
        //click on the ‘Books’ Tab
        WebElement linkText = driver.findElement(By.linkText("Books"));
        linkText.click();

        //Verify the text ‘Books’
        String expectedText = "Books";
        String actualText = driver.findElement(By.xpath("//h1[text()='Books']")).getText();
        Assert.assertEquals("Books text is not found", expectedText, actualText);
    }
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully(){
        //click on the ‘Jewelry’ Tab
        WebElement linkText = driver.findElement(By.linkText("Jewelry"));
        linkText.click();

        //Verify the text ‘Jewelry’
        String expectedText = "Jewelry";
        String actualText = driver.findElement(By.xpath("//h1[text()='Jewelry']")).getText();
        Assert.assertEquals("Jewelry text is not found", expectedText, actualText);
    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
        //click on the ‘Gift Cards ’ Tab
        WebElement linkText = driver.findElement(By.linkText("Gift Cards"));
        linkText.click();

        //Verify the text ‘Gift Cards’
        String expectedText = "Gift Cards";
        String actualText = driver.findElement(By.xpath("//h1[text()='Gift Cards']")).getText();
        Assert.assertEquals("Gift Cards text is not found", expectedText, actualText);
    }

    @After
    public void close(){

        closeBrowser();
    }
}
