import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GiftCardsTest extends BaseTest{
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp (){
        openBrowser(baseUrl);
    }
    public void tearDown(){
        closeBrowser();
    }
    @Test
    public void verifyThatUserShouldNavigateToGiftCardPage() {
    WebElement giftCardPage = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]"));
        giftCardPage.click();
    String expectedResult = "Gift Cards";
    WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Gift Cards')]"));
    String actualResult = message.getText();
        Assert.assertEquals(expectedResult, actualResult);



}}
