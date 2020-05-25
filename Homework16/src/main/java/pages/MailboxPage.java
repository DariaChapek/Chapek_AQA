package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class MailboxPage {

    private SelenideElement searchCreateMail = $("div.Left > p > a");
    private SelenideElement searchToField = $("#to");
    private SelenideElement searchThemeField =$("span > input[type=text]");
    private SelenideElement searchTextField = $("#text");
    private SelenideElement searchSendButton = $("p:nth-child(1) > input.bold");
    private SelenideElement searchInbox = $("li.new > a");
    private SelenideElement searchNewEmail = $("div:nth-child(20) span.frm");

    public void clickCreateMail() {
        searchCreateMail.click();
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

    public void openInbox() {
        searchInbox.click();
    }

    public String checkFromWho() {
        return searchNewEmail.getText();
    }


}
