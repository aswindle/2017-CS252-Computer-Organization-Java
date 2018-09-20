/* HwProj02_HalfAdder.java
 * Alex Swindle
 * aswindle
 * CSC 252 Project HW02
 * Models a half-adder built out of AND and XOR gates
 */

public class HwProj02_HalfAdder
{
	public void execute()
	{
		// sum is a XOR b
		xor.a.set(a.get());
		xor.b.set(b.get());
		xor.execute();
		sum.set(xor.out.get());
		
		// carry is a and b
		and.a.set(a.get());
		and.b.set(b.get());
		and.execute();
		carry.set(and.out.get());
	}


	// inputs
	public RussWire a;
	public RussWire b;
	// outputs
	public RussWire sum;
	public RussWire carry;
	// gates
	public HwProj02_XOR xor;
	public HwProj02_AND and;


	public HwProj02_HalfAdder()
	{
		// the constructor for an object has to create all of the
		// RussWire objects to represent the inputs and outputs
		// of the object.
		a  = new RussWire();
		b  = new RussWire();
		sum = new RussWire();
		carry = new RussWire();
		xor = new HwProj02_XOR();
		and = new HwProj02_AND();
	}
}
