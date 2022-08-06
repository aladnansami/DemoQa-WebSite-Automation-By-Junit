import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {
    WebDriver driver;
    @FindBy(id = "firstName")
    WebElement txtfirstName;

}
