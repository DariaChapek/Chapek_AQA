import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginForm extends BasePage{

    private WebElement searchEmailField = driver.findElement(By.cssSelector("#FloatLogin input[name=\"login\"]"));
    private WebElement searchPasswordField = driver.findElement(By.cssSelector("#FloatLogin input[name=\"pass\"]"));
    private WebElement searchSubmit = driver.findElement(By.cssSelector("#FloatLogin input[type=submit]"));

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String email) {
        searchEmailField.sendKeys(email);
    }

    public void setPassword(String password) {
        searchPasswordField.sendKeys(password);
    }

    public void clickSubmit() {
        searchSubmit.click();
    }

}
