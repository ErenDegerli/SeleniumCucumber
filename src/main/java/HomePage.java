import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HomePage extends Base {

    public static WebDriver driver;
    FileInputStream fileInputStream = new FileInputStream("C:\\Users\\erend\\Desktop\\SeleniumTry\\src\\main\\java\\data.properties");

    public HomePage(WebDriver driver) throws FileNotFoundException {
        HomePage.driver = driver;
    }
    //@FindBy(id="idcta-statusbar")
    // WebElement signinBtn;     //(Bu webelementin HomePageTest classında kullanımını bulamadığım için alt satırdakini uyguluyorum.)
    // By signinBtn = By.id("idcta-statusbar");

    public void navigateToLoginPage() throws InterruptedException, IOException {
        properties.load(fileInputStream);
        driver.get(properties.getProperty("url"));
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("div[id='mybbc-wrapper'] div")).click();
    }
}
