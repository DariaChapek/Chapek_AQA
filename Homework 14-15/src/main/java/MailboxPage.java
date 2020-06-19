import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailboxPage extends BasePage {

    private WebElement searchCreateMail = driver.findElement(By.cssSelector("div.Left > p > a"));
    private WebElement searchInbox = driver.findElement(By.cssSelector("li.new > a"));
    private WebElement searchNewEmail = driver.findElement(By.cssSelector("div:nth-child(20) span.frm"));

    public MailboxPage(WebDriver driver) {
        super(driver);
    }

    public void clickCreateMail() {
        searchCreateMail.click();
    }

    public void openInbox() {
        searchInbox.click();
    }

    public String checkFromWho() {
        return searchNewEmail.getText();
    }


}
