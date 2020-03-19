import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends Base {
    public HomePage homePage;

    public HomePageTest() throws IOException {
        driver = initializeBrowser();
        homePage = new HomePage(driver);
    }
    @BeforeTest
    public void initialize() {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
    @Test
    public void homePage() throws InterruptedException, IOException {
        homePage.navigateToLoginPage();
    }
    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
