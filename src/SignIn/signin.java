package SignIn;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class signin {

	@Test
	public void Test1() {
		File f = new File("src");
		File fs = new File(f, "chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", fs.getAbsolutePath());
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Navigate to page and click Login button
		driver.get("http://testapp.galenframework.com/");
		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary button-login']")).click();

		// Enter username, password to fields and click button login
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("testuser@example.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("test123");

		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary button-login']")).click();

		// Verify button Add note is displayed on screeen. If yes, this is logged in
		// successfully
		boolean flag = driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary']")).isDisplayed();
		Assert.assertEquals(flag, true);

		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary']")).click();

		// Add the Title and description and click Add note button
		driver.findElement(By.xpath("//input[@placeholder='Title']")).sendKeys("Nghi-Title");
		driver.findElement(By.xpath("//textarea[@placeholder='Description']")).sendKeys("Nghi-Description");

		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary']")).click();

		// Idea of this is to verify the note which newly added is displayed on screen.
		// But currently, I'm out of time do check this
		String message = driver.findElement(By.xpath("//div[@class='list-group']//h4[contains(text(),'Nghi-title')]"))
				.getText();
		Assert.assertEquals(message, "Nghi-title");

		driver.quit();
	}

}
