package ohtu;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ohtu.domain.User;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Stepdefs {

    WebDriver driver = new ChromeDriver();
    String baseUrl = "http://localhost:4567";

    @Given("^login is selected$")
    public void login_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
    }

    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_and_password_are_given(String username, String password) throws Throwable {
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    @Then("^system will respond \"([^\"]*)\"$")
    public void system_will_respond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }

    @When("^correct username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_correct_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^correct username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given$")
    public void username_and_incorrect_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @Then("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        pageHasContent("Ohtu Application main page");
    }

    @Then("^user is not logged in and error message is given$")
    public void user_is_not_logged_in_and_error_message_is_given() throws Throwable {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }

    @When("^incorrect username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void incorrect_username_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @Given("^new user is selected$")
    public void new_user_is_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }

    @When("^new username \"([^\"]*)\", password \"([^\"]*)\" and password confirmation \"([^\"]*)\" are given$")
    public void new_username_password_and_password_confirmation_are_given(String username, String password, String passwordConfirmation) throws Throwable {
        registerWith(username, password, passwordConfirmation);
    }

    @Then("^new user is created$")
    public void new_user_is_created() throws Throwable {
        pageHasContent("Welcome to Ohtu Application!");
    }

    @Then("^user is not created and error \"([^\"]*)\" is reported$")
    public void user_is_not_created_and_error_is_reported(String error) throws Throwable {
        pageHasContent(error);
    }

    @Given("^new username \"([^\"]*)\", password \"([^\"]*)\" and password confirmation \"([^\"]*)\" are given succesfully$")
    public void new_username_password_and_password_confirmation_are_given_succesfully(String username, String password, String passwordConfirmation) throws Throwable {
        registerWith(username, password, passwordConfirmation);
    }

    @Given("^new user is created succesfully$")
    public void new_user_is_created_succesfully() throws Throwable {
        pageHasContent("Welcome to Ohtu Application!");
    }

    @Given("^user with username \"([^\"]*)\" with password \"([^\"]*)\" is succesfully created$")
    public void user_with_username_with_password_is_succesfully_created(String username, String password) throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        registerWith(username, password, password);
        pageHasContent("Welcome to Ohtu Application!");
    }

    @Given("^user with username \"([^\"]*)\" and password \"([^\"]*)\" is unsuccesfully created$")
    public void user_with_username_and_password_is_unsuccesfully_created(String username, String password) throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        registerWith(username, password, password);
        assertFalse(driver.getPageSource().contains("Welcome to Ohtu Application!"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /* helper methods */
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    private void registerWith(String username, String password, String passwordConfirmation) {
        pageHasContent("Create username and give password");
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConfirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }

    private void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
