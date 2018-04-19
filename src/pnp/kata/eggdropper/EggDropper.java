package pnp.kata.eggdropper;

import pnp.kata.eggdropper.exceptions.CriticalFloorIsToLowException;
import pnp.kata.eggdropper.exceptions.IncorrectNumberOfEggsException;
import pnp.kata.eggdropper.exceptions.IncorrectNumberOfFloorsException;

public class EggDropper {

	/**
	 * BASIC
	 * 
	 * En esta versión, la manera más eficiente de encontrar la
	 * respuesta es realizar una búsqueda binaria, con coste O(log(n)).
	 * 
	 * Puesto que disponemos de 100 huevos, el algoritmo nunca los romperá
	 * todos, por lo que es innecesario llevar la cuenta de los
	 * que todavía siguen "vivos".
	 * @throws IncorrectNumberOfFloorsException 
	 * @throws IncorrectNumberOfEggsException 
	 */
	public int minEggDropper100(int criticalFloor)
			throws CriticalFloorIsToLowException, IncorrectNumberOfEggsException, IncorrectNumberOfFloorsException {

		int survivingEggs = 100;
		int maxFloor = 100;
		
		return minEggDropperX(criticalFloor, survivingEggs, maxFloor);
	}
	
	/**
	 * INTERMEDIATE
	 * 
	 * En esta versión, puesto que al menos debe quedar un huevo intacto,
	 * la única forma de encontrar el criticalFloor sin romperlos todos,
	 * es hacer una búsqueda lineal. Empezar desde el primer piso e ir
	 * subiendo hasta que se rompa el primer huevo. Cuando esto suceda,
	 * sabremos que el criticalFloor es el piso inmediatamente inferior.
	 * 
	 * De nuevo, no necesitamos almacenar ninguna variable que contenga
	 * el número de huevos "vivos"
	 * El coste de esta versión será O(n).
	 * @throws IncorrectNumberOfFloorsException 
	 * @throws IncorrectNumberOfEggsException 
	 * 
	 */
	public int minEggDropper2(int criticalFloor)
			throws CriticalFloorIsToLowException, IncorrectNumberOfEggsException, IncorrectNumberOfFloorsException {

		int survivingEggs = 2;
		int maxFloor = 100;
		
		return minEggDropperX(criticalFloor, survivingEggs, maxFloor);
	}

	/**
	 * HARD
	 * 
	 * En esta versión debemos hacer una mezcla de las dos anteriores.
	 * Mientras tengamos más de dos huevos "vivos", utilizaremos el
	 * algoritmo de la búsqueda binaria. Si en algún momento quedan
	 * únicamente dos huevos, realizaremos una búsqueda lineal entre
	 * el rango de pisos que todavía no se haya descartado.
	 */
	public int minEggDropperX(int criticalFloor, int x, int y)
			throws CriticalFloorIsToLowException, IncorrectNumberOfEggsException, IncorrectNumberOfFloorsException {
		final int numberOfEggsToApplyLinearAlgorithm = 2;
		int minDrops = 0;
		int nextDropFloor;
		
		int survivingEggs = x;
		int minFloor = 1;
		int maxFloor = y;

		EggDropperUtils.exceptionControl(criticalFloor, survivingEggs, maxFloor);
		
		/* 
	     * La variable 'searchingCriticalFloor' terminará conteniendo el valor del criticalFloor, 
	     * correctamente calculado. 
	     *  
	     * Aunque el enunciado hace un recordatorio de que el desafio no es encontrar este número, 
	     * creo que al menos es interesante tener una variable que termine conteniéndolo 
	     * (aun a pesar de que la variable no tenga uso en el método). 
	     */ 
		@SuppressWarnings("unused")
		int searchingCriticalFloor = EggDropperUtils.calculateAverage(minFloor, maxFloor);
		
		boolean weMustApplyLinearAlgorithm;
		while(maxFloor >= minFloor) {
			weMustApplyLinearAlgorithm = survivingEggs == numberOfEggsToApplyLinearAlgorithm;
			
			nextDropFloor = EggDropperUtils.calculateNextDropFloor(minFloor, maxFloor, weMustApplyLinearAlgorithm);
			
			if(EggDropperUtils.dropAnEggAndItBreaks(nextDropFloor, criticalFloor)) {
				survivingEggs--;
				if(weMustApplyLinearAlgorithm) {
					break;
				} else {
					maxFloor = nextDropFloor - 1;					
				}
			} else {
				if(weMustApplyLinearAlgorithm) {
					searchingCriticalFloor = minFloor;
					minFloor++;					
				} else {
					searchingCriticalFloor = nextDropFloor;
					minFloor = nextDropFloor + 1;
				}
			}
			
			minDrops++;
		}

		return minDrops;
	}
}
