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
				perspectives.add(new Perspective("Adrenaline uses", perspectiveFacade.getAdrenalineFacts(stat.getValue()), (int) stat.getValue()));
				break;
			case "Stat.DefibrillatorsUsed.Total":
				perspectives.add(new Perspective("Defib uses", perspectiveFacade.getDefibrillatorFact(stat.getValue()), (int) stat.getValue()));
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
		for (Stat stat : statProvider.getGlobalStats(steamID))
		{
			System.out.println("in loop: " + stat.getName());
			// I'll run this on a tomcat 8 server so I can switch on string! :)
			switch (stat.getName())
			{
			case "Stat.pistol.Shots.Total":
				perspectives.add(new Perspective("Pistol bullets", perspectiveFacade.getWeaponFact(Weapon.Akimbo, stat.getValue()), stat.getValue()));
				System.out.println("Gametime");
				break;
			case "Stat.smg.Shots.Total":
				perspectives.add(new Perspective("SMG bullets", perspectiveFacade.getWeaponFact(Weapon.SMG, stat.getValue()), stat.getValue()));
				break;
			case "Stat.pumpshotgun.Shots.Total":
				perspectives.add(new Perspective("pump shotgun shells", perspectiveFacade.getWeaponFact(Weapon.T1Shotgun, stat.getValue()), stat.getValue()));
				break;

			case "Stat.autoshotgun.Shots.Total":
				perspectives.add(new Perspective("autoshotgun shells", perspectiveFacade.getWeaponFact(Weapon.T1Shotgun, stat.getValue()), stat.getValue()));
				break;

			case "Stat.rifle.Shots.Total":
				perspectives.add(new Perspective("M16", perspectiveFacade.getWeaponFact(Weapon.M16, stat.getValue()), stat.getValue()));
				break;

			case "Stat.hunting_fiel.Shots.Total":
				perspectives.add(new Perspective("Hunting rifle", perspectiveFacade.getWeaponFact(Weapon.T1Sniper, stat.getValue()),stat.getValue()));
				break;
				
			case "Stat.machinegun.Shots.Total":
				perspectives.add(new Perspective("(Mounted) Machine gun", perspectiveFacade.getWeaponFact(Weapon.AK, stat.getValue()),stat.getValue())); // TODO: Not AK obviously!
				break;
				
			case "Stat.rifle_ak47.Shots.Total":
				perspectives.add(new Perspective("AK-47", perspectiveFacade.getWeaponFact(Weapon.AK, stat.getValue()),stat.getValue()));
				break;
				
			case "Stat.sniper_military.Shots.Total":
				perspectives.add(new Perspective("Military sniper-rifle", perspectiveFacade.getWeaponFact(Weapon.T2Sniper, stat.getValue()),stat.getValue()));
				break;
				
			case "Stat.rifle_desert.Shots.Total":
				perspectives.add(new Perspective("SCAR-H", perspectiveFacade.getWeaponFact(Weapon.SCAR, stat.getValue()),stat.getValue()));
				break;
				
			case "Stat.pistol_magnum.Shots.Total":
				perspectives.add(new Perspective("Deagle (Magnum)", perspectiveFacade.getWeaponFact(Weapon.Deagle, stat.getValue()),stat.getValue()));
				break;
			}
		}
		return perspectives;
	}
}
