package pnp.kata.eggdropper;

public class EggDropperUtils {

	public static int calculateAverage(int minFloor, int maxFloor) {
		return (minFloor + maxFloor) / 2;
	}

	public static boolean dropAnEggAndItBreaks(int dropFloor, int criticalFloor) {
		if(dropFloor > criticalFloor)
			return true;
		return false;
	}
}
