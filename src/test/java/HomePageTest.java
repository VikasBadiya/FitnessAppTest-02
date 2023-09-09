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

public class HomePageTest {

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

    //Test the Homepage Heading
    //Navigate to the URL https://qafitnessapp.ccbp.tech/gym/login
    //Enter the text 142420 in the "User ID" field.
    //Enter the text 231225 in the "PIN" field.
    //Click the "Login" button.
    //Wait until the web driver navigates to the home page,
    //Home Page URL: https://qafitnessapp.ccbp.tech/
    //Verify the Description text of the home page - use Assertions
    //Expected text: "The only bad workout is the one that didn't happen."
    //If the Description text does not match the expected text, print "Description text does not match"
    //Close the browser window.

    @Test(priority = 1)

    public void HomepageHeading(){
        WebElement UserInputEle = driver.findElement(By.id("userIdInput"));
        UserInputEle.sendKeys("142420");

        WebElement pinInputEle = driver.findElement(By.id("pinInput"));
        pinInputEle.sendKeys("231225");

        WebElement LoginEle = driver.findElement(By.className("login-button"));
        LoginEle.submit();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qafitnessapp.ccbp.tech/"));

        WebElement DescriptionEle = driver.findElement(By.className("motivational-quote"));

        String actualDescription = DescriptionEle.getText();
        String expectedDescription = "\"The only bad workout is the one that didn't happen.\"";

        Assert.assertEquals(actualDescription,expectedDescription,"Description text does not match");

    }

    //Test the Logout functionality
    //Navigate to the URL https://qafitnessapp.ccbp.tech/gym/login
    //Enter the text 142420 in the "User ID" field.
    //Enter the text 231225 in the "PIN" field.
    //Click the "Login" button.
    //Wait until the web driver navigates to the home page,
    //Home Page URL: https://qafitnessapp.ccbp.tech/
    //Click the "Logout" button.
    //Verify the navigation to the login page - use Assertions,
    //Expected URL: https://qafitnessapp.ccbp.tech/gym/login/
    //If the current URL does not match the expected URL, print "URLs do not match"
    //Close the browser window.

    @Test(priority = 2)

    public void LogoutFunctionality(){
        WebElement UserInputEle = driver.findElement(By.id("userIdInput"));
        UserInputEle.sendKeys("142420");

        WebElement pinInputEle = driver.findElement(By.id("pinInput"));
        pinInputEle.sendKeys("231225");

        WebElement LoginEle = driver.findElement(By.className("login-button"));
        LoginEle.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qafitnessapp.ccbp.tech/"));

        WebElement LogOutEle = driver.findElement(By.className("logout-button"));
        LogOutEle.click();

        String actualLoginUrl = driver.getCurrentUrl();

        String expectedLoginUrl = "https://qafitnessapp.ccbp.tech/gym/login";

        Assert.assertEquals(actualLoginUrl,expectedLoginUrl,"URLs do not match");



    }


}
