/* HwProj02_XOR.java
 * Alex Swindle
 * aswindle
 * CSC 252 Project HW02
 * Models an XOR gate built out of AND, OR, and NOT gates
 */

public class HwProj02_XOR
{
	public void execute()
	{
		// and1 is a and notb
		not1.in.set(b.get());
		not1.execute();
		and1.a.set(a.get());
		and1.b.set(not1.out.get());
		and1.execute();
		
		// and2 is nota and b
		not2.in.set(a.get());
		not2.execute();
		and2.a.set(not2.out.get());
		and2.b.set(b.get());
		and2.execute();
		
		// out is and1 or and2
		or.a.set(and1.out.get());
		or.b.set(and2.out.get());
		or.execute();
		out.set(or.out.get());
	}


	// inputs
	public RussWire a;
	public RussWire b;
	// outputs
	public RussWire out;
	// gates
	public HwProj02_OR or;
	public HwProj02_AND and1;
	public HwProj02_AND and2;
	public HwProj02_NOT not1;
	public HwProj02_NOT not2;


	public HwProj02_XOR()
	{
		// the constructor for an object has to create all of the
		// RussWire objects to represent the inputs and outputs
		// of the object.
		a  = new RussWire();
		b  = new RussWire();
		out = new RussWire();
		or = new HwProj02_OR();
		and1 = new HwProj02_AND();
		and2 = new HwProj02_AND();
		not1 = new HwProj02_NOT();
		not2 = new HwProj02_NOT();
	}
}

