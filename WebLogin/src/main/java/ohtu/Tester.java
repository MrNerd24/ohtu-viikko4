package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\juuso_j0pbwen\\OneDrive\\Asiakirjat\\Opiskelu\\Harjoitukset\\Ohjelmointituotanto\\chromedriver.exe"); 
        
        WebDriver driver = new ChromeDriver();

        Login(driver, "pekka", "akkep");
        Login(driver, "pekka", "akke");
        Login(driver, "ekka", "akke");
        
        newUser(driver, "pentti", "ittnep");
        
        newUser(driver, "paavo", "ovaap");
        logout(driver);
        
        driver.quit();
    }

    private static void Login(WebDriver driver, String username, String password) {
        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
        
        sleep(3);
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }

    private static void newUser(WebDriver driver, String username, String password) {
        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();
        
        sleep(3);
    }

    private static void logout(WebDriver driver) {
        
        
        WebElement element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();

        sleep(2);
        
        element = driver.findElement(By.linkText("logout"));
        element.click();
        
        sleep(3);
    }
}
