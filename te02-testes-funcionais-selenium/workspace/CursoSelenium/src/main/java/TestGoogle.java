import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestGoogle {

	
	
	@Test
	public void deve_testar_google() {
		System.setProperty("webdriver.chrome.driver",
				"C://ARTHUR//ESTUDO-TI//TI02-TESTES//te02-testes-funcionais-selenium//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(1200,765));
		driver.get("http://www.google.com.br");
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}
}
