package core;

public class Stat
{
	private String name;
	private double value;

	
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
	public void setValue(String value)
	{
		this.value = Double.parseDouble(value);
	}
}
