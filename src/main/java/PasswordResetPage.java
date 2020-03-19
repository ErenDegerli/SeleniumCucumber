import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.IOException;

public class PasswordResetPage extends Base {
    public static WebDriver driver;
    public HomePage homePage;
    public LoginPage loginPage;

    By emailInput = By.id("user-identifier-input");
    By sendBtn = By.id("submit-button");

    public PasswordResetPage(WebDriver driver) throws IOException {
        PasswordResetPage.driver = driver;
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\erend\\Desktop\\SeleniumTry\\src\\main\\java\\data.properties");
        properties.load(fileInputStream);
    }

    public void getPasswordResetScreen() throws IOException, InterruptedException {
        homePage.navigateToLoginPage();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("p[class='button__label'] a")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("li[class='text'] a")).click();
    }
    public String getHeader() {
        return driver.findElement(By.cssSelector("div[class='page__content'] h1")).getText();
    }
    public void enterEmail() {
        driver.findElement(emailInput).sendKeys(properties.getProperty("email"));
    }
    public void enterButton() {
        driver.findElement(sendBtn).click();
    }
    public boolean getHelperDisplayed() {
        return driver.findElement(By.cssSelector("a[href='https://www.bbc.co.uk/usingthebbc/account/im-having-problems-with-my-email-address']")).isEnabled();
    }
}
