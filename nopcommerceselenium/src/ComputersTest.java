import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ComputersTest extends BaseTest {
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
    public void verifyThatUserShouldNavigateToComputersPage() {
        WebElement computerClick = driver.findElement(new By.ByXPath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        computerClick.click();

        String expectedResult ="Computers";
        WebElement message=driver.findElement(new By.ByXPath("//h1"));
       String actualResult =message.getText();
      //  System.out.println(actualResult);
        Assert.assertEquals(expectedResult,actualResult);

    }
    @Test
    public void verifyDesktopFunctionality(){
        WebElement computerClick = driver.findElement(new By.ByXPath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        computerClick.click();
        WebElement desktopClick =driver.findElement(By.xpath("//h2/a[@href='/desktops']"));
        desktopClick.click();
        String expectedResult ="Desktops";
        WebElement message=driver.findElement(new By.ByXPath("//h1"));
        String actualResult =message.getText();
      //  System.out.println(actualResult);
        Assert.assertEquals(expectedResult,actualResult);
    }
}
