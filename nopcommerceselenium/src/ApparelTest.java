import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ApparelTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp (){
        openBrowser(baseUrl);
    }
    public void tearDown(){
        closeBrowser();
    }
    @Test
    public void verifyThatUserShouldNavigateToApparelPage(){
        WebElement apparelsPage = driver.findElement(new By.ByXPath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        apparelsPage.click();

        String expectedResult ="Apparel";
        WebElement message=driver.findElement(new By.ByXPath("//h1"));
        String actualResult =message.getText();
        System.out.println(actualResult);
        Assert.assertEquals(expectedResult,actualResult);

    }
    @Test
    public void verifyApparelPageFunctionality(){
        WebElement apparelsPage = driver.findElement(new By.ByXPath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        apparelsPage.click();
        WebElement shoesClick =driver.findElement(new By.ByXPath("//h2"));
        shoesClick.click();
        String expectedResult ="Shoes";
        WebElement message=driver.findElement(new By.ByXPath("//h1"));
        String actualResult =message.getText();
        System.out.println(actualResult);
        Assert.assertEquals(expectedResult,actualResult);
    }




}
