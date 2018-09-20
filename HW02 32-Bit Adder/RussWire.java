public class RussWire
{
	public void set(boolean val)
	{
		if (this.isSet)
			throw new IllegalArgumentException("A RussWire was set multiple times.");

		this.val   = val;
		this.isSet = true;
	}

	public boolean get()
	{
		if (this.isSet == false)
			throw new IllegalArgumentException("A RussWire was read before it had been set.");
		return this.val;
	}


	public RussWire()
	{
		this.isSet = false;
	}

	public String toString()
	{
		if (this.get())
			return "true";
		else
			return "false";
	}


	private boolean isSet;
	private boolean val;
}

