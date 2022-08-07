import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;

import java.sql.Driver;
import java.time.Duration;

public class Practice_Form extends BasePage
{
    WebDriver driver;

    @Before
    public  void setup(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--headedless");
        driver =new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @Test
    public void loginform()
    {

        BasePage basePage=new BasePage();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @After
    public void closeDriver(){

        driver.close();
    }
}
