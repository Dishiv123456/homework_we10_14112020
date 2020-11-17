import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;

    public void openBrowser(String baseUrl) { //openbrowser
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //setproperty for webdriver
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(+2000, 0)); //open browser in 2nd screen
        driver.manage().window().maximize(); //maximize window
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //wait
        driver.get(baseUrl);

    }

    public void closeBrowser() { //close browser
        driver.quit();
    }
}
