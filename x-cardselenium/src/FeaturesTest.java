import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FeaturesTest extends BaseTest {
    String baseUrl="https://www.x-cart.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @After
    public void tearDown(){
        //closeBrowser();
    }
    @Test
    public void verifyThatUserShouldNavigateToFeatures(){
        WebElement featureClick =driver.findElement(By.xpath("//body/nav[1]/div[1]/ul[1]/li[1]/a[1]"));
        featureClick.click();
        String expectedResult="Never get locked into one way of doing business ever again.";
        WebElement message =driver.findElement(By.xpath("//h1[contains(text(),'Never get locked into one way of doing business ev')]"));
String actualResult =message.getText();
        Assert.assertEquals(expectedResult,actualResult);

    }

}
