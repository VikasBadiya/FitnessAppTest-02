import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest {

    public WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qafitnessapp.ccbp.tech/gym/login");
        System.out.println("Browser was Opened");
    }

    @AfterMethod
    public void TearDown(){
        driver.close();
        System.out.println("Browser was Closed");
    }

    //Test the submission with empty input fields
    //Navigate to the URL https://qafitnessapp.ccbp.tech/gym/login
    //Click the "Login" button.
    //Wait and verify the error message - use Assertions,
    //Expected text: Invalid user ID
    //If the error message does not match the expected text, print "Error text with empty input fields does not match"
    //Close the browser window.


    @Test(priority = 1)
    public void emptyInputFields(){

        WebElement LoginEle = driver.findElement(By.className("login-button"));
        LoginEle.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-text")));

        WebElement ErrorMessageEle = driver.findElement(By.className("error-message-text"));

        String actualErrorMessage = ErrorMessageEle.getText();

        String expectedErrorMessage = "Invalid user ID";

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Error text with empty input fields does not match");

    }

    //Test the submission with empty User ID field
    //Navigate to the URL https://qafitnessapp.ccbp.tech/gym/login
    //Enter the text 231225 in the "PIN" field.
    //Click the "Login" button.
    //Wait and verify the error message - use Assertions,
    //Expected text: Invalid user ID
    //If the error message does not match the expected text, print "Error text with empty input field do not match"
    //Close the browser window.


    @Test(priority = 2)
    public void emptyUserIDField(){
        WebElement pinInputEle = driver.findElement(By.id("pinInput"));
        pinInputEle.sendKeys("231225");
        WebElement LoginEle = driver.findElement(By.className("login-button"));
        LoginEle.submit();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-text")));

        WebElement ErrorMessageEle = driver.findElement(By.className("error-message-text"));

        String actualErrorMessage = ErrorMessageEle.getText();

        String expectedErrorMessage = "Invalid user ID";

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Error text with empty input field do not match");

    }

    //Test the submission with empty PIN field
    //Navigate to the URL https://qafitnessapp.ccbp.tech/gym/login
    //Enter the text 142420 in the "User ID" field.
    //Click the "Login" button.
    //Wait and verify the error message - use Assertions,
    //
    //Expected text: Invalid PIN
    //If the error message does not match the expected text, print "Error text with empty input field do not match"
    //Close the browser window.

    @Test(priority = 3)

    public void emptyPINField(){
        WebElement UserInputEle = driver.findElement(By.id("userIdInput"));
        UserInputEle.sendKeys("142420");

        WebElement LoginEle = driver.findElement(By.className("login-button"));
        LoginEle.submit();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-text")));

        WebElement ErrorMessageEle = driver.findElement(By.className("error-message-text"));

        String actualErrorMessage = ErrorMessageEle.getText();

        String expectedErrorMessage = "Invalid PIN";

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Error text with empty input field do not match");

    }

    //Test the submission with invalid PIN
    //Navigate to the URL https://qafitnessapp.ccbp.tech/gym/login
    //Enter the text 142420 in the "User ID" field.
    //Enter the text 123456 in the "PIN" field.
    //Click the "Login" button.
    //Wait and verify the error message - use Assertions,
    //Expected text: User ID and PIN didn't match
    //If the error message does not match the expected text, print "Error text with invalid PIN do not match"
    //Close the browser window.

    @Test(priority = 4)

    public void invalidPIN(){
        WebElement UserInputEle = driver.findElement(By.id("userIdInput"));
        UserInputEle.sendKeys("142420");

        WebElement pinInputEle = driver.findElement(By.id("pinInput"));
        pinInputEle.sendKeys("123456");

        WebElement LoginEle = driver.findElement(By.className("login-button"));
        LoginEle.submit();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-text")));

        WebElement ErrorMessageEle = driver.findElement(By.className("error-message-text"));

        String actualErrorMessage = ErrorMessageEle.getText();

        String expectedErrorMessage = "User ID and PIN didn't match";

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Error text with invalid PIN do not match");

    }

    //Test the successful login
    //Navigate to the URL https://qafitnessapp.ccbp.tech/gym/login
    //Enter the text 142420 in the "User ID" field.
    //Enter the text 231225 in the "PIN" field.
    //Click the "Login" button.
    //Wait and verify the navigation to the home page - use Assertions,
    //Expected URL: https://qafitnessapp.ccbp.tech/
    //If the current URL does not match the expected URL, print "URLs do not match"
    //Close the browser window.

    @Test(priority = 5)

    public void successfulLogin(){
        WebElement UserInputEle = driver.findElement(By.id("userIdInput"));
        UserInputEle.sendKeys("142420");

        WebElement pinInputEle = driver.findElement(By.id("pinInput"));
        pinInputEle.sendKeys("231225");

        WebElement LoginEle = driver.findElement(By.className("login-button"));
        LoginEle.submit();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qafitnessapp.ccbp.tech/"));

        String actualHomeUrl = driver.getCurrentUrl();

        String expectedHomeUrl = "https://qafitnessapp.ccbp.tech/";

        Assert.assertEquals(actualHomeUrl,expectedHomeUrl,"URLs do not match");

    }




}
