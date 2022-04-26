import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert {

	@Test
	public void deve_Interagir_com_AlertSimples() {  
		System.setProperty("webdriver.chrome.driver", "C://ARTHUR//ESTUDO-TI//TI02-TESTES//te02-testes-funcionais-selenium//drivers//chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
    	
    	driver.findElement(By.id("alert")).click();
    	Alert alert = driver.switchTo().alert();
    	
    	Assert.assertEquals("Alert Simples", alert.getText());
    	driver.quit();
	}
	
	@Test
	public void deve_Interagir_com_AlertConfirm() {  
		System.setProperty("webdriver.chrome.driver", "C://ARTHUR//ESTUDO-TI//TI02-TESTES//te02-testes-funcionais-selenium//drivers//chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
    	
    	driver.findElement(By.id("confirm")).click();
    	Alert alert = driver.switchTo().alert();
    	Assert.assertEquals("Confirm Simples", alert.getText());
    	alert.accept();
    	Assert.assertEquals("Confirmado", alert.getText());
    	alert.accept();
   // 	driver.quit();
	}
	
	@Test
	public void deve_Interagir_com_AlertPrompt() {  
		System.setProperty("webdriver.chrome.driver", "C://ARTHUR//ESTUDO-TI//TI02-TESTES//te02-testes-funcionais-selenium//drivers//chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
    	
    	driver.findElement(By.id("prompt")).click();
    	Alert alert = driver.switchTo().alert();
    	Assert.assertEquals("Digite um numero", alert.getText());
    	alert.sendKeys("12");
    	alert.accept();
    	Assert.assertEquals("Era 12?", alert.getText());
    	alert.accept();
    	Assert.assertEquals(":D", alert.getText());
    	alert.accept();
   // 	driver.quit();
	}
}
