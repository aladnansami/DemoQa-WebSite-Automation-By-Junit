# DemoQa-WebSite-Automation-By-Junit
### website link : https://demoqa.com/
## Automated Modules in JunitPractics Class  
JunitPractics Class   = https://github.com/aladnansami/DemoQa-WebSite-Automation-By-Junit/blob/main/src/test/java/JunitPractice.java
1. https://demoqa.com/text-box (Write TextBox )<br>
2. https://demoqa.com/alerts  (handle Alerts) <br>
3. https://demoqa.com/date-picker (Select Date) <br>
4. https://www.google.com/ (keyboard Event) <br>
5. https://demoqa.com/select-menu (Select DropDown)<br>
6. https://green.edu.bd/ (Mouse Hover)<br>
7. https://demoqa.com/buttons  (Action Click)<br>
8. takeScreenShot <br>     
public void takeScreenShot () throws IOException {<br> 
        driver.get("https://demoqa.com");<br> 
        File screenshotfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);<br> 
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());<br> 
        String fileWithPath = "./src/test/resources/screenshots/" + time + ".png";<br> 
        File DestFile = new File(fileWithPath);<br> 
        FileUtils.copyFile(screenshotFile, DestFile);<br><br> 

9. https://demoqa.com/upload-download (Upload File) <br>
10. https://demoqa.com/upload-download (Download File) <br>
11. https://demoqa.com/browser-windows (handle Window)<br>
12. https://demoqa.com/webtables (Scrap data) <br>

## # Automated Modules in Practice_Form Class 
1. https://demoqa.com/automation-practice-form (Automated Form) <br>
Junit Form - https://github.com/aladnansami/DemoQa-WebSite-Automation-By-Junit/blob/main/src/test/java/Practice_Form.java

