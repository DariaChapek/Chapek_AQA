import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GeneralPageIUa extends BasePage{

    private WebElement searchEnter = driver.findElement(By.cssSelector("ul.user_menu > li.first > a"));
    private WebElement searchEmailMailBox = driver.findElement(By.cssSelector("input[name=\"login\"]"));
    private WebElement searchPasswordMailBox = driver.findElement(By.cssSelector("input[name=\"pass\"]"));
    private List<WebElement> searchDomains = driver.findElements(By.cssSelector("div.Left select"));
    private WebElement searchEnterMailBox = driver.findElement(By.cssSelector("p input[type=submit]"));

    public GeneralPageIUa(WebDriver driver) {
        super(driver);
    }

    public void clickEnter() {
        searchEnter.click();
    }

    public void setEmailMailBox(String emailMailBox) {
        searchEmailMailBox.sendKeys(emailMailBox);
    }

    public void setPasswordMailBox(String passwordMailBox) {
        searchPasswordMailBox.sendKeys(passwordMailBox);
    }

    public String setDomain(int domainNumber) {
        if (domainNumber <= searchDomains.size() && domainNumber > 0) {
            return searchDomains.get(domainNumber - 1).getText();
        }
        return null;
    }

    public void clickEnterMailBox() {
        searchEnterMailBox.click();
    }


}
