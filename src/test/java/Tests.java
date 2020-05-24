import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class Tests extends BaseTest{

    public static final String RIGHT_EMAIL = "dariachapek@i.ua";
    public static final String RIGHT_PASSWORD = "dasha2607";
    public static final String WRONG_EMAIL = "daryachapek@i.ua";
    public static final String USER_NAME = "Test";
    public static final String USER_FULL_NAME = "Test Test";
    public static final String ERROR_TEXT = "Неверный логин или пароль";
    public static final String THEME = "Hello Everybody";
    public static final String TEXT_IN_EMAIL = "Hello, this is an email.";

    @Test
    public void positiveTestLoginSelenidePageObject() {

        GeneralPageIUa generalPageIUa = new GeneralPageIUa();

        generalPageIUa.clickEnter();
        generalPageIUa.setEmail(RIGHT_EMAIL);
        generalPageIUa.setPassword(RIGHT_PASSWORD);
        generalPageIUa.clickSubmit();

        PageWithLoggedInUser pageWithLoggedInUser = new PageWithLoggedInUser();
        String helloUser = pageWithLoggedInUser.checkUserLoggedIn();
        Assert.assertTrue(helloUser.contains(USER_NAME));

    }

    @Test
    public void positiveTestLoginSelenide() {

        $("ul.user_menu > li.first > a").click();
        $("#FloatLogin input[name=\"login\"]").sendKeys(RIGHT_EMAIL);
        $("#FloatLogin input[name=\"pass\"]").sendKeys(RIGHT_PASSWORD);
        $("#FloatLogin input[type=submit]").click();
        $("ul.user_menu > li.first > a").shouldHave(Condition.text(USER_NAME));

    }

    @Test
    public void negativeTestLoginSelenidePageObject() {

        GeneralPageIUa generalPageIUa = new GeneralPageIUa();

        generalPageIUa.clickEnter();
        generalPageIUa.setEmail(WRONG_EMAIL);
        generalPageIUa.setPassword(RIGHT_PASSWORD);
        generalPageIUa.clickSubmit();

        ErrorWrongCredentials errorWrongCredentials = new ErrorWrongCredentials();
        String errorText = errorWrongCredentials.checkError();
        Assert.assertTrue(errorText.contains(ERROR_TEXT));
    }

    @Test
    public void negativeTestLoginSelenide() {

        $("ul.user_menu > li.first > a").click();
        $("#FloatLogin input[name=\"login\"]").sendKeys(WRONG_EMAIL);
        $("#FloatLogin input[name=\"pass\"]").sendKeys(RIGHT_EMAIL);
        $("#FloatLogin input[type=submit]").click();
        $("#lform_errCtrl > div.content.clear").shouldHave(Condition.text(ERROR_TEXT));

    }

    @Test
    public void sendEmailSelenidePageObject() {

        GeneralPageIUa generalPageIUa = new GeneralPageIUa();
        generalPageIUa.setEmailMailBox(RIGHT_EMAIL);
        generalPageIUa.setPasswordMailBox(RIGHT_PASSWORD);
        generalPageIUa.setDomain(1);
        generalPageIUa.clickEnterMailBox();

        MailboxPage mailboxPage = new MailboxPage();
        mailboxPage.clickCreateMail();
        mailboxPage.writeToEmail(RIGHT_EMAIL);
        mailboxPage.writeTheme(THEME);
        mailboxPage.writeTextEmail(TEXT_IN_EMAIL);
        mailboxPage.sendEmail();
        mailboxPage.openInbox();
        refresh();

        String fromWho = mailboxPage.checkFromWho();
        Assert.assertTrue(fromWho.contains(USER_FULL_NAME));
    }

    @Test
    public void sendEmailSelenide() {

        $("input[name=\"login\"]").sendKeys(RIGHT_EMAIL);
        $("input[name=\"pass\"]").sendKeys(RIGHT_PASSWORD);
        $("div.Left select").click();
        $("option[value=\"i.ua\"]").click();
        $("p input[type=submit]").click();
        $("div.Left > p > a").click();
        $("#to").sendKeys(RIGHT_EMAIL);
        $("span > input[type=text]").sendKeys(THEME);
        $("#text").sendKeys(TEXT_IN_EMAIL);
        $("p:nth-child(1) > input.bold").click();
        $("li.new > a").click();
        refresh();
        $("div:nth-child(20) span.frm").shouldHave(Condition.text(USER_FULL_NAME));

    }

}
