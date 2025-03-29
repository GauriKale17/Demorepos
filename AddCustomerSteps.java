package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import io.cucumber.java.en.*;
import java.time.Duration;

public class AddCustomerSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on the Add Customer page")
    public void user_is_on_the_add_customer_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testffc.nimapinfotech.com/auth/login");

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mat-input-element"))).sendKeys("gaurikale2003@gmail.com");
        driver.findElement(By.id("mat-input-1")).sendKeys("gauri@123");
        driver.findElement(By.xpath("//*[@id='kt_login_signin_submit']")).click();
    }

    @When("User enters {string} and {string} and {string}")
    public void user_enters_and_and(String name, String email, String phone) {
        // Click on Customer Menu
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"kt_aside_menu\"]/ul/li[2]/a/span"))).click();

      
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"kt_content\"]/div/ng-component/kt-customers-list/mat-drawer-container/mat-drawer-content/kt-portlet/div/kt-portlet-header/div[4]/button[1]/span[1]"))).click();

        driver.findElement(By.xpath("//input[@formcontrolname='LeadName']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@formcontrolname='Email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@formcontrolname='MobileNo']")).sendKeys(phone);

        // Click Save button
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
    }

    @Then("The customer should be added successfully")
    public void the_customer_should_be_added_successfully() {
        String actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("toast-message"))).getText();
        Assert.assertTrue(actualMessage.contains("Customer Added Successfully"));
        
    }
}
