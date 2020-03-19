import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public WebDriver driver;
    public Properties properties = new Properties();

    public WebDriver initializeBrowser() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\erend\\Desktop\\SeleniumTry\\src\\main\\java\\data.properties");
        properties.load(fileInputStream);
        String browserName = properties.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\erend\\Desktop\\Browsers\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\erend\\Desktop\\Browsers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "C:\\Users\\erend\\Desktop\\Browsers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        return driver;
    }

}
