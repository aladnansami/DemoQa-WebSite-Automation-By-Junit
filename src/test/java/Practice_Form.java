import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.sql.Driver;
import java.time.Duration;

public class Practice_Form
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
    public void loginform() throws InterruptedException {

            BasePage basePage=new BasePage(driver);
            driver.get("https://demoqa.com/automation-practice-form");
            WebElement txtFirstname =driver.findElement(By.id("firstName"));
            txtFirstname.sendKeys("adnan");
            WebElement txtLastname =driver.findElement(By.id("lastName"));
            txtLastname.sendKeys("sami");
            WebElement txtemail =driver.findElement(By.id("userEmail"));
            txtemail.sendKeys("aladnansami@gmail.com");
            WebElement radiogendermale =driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label"));
            radiogendermale.click();
            WebElement txtusernumber =driver.findElement(By.id("userNumber"));
            txtusernumber.sendKeys("0123456743");
        WebElement btnsubmit =driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        Actions actions=new Actions(driver);
        WebElement txtDate=driver.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]"));
        txtDate.sendKeys(Keys.CONTROL+"a");
        txtDate.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(1000);

        driver.findElement(By.id("xpath(\"//*[@id=\\\"dateOfBirthInput\\\"]\")")).sendKeys("18/03/1998");
        txtDate.sendKeys(Keys.ENTER);

        WebElement txtsubject =driver.findElement(By.id("//*[@id=\"subjectsContainer\"]/div"));
        txtsubject.sendKeys("This is my subject");

        WebElement radiohobbiessports =driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label"));
        radiohobbiessports.click();

        WebElement uploadpicture =driver.findElement(By.id("uploadPicture"));
        txtsubject.sendKeys("\"D:\\Testing SEDT\\CV\\279959202_3271339786432422_1618629510372504782_n-removebg-preview.png\"");


    }

    @After
    public void closeDriver(){

        driver.close();
    }
}
