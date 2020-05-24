import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    @BeforeMethod
    public void setUp() {
        open("https://www.i.ua/");
    }

}
