package pnp.kata.eggdropper;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import pnp.kata.eggdropper.exceptions.CriticalFloorIsToLowException;

/**
 * Esta clase contiene los métodos de test, encargados de verificar
 * que la implementación es correcta.
 * 
 * El nombre de los métodos pretende ser autodescriptivo, consta de las siguientes partes:
 *     - Número de test.
 *     - Nombre del método que se prueba.
 *     - Resumen del caso que pretende probar el test. Si es necesario se añadirá un
 *       comentario explicativo.
 *     - Retorno esperado (opcionalmente, en los casos en que puede no ser obvio).
 */
public class EggDropperTest {
	
	private static EggDropper eggDropper;
	private int criticalFloor;
	private int expectedResult;
	
	@BeforeClass
	public static void setUp() {
		eggDropper = new EggDropper();
	}

	@Test(expected=CriticalFloorIsToLowException.class)
	public void test01_MinEggDropper100_criticalFloorNegative_throwCriticalFloorIsToLowException() throws CriticalFloorIsToLowException {
		criticalFloor = -1;
		eggDropper.minEggDropper100(criticalFloor);
	}

	@Test(expected=CriticalFloorIsToLowException.class)
	public void test02_MinEggDropper100_criticalFloor0_throwCriticalFloorIsToLowException() throws CriticalFloorIsToLowException {
		criticalFloor = 0;
		eggDropper.minEggDropper100(criticalFloor);
	}
	
	@Test
	public void test03_MinEggDropper100_criticalFloorIsFirstFloor() throws CriticalFloorIsToLowException {
		criticalFloor = 1;
		expectedResult = 7;
		assertEquals(expectedResult, eggDropper.minEggDropper100(criticalFloor));
	}
	
	@Test
	public void test04_MinEggDropper100_criticalFloorIs2() throws CriticalFloorIsToLowException {
		criticalFloor = 1;
		expectedResult = 7;
		assertEquals(expectedResult, eggDropper.minEggDropper100(criticalFloor));
	}

	@Test
	public void test05_MinEggDropper100_criticalFloorIsCentralFloor() throws CriticalFloorIsToLowException {
		criticalFloor = 50;
		expectedResult = 6;
		assertEquals(expectedResult, eggDropper.minEggDropper100(criticalFloor));
	}

	@Test
	public void test06_MinEggDropper100_complex() throws CriticalFloorIsToLowException {
		// Encontrar un número como el 67 implica que la búsqueda binaria tendrá que
		// pivotar cada vez en una dirección, por lo que es un test interesante.
		criticalFloor = 67;
		expectedResult = 7;
		assertEquals(expectedResult, eggDropper.minEggDropper100(criticalFloor));
	}

	@Test
	public void test07_MinEggDropper100_criticalFloorIs99() throws CriticalFloorIsToLowException {
		criticalFloor = 99;
		expectedResult = 7;
		assertEquals(expectedResult, eggDropper.minEggDropper100(criticalFloor));
	}

	@Test
	public void test08_MinEggDropper100_criticalFloorIsLastFloor() throws CriticalFloorIsToLowException {
		criticalFloor = 100;
		expectedResult = 7;
		assertEquals(expectedResult, eggDropper.minEggDropper100(criticalFloor));
	}

	@Test
	public void test09_MinEggDropper100_criticalFloor() throws CriticalFloorIsToLowException {
		criticalFloor = 101;
		expectedResult = 7;
		assertEquals(expectedResult, eggDropper.minEggDropper100(criticalFloor));
	}

}
