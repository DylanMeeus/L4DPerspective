package handlers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import core.Profile;

public class ProfileHandler extends DefaultHandler
{
	private StringBuffer buffer = new StringBuffer();
	Profile user = new Profile();
	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException
	{
		buffer.setLength(0);
		if (localName.equals("appid"))
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
		if(localName.equals("personaname"))
		{
			user.setNickname(buffer.toString());
		}
		if(localName.equals("profileurl"))
		{
			user.setProfileURL(buffer.toString());
		}
		if(localName.equals("avatarmedium"))
		{
			user.setAvatarmediumURL(buffer.toString());
		}
		if(localName.equals("avatarfull"))
		{
			user.setAvatarfullURL(buffer.toString());
		}
	}

	public Profile getProfile()
	{
		return user;
	}
}
