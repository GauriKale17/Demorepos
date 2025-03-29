package stepDefinition;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.junit.Assert;

public class LoginSteps {

    WebDriver driver;

    @Given("User is on the login page")
    public void user_is_on_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testffc.nimapinfotech.com/auth/login");
    }

    @When("User enters {string} and {string}")
    public void user_enters_and(String email, String password) {
        driver.findElement(By.className("mat-input-element")).sendKeys(email);
        driver.findElement(By.id("mat-input-1")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"kt_login_signin_submit\"]")).click();
    }

    @Then("User should be navigated to dashboard")
    public void user_should_be_navigated_to_dashboard() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("kt-menu__link-text")));
    	Assert.assertTrue("Dashboard not loaded!", dashboardElement.isDisplayed());
 
    }
}
