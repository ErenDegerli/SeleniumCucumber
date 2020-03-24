import base.Base;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;

public class LoginPageTest extends Base {
    public LoginPage loginPage;
    public HomePage homePage;

    public LoginPageTest() throws IOException {
        driver = initializeBrowser();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\erend\\Desktop\\SeleniumTry\\src\\main\\java\\data.properties");
        properties.load(fileInputStream);
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
        loginPage.getLoginPageTitle();
        loginPage.enterEmail();
        loginPage.enterPassword();
        loginPage.clickLoginBtn();
        Thread.sleep(3000);
        //Assert.assertEquals(loginPage.getErrorMsg(), driver.findElement(By.cssSelector("div[id='form-message-password'] p")).getText());
    }
    @AfterClass
    public void tearDown() {
        driver.close();
    }
}