import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElectronicsTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp (){
        openBrowser(baseUrl);
    }
    public void tearDown(){
        closeBrowser();
    }
    @Test
    public void verifyThatUserShouldNavigateToElectronicsPage(){
        WebElement electronicsPage = driver.findElement(new By.ByXPath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        electronicsPage.click();

        String expectedResult ="Electronics";
        WebElement message=driver.findElement(new By.ByXPath("//h1"));
        String actualResult =message.getText();
        //System.out.println(actualResult);
        Assert.assertEquals(expectedResult,actualResult);

    }
    @Test
    public void verifyElectronicsPageFunctionality(){
        WebElement electronicsPage = driver.findElement(new By.ByXPath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        electronicsPage.click();
        WebElement cameraPhotoClick =driver.findElement(new By.ByXPath("//h2"));
        cameraPhotoClick.click();
        String expectedResult ="Camera & photo";
        WebElement message=driver.findElement(new By.ByXPath("//h1"));
        String actualResult =message.getText();
        //System.out.println(actualResult);
        Assert.assertEquals(expectedResult,actualResult);
    }


}
