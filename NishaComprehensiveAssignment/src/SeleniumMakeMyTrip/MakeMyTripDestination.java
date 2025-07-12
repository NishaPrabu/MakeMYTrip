package SeleniumMakeMyTrip;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTripDestination {

	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "E:\\NishaStudyMaterial\\Driver\\geckodriver.exe");

		// Initialize Firefox WebDriver
		WebDriver driver = new FirefoxDriver();
		// WebDriver driver = new ChromeDriver();

		// Set up explicit wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		try {
			// Open MakeMyTrip website
			launchURL("https://www.makemytrip.com/");

			driver.manage().window().maximize();

			waitForPageLoad();

			// Wait and attempt to dismiss popup by clicking on body
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-cy = 'closeModal']")))
						.click();
			} catch (Exception e) {
				System.out.println("No popup or click failed.");
			}

			// dismissOverlayIfPresent();


			// Wait for logo to verify page load
			waitForVisibility(By.xpath("//img[@alt='Make My Trip']"));

			// Click on Flights tab
			clickElement(By.xpath("(//a[@href='/flights/'])[1]"));
			// clickElement(By.xpath("(//a[@href='/flights/'])[1]"));

			// Click on One Way option
			clickElement(By.xpath("//li[@data-cy='oneWayTrip']"));

			// FROM city
			clickElement(By.xpath("//label[@for='fromCity']"));
			enterText(By.xpath("//input[@placeholder='From']"), "Delhi");
			clickElement(By.xpath("//p[contains(text(),'Bengaluru, India')]"));

			// TO city
			clickElement(By.xpath("//label[@for='toCity']"));
			enterText(By.xpath("//input[@placeholder='To']"), "Bengaluru");
			clickElement(By.xpath("//p[contains(text(),'Delhi, India')]"));

			System.out.println(" OneWay trip, From and To locations selected successfully.");

		} catch (Exception e) {
			System.out.println(" Error occurred: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}

	// Generic Utility Methods
	// --------------------------

	public static void launchURL(String url) {
		driver.get(url);
	}

	public static void clickElement(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public static void enterText(By locator, String text) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.clear();
		element.sendKeys(text);
	}

	public static void waitForVisibility(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void dismissOverlayIfPresent() {
		try {
			Thread.sleep(2000); // Wait briefly for overlay to appear
			WebElement overlay = driver.findElement(By.cssSelector(".loginModal"));
			wait.until(ExpectedConditions.invisibilityOf(overlay));
			System.out.println(" Overlay/modal dismissed.");
		} catch (Exception e) {
			System.out.println("Overlay not present or already closed.");
		}
	}

	public static void jsClick(By locator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public static void waitForPageLoad() {
		wait.until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
	}
}
