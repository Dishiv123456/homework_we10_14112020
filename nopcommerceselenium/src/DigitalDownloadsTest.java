import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DigitalDownloadsTest extends BaseTest {
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
    public void verifyThatUserShouldNavigateToDigitalDownloadsPage() {

        WebElement digitalPage = driver.findElement(By.xpath("//div[6]/div[2]/ul[1]/li[4]"));
        digitalPage.click();
        String expectedResult = "Digital downloads";
        WebElement message = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]"));
        String actualResult = message.getText();
        Assert.assertEquals(expectedResult, actualResult);

    }
}
