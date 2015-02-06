package core;

public enum Weapon
{
	Akimbo (0.009),
	Deagle (0.0127),
	M16(0.0556),
	AK(0.056),
	SCAR(0.05740),
	SMG(0.009), // assuming a parabellum of 9x19mm model 
	T1Sniper(0.056),
	T2Sniper(0.0699),
	T1Shotgun(0.0254), // Assuming 12-gauge
	Tactical(0.0254), // Assuming 12-gauge
	Combat(0.0254);
	
	// IDEA TO ALSO HAVE COST?
	
	/**
	 * Bullet length in meters.
	 * @param bulletlength
	 */
	
	private double bulletLength;
	private Weapon(double bulletlength)
	{
		bulletLength = bulletlength;
	}
	
	public double getLength()
	{
		return bulletLength;
	}
}


