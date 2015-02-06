package providers;

import handlers.GameHandler;
import handlers.ProfileHandler;
import handlers.StatHandler;

import java.net.URL;
import java.util.ArrayList;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import core.Stat;

public class StatProvider
{

	private ArrayList<Stat> globalStats;
	private boolean hasData = false;

	/**
	 * Returning global stats
	 * 
	 * @return
	 */
	public ArrayList<Stat> getGlobalStats(String steamID)
	{
		if (hasData)
		{
			return globalStats;
		} else
		{
			// First fetch the time via getOwnedGames (more accurate it seems?)
			String url = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=C9D49868B7FE152D5C0A052CB0B6A7D8&steamid="
					+ steamID + "&format=xml";
			System.out.println(url);
			GameHandler gameHandler = new GameHandler();
			globalStats = new ArrayList<Stat>();
			try
			{
				XMLReader xmlReader = XMLReaderFactory.createXMLReader();
				xmlReader.setContentHandler(gameHandler);
				xmlReader.parse(new InputSource(new URL(url).openStream()));
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
			globalStats.add(gameHandler.getGameStat());	
			
			
			//http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?appid=550&key=C9D49868B7FE152D5C0A052CB0B6A7D8&steamid=76561197991055190&format=xml
			String staturl = "http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?appid=550&key=C9D49868B7FE152D5C0A052CB0B6A7D8&steamid="
					+ steamID + "&format=xml";
			System.out.println(staturl);
			StatHandler statHandler = new StatHandler();
			try
			{
				XMLReader xmlReader = XMLReaderFactory.createXMLReader();
				xmlReader.setContentHandler(statHandler);
				xmlReader.parse(new InputSource(new URL(staturl).openStream()));
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
			globalStats.addAll(statHandler.getGeneralStats());	
			
			//hasData = true;
		}
		
		// Also add the global stats (as in, zombies)
		return globalStats;
	}
	
	

}
