package SeleniumMakeMyTrip;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTrip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "E:\\NishaStudyMaterial\\Driver\\geckodriver.exe");

		// Initialize Firefox WebDriver
		WebDriver driver = new FirefoxDriver();
		// WebDriver driver = new ChromeDriver();

		// Set up explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		try {
			// Open MakeMyTrip website
			driver.get("https://www.makemytrip.com/");
			driver.manage().window().maximize();

			// Wait and attempt to dismiss popup by clicking on body
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-cy = 'closeModal']")))
						.click();
			} catch (Exception e) {
				System.out.println("No popup or click failed.");
			}

			// Wait until the logo is visible
			WebElement logo = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt= 'Make My Trip']")));

			// Check if logo is displayed
			if (logo.isDisplayed()) {
				System.out.println("MakeMyTrip logo is present on the page.");
			} else {
				System.out.println("Logo found but not visible.");
			}

		} catch (NoSuchElementException e) {
			System.out.println("MakeMyTrip logo not found on the page.");
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		} finally {
			// Close the browser
			driver.quit();
		}
	}

}
