package br.ce.wcaquino.servicos;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {

	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private LocacaoService service;
	
	@Before
	public  void setup() {
		 service = new LocacaoService();
	}
	
	@After
	public  void tearDown() {
		System.out.println("after");
	}
	
	@BeforeClass
	public static  void setupClass() {
		System.out.println("before class");
	}
	
	@AfterClass
	public static  void tearDownClass() {
		System.out.println("after class");
	}
	
	@Test
	public void devePagar75PcnrNoFilme3() throws Exception {
		
		//cenario
		Usuario usuario = new Usuario("Usuario 1");
		List<Filme>filmes = Arrays.asList(new Filme("filme 1 ", 5, 4.0),new Filme("filme 2 ", 5, 4.0),new Filme("filme 3 ", 5, 4.0));
		
	    //acao
		Locacao resultado = service.alugarFilme(usuario, filmes);
		
		//validacao
		Assert.assertThat(resultado.getValor(), CoreMatchers.is(11) , 0.01);
	}

	@Test
	public void deve_Aluga_filme() throws Exception {

		// cenario
		
		Usuario usuario = new Usuario("Usuario 1");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1 ", 2, 5.0)) ;

		// acao
		Locacao locacao = service.alugarFilme(usuario, filmes);

		// verificacao
		Assert.assertTrue(locacao.getValor() == 5.0);
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));

		// utilizando aserrtThat -----------------------------

		Assert.assertThat(locacao.getValor(), CoreMatchers.is(5.0));

	}
	
	@Test
	public void deve_alugar_filme_SemEstoque3() throws Exception {
		
		// cenario
		
		Usuario usuario = new Usuario("Usuario 1");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1 ", 0, 5.0)) ;

		exception.expect(Exception.class);
		exception.expectMessage("Filme sem estoque");
		
		//como assim as validacoes foram veitas antes da açao ? 
		//porque como esperamos uma xecption lancada , a exception foi lancada e o teste finalizou , por isso devemos coloca-lo antes da acao
		
		// acao
		 service.alugarFilme(usuario, filmes);
		 
		

	}
	
	@Test(expected = Exception.class)
	public void testeLocacao_filmeSemEstoque() throws Exception {
		
		// cenario
		
		Usuario usuario = new Usuario("Usuario 1");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1 ", 0, 5.0)) ;

		// acao
		 service.alugarFilme(usuario, filmes);

	}
	
	@Test
	public void testeLocacao_filmeSemEstoque2() {
		
		// cenario
		
		Usuario usuario = new Usuario("Usuario 1");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1 ", 0, 5.0)) ;

		// acao
		try {
			service.alugarFilme(usuario, filmes);
			Assert.fail("Deveria lancar uma exception");
		}catch (Exception e) {
		    Assert.assertThat(e.getMessage(),  CoreMatchers.is("Filme sem estoque"));
		}
		 

	}
}
