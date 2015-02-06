package providers;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import core.Stat;

public class GameHandler extends DefaultHandler
{

	private Stat gameStat = new Stat();
	private StringBuffer buffer = new StringBuffer();
	boolean isL4D = false;

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException
	{
		buffer.setLength(0);
		if (localName.equals("message"))
		{

		}

	}

	@Override
	public void characters(char[] ch, int start, int length)
	{
		// Fill the buffer!
		buffer.append(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException
	{

		if (localName.equals("appid"))
		{
			if (buffer.toString().equals("550"))
			{
				System.out.println("Is in 550");
				isL4D = true;
			}
		}
		if (localName.equals("playtime_forever"))
		{
			if (isL4D)
			{
				String time = buffer.toString();
				System.out.println(time);
				gameStat.setName("Gametime");
				double dtime = Double.parseDouble(time);
				String stime = Double.toString(dtime/60);
				gameStat.setValue(stime);
				isL4D = false;
			}
		}

	}

	public Stat getGameStat()
	{
		return gameStat;
	}
}
