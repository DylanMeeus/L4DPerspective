package core;

import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

import perspectives.Perspective;
import providers.ProfileProvider;
import providers.StatProvider;

public class L4DFacade
{

	ProfileProvider profileProvider;
	StatProvider statProvider;
	public L4DFacade()
	{
		profileProvider = new ProfileProvider();
		statProvider = new StatProvider();
	}
	public Profile getProfile(String steamID)
	{
		return profileProvider.getProfile(steamID);
	}
	
	public ArrayList<Stat> getGlobalStats(String steamID)
	{
		return statProvider.getGlobalStats(steamID);
	}
	
	public ArrayList<Perspective> generatePerspectives(String steamID)
	{
		ArrayList<Perspective> perspectives = new ArrayList<Perspective>();
		for(Stat stat : statProvider.getGlobalStats(steamID))
		{
			System.out.println("in loop: " + stat.getName());
			// I'll run this on a tomcat 8 server so I can switch on string! :)
			switch(stat.getName())
			{
			case "Gametime": perspectives.add(new Perspective("Game time","You played " + stat.getValue() + " hours"));
			break;
			}
		}
		
		return perspectives;
	}
}
