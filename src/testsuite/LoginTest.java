package testsuite;
/**
 * 1. userShouldNavigateToLoginPageSuccessfully *
 * click on the Sign In' link
 * * Verify the text ‘Welcome Back!’
 * <p>
 * 2. verifyTheErrorMessage
 * <p>
 * * click on the ‘Sign In’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Invalid email
 * or password.’
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //signIn elements
        WebElement signInField = driver.findElement(By.linkText("Sign In"));
        signInField.click();
        //actual result
        WebElement actualResult = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]"));
        String actualMsg = actualResult.getText();
        System.out.println(actualMsg);

        //expectedResult
        String expectedResult = "Welcome Back!";

        //match actual and expected result
        Assert.assertEquals("", actualMsg, expectedResult);

    }

    @Test
    public void verifyTheErrorMessage() {
        //signIn elements
        WebElement signInField = driver.findElement(By.linkText("Sign In"));
        signInField.click();

        //emailField element
        WebElement emailField = driver.findElement(By.name("user[email]"));
        emailField.sendKeys("mac123@gmail.com");

        //password element
        WebElement PasswordField = driver.findElement(By.id("user[password]"));
        PasswordField.sendKeys("mac123");

        //signIn element
        WebElement signInField1 = driver.findElement(By.xpath("//button[@type='submit']"));
        signInField1.click();

        //actual result
        WebElement actualResult = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualMsg = actualResult.getText();
        System.out.println(actualMsg);

        //expectedResult
        String expectedMsg = "Invalid email or password.";

        //match actual and expected result
        Assert.assertEquals("",expectedMsg,actualMsg);
    }
    @After
    //Here After method for close the browser
    public  void tearDown(){
        closeBrowser();
    }
}