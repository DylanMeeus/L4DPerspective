package perspectives;

import java.util.HashMap;

import core.Weapon;

public class WeaponPerspective
{
	// string formatting should be done in some kind of perspective facade.
	public WeaponPerspective()
	{
		
	}
	
	public double getDistance(Weapon weapon, int shots)
	{
		// So we have to do weapon
		double bLength = weapon.getLength();
		return bLength * shots;
 	}
	
	
	public String compareToStructure(Weapon weapon, int shots)
	{
		double distance = getDistance(weapon, shots);
		String structure = "Stacked, they would reach "+ distance + "m which is about as high as ";
		
		if (distance > 2736)
		{
			structure = "Layed out, they would cover " + distance + ", covering the entire Golde Gate Bridge (2737m) " + distance / shots + " times";
		}
		else if(distance > 1000)
		{
			structure = "Stacked, they reach " + distance + "m, you could make two towers each reaching about as high as the World Trade Center";
		}
		else if(distance > 800)
		{
			structure += "Burj Khalifa (Dubai, 828m)";
		}
		else if(distance > 600)
		{
			structure += "Shanghai tower (China, 632m)";
		}
		else if(distance > 500 && distance < 550)
		{
			structure += "the World Trade Center (526m-541m)";
		}
		else if(distance > 200 && distance < 250)
		{
			structure = "Layed out, they would cover " + distance + ", covering Tower Bridge " + distance/shots + " times";
		}
		else if(distance > 100 && distance < 150)
		{
			structure += "the London Eye (Ferris Wheel, 135m)";
		}
		return structure;
	}
	
	public double getCostInDollar(Weapon weapon, int shots)
	{
		// PRICES FROM MIDWAYUSA.COM
		double cost = 0;
		
		if(weapon.equals(Weapon.T1Shotgun))
		{
			System.out.println("shotgun shells, 12 gauge");
			double packs = shots / 25;// (25 a pack)
			cost =  packs * 8.99;
		}
		else if(weapon.equals(Weapon.Akimbo) || weapon.equals(Weapon.SMG))
		{
			// packs of 50
			double packs = shots / 50;
			cost = packs * 12.79;
		}
		else if(weapon.equals(Weapon.Deagle))
		{
			double packs = shots / 20;
			cost = packs * 20.99;
		}
		else if(weapon.equals(Weapon.M16) || weapon.equals(Weapon.AK)|| weapon.equals(Weapon.T1Sniper))
		{
			// price from SGammo
			double packs = shots / 100;
			cost = packs * 29.95;
		}
		
		return cost;
		
	}
	
}
