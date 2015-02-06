package perspectives;

public class Perspective
{
	private String text;
	private String name;
	private double value;

	public Perspective()
	{
		
	}
	
	public Perspective(String name, String text, double value)
	{
		this.name = name;
		this.text = text;
		this.value = value;
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

	public double getValue()
	{
		return value;
	}
	
	public void setValue(double value)
	{
		this.value = value;
	}
}
