package providers;

import handlers.ProfileHandler;

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
			String url = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=C9D49868B7FE152D5C0A052CB0B6A7D8&steamid="
					+ steamID + "&format=xml";
			GameHandler handler = new GameHandler();
			globalStats = new ArrayList<Stat>();
			try
			{
				XMLReader xmlReader = XMLReaderFactory.createXMLReader();
				xmlReader.setContentHandler(handler);
				xmlReader.parse(new InputSource(new URL(url).openStream()));
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
			globalStats.add(handler.getGameStat());
			hasData = true;
		}
		return globalStats;
	}

}
