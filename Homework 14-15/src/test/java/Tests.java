import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends BaseTest{

    public static final String RIGHT_EMAIL = "dariachapek@i.ua";
    public static final String RIGHT_PASSWORD = "dasha2607";
    public static final String WRONG_EMAIL = "daryachapek@i.ua";
    public static final String USER_NAME = "Test";
    public static final String USER_FULL_NAME = "Test Test";
    public static final String ERROR_TEXT = "Неверный логин или пароль";
    public static final String THEME = "Hello Every person";
    public static final String TEXT_IN_EMAIL = "Hello, this is an email.";

    @Test
    public void positiveTestLogin() {

        GeneralPageIUa generalPageIUa = new GeneralPageIUa(driver);
        generalPageIUa.clickEnter();

        LoginForm loginForm = new LoginForm(driver);
        loginForm.setEmail(RIGHT_EMAIL);
        loginForm.setPassword(RIGHT_PASSWORD);
        loginForm.clickSubmit();

        PageWithLoggedInUser pageWithLoggedInUser = new PageWithLoggedInUser(driver);
        String helloUser = pageWithLoggedInUser.checkUserLoggedIn();
        Assert.assertTrue(helloUser.contains(USER_NAME));

    }

    @Test
    public void negativeTestLogin() {

        GeneralPageIUa generalPageIUa = new GeneralPageIUa(driver);
        generalPageIUa.clickEnter();

        LoginForm loginForm = new LoginForm(driver);
        loginForm.setEmail(WRONG_EMAIL);
        loginForm.setPassword(RIGHT_PASSWORD);
        loginForm.clickSubmit();

        ErrorWrongCredentials errorWrongCredentials = new ErrorWrongCredentials(driver);
        String errorText = errorWrongCredentials.checkError();
        Assert.assertTrue(errorText.contains(ERROR_TEXT));
    }

    @Test
    public void sendEmail() {

        GeneralPageIUa generalPageIUa = new GeneralPageIUa(driver);
        generalPageIUa.setEmailMailBox(RIGHT_EMAIL);
        generalPageIUa.setPasswordMailBox(RIGHT_PASSWORD);
        generalPageIUa.setDomain(1);
        generalPageIUa.clickEnterMailBox();

        MailboxPage mailboxPage = new MailboxPage(driver);
        mailboxPage.clickCreateMail();

        NewEmailPage newEmailPage = new NewEmailPage(driver);
        newEmailPage.writeToEmail(RIGHT_EMAIL);
        newEmailPage.writeTheme(THEME);
        newEmailPage.writeTextEmail(TEXT_IN_EMAIL);
        newEmailPage.sendEmail();
        mailboxPage.openInbox();

        driver.navigate().refresh();

        String fromWho = mailboxPage.checkFromWho();
        Assert.assertTrue(fromWho.contains(USER_FULL_NAME));
    }

}
