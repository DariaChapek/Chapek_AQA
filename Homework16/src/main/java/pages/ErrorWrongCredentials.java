package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class ErrorWrongCredentials{

    private SelenideElement searchError = $("#lform_errCtrl > div.content.clear");

    public String checkError() {
        return searchError.getText();
    }

}
