import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Random;

public class RegisterTest extends BaseTest {
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
    public void VerifyThatUserNavigateToRegistrationPageSuccessfully() {
        WebElement registerButton = driver.findElement(By.xpath("//a[@class='ico-register']"));
        registerButton.click();
        String expectedMessage = "Your Personal Details";
        WebElement message = driver.findElement(By.xpath("//strong[contains(text(),'Your Personal Details')]"));
        String actualResult = message.getText();
        Assert.assertEquals(expectedMessage, actualResult);

    }

    @Test
    public void verifyThatUserIsOnRegistrationPage() {
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        WebElement genderRadioButton = driver.findElement(By.xpath("//label[contains(text(),'Male')]"));
        genderRadioButton.click();
        WebElement firstNameField = driver.findElement(By.id("FirstName"));
        firstNameField.sendKeys("ram");
        WebElement lastNameField = driver.findElement(By.id("LastName"));
        lastNameField.sendKeys("krishna");
        Random randomGenerator = new Random();
        WebElement dateOfBirthFieldDay = driver.findElement(By.xpath("//form[1]//select[1]"));
        dateOfBirthFieldDay.sendKeys("10");
        WebElement dateOFBirthMonth = driver.findElement(By.xpath("//form[1]//select[2]"));
        dateOFBirthMonth.sendKeys("01");
        WebElement dareOfBirthYear = driver.findElement(By.xpath("//form[1]//select[3]"));
        dareOfBirthYear.sendKeys("2020");
        int randomInt = randomGenerator.nextInt(1000);
        WebElement idField = driver.findElement(By.id("Email"));
        idField.sendKeys("ramkrishna" + randomInt + "@yahoo.com");
        WebElement companyName = driver.findElement(By.xpath("//input[@id='Company']"));
        companyName.sendKeys("PrimeTesting");
        WebElement newsLetterCheckBox = driver.findElement(By.xpath("//label[contains(text(),'Newsletter:')]"));
        newsLetterCheckBox.click();
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("123456");
        WebElement confirmPasswordField = driver.findElement(By.id("ConfirmPassword"));
        confirmPasswordField.sendKeys("123456");
        WebElement registerButton1 = driver.findElement(By.id("register-button"));
        registerButton1.click();
        String expected = "Your registration completed";//
        WebElement message = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String actualResult = message.getText();
        Assert.assertEquals(expected, actualResult);
    }
}
