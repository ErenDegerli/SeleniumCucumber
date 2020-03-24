package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import base.Base;
import org.testng.Assert;
import pages.*;

import java.io.IOException;

@RunWith(Cucumber.class)
public class StepDefinition extends Base {

    public HomePage homePage;
    public LoginPage loginPage;
    public PasswordResetPage passwordResetPage;

    @Given("Initialise the browser with chrome")
    public void initialise_the_browser_with_chrome() throws IOException {
        driver = initializeBrowser();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        passwordResetPage = new PasswordResetPage(driver);
    }

    @Given("Navigate to {string} website")
    public void navigate_to_website(String string) {
        driver.get(string);
    }

    @Given("Click on login link in homepage to land on sign in page")
    public void click_on_login_link_in_homepage_to_land_on_sign_in_page() throws IOException, InterruptedException {

        homePage.navigateToLoginPage();

    }

    @When("User enters email and password and logs in")
    public void user_enters_email_and_password_and_logs_in() throws IOException, InterruptedException {

        loginPage.getLoginPageTitle();
        Thread.sleep(5000);
        loginPage.enterEmail();
        loginPage.enterPassword();
        loginPage.clickLoginBtn();
        Thread.sleep(3000);
    }

    @When("Clicks on I forgot my password")
    public void clicks_on_I_forgot_my_password() throws IOException, InterruptedException {

        passwordResetPage.getPasswordResetScreen();
        Thread.sleep(2000);
    }

    @Then("Verify that user is not able to log in")
    public void verify_that_user_is_not_able_to_log_in() {
        passwordResetPage.enterEmail();
        passwordResetPage.enterButton();
    }

    @Then("GetHelper is displayed")
    public void gethelper_is_displayed() {

        Assert.assertEquals(passwordResetPage.getHeader(), properties.getProperty("password_reset_header"));
    }

    @And("Close browsers")
    public void close_browsers() {
        driver.quit();
    }

}
