import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class JunitPractice {

        WebDriver driver;
      @Before
        public  void setup(){
            System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
          ChromeOptions options= new ChromeOptions();
          options.addArguments("--headed");
          driver =new ChromeDriver(options);
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        }
        @Test
        public void getTitle(){
            driver.get("https://demoqa.com/");
            String title= driver.getTitle();
            Assert.assertEquals("ToolsQA",title);
        }
    @Test
    public void writeText() {
        driver.get("https://demoqa.com/text-box");
        WebElement txtUsername =driver.findElement(By.id("userName"));
        txtUsername.sendKeys("adnan");
        WebElement txtEmail= driver.findElement(By.id("userEmail"));
        txtEmail.sendKeys("aladnansami21@gmail.com");
        WebElement txtCurrentAddress= driver.findElement(By.id("currentAddress"));
        txtCurrentAddress.sendKeys("dhaka");
        WebElement txtPermanentAddress =driver.findElement(By.id("permanentAddress"));
        txtPermanentAddress.sendKeys("BB");
        List<WebElement> button=driver.findElements(By.tagName("button"));
        button.get(1).click();
    }
    @Test
    public void handleAlert() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().dismiss();
        String text= driver.findElement(By.className("text-success")).getText();
        System.out.println(text);
        Assert.assertTrue(text.contains("Cancel"));
    }
    @Test
    public void selectDate() throws InterruptedException {

          driver.get("https://demoqa.com/date-picker");
        Actions actions=new Actions(driver);
        WebElement txtDate=driver.findElement(By.id("datePickerMonthYearInput"));
        txtDate.sendKeys(Keys.CONTROL+"a");
        txtDate.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(1000);
        driver.findElement(By.id("datePickerMonthYearInput")).sendKeys("07/27/2022");
        txtDate.sendKeys(Keys.ENTER);

    }
    @Test
    public void keyboardEvent() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement searchElement = driver.findElement(By.name("q"));
        Actions action = new Actions(driver);
        action.moveToElement(searchElement);
        action.keyDown(Keys.SHIFT);
        action.sendKeys("dfhgf").keyUp(Keys.SHIFT).doubleClick().click().contextClick().perform();
        Thread.sleep(3000);
    }
    @Test
    public void selectDropdown(){
        driver.get("https://demoqa.com/select-menu");
        Select select=new Select(driver.findElement(By.id("oldSelectMenu")));
        select.selectByValue("1");
        Select cars=new Select(driver.findElement(By.id("cars")));
        if (cars.isMultiple()) {
            cars.selectByValue("volvo");
            cars.selectByValue("audi");
        }
    }
    @Test
    public void mouseHover(){
        driver.get("https://green.edu.bd/");
        Actions actions=new Actions(driver);
        List<WebElement> list= driver.findElements(By.xpath("//a[contains(text(),\"About Us\")]"));
        actions.moveToElement(list.get(2)).perform();

    }
    @Test
    public void actionClick(){
        driver.get("https://demoqa.com/buttons");
        List<WebElement> buttons=driver.findElements(By.cssSelector("[type=button]"));
        Actions actions=new Actions(driver);
        actions.doubleClick(buttons.get(1)).perform();
        actions.contextClick(buttons.get(2)).perform();
    }

    @Test
    public void takeScreenShot () throws IOException {

        driver.get("https://demoqa.com");
        File screenshotfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
        String fileWithPath = "./src/test/resources/screenshots/" + time + ".png";
        File DestFile = new File(fileWithPath);
        //FileUtils.copyFile(screenshotFile, DestFile);
    }
    @Test
    public void uploadFile(){
        driver.get("https://demoqa.com/upload-download");
        driver.findElement(By.id("uploadFile")).sendKeys("D:\\a.jpg");
    }
    @Test
    public void downloadFile(){
        driver.get("https://demoqa.com/upload-download");
        driver.findElement(By.id("downloadButton")).click();
    }
    @Test
    public void handleTab() throws InterruptedException {
          driver.get("https://demoqa.com/browser-windows");
          driver.findElement(By.id("tabButton")).click();
          Thread.sleep(3000);
        ArrayList<String> w= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(w.get(1));
        String text = driver.findElement(By.id("sampleHandling")).getText();
        Assert.assertEquals(text,"This is a simple page");
        driver.close();
        driver.switchTo().window(w.get(0));
    }
@Test
    public void handleWindow(){
        driver.get("https://demoqa.com/browser-windows");
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("windowButton")));
        driver.findElement(By.id("windowButton")).click();
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
    Iterator<String> iterator =allWindowHandles.iterator();
    while (iterator.hasNext()){
        String childwindw=iterator.next();
        if(!mainWindowHandle.equalsIgnoreCase(childwindw));
        driver.switchTo().window(childwindw);
        String text = driver.findElement(By.id("sampleHandling")).getText();
        Assert.assertEquals(text,"This is a simple page");
    }
    driver.close();
    }
    @Test
    public void scrapData(){
          driver.get("https://demoqa.com/webtables");
          WebElement table = driver.findElement(By.className("rt-tbody"));
          List<WebElement> allrows =table.findElements(By.className("rt-rt"));
          int i=0;
          for (WebElement row:allrows){
              List<WebElement>cells = row.findElements(By.className("rt-td"));
              for (WebElement cell:cells){
                  i++;
                  System.out.println("num["+i+"]"+cell.getText());
              }
          }
    }

    @After
        public void closeDriver(){
          driver.close();
        }


    }
