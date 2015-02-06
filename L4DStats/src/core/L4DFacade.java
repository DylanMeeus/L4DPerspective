package core;

import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

import perspectives.Perspective;
import perspectives.PerspectiveFacade;
import providers.ProfileProvider;
import providers.StatProvider;

public class L4DFacade
{

	ProfileProvider profileProvider;
	StatProvider statProvider;
	String steamID;
	public L4DFacade()
	{
		profileProvider = new ProfileProvider();
		statProvider = new StatProvider();
	}
	
	public void setSteamID(String steamID)
	{
		this.steamID = steamID;
	}

	public Profile getProfile()
	{
		return profileProvider.getProfile(steamID);
	}

	public ArrayList<Stat> getGlobalStats()
	{
		return statProvider.getGlobalStats(steamID);
	}
	
	public ArrayList<Perspective> generateGeneralPerspectives()
	{
		ArrayList<Perspective> perspectives = new ArrayList<Perspective>();
		PerspectiveFacade perspectiveFacade = new PerspectiveFacade();
		for (Stat stat : statProvider.getGlobalStats(steamID))
		{
			System.out.println("in loop: " + stat.getName());
			// I'll run this on a tomcat 8 server so I can switch on string! :)
			switch (stat.getName())
			{
			case "Gametime":
				perspectives.add(new Perspective("Game time", "You played " + (int) stat.getValue() + " hours", (int) stat.getValue()));
				System.out.println("Gametime");
				break;
			case "Stat.InfectedKilled.Total":
				perspectives.add(new Perspective("Total infected kills", perspectiveFacade.getZombieFact(stat.getValue()), (int) stat.getValue()));
				break;
			case "Stat.AdrenalineUsed.Total": 
				perspectives.add(new Perspective("Adrenaline uses",perspectiveFacade.getAdrenalineFacts(stat.getValue()),(int) stat.getValue()));
				break;
			case "Stat.DefibrillatorsUsed.Total": 
				perspectives.add(new Perspective("Defib uses", perspectiveFacade.getDefibrillatorFact(stat.getValue()),(int) stat.getValue()));
				break;
				// weapons now!
			}
		}

		return perspectives;
	}
	
	public ArrayList<Perspective> generateWeaponPerspectives()
	{
		ArrayList<Perspective> perspectives = new ArrayList<Perspective>();
		PerspectiveFacade perspectiveFacade = new PerspectiveFacade();
		// and now we filter the weapon stats.
		for(Stat stat : statProvider.getGlobalStats(steamID))
		{
			System.out.println("in loop: " + stat.getName());
			// I'll run this on a tomcat 8 server so I can switch on string! :)
			switch (stat.getName())
			{
			case "Stat.pistol.Shots.Total":
				perspectives.add(new Perspective("Pistol bullets shot", perspectiveFacade.getWeaponFact(Weapon.Akimbo, stat.getValue()), stat.getValue()));
				System.out.println("Gametime");
				break;
			case "Stat.smg.Shots.Total":
			perspectives.add(new Perspective("SMG bullets shot", perspectiveFacade.getWeaponFact(Weapon.SMG, stat.getValue()),stat.getValue()));
			break;
			case "Stat.pumpshotgun.Shots.Total":
				perspectives.add(new Perspective("pump shotgun shells shot", perspectiveFacade.getWeaponFact(Weapon.T1Shotgun, stat.getValue()),stat.getValue()));
				break;
				
			case "Stat.autoshotgun.Shots.Total":
				perspectives.add(new Perspective("autoshotgun shells shot", perspectiveFacade.getWeaponFact(Weapon.T1Shotgun, stat.getValue()),stat.getValue()));
				break;
			}
		}
		return perspectives;
	}
}
