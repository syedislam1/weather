package Selenium;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstScript {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "F:\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		//open NDTV Page
		driver.get("https://www.ndtv.com/");
		driver.manage().window().maximize();
		Thread.sleep(6000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='notnow']"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='h_sub_menu']")).click();
		Thread.sleep(4000);
		// open Weather Section
		driver.findElement(By.xpath("//*[@id=\"subnav\"]/div/div/div/div/div/a[8]")).click();
		Thread.sleep(6000);
		// Search City
		driver.findElement(By.xpath("//*[@id='searchBox']")).sendKeys("Ahmedabad");
		driver.findElement(By.xpath("//*[@id='Ahmedabad']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='cityText' and contains(text(),'Ahmedabad')]")).click();
		Thread.sleep(3000);
		// taking ScreenShot
		File scrShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrShot, new File("F:\\weather.png"));
		driver.close();
	}
}
