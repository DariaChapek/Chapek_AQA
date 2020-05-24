import base.BaseTest;
import com.codeborne.selenide.Condition;
import helpers.PropertyHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ErrorWrongCredentials;
import pages.GeneralPageIUa;
import pages.MailboxPage;
import pages.PageWithLoggedInUser;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class Tests extends BaseTest {

    @Test
    public void positiveTestLoginSelenidePageObject() {

        GeneralPageIUa generalPageIUa = new GeneralPageIUa();

        generalPageIUa.clickEnter();
        generalPageIUa.setEmail(PropertyHelper.getInstance().getProperty("rightEmail"));
        generalPageIUa.setPassword(PropertyHelper.getInstance().getProperty("rightPassword"));
        generalPageIUa.clickSubmit();

        PageWithLoggedInUser pageWithLoggedInUser = new PageWithLoggedInUser();
        String helloUser = pageWithLoggedInUser.checkUserLoggedIn();
        Assert.assertTrue(helloUser.contains(PropertyHelper.getInstance().getProperty("userName")));

    }

    @Test
    public void positiveTestLoginSelenide() {

        $("ul.user_menu > li.first > a").click();
        $("#FloatLogin input[name=\"login\"]").sendKeys(PropertyHelper.getInstance().getProperty("rightEmail"));
        $("#FloatLogin input[name=\"pass\"]").sendKeys(PropertyHelper.getInstance().getProperty("rightPassword"));
        $("#FloatLogin input[type=submit]").click();
        $("ul.user_menu > li.first > a").shouldHave(Condition.text(PropertyHelper.getInstance().getProperty("userName")));

    }

    @Test
    public void negativeTestLoginSelenidePageObject() {

        GeneralPageIUa generalPageIUa = new GeneralPageIUa();

        generalPageIUa.clickEnter();
        generalPageIUa.setEmail(PropertyHelper.getInstance().getProperty("wrongEmail"));
        generalPageIUa.setPassword(PropertyHelper.getInstance().getProperty("rightPassword"));
        generalPageIUa.clickSubmit();

        ErrorWrongCredentials errorWrongCredentials = new ErrorWrongCredentials();
        String errorText = errorWrongCredentials.checkError();
        Assert.assertTrue(errorText.contains(PropertyHelper.getInstance().getProperty("errorText")));
    }

    @Test
    public void negativeTestLoginSelenide() {

        $("ul.user_menu > li.first > a").click();
        $("#FloatLogin input[name=\"login\"]").sendKeys(PropertyHelper.getInstance().getProperty("wrongEmail"));
        $("#FloatLogin input[name=\"pass\"]").sendKeys(PropertyHelper.getInstance().getProperty("rightPassword"));
        $("#FloatLogin input[type=submit]").click();
        $("#lform_errCtrl > div.content.clear").shouldHave(Condition.text(PropertyHelper.getInstance().getProperty("errorText")));

    }

    @Test
    public void sendEmailSelenidePageObject() {

        GeneralPageIUa generalPageIUa = new GeneralPageIUa();
        generalPageIUa.setEmailMailBox(PropertyHelper.getInstance().getProperty("rightEmail"));
        generalPageIUa.setPasswordMailBox(PropertyHelper.getInstance().getProperty("rightPassword"));
        generalPageIUa.setDomain(1);
        generalPageIUa.clickEnterMailBox();

        MailboxPage mailboxPage = new MailboxPage();
        mailboxPage.clickCreateMail();
        mailboxPage.writeToEmail(PropertyHelper.getInstance().getProperty("rightEmail"));
        mailboxPage.writeTheme(PropertyHelper.getInstance().getProperty("theme"));
        mailboxPage.writeTextEmail(PropertyHelper.getInstance().getProperty("textInEmail"));
        mailboxPage.sendEmail();
        mailboxPage.openInbox();
        refresh();

        String fromWho = mailboxPage.checkFromWho();
        Assert.assertTrue(fromWho.contains(PropertyHelper.getInstance().getProperty("userFullName")));
    }

    @Test
    public void sendEmailSelenide() {

        $("input[name=\"login\"]").sendKeys(PropertyHelper.getInstance().getProperty("rightEmail"));
        $("input[name=\"pass\"]").sendKeys(PropertyHelper.getInstance().getProperty("rightPassword"));
        $("div.Left select").click();
        $("option[value=\"i.ua\"]").click();
        $("p input[type=submit]").click();
        $("div.Left > p > a").click();
        $("#to").sendKeys(PropertyHelper.getInstance().getProperty("rightEmail"));
        $("span > input[type=text]").sendKeys(PropertyHelper.getInstance().getProperty("theme"));
        $("#text").sendKeys(PropertyHelper.getInstance().getProperty("textInEmail"));
        $("p:nth-child(1) > input.bold").click();
        $("li.new > a").click();
        refresh();
        $("div:nth-child(20) span.frm").shouldHave(Condition.text(PropertyHelper.getInstance().getProperty("userFullName")));

    }

}
