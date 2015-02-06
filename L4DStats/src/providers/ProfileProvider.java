package providers;

import handlers.ProfileHandler;

import java.net.URL;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import core.Profile;



/**
 * Provides the profile data
 * @author Dylan
 *
 */
public class ProfileProvider
{
	public Profile getProfile(String steamID)
	{
		String url = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=C9D49868B7FE152D5C0A052CB0B6A7D8&steamids="
				+ steamID + "&format=xml";
		ProfileHandler handler = new ProfileHandler();
		try
		{
			XMLReader xmlReader = XMLReaderFactory.createXMLReader();
			xmlReader.setContentHandler(handler);
			xmlReader.parse(new InputSource(new URL(url).openStream()));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return handler.getProfile();
	}

}
