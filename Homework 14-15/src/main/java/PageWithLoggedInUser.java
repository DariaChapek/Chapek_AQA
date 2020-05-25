import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageWithLoggedInUser extends BasePage {

    WebElement searchHelloUser = driver.findElement(By.cssSelector("ul.user_menu > li.first > a"));

    public PageWithLoggedInUser(WebDriver driver) {
        super(driver);
    }

    public String checkUserLoggedIn() {
        return searchHelloUser.getText();
    }


}
