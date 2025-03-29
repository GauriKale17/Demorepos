package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import io.cucumber.java.en.*;

import java.time.Duration;

public class PunchInSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("User is logged in")
    public void user_is_logged_in() {
    	  driver = new ChromeDriver();
          driver.manage().window().maximize();
          wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Explicit wait

        // Open Login Page
        driver.get("https://testffc.nimapinfotech.com/auth/login");

        // Login Steps
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mat-input-element"))).sendKeys("gaurikale2003@gmail.com");
        driver.findElement(By.id("mat-input-1")).sendKeys("gauri@123");
        driver.findElement(By.id("kt_login_signin_submit")).click();
    }

    @When("User clicks on PunchIn button")
    public void user_clicks_on_punch_in_button() {
        WebElement punchInButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("userPunch")));
        punchInButton.click();
    }

    @Then("A toast message should appear with {string}")
    public void a_toast_message_should_appear_with(String expectedMessage) {
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("toast-message")));
        String actualMessage = toastMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        driver.quit();
    }
}
