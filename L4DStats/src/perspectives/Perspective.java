package perspectives;

public class Perspective
{
	private String text;
	private String name;
	
	public Perspective()
	{
		
	}
	
	public Perspective(String name, String text)
	{
		this.name = name;
		this.text = text;
	}
	
	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
