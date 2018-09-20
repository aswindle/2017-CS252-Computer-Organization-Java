/* HwProj02_FullAdder.java
 * Alex Swindle
 * aswindle
 * CSC 252 Project HW02
 * Models a full adder built out of 2 half adders and an OR gate
 */

public class HwProj02_FullAdder
{
	public void execute()
	{
		// add a and b
		add1.a.set(a.get());
		add1.b.set(b.get());
		add1.execute();
		// sum is that result plus carryIn
		add2.a.set(add1.sum.get());
		add2.b.set(carryIn.get());
		add2.execute();
		sum.set(add2.sum.get());

		/* carryOut is at least 2 of a, b, and carryIn
		 * [(a or b) and carryIn] or (a and b)
		*/
		
		// (a or b) and carryIn
		or1.a.set(a.get());
		or1.b.set(b.get());
		or1.execute();
		and1.a.set(or1.out.get());
		and1.b.set(carryIn.get());
		and1.execute();
		
		// a and b
		and2.a.set(a.get());
		and2.b.set(b.get());
		and2.execute();
		
		// carryOut is and1 or and2
		or2.a.set(and1.out.get());
		or2.b.set(and2.out.get());
		or2.execute();
		carryOut.set(or2.out.get());		
	}


	// inputs
	public RussWire a;
	public RussWire b;
	public RussWire carryIn;
	// outputs
	public RussWire sum;
	public RussWire carryOut;
	// gates
	public HwProj02_HalfAdder add1;
	public HwProj02_HalfAdder add2;
	public HwProj02_OR or1;
	public HwProj02_OR or2;
	public HwProj02_AND and1;
	public HwProj02_AND and2;


	public HwProj02_FullAdder()
	{
		// the constructor for an object has to create all of the
		// RussWire objects to represent the inputs and outputs
		// of the object.
		a  = new RussWire();
		b  = new RussWire();
		carryIn = new RussWire();
		sum = new RussWire();
		carryOut = new RussWire();
		add1 = new HwProj02_HalfAdder();
		add2 = new HwProj02_HalfAdder();
		or1 = new HwProj02_OR();
		or2 = new HwProj02_OR();
		and1 = new HwProj02_AND();
		and2 = new HwProj02_AND();
	}
}
