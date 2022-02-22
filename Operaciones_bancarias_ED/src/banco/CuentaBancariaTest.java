package banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaBancariaTest {

	/*
	 * Para poder usar el objeto cc en todos los m�todos de la prueba, tenemos que convertirlo en un atributo global para todos los m�todos de la clase. 
	 * refactor-->Convert Local Variable to Field..
	 */
	
	private CuentaBancaria cc;

	/*
	 * Estos 4 m�todos se van a ejecutar antes o despues de cada prueba.
	 * 1. BeforeAll se va a ejecutar una sola vez al principio, se usa para inicializar la clase de pruebas.
	 * 2. Despu�s se va a ejecutar BeforeEach y afterEach por cada @test que tengamos. Siendo el orden BeforeEach-->@test--->AfterEach.
	 * 3. AfterAll se va a ejecutar al final de las pruebas.
	 */
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		System.out.println("*************");
		System.out.println("COMENZANDO LAS PRUEBAS");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		System.out.println("FINALIZANDO LAS PRUEBAS");
		System.out.println("*************");
	}
	
	/*
	 *  Como este m�todo se ejecuta siempre antes de un @Test, creamos el objeto que necesitamos para cada prueba, en este m�todo.
	 */
	
	@BeforeEach
	void setUp() throws Exception {
		cc = new CuentaBancaria(1000, "pass");
		
		System.out.println("Comenzando un test");
	}

	@AfterEach
	void tearDown() throws Exception {
		
		cc = null;
		System.out.println("Finalizando un test");
	}

	
	/*
	 * @TEST nos indica que va a probar el m�todo escrito dentro de la anotacion.
	 * Hay que probar todos los m�todos tantas veces como bifurcaciones tenga el m�todo.
	 * 
	 * Por lo tanto el testDepositar, lo probaremos 2 veces, una con una cantidad positiva y otra con una negativa.
	 * Para probar cada m�todo hay que crear un objeto dentro del mismo, con el cu�l vamos a probar nuestros m�todos.
	 */
	@Test
	void testDepositar_correcto() {
		 
		// CuentaBancaria cc = new CuentaBancaria(1000, "pass");
		
		System.out.println("REALIZANDO TEST");
		 int resultadoEsperado = 1500;
		 int resultadoReal = cc.depositar(500);
		 
		 assertEquals(resultadoEsperado, resultadoReal);
	}
	
	@Test
	void testDepositar_no_correcto() {
		
		// CuentaBancaria cc = new CuentaBancaria(1000, "pass");
		System.out.println("REALIZANDO TEST");
		 int resultadoEsperado = -1;
		 int resultadoReal = cc.depositar(-500);
		 
		 assertEquals(resultadoEsperado, resultadoReal);
	}

	/*
	 * Para este m�todo tenemos que hacer 3 pruebas:
	 * 1. Con la contrase�a correcta y una cantidad inferior o igual a que tenemos. Aqu� me ejecutar� el m�todo restando la cantidad metida a la que tenemos.
	 * 2. Contrase�a correcta y cantidad superior a la que tenemos. Me devolvera un codigo de error igual a -1.
	 * 3. Contrase�a incorrecta. Me devolver� un c�digo de error igual a -2.
	 */
	@Test
	void testRetirar_correcta() {
		
		// CuentaBancaria cc = new CuentaBancaria(1000, "pass");
		System.out.println("REALIZANDO TEST");
		int resultadoEsperado = 500;
		int resultadoReal = cc.retirar(500, "pass");
		
		assertEquals(resultadoEsperado, resultadoReal);
	}
	
	@Test
	void testRetirar_Contrase�a_Correcta_Cantidad_Superior() {
		
		// CuentaBancaria cc = new CuentaBancaria(1000, "pass");
		System.out.println("REALIZANDO TEST");
		int resultadoEsperado = -1;
		int resultadoReal = cc.retirar(5000, "pass");
		
		assertEquals(resultadoEsperado, resultadoReal);
	}
	
	@Test
	void testRetirar_No_Correcto() {
		
		// CuentaBancaria cc = new CuentaBancaria(1000, "pass");
		System.out.println("REALIZANDO TEST");
		int resultadoEsperado = -2;
		int resultadoReal = cc.retirar(500, "pas");
		
		assertEquals(resultadoEsperado, resultadoReal);
		
	}
	/*
	 * Compara el password configurado en la cuenta con un String que le pasemos.
	 * Hay que comparar el metodo 2 veces, una con la contrase�a correcta y otra con la incorrecta.
	 */
	@Test
	void testPasswordCorrecta_True() {
		
		// CuentaBancaria cc = new CuentaBancaria(1000, "pass");
		System.out.println("REALIZANDO TEST");
		assertTrue(cc.passwordCorrecta("pass"));
		
	}
	
	@Test
	void testPasswordCorrecta_False() {
		
		// CuentaBancaria cc = new CuentaBancaria(1000, "pass");
		System.out.println("REALIZANDO TEST");
		assertFalse(cc.passwordCorrecta("pas"));
		
		
	}

}
