import java.util.Arrays;
import java.util.List;


import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;





public class TestCampoTreinamento {

	@Test
    public void deveInteragirCom__TextField() { //TextField
    	System.setProperty("webdriver.chrome.driver", "C://ARTHUR//ESTUDO-TI//TI02-TESTES//te02-testes-funcionais-selenium//drivers//chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
    	driver.findElement(By.id("elementosForm:nome")).sendKeys("Arthur");
    	
    	Assert.assertEquals("Arthur", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
    	driver.quit();
    }
	
	@Test
	public void deveInteragirCom__Textarea() {  //TextArea
		System.setProperty("webdriver.chrome.driver", "C://ARTHUR//ESTUDO-TI//TI02-TESTES//te02-testes-funcionais-selenium//drivers//chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
    	driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Test");
    	
    	Assert.assertEquals("Test",driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value") );
    	driver.quit();
	}
	
	@Test
	public void deveInteragirCom__RadioButton() {  //TextArea
		System.setProperty("webdriver.chrome.driver", "C://ARTHUR//ESTUDO-TI//TI02-TESTES//te02-testes-funcionais-selenium//drivers//chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
    	driver.findElement(By.id("elementosForm:sexo:0")).click();
    	
    	Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
    	driver.quit();
	}
	
	@Test
	public void deveInteragirCom__CheckBox() { 
		System.setProperty("webdriver.chrome.driver", "C://ARTHUR//ESTUDO-TI//TI02-TESTES//te02-testes-funcionais-selenium//drivers//chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
    	
    	driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
    	driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
    	
    	Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
    	Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());
    	driver.quit();
	}
	
	@Test
	public void deveInteragirCom__Combo() {  
		System.setProperty("webdriver.chrome.driver", "C://ARTHUR//ESTUDO-TI//TI02-TESTES//te02-testes-funcionais-selenium//drivers//chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
    	
    	WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
    	Select combo = new Select(element);
    	//forma 1 -> pelo index
    	//combo.selectByIndex(3);
    	
    	//forma 2 -> pelo valor
    	//combo.selectByValue("1grauincomp");
    	
    	//forma 3 -> pelo valor visiviel ao usuario 
    	combo.selectByVisibleText("Superior");
    	
    	
    	
    	Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
    	driver.quit();
	}
	
	@Test
	public void deveInteragirCom__Combo__VerificandoValoresDisponiveis() {   //combo
		System.setProperty("webdriver.chrome.driver", "C://ARTHUR//ESTUDO-TI//TI02-TESTES//te02-testes-funcionais-selenium//drivers//chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
    	
    	WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
    	Select combo = new Select(element);
    	List<WebElement>elementos = combo.getOptions();
    	
    	Assert.assertEquals(8, elementos.size());
	
    	driver.quit();
	}
	
	
	@Test
	public void deveInteragirCom__Combo__VerificandoValores() {  
		System.setProperty("webdriver.chrome.driver", "C://ARTHUR//ESTUDO-TI//TI02-TESTES//te02-testes-funcionais-selenium//drivers//chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
    	
    	WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
    	Select combo = new Select(element);
    	List<WebElement>elementos = combo.getOptions();
    	
    	boolean encontrou = false;
    	for(WebElement option : elementos ) {
    		if(option.getText().equals("Mestrado")) {
    			encontrou = true;
    			break;
    		}
    	}
    	
    	Assert.assertTrue(encontrou);
    	driver.quit();
	}
	
	@Test
	public void deveInteragirCom__Combo_MultiplaEscolha() {  
		System.setProperty("webdriver.chrome.driver", "C://ARTHUR//ESTUDO-TI//TI02-TESTES//te02-testes-funcionais-selenium//drivers//chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
    	
    	WebElement element = driver.findElement(By.id("elementosForm:esportes"));
    	Select combo = new Select(element);
    	combo.selectByVisibleText("Natacao");
    	combo.selectByVisibleText("Futebol");
    	combo.selectByVisibleText("Corrida");
    	
    	List<WebElement>combos = combo.getAllSelectedOptions();
    	Assert.assertEquals(3, combos.size());
    	
    	driver.quit();
	}
	
	@Test
	public void deveInteragirCom__Botoes() {  
		System.setProperty("webdriver.chrome.driver", "C://ARTHUR//ESTUDO-TI//TI02-TESTES//te02-testes-funcionais-selenium//drivers//chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
    	
    	WebElement botao =  driver.findElement(By.id("buttonSimple"));
    	botao.click();
    	
    	Assert.assertEquals("Obrigado!",botao.getAttribute("value"));
    	
    	driver.quit();
	}
	
	@Test
	public void deveInteragirCom__Botoes_verificandoAntes_Depois() {  
		System.setProperty("webdriver.chrome.driver", "C://ARTHUR//ESTUDO-TI//TI02-TESTES//te02-testes-funcionais-selenium//drivers//chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
    	
    	//verificar o nome do botao antes e depois do clique
    	
    	WebElement botaoAntes =  driver.findElement(By.id("buttonSimple"));
    	String nomeAntes = botaoAntes.getAttribute("value");
    	botaoAntes.click();
    	
    	Assert.assertNotEquals(nomeAntes,driver.findElement(By.id("buttonSimple")).getAttribute("value") );
    	driver.quit();
	}
	
	@Test
	public void deveInteragirCom__Links() {  
		System.setProperty("webdriver.chrome.driver", "C://ARTHUR//ESTUDO-TI//TI02-TESTES//te02-testes-funcionais-selenium//drivers//chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
    	
    	driver.findElement(By.linkText("Voltar")).click();
    	Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
    	driver.quit();
	}
	
	@Test
	public void devebuscartextosNaPagina() {  
		System.setProperty("webdriver.chrome.driver", "C://ARTHUR//ESTUDO-TI//TI02-TESTES//te02-testes-funcionais-selenium//drivers//chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
    	
    
 //   	Assert.assertTrue(	driver.findElement(By.tagName("body"))
 //   			.getText().contains("Campo de Treinamento"));
    	
    	Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
    	driver.quit();
	}
	
	
}
