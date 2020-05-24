import com.codeborne.selenide.SelenideElement;
import java.util.List;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GeneralPageIUa {

    private SelenideElement searchEnter = $("ul.user_menu > li.first > a");
    private SelenideElement searchEmailField = $("#FloatLogin input[name=\"login\"]");
    private SelenideElement searchPasswordField = $("#FloatLogin input[name=\"pass\"]");
    private SelenideElement searchSubmit = $("#FloatLogin input[type=submit]");
    private SelenideElement searchEmailMailBox = $("input[name=\"login\"]");
    private SelenideElement searchPasswordMailBox = $("input[name=\"pass\"]");
    private List<SelenideElement> searchDomains = $$("div.Left select");
    private SelenideElement searchEnterMailBox = $("p input[type=submit]");

    public void clickEnter() {
        searchEnter.click();
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

    public void setEmailMailBox(String emailMailBox) {
        searchEmailMailBox.sendKeys(emailMailBox);
    }

    public void setPasswordMailBox(String passwordMailBox) {
        searchPasswordMailBox.sendKeys(passwordMailBox);
    }

    public void setDomain(int domainNumber) {
        if (domainNumber <= searchDomains.size() && domainNumber > 0) {
            searchDomains.get(domainNumber - 1).getText();
        }
    }

    public void clickEnterMailBox() {
        searchEnterMailBox.click();
    }


}
