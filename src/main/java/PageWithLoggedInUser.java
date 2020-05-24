import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class PageWithLoggedInUser{

    private SelenideElement searchHelloUser = $("ul.user_menu > li.first > a");

    public String checkUserLoggedIn() {
        return searchHelloUser.getText();
    }


}
