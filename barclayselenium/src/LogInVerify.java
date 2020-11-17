import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LogInVerify extends BaseTest {
    String baseUrl = "https://www.barclays.co.uk/  ";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        WebElement logInLink = driver.findElement(By.xpath(" //a[contains(text(),'Log In')]"));
        logInLink.click();
        String expectedMessage ="Quick, safe and convenient";

        WebElement message = driver.findElement(By.xpath("//*[@id=\"login-bootstrap\"]/div/ng-include[1]/div/div[2]/h2/strong"));

        String actualMessage = message.getText();
        Assert.assertEquals(expectedMessage, actualMessage);


    }

    @After
    public void tearDown() {
        //closeBrowser();
    }


}
