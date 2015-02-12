package perspectives;

import java.util.Random;

import core.Weapon;

/**
 * This class will return strings with generated perspectives. Return them
 * randomly or some stuff, not sure yet.
 * 
 * @author Dylan
 *
 */
public class PerspectiveFacade
{
	GeneralPerspective general = new GeneralPerspective();
	WeaponPerspective wp = new WeaponPerspective();

	public PerspectiveFacade()
	{

	}

	public String getAdrenalineFacts(double uses)
	{
		return "You have used " + general.getAdrenalineVolume(uses) + " mL of adrenaline (epinephrine).";
	}

	public String getDefibrillatorFact(double uses)
	{
		return "You have generated " + general.getTotalJouleGenerated(uses) + " Joule";
	}

	public String getZombieFact(double kills)
	{
		// we should randomize this.
		// random selection but for now let's leave it as is.

		// we randomize this stuff!

		String randomFact = "";
		Random rand = new Random();
		int randomnumber = rand.nextInt(3); // 0 - 1

		switch (randomnumber)
		{
		default: // in case I fuck up the random numbers at some point.
			break;
		case 0:
			randomFact = "Stacked, they would reach " + general.zombieKillsStack(kills) + " meters";
			break;
		case 1:
			randomFact = "If they bled out, combined they lost " + general.zombieBloodLiters(kills) + " liters of blood";
			break;
		case 2:
			randomFact = general.getHeightPerspective(kills);
			break;
		}

		return randomFact;
	}

	public String getWeaponFact(Weapon weapon, int shots)
	{
		String randomFact = "";
		Random rand = new Random();
		int randomNumber = rand.nextInt(3);
		switch (randomNumber)
		{
		case 0:
			randomFact = "Stacked, they would reach " + wp.getDistance(weapon, shots) + " meters";
			break;
		case 1:
			randomFact = wp.compareToStructure(weapon, shots);
			break;
		case 2:
			randomFact = "Buying all these bullets would have cost ~" + wp.getCostInDollar(weapon, shots) + "$";
			break;
		}

		return randomFact;
	}

}
