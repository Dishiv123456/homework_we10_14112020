import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JewelryTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
    @Test
    public void verifyThatUserShouldNavigateToJwelryPage(){
        WebElement jwelryClick =driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[6]/a[1]"));
        jwelryClick.click();
        String expectedResult ="Jewelry";
        WebElement message=driver.findElement(By.xpath("//h1[contains(text(),'Jewelry')]"));
        String actualResult =message.getText();
        Assert.assertEquals(expectedResult,actualResult);
    }
}
