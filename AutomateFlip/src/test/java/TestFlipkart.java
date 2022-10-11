import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestFlipkart {
	WebDriver driver;

	@Test(groups = "Chrome")
	public void LaunchChrome() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Desktop\\selenium/chromedriver.exe");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(groups = "Chrome", dependsOnMethods = "LaunchChrome")
	public void Chrome() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");

		driver.findElement(By.xpath("//button[contains(.,'✕')]")).click();
		System.out.println("Closed the signup page");

		Long loadtime = (Long) ((JavascriptExecutor) driver)
				.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println("Load time of the website is :- " + loadtime);
		

		driver.findElement(By.className("_3704LK")).sendKeys("iphone 13");
		driver.findElement(By.className("L0Z3Pu")).click();

		WebElement i = driver.findElement(By.xpath("//img[@class='_396cs4 _3exPp9']"));
		Boolean p = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
				+ "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

		if (p) {
			System.out.println("Image is loaded");
		} else {
			System.out.println("Image not loaded");
		}
		
		System.out.println("Current Webpage: "+ driver.getTitle());

		try {
			long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2000);

				long newHeight = (long) ((JavascriptExecutor) driver)
						.executeScript("return document.body.scrollHeight");
				if (newHeight == lastHeight) {
					break;
				}
				lastHeight = newHeight;
				System.out.println("Scrolled & Page Height: "+lastHeight);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(groups = "Edge")
	public void LaunchEdge() {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\Admin\\Desktop\\selenium/msedgedriver.exe");
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(groups="Edge", dependsOnMethods="LaunchEdge")
	public void Edge() {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//button[contains(.,'✕')]")).click();
		System.out.println("Closed the signup page");

		Long loadtime = (Long) ((JavascriptExecutor) driver)
				.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println("Load time of the website is :- " + loadtime);


		driver.findElement(By.className("_3704LK")).sendKeys("iphone 13");
		driver.findElement(By.className("L0Z3Pu")).click();

		WebElement i = driver.findElement(By.xpath("//img[@class='_396cs4 _3exPp9']"));
		Boolean p = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
				+ "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

		if (p) {
			System.out.println("Image is loaded");
		} else {
			System.out.println("Image not loaded");
		}
		
		System.out.println("Current Webpage: "+ driver.getTitle());

		try {
			long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2000);

				long newHeight = (long) ((JavascriptExecutor) driver)
						.executeScript("return document.body.scrollHeight");
				if (newHeight == lastHeight) {
					break;
				}
				lastHeight = newHeight;
				System.out.println("Scrolled & Page Height: "+lastHeight);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
