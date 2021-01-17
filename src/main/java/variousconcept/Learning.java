package variousconcept;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learning {

	WebDriver driver;

	@Test
	public void init() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Abderrahim\\Aug2020_selenium\\session5\\driver\\driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		String handle1 = driver.getWindowHandle();
		
		
		driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("xpath");
		driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();
		
		driver.findElement(By.linkText("XPath Tutorial - W3Schools"));

		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);

		for (String i : handles) {
			System.out.println(i);
			driver.switchTo().window(i);

		}

		System.out.println(driver.getTitle());
		driver.switchTo().window(handle1);
		System.out.println(driver.getTitle());

	}

}
