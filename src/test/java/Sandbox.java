import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sandbox {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

    @Test
    public void commonSearchTemrTest() throws InterruptedException {

        driver.get("http://automationpractice.com/index.php");


        WebElement searchField = waitForElementLocatedBy(driver, By.id("search_query_top"));

        searchField.sendKeys("sona test");
        Thread.sleep(2000);

    }

    public static WebElement waitForElementLocatedBy(WebDriver driver, By by){
        return new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(by));
    }


}
