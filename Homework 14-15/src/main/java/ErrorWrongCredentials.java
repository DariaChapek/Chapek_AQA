import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErrorWrongCredentials extends BasePage{

    WebElement searchError = driver.findElement(By.cssSelector("#lform_errCtrl > div.content.clear"));

    public ErrorWrongCredentials(WebDriver driver) {
        super(driver);
    }

    public String checkError() {
        return searchError.getText();
    }

}
