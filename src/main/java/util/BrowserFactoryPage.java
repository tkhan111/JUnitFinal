package util;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactoryPage {

	static WebDriver driver;
	
	
	public static WebDriver init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/test/101/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public static int generateRandomnumber() {
		int maxValue = 5;
		int minValue = 1;
		Random random = new Random();
		int randomNum = random.nextInt((maxValue - minValue) + 1) + minValue;
		System.out.println(randomNum);
		return randomNum;
	}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
}
