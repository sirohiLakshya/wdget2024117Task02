package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinitions {
    WebDriver driver;
    String username;
    String password;

    @Given("User is on Home Page")
    public void user_is_on_home_page() {
        // Code to navigate to the home page
        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
    }

    @When("User navigates to Login Page")
    public void user_navigates_to_login_page() {
        // Code to navigate to the login page
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
    }

    @Then("User enters {string} and {string}")
    public void user_enters_username_and_password(String username, String password) {
        this.username=username;
        this.password=password;
        // Code to enter username and password
        driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
    }

    @Then("User should get logged in")
    public void user_should_get_logged_in() {
        // Code to verify successful login
        String expectedPageTitle = "My Account";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(expectedPageTitle,actualPageTitle);
    }

    @And("Message displayed Login Successfully")
    public void message_displayed_login_successfully() {
        // Code to verify login success message
        WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]"));
        if(myAccount.isDisplayed()){
            System.out.println("Login Successful!");
        }
    }

    @Then("User will be asked to go back to login page")
    public void user_will_be_asked_to_go_back_to_login_page() {
        // Code to verify prompt to go back to login page
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }


    @And("Provide correct credentials")
    public void provide_correct_credentials() {
        // Code to provide correct credentials
        System.out.println("Enter valid creentials!");
    }
}

