import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {
    protected WebDriver driver;
    @FindBy(id = "firstName")
    WebElement txtfirstName;

    @FindBy(id = "lastName")
    WebElement txtlastName;

    @FindBy(id = "userEmail")
    WebElement txtuserEmail;

    @FindBy(id = "gender-radio-1")
    WebElement radiogendermale;

    @FindBy(id = "gender-radio-2")
    WebElement radiogenderfemale;

    @FindBy(id = "gender-radio-3")
    WebElement radiogenderothers;

    @FindBy(id = "userNumber")
    WebElement txtusernumber;

    @FindBy(id = "dateOfBirthInput")
    WebElement txtdateOfBirthInput;

    @FindBy(xpath = "//*[@id=\"subjectsContainer\"]/div")
    WebElement txtsubject;

    @FindBy(id = "hobbies-checkbox-1")
    WebElement radiohobbiessports;

    @FindBy(id = "hobbies-checkbox-2")
    WebElement radiohobbiesreading;

    @FindBy(id = "hobbies-checkbox-2")
    WebElement radiohobbiesmusic;

    @FindBy(id = "uploadPicture")
            WebElement uploadpicture;

    @FindBy(id = "submit")
    WebElement btnsubmit;

    public BasePage(WebDriver driver) {
        this.driver=driver;
    }
}
