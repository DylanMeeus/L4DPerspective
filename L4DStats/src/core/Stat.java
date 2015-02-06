package core;

public class Stat
{
	private String name;
	private int value;

	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getValue()
	{
		return value;
	}
	public void setValue(String value)
	{
		double originalDouble = Double.parseDouble(value);
		this.value = (int) originalDouble;
	}
}
