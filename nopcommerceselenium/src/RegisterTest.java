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
    public void setUp() {  //open browser
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() { //close browser
          closeBrowser();
    }

    @Test
    public void VerifyThatUserNavigateToRegistrationPageSuccessfully() { //click register page and verify
        WebElement registerButton = driver.findElement(By.xpath("//a[@class='ico-register']"));
        registerButton.click();
        String expectedMessage = "Your Personal Details";
        WebElement message = driver.findElement(By.xpath("//strong[contains(text(),'Your Personal Details')]"));
        String actualResult = message.getText();
        Assert.assertEquals(expectedMessage, actualResult);

    }

    @Test
    public void verifyThatUserIsOnRegistrationPage() {
        driver.findElement(By.xpath("//a[@class='ico-register']")).click(); //click on register page
        WebElement genderRadioButton = driver.findElement(By.xpath("//label[contains(text(),'Male')]")); //click on radio button
        genderRadioButton.click();
        WebElement firstNameField = driver.findElement(By.id("FirstName")); //first name field location
        firstNameField.sendKeys("ram"); //will send name
        WebElement lastNameField = driver.findElement(By.id("LastName"));//last name field location
        lastNameField.sendKeys("krishna"); //set last name on field
        WebElement dateOfBirthFieldDay = driver.findElement(By.xpath("//form[1]//select[1]")); //date
        dateOfBirthFieldDay.sendKeys("10");
        WebElement dateOFBirthMonth = driver.findElement(By.xpath("//form[1]//select[2]")); //month
        dateOFBirthMonth.sendKeys("01");
        WebElement dareOfBirthYear = driver.findElement(By.xpath("//form[1]//select[3]")); //year
        dareOfBirthYear.sendKeys("2020");
        Random randomGenerator = new Random(); //random object
        int randomInt = randomGenerator.nextInt(1000);
        WebElement idField = driver.findElement(By.id("Email")); //email field location
        idField.sendKeys("ramkrishna" + randomInt + "@yahoo.com"); //send email address
        WebElement companyName = driver.findElement(By.xpath("//input[@id='Company']")); // company name location
        companyName.sendKeys("PrimeTesting"); // set name on company field
        WebElement newsLetterCheckBox = driver.findElement(By.xpath("//label[contains(text(),'Newsletter:')]")); //newletter box location
        newsLetterCheckBox.click();
        WebElement passwordField = driver.findElement(By.id("Password")); // password field location
        passwordField.sendKeys("123456");
        WebElement confirmPasswordField = driver.findElement(By.id("ConfirmPassword"));  // confirm password field location
        confirmPasswordField.sendKeys("123456");
        WebElement registerButton1 = driver.findElement(By.id("register-button")); //click on register button
        registerButton1.click();
        String expected = "Your registration completed";//  to confirm register successfully
        WebElement message = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String actualResult = message.getText();
        Assert.assertEquals(expected, actualResult);
    }
}
