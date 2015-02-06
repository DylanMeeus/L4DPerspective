package perspectives;

import java.util.HashMap;

import core.Weapon;

public class WeaponPerspective
{
	// string formatting should be done in some kind of perspective facade.
	public WeaponPerspective()
	{
		
	}
	
	public double getDistance(Weapon weapon)
	{
		// So we have to do weapon
		double bLength = weapon.getLength();
		
		return bLength;
	}
	
	public double getHeight(Weapon weapon)
	{
		return getDistance(weapon);
	}
	
}
