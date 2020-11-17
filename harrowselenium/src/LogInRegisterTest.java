import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogInRegisterTest extends BaseTest {
    String baseUrl = "https://www.harrow.gov.uk/ ";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

    @Test
    public void verifyThatUserShouldANavigateToLoginPageSuccessfully() {
        WebElement logInOrRegister = driver.findElement(By.className("icon-fallback"));
        //driver.findElement(By.xpath("//span[@class=\"icon-fallback\"]"));
        logInOrRegister.click();

        String expectedResult = "Already have a MyHarrow Account?";
        WebElement message = driver.findElement(By.xpath("//*[@id=\"citizenportal_login\"]/div[1]/div/h1"));
        String actualResult = message.getText();
        Assert.assertEquals(expectedResult, actualResult);


    }

    @Test
    public void verifyThatUsersShouldGetErrorMessageWithInvalidData() {
        verifyThatUserShouldANavigateToLoginPageSuccessfully();
        driver.findElement(By.id("username-input")).sendKeys("varsha@gmail.com");
        driver.findElement(By.id("password-input")).sendKeys("123456");
        driver.findElement(By.id("submitBtnSignIn")).click();
        String errorMessage = "Invalid Username/Password supplied";
        WebElement message = driver.findElement(By.xpath("//span[@id='password.errors']"));
        String actualMessage = message.getText();
        Assert.assertEquals(errorMessage, actualMessage);
    }

}
