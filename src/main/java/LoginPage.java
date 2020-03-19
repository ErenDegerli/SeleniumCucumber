import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginPage extends Base{

    public static WebDriver driver;
    FileInputStream fileInputStream = new FileInputStream("C:\\Users\\erend\\Desktop\\SeleniumTry\\src\\main\\java\\data.properties");

    By emailInput = By.id("user-identifier-input");
    By passwordInput = By.id("password-input");
    By loginBtn = By.id("submit-button");

    public LoginPage(WebDriver driver) throws FileNotFoundException {
        LoginPage.driver = driver;
    }
    public void enterEmail() throws IOException {
        properties.load(fileInputStream);
        driver.findElement(emailInput).sendKeys(properties.getProperty("email"));
    }
    public void enterPassword() throws IOException {
        properties.load(fileInputStream);
        driver.findElement(passwordInput).sendKeys(properties.getProperty("password"));
    }
    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }
}

