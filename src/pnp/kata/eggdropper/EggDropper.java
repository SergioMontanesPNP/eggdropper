package pnp.kata.eggdropper;

import pnp.kata.eggdropper.exceptions.CriticalFloorIsToLowException;

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
	 */
	public int minEggDropper100(int criticalFloor) throws CriticalFloorIsToLowException {
		if(criticalFloor < 1) {
			throw new CriticalFloorIsToLowException();
		}
		
		// int survivingEggs = 100; // Innecesario
		
		int minFloor = 1;
		int maxFloor = 100;
		int minDrops100 = 0;
		int nextDropFloor;
		
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
		
		while(maxFloor >= minFloor) {
			nextDropFloor = EggDropperUtils.calculateAverage(minFloor, maxFloor);
			minDrops100++;
			if(EggDropperUtils.dropAnEggAndItBreaks(nextDropFloor, criticalFloor)) {
				// survivingEggs--; // Innecesario
				maxFloor = nextDropFloor - 1;
			} else {
				searchingCriticalFloor = nextDropFloor;
				minFloor = nextDropFloor + 1;
			}
		}
		
		return minDrops100;
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
	 * 
	 */
	public int minEggDropper2(int criticalFloor) throws CriticalFloorIsToLowException {
		if(criticalFloor < 1) {
			throw new CriticalFloorIsToLowException();
		}

		// int survivingEggs = 2; // Innecesario
		
		int minFloor = 1;
		int maxFloor = 100;
		int minDrops2 = 0;
		int nextDropFloor;
		
		while(maxFloor >= minFloor) {
			nextDropFloor = minFloor;
			if(EggDropperUtils.dropAnEggAndItBreaks(nextDropFloor, criticalFloor)) {
				// survivingEggs--; // Innecesario
				break;
			} else {
				minFloor++;
			}
			minDrops2++;
		}
		
		return minDrops2;
	}
}
