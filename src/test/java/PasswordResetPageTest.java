import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class PasswordResetPageTest extends Base {

    public PasswordResetPage passwordResetPage;

    public PasswordResetPageTest() throws IOException {
        driver = initializeBrowser();
        passwordResetPage = new PasswordResetPage(driver);
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\erend\\Desktop\\SeleniumTry\\src\\main\\java\\data.properties");
        properties.load(fileInputStream);
    }
    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        passwordResetPage.getPasswordResetScreen();
    }
    @Test
    public void passwordResetPageTest() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(passwordResetPage.getHeader(), properties.getProperty("password_reset_header"));
        passwordResetPage.enterEmail();
        passwordResetPage.enterButton();
        Assert.assertTrue(passwordResetPage.getHelperDisplayed());
    }
    @AfterClass
    public void tearDown() {
        driver.close();
    }

}
