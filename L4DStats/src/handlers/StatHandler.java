package handlers;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import core.Profile;
import core.Stat;

/**
 * 
 * @author Dylan
 *
 */
public class StatHandler extends DefaultHandler
{
	private StringBuffer buffer = new StringBuffer();
	private Stat stat;
	private ArrayList<Stat> generalStats = new ArrayList<Stat>();
	private ArrayList<Stat> weaponStats = new ArrayList<Stat>();
	private boolean inStats = false;

	@Override
	public void startElement(String namespaceURI, String localName,
			String qName, Attributes atts) throws SAXException
	{
		System.out.println("start element: " + localName);
		buffer.setLength(0);
		if (localName.equals("stat"))
		{
			inStats = true;
			stat = new Stat();
		}

	}

	@Override
	public void characters(char[] ch, int start, int length)
	{
		// Fill the buffer!
		buffer.append(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException
	{
		if (inStats)
		{
			if (localName.equals("name"))
			{
				stat.setName(buffer.toString());
				// System.out.println("name: " + buffer.toString());
			}

			if (localName.equals("value"))
			{
				stat.setValue(buffer.toString());
				// System.out.println("buffer: " + buffer.toString());
			}
			if (localName.equals("stat"))
			{
				// Now to determine which arrayList it goes in?
				addStatToList(stat);
			}
		}

	}

	private void addStatToList(Stat stat)
	{
		// Don't switch over all stats, only the global ones. All the "weapons"
		// are default! (less switching!)
		switch (stat.getName())
		{
		default:
			//weaponStats.add(stat);
			generalStats.add(stat);
			break;
		case "Stat.InfectedKilled.Total":
			generalStats.add(stat);
			break;
		case "Stat.AdrenalineUsed.Total":
			generalStats.add(stat);
			break;
		case "Stat.DefibrillatorsUsed.Total":
			generalStats.add(stat);
			break;
		}
	}

	public ArrayList<Stat> getGeneralStats()
	{
		return generalStats;
	}
	
	public ArrayList<Stat> getWeaponFacts()
	{
		return weaponStats;
	}

}
