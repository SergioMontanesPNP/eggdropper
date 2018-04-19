package pnp.kata.eggdropper;

import pnp.kata.eggdropper.exceptions.CriticalFloorIsToLowException;
import pnp.kata.eggdropper.exceptions.IncorrectNumberOfEggsException;
import pnp.kata.eggdropper.exceptions.IncorrectNumberOfFloorsException;

public class EggDropperUtils {

	public static int calculateAverage(int minFloor, int maxFloor) {
		return (minFloor + maxFloor) / 2;
	}

	public static boolean dropAnEggAndItBreaks(int dropFloor, int criticalFloor) {
		if(dropFloor > criticalFloor)
			return true;
		return false;
	}

	public static int calculateNextDropFloor(int minFloor, int maxFloor, boolean weMustApplyLinearAlgorithm) {
		int nextDropFloor;
		if(weMustApplyLinearAlgorithm) {
			nextDropFloor = minFloor;
		} else {
			nextDropFloor = EggDropperUtils.calculateAverage(minFloor, maxFloor);
		}
		return nextDropFloor;
	}

	public static void exceptionControl(int criticalFloor, int survivingEggs, int maxFloor)
			throws CriticalFloorIsToLowException, IncorrectNumberOfEggsException, IncorrectNumberOfFloorsException {
		if(criticalFloor < 1)
			throw new CriticalFloorIsToLowException();
		if(survivingEggs < 2)
			throw new IncorrectNumberOfEggsException();
		if(maxFloor < 1)
			throw new IncorrectNumberOfFloorsException();
	}
}
