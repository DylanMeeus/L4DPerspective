package perspectives;

import java.util.Random;

public class GeneralPerspective
{

	public GeneralPerspective()
	{
		
	}
	
	public double zombieKillsStack(double kills)
	{
		// average height = 1.75;
		double zombieHeight = 1.75d;//meters
		return zombieHeight * kills;
	}
	
	public double zombieBloodLiters(double kills)
	{
		return (int) 5*kills; // source: http://en.wikipedia.org/wiki/Blood_volume
	}
	
	public String getHeightPerspective(double kills)
	{
		
		String heightPerspective = "";
		Random rand = new Random();
		int randomNumber = rand.nextInt(2);
		switch(randomNumber)
		{
		case 0: heightPerspective = "Stacked, they would reach " + (int) compareToMtEverest(kills) + " times the himalayas";
		break;
		case 1: heightPerspective =  "Stacked, they could fill the Mariana Trench " + (int)compareToMarianaTrench(kills) + " times. (Deepest place on earth)";
		break;
		}
		return heightPerspective;
	}
	
	public String getNearestPOI(double kills) // Point of interest.
	{
		double distanceInM = zombieKillsStack(kills);
		
		return "";
	}
	
	public double compareToMarianaTrench(double kills)
	{
		return zombieKillsStack(kills) / 10994;
	}
	
	public double compareToMtEverest(double kills)
	{
		return (int) zombieKillsStack(kills) / 8840;
	}
	
	public double getAdrenalineVolume(double adrenUses)
	{
		double totalMl = adrenUses * 0.3;
		return totalMl;
	}
	
	public double getTotalJouleGenerated(double defibUses)
	{
		return (int) 300*defibUses;
	}
	
}
