package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;

public class AssertTest {

	@Test
	public void test() {
		Assert.assertTrue(true);    //espera sempre expressoes verdadeiras   
		Assert.assertFalse(false);    //espera sempre expressoes falsas
		
		Assert.assertEquals(1, 1);    //verifica se as expressoes sao iguais
		Assert.assertEquals(0.52,0.52, 0.01);    //o delta é a margem de erro para casa decimais , ele relamentediz que dados depois da margem de delta serao ignorados 
		
		// formas de compara numeros 
		
		int i = 5;
		Integer i2 = 5;
		Assert.assertEquals(Integer.valueOf(i), i2);
		Assert.assertEquals(i, i2.intValue());
		
		// string ---------------------------
		
		Assert.assertEquals("bola", "bola");
		Assert.assertTrue("bola" .equalsIgnoreCase("Bola"));
		
		// objetos---------------------------------------------------------------------
		// implemente o metodo equal do objeto
		
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		Usuario u3 = null;
		
		Assert.assertEquals(u1, u2);    //aqui verificaa se os dados do objeto (nome) sao iguais 
		Assert.assertSame(u2, u2);      // aqui verifica se a instancias do objeto sao igauis , se fosse , o u1 e u2 , o testes nao passaria 
		Assert.assertNull(u3);          // verifica se o objeto esta nulo
		
	}
}
