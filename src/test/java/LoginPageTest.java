import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends Base {
    public LoginPage loginPage;
    public HomePage homePage;

    public LoginPageTest() throws IOException {
        driver = initializeBrowser();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }
    @BeforeClass
    public void setUp() throws InterruptedException, IOException {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        homePage.navigateToLoginPage();
    }
    @Test
    public void loginTest() throws InterruptedException, IOException {
        Thread.sleep(3000);
        loginPage.enterEmail();
        loginPage.enterPassword();
        loginPage.clickLoginBtn();
    }
    @AfterClass
    public void tearDown() {
        driver.close();
    }
}