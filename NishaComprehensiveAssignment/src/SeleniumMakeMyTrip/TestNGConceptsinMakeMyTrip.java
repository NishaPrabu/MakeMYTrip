package SeleniumMakeMyTrip;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGConceptsinMakeMyTrip {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.gecko.driver", "E:\\NishaStudyMaterial\\Driver\\geckodriver.exe");

		// Initialize Firefox WebDriver
		WebDriver driver = new FirefoxDriver();
		// Initialize Chrome WebDriver
		// driver = new ChromeDriver();

		// Set up explicit wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void verifyMakeMyTripLogo() {
		launchURL("https://www.makemytrip.com/");
		waitForPageLoad();
		dismissPopup();

		try {
			WebElement logo = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Make My Trip']")));
			Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed.");
			System.out.println("MakeMyTrip logo is present.");
		} catch (NoSuchElementException e) {
			Assert.fail("❌ Logo not found.");
		}
	}

	@Test
	public void selectOneWayTripWithCities() {
		launchURL("https://www.makemytrip.com/");
		waitForPageLoad();
		dismissPopup();

		clickElement(By.xpath("(//a[@href='/flights/'])[1]"));
		clickElement(By.xpath("//li[@data-cy='oneWayTrip']"));

		// FROM city: Delhi
		clickElement(By.xpath("//label[@for='fromCity']"));
		enterText(By.xpath("//input[@placeholder='From']"), "Delhi");
		clickElement(By.xpath("//p[contains(text(),'Bengaluru, India')]"));

		// TO city: Bengaluru
		clickElement(By.xpath("//label[@for='toCity']"));
		enterText(By.xpath("//input[@placeholder='To']"), "Bengaluru");
		clickElement(By.xpath("//p[contains(text(),'Delhi, India')]"));

		System.out.println("OneWay trip FROM/TO selection successful.");
	}

	// ---------- Utility Methods ----------

	public void launchURL(String url) {
		driver.get(url);
	}

	public void clickElement(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public void enterText(By locator, String text) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.clear();
		element.sendKeys(text);
	}

	public void waitForPageLoad() {
		wait.until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
	}

	public void dismissPopup() {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-cy = 'closeModal']")))
					.click();
			System.out.println("Popup closed.");
		} catch (Exception e) {
			System.out.println("No popup or already dismissed.");
		}
	}
}
