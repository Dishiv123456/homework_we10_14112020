import com.sun.java.accessibility.util.EventID;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class logInTest extends BaseTest {
    public String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @After
    public void tearDown() {

        closeBrowser();
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {  //this method will nag=vigate to login page
        WebElement loginButton = driver.findElement(By.className("ico-login"));
        loginButton.click();
        String expectedMessage = "Welcome, Please Sign In!";  //will verify that we are on right place
        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = message.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void verifyUserShouldGetErrorMessageWithInvalidData() throws InterruptedException {   //negative test case
        WebElement loginButton = driver.findElement(By.className("ico-login"));
        loginButton.click();
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("vpatel@gmail.com");
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("12346");
        WebElement login = driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[3]/input[1]"));
        login.click();

    }

    @Test
    public void VerifyErrorMessageWithInValidData() {

        WebElement loginButton = driver.findElement(By.className("ico-login"));
        loginButton.click();
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("vpatel@gmail.com");
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("12346");
        WebElement login = driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[3]/input[1]"));
        login.click();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        WebElement message = driver.findElement(By.xpath("//div[contains(text(),'Login was unsuccessful. Please correct the errors and try again.')]"));
        String actualErrorMessage = message.getText();

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

}
