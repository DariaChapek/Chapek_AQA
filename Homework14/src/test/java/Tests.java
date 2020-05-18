import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tests {

    public static final String RIGHT_EMAIL = "dariachapek@i.ua";
    public static final String RIGHT_PASSWORD = "dasha2607";
    public static final String WRONG_EMAIL = "daryachapek@i.ua";
    public static final String USER_NAME = "Test";
    public static final String USER_FULL_NAME = "Test Test";
    public static final String ERROR_TEXT = "Неверный логин или пароль";
    public static final String THEME = "Hello Everybody";
    public static final String TEXT_IN_EMAIL = "Hello, this is an email.";

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.i.ua/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void positiveTestLogin() {

        driver.findElement(By.cssSelector("ul.user_menu > li.first > a")).click();

        driver.findElement(By.cssSelector("#FloatLogin input[name=\"login\"]")).sendKeys(RIGHT_EMAIL);

        driver.findElement(By.cssSelector("#FloatLogin input[name=\"pass\"]")).sendKeys(RIGHT_PASSWORD);

        driver.findElement(By.cssSelector("#FloatLogin input[type=submit]")).click();

        WebElement searchHelloUser = driver.findElement(By.cssSelector("ul.user_menu > li.first > a"));
        String helloUser = searchHelloUser.getText();
        Assert.assertTrue(helloUser.contains(USER_NAME));

    }

    @Test
    public void negativeTestLogin() {

        driver.findElement(By.cssSelector("ul.user_menu > li.first > a")).click();

        driver.findElement(By.cssSelector("#FloatLogin input[name=\"login\"]")).sendKeys(WRONG_EMAIL);

        driver.findElement(By.cssSelector("#FloatLogin input[name=\"pass\"]")).sendKeys(RIGHT_PASSWORD);

        driver.findElement(By.cssSelector("#FloatLogin input[type=submit]")).click();

        WebElement searchError = driver.findElement(By.cssSelector("#lform_errCtrl > div.content.clear"));
        String errorText = searchError.getText();
        Assert.assertTrue(errorText.contains(ERROR_TEXT));
    }

    @Test
    public void sendEmail() {

        driver.findElement(By.cssSelector("input[name=\"login\"]")).sendKeys(RIGHT_EMAIL);

        driver.findElement(By.cssSelector("input[name=\"pass\"]")).sendKeys(RIGHT_PASSWORD);

        driver.findElement(By.cssSelector("div.Left select")).click();

        driver.findElement(By.cssSelector("option[value=\"i.ua\"]")).click();

        driver.findElement(By.cssSelector("p input[type=submit]")).click();

        driver.findElement(By.cssSelector("div.Left > p > a")).click();

        driver.findElement(By.cssSelector("#to")).sendKeys(RIGHT_EMAIL);

        driver.findElement(By.cssSelector("span > input[type=text]")).sendKeys(THEME);

        driver.findElement(By.cssSelector("#text")).sendKeys(TEXT_IN_EMAIL);

        driver.findElement(By.cssSelector("p:nth-child(1) > input.bold")).click();

        driver.findElement(By.cssSelector("li.new > a")).click();

        driver.navigate().refresh();

        WebElement searchNewEmail = driver.findElement(By.cssSelector("div:nth-child(20) span.frm"));
        String fromWho = searchNewEmail.getText();
        Assert.assertTrue(fromWho.contains(USER_FULL_NAME));
    }

}
