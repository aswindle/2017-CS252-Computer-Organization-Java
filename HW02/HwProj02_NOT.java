/* HwProj02_NOT.java
 * Alex Swindle
 * aswindle
 * CSC 252 Project HW02
 * Models a NOT gate using input and output wires
 */

public class HwProj02_NOT
{
	public void execute()
	{
		out.set(!in.get());
	}


	// inputs
	public RussWire in;
	// outputs
	public RussWire out;


	public HwProj02_NOT()
	{
		// the constructor for an object has to create all of the
		// RussWire objects to represent the inputs and outputs
		// of the object.
		in  = new RussWire();
		out = new RussWire();
	}
}

