package br.com.arthur.suites;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.arthur.core.DriverFactory;
import br.com.arthur.test.TesteCadastro;
import br.com.arthur.test.TesteRegrasCadastro;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastro.class,
	TesteRegrasCadastro.class
})
public class SuiteTeste {
	
	@AfterClass
	public static void finalizaTudo(){
		DriverFactory.killDriver();
	}

}
