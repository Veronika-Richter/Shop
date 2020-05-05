package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.UserAccountPage;
import pages.UserAuthenticationPage;


public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected UserAuthenticationPage userAuthenticationPage;
    protected UserAccountPage userAccountPage;

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void accountLogin() {
        homePage = new HomePage(driver);
        userAuthenticationPage = new UserAuthenticationPage(driver);
        userAccountPage = new UserAccountPage(driver);
        homePage.openPage();
        homePage.clickSignIn();
        userAuthenticationPage.enterEmailAddress("verbena_1@mail.ru");
        userAuthenticationPage.enterPassword("19942509");
        userAuthenticationPage.clickSubmitButton();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}

