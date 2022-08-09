import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class Practice_Form {

    WebDriver driver;
    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--headed");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @Test
    public void formFillUp() throws InterruptedException, IOException ,ParseException{

        driver.get("https://demoqa.com/automation-practice-form");
        //firstname
        driver.findElement(By.id("firstName")).sendKeys("Al adnan");

        //lastname
        driver.findElement(By.id("lastName")).sendKeys("Sami");

        //email
        driver.findElement(By.id("userEmail")).sendKeys("aladnansami21@gmail.com");

        //phn_no
        driver.findElement(By.id("userNumber")).sendKeys("01625208031");

        //date_of_birth
        Thread.sleep(1000);
        WebElement date=driver.findElement(By.id("dateOfBirthInput"));
        Actions actionDate=new Actions(driver);
        actionDate.doubleClick(date).click().sendKeys(Keys.SPACE).sendKeys("19/03/1998").sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);


        //Subject
        Thread.sleep(1000);
        WebElement subject = driver.findElement(By.id("subjectsInput"));
        subject.sendKeys("CSE");
        subject.sendKeys(Keys.ARROW_DOWN);
        subject.sendKeys(Keys.ENTER);


        //upload_image
        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\Sami\\Pictures\\testcase.png");
        //Current_address
        driver.findElement(By.id("currentAddress")).sendKeys("B Baria");
        //state
        driver.findElement(By.id("react-select-3-input")).sendKeys("NCR"+Keys.ARROW_DOWN+Keys.ENTER);
        //city.selectByClass();
        //city
        driver.findElement(By.id("react-select-4-input")).sendKeys("Delhi"+Keys.ARROW_DOWN+Keys.ENTER);
        //submit_button
        //driver.findElement(By.id("submit")).click();


        //radio_button_for_gender
        WebElement radioGender = driver.findElement(By.id("gender-radio-1"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", radioGender);


        //checkbox_for_hobby
        WebElement checkboxHobby = driver.findElement(By.id("hobbies-checkbox-1"));
        jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", checkboxHobby);


        //submit
        WebElement submit= driver.findElement(By.id("submit"));
        jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", submit);


        JSONObject studentObject=new JSONObject();
        WebElement stuTbleBody=driver.findElement(By.tagName("tbody"));
        List<WebElement> tRows=stuTbleBody.findElements(By.tagName("tr"));
        for(WebElement row: tRows)
        {
            List<WebElement> tData=row.findElements(By.tagName("td"));
            studentObject.put(tData.get(0).getText(),tData.get(1).getText());
        }
        FileWriter file = new FileWriter("./src/test/resources/students.json");
        file.write(studentObject.toJSONString());
        file.flush();



    }
    @After
    public void closeWindow()
    {
        driver.quit();
    }
}