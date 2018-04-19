package pnp.kata.eggdropper;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import pnp.kata.eggdropper.exceptions.CriticalFloorIsToLowException;
import pnp.kata.eggdropper.exceptions.IncorrectNumberOfEggsException;
import pnp.kata.eggdropper.exceptions.IncorrectNumberOfFloorsException;

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

	private final static int CRITICAL_FLOOR_BY_DEFAULT = 50;
	private final static int NUMBER_OF_EGGS_BY_DEFAULT = 100;
	private final static int NUMBER_OF_FLOORS_BY_DEFAULT = 100;
	
	private static EggDropper eggDropper;
	private int criticalFloor;
	private int numberOfEggs;
	private int numberOfFloors;
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
	public void test09_MinEggDropper100_criticalFloorIsAboveTheLastFloor() throws CriticalFloorIsToLowException {
		criticalFloor = 101;
		expectedResult = 7;
		assertEquals(expectedResult, eggDropper.minEggDropper100(criticalFloor));
	}
	
	@Test(expected=CriticalFloorIsToLowException.class)
	public void test10_minEggDropper2_criticalFloorNegative_throwCriticalFloorIsToLowException() throws CriticalFloorIsToLowException {
		criticalFloor = -1;
		eggDropper.minEggDropper2(criticalFloor);
	}
	
	@Test(expected=CriticalFloorIsToLowException.class)
	public void test11_minEggDropper2_criticalFloor0_throwCriticalFloorIsToLowException() throws CriticalFloorIsToLowException {
		criticalFloor = 0;
		eggDropper.minEggDropper2(criticalFloor);
	}
	
	@Test
	public void test12_minEggDropper2_criticalFloorIsFirstFloor() throws CriticalFloorIsToLowException {
		criticalFloor = 1;
		expectedResult = 1;
		assertEquals(expectedResult, eggDropper.minEggDropper2(criticalFloor));
	}
	
	@Test
	public void test13_minEggDropper2_criticalFloorIsCentralFloor() throws CriticalFloorIsToLowException {
		criticalFloor = 50;
		expectedResult = 50;
		assertEquals(expectedResult, eggDropper.minEggDropper2(criticalFloor));
	}
	
	@Test
	public void test14_minEggDropper2_criticalFloorIsCentralFloor() throws CriticalFloorIsToLowException {
		criticalFloor = 50;
		expectedResult = 50;
		assertEquals(expectedResult, eggDropper.minEggDropper2(criticalFloor));
	}
	
	@Test
	public void test15_minEggDropper2_criticalFloorIsLastFloor() throws CriticalFloorIsToLowException {
		criticalFloor = 100;
		expectedResult = 100;
		assertEquals(expectedResult, eggDropper.minEggDropper2(criticalFloor));
	}
	
	@Test
	public void test16_minEggDropper2_criticalFloorIsAboveTheLastFloor() throws CriticalFloorIsToLowException {
		criticalFloor = 101;
		expectedResult = 100;
		assertEquals(expectedResult, eggDropper.minEggDropper2(criticalFloor));
	}
	
	@Test(expected=CriticalFloorIsToLowException.class)
	public void test17_minEggDropperX_criticalFloorNegative_throwCriticalFloorIsToLowException()
			throws CriticalFloorIsToLowException, IncorrectNumberOfEggsException, IncorrectNumberOfFloorsException {
		criticalFloor = -1;
		numberOfEggs = NUMBER_OF_EGGS_BY_DEFAULT;
		numberOfFloors = NUMBER_OF_FLOORS_BY_DEFAULT;
		eggDropper.minEggDropperX(criticalFloor, numberOfEggs, numberOfFloors);
	}
	
	@Test(expected=CriticalFloorIsToLowException.class)
	public void test18_minEggDropperX_criticalFloor0_throwCriticalFloorIsToLowException()
			throws CriticalFloorIsToLowException, IncorrectNumberOfEggsException, IncorrectNumberOfFloorsException {
		criticalFloor = 0;
		numberOfEggs = NUMBER_OF_EGGS_BY_DEFAULT;
		numberOfFloors = NUMBER_OF_FLOORS_BY_DEFAULT;
		eggDropper.minEggDropperX(criticalFloor, numberOfEggs, numberOfFloors);
	}
	
	@Test(expected=IncorrectNumberOfEggsException.class)
	public void test19_minEggDropperX_negativeEggs_throwIncorrectNumberOfEggsException()
			throws CriticalFloorIsToLowException, IncorrectNumberOfEggsException, IncorrectNumberOfFloorsException {
		criticalFloor = CRITICAL_FLOOR_BY_DEFAULT;
		numberOfEggs = -1;
		numberOfFloors = NUMBER_OF_FLOORS_BY_DEFAULT;
		eggDropper.minEggDropperX(criticalFloor, numberOfEggs, numberOfFloors);
	}
	
	@Test(expected=IncorrectNumberOfEggsException.class)
	public void test20_minEggDropperX_withoutEggs_throwIncorrectNumberOfEggsException()
			throws CriticalFloorIsToLowException, IncorrectNumberOfEggsException, IncorrectNumberOfFloorsException {
		criticalFloor = CRITICAL_FLOOR_BY_DEFAULT;
		numberOfEggs = 0;
		numberOfFloors = NUMBER_OF_FLOORS_BY_DEFAULT;
		eggDropper.minEggDropperX(criticalFloor, numberOfEggs, numberOfFloors);
	}
	
	@Test(expected=IncorrectNumberOfEggsException.class)
	public void test21_minEggDropperX_onlyOneEgg_throwIncorrectNumberOfEggsException()
			throws CriticalFloorIsToLowException, IncorrectNumberOfEggsException, IncorrectNumberOfFloorsException {
		criticalFloor = CRITICAL_FLOOR_BY_DEFAULT;
		numberOfEggs = 1;
		numberOfFloors = NUMBER_OF_FLOORS_BY_DEFAULT;
		eggDropper.minEggDropperX(criticalFloor, numberOfEggs, numberOfFloors);
	}
	
	@Test(expected=IncorrectNumberOfFloorsException.class)
	public void test22_minEggDropperX_negativeFloors_throwIncorrectNumberOfFloorsException()
			throws CriticalFloorIsToLowException, IncorrectNumberOfEggsException, IncorrectNumberOfFloorsException {
		criticalFloor = CRITICAL_FLOOR_BY_DEFAULT;
		numberOfEggs = NUMBER_OF_EGGS_BY_DEFAULT;
		numberOfFloors = -1;
		eggDropper.minEggDropperX(criticalFloor, numberOfEggs, numberOfFloors);
	}
	
	@Test(expected=IncorrectNumberOfFloorsException.class)
	public void test23_minEggDropperX_zeroFloors_throwIncorrectNumberOfFloorsException()
			throws CriticalFloorIsToLowException, IncorrectNumberOfEggsException, IncorrectNumberOfFloorsException {
		criticalFloor = CRITICAL_FLOOR_BY_DEFAULT;
		numberOfEggs = NUMBER_OF_EGGS_BY_DEFAULT;
		numberOfFloors = 0;
		eggDropper.minEggDropperX(criticalFloor, numberOfEggs, numberOfFloors);
	}
	
	@Test
	public void test24_minEggDropperX_criticalFloorIsLastFloor()
			throws CriticalFloorIsToLowException, IncorrectNumberOfEggsException, IncorrectNumberOfFloorsException {
		criticalFloor = 20;
		numberOfEggs = NUMBER_OF_EGGS_BY_DEFAULT;
		numberOfFloors = 20;
		expectedResult = 5;
		assertEquals(expectedResult, eggDropper.minEggDropperX(criticalFloor, numberOfEggs, numberOfFloors));
	}
	
	@Test
	public void test25_minEggDropperX_onlyBinaryAlgorithm()
			throws CriticalFloorIsToLowException, IncorrectNumberOfEggsException, IncorrectNumberOfFloorsException {
		criticalFloor = 67;
		numberOfEggs = 300;
		numberOfFloors = NUMBER_OF_FLOORS_BY_DEFAULT;
		expectedResult = 7;
		assertEquals(expectedResult, eggDropper.minEggDropperX(criticalFloor, numberOfEggs, numberOfFloors));
	}
	
	@Test
	public void test26_minEggDropperX_onlyLinealAlgorithm()
			throws CriticalFloorIsToLowException, IncorrectNumberOfEggsException, IncorrectNumberOfFloorsException {
		criticalFloor = 1;
		numberOfEggs = 2;
		numberOfFloors = NUMBER_OF_FLOORS_BY_DEFAULT;
		expectedResult = 1;
		assertEquals(expectedResult, eggDropper.minEggDropperX(criticalFloor, numberOfEggs, numberOfFloors));
	}
	
	@Test
	public void test27_minEggDropperX_complex()
			throws CriticalFloorIsToLowException, IncorrectNumberOfEggsException, IncorrectNumberOfFloorsException {
		// Este test genera una ejecución del método que mezcla el algoritmo binario y el lineal. 
		criticalFloor = 55;
		numberOfEggs = 3;
		numberOfFloors = NUMBER_OF_FLOORS_BY_DEFAULT;
		expectedResult = 7;
		assertEquals(expectedResult, eggDropper.minEggDropperX(criticalFloor, numberOfEggs, numberOfFloors));
	}
	
	@Test
	public void test28_minEggDropperX_criticalFloorIsAboveTheLastFloor()
			throws CriticalFloorIsToLowException, IncorrectNumberOfEggsException, IncorrectNumberOfFloorsException {
		// Este test genera una ejecución del método que mezcla el algoritmo binario y el lineal. 
		criticalFloor = 101;
		numberOfEggs = NUMBER_OF_EGGS_BY_DEFAULT;
		numberOfFloors = NUMBER_OF_FLOORS_BY_DEFAULT;
		expectedResult = 7;
		assertEquals(expectedResult, eggDropper.minEggDropperX(criticalFloor, numberOfEggs, numberOfFloors));
	}

}
