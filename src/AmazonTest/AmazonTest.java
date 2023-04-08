package AmazonTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//webdriver -> interface used for all browser drivers
		//if we use chromedriver it will be used only for chrome driver.not for FF browser.
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("samsung mobile");
		
		WebElement searchbtn = driver.findElement(By.id("nav-search-submit-button"));
		searchbtn.click();
		
		//read the locators using xpath
		List<WebElement> productname = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//h2//span"));
		List<WebElement> productprice = driver.findElements(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-micro s-price-instructions-style']//div//span[@class='a-price']"));
		System.out.println("All the products on the results " + productname.size());
		for(int i=0;i<productname.size();i++)
			{
				System.out.println("product name : " + productname.get(i).getText());
				System.out.println("product price : " + productprice.get(i).getText());					}
			
		
		//take screenshot:
		TakesScreenshot tsObj = (TakesScreenshot) driver;
		File fileobj = tsObj.getScreenshotAs(OutputType.FILE);
		
		File screenshotobj = new File("image.png");
		
		FileUtils.copyFile(fileobj, screenshotobj);
		driver.close();

		//	List<WebElement> productprice = driver.findElements(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-micro s-price-instructions-style']//div//span[@class='a-price']"));
		//	for(WebElement x:listprice)
		//	{
		//		System.out.println(x.getText());
		//	}							

	}

}
