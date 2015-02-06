package core;

/**
 * Java Bean
 * @author Dylan
 *
 */
public class Profile
{
	private String nickname;
	private String avatarmediumURL;
	private String avatarfullURL;
	private String profileURL;
	private String countryCode;

	public Profile()
	{
		
	}

	public String getProfileURL()
	{
		return profileURL;
	}

	public void setProfileURL(String profileURL)
	{
		this.profileURL = profileURL;
	}

	public String getCountryCode()
	{
		return countryCode;
	}

	public void setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
	}


	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public String getAvatarmediumURL()
	{
		return avatarmediumURL;
	}

	public void setAvatarmediumURL(String avatarmediumURL)
	{
		this.avatarmediumURL = avatarmediumURL;
	}

	public String getAvatarfullURL()
	{
		return avatarfullURL;
	}

	public void setAvatarfullURL(String avatarfullURL)
	{
		this.avatarfullURL = avatarfullURL;
	}
	
	
	
}
