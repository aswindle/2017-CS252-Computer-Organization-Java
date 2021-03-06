/* HwProj02_OR.java
 * Alex Swindle
 * aswindle
 * CSC 252 Project HW02
 * Models an OR gate using input and output wires
 */

public class HwProj02_OR
{
	public void execute()
	{
		out.set(a.get() || b.get());
	}


	// inputs
	public RussWire a;
	public RussWire b;
	// outputs
	public RussWire out;


	public HwProj02_OR()
	{
		// the constructor for an object has to create all of the
		// RussWire objects to represent the inputs and outputs
		// of the object.
		a  = new RussWire();
		b  = new RussWire();
		out = new RussWire();
	}
}

