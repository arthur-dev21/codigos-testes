import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioCadastro1 {

	private static WebDriver driver;

	@BeforeClass
	public static  void antes() {
		System.setProperty("webdriver.chrome.driver",
				"C://ARTHUR//ESTUDO-TI//TI02-TESTES//te02-testes-funcionais-selenium//drivers//chromedriver.exe");
		driver = new ChromeDriver();
	
	}

	@Test
	public void deve_inserir_elementos_para_validacao() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Arthur");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Kenned");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select select = new Select(element);
		select.selectByVisibleText("Superior");
		
		WebElement element2 = driver.findElement(By.id("elementosForm:esportes"));
		Select select2 = new Select(element2);
		select2.selectByVisibleText("Futebol");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		
		
		
	}

	@AfterClass
	public static  void encerrar() {
		//driver.quit();
	
	}
}

/*
 * 
 * testes cadastro completo
 * 
 * -nome sobrenome sexo xcomida escoldaridade esporte
 * 
 * cadastrar
 * 
 * validar se todos os dados estao certos
 */
