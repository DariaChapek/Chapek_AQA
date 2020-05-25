import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewEmailPage extends BasePage {

    private WebElement searchToField = driver.findElement(By.cssSelector("#to"));
    private WebElement searchThemeField = driver.findElement(By.cssSelector("span > input[type=text]"));
    private WebElement searchTextField = driver.findElement(By.cssSelector("#text"));
    private WebElement searchSendButton = driver.findElement(By.cssSelector("p:nth-child(1) > input.bold"));

    public NewEmailPage(WebDriver driver) {
        super(driver);
    }

    public void writeToEmail(String email) {
        searchToField.sendKeys(email);
    }

    public void writeTheme(String theme) {
        searchThemeField.sendKeys(theme);
    }

    public void writeTextEmail(String text) {
        searchTextField.sendKeys(text);
    }

    public void sendEmail() {
        searchSendButton.click();
    }

}
