/* HwProj02_Adder32.java
 * Alex Swindle
 * aswindle
 * CSC 252 Project HW02
 * Models a 32-bit ripple carry adder
 */

public class HwProj02_Adder32
{
	public void execute()
	{
		// perform first add outside of the loop so i-1 doesn't go out of bounds
		// first carryIn is hardcoded to off
		adders[0].carryIn.set(false);
		// set bits of a and b as inputs to adder
		adders[0].a.set(a[0].get());
		adders[0].b.set(b[0].get());
		
		// execute and store bit in sum
		adders[0].execute();
		sum[0].set(adders[0].sum.get());
		
		for(int i=1; i<32; i++)
		{
			// carryIn is previous adder's carryOut
			adders[i].carryIn.set(adders[i-1].carryOut.get());
			
			// sets bits of a and b as inputs to adder
			adders[i].a.set(a[i].get());
			adders[i].b.set(b[i].get());
			
			// execute and store bit in sum
			adders[i].execute();
			sum[i].set(adders[i].sum.get());
		}
		
		// final carryOut is just the last carryOut bit created
		carryOut.set(adders[31].carryOut.get());
		
		/* overflow occurs if leftmost bits of a and b agree, but disagree with LMB of sum
		 * ((a and b) and notsum) or ((nota and notb) and sum) 
		 */
		
		// (a and1 b) and2 not sum
		and1.a.set(a[31].get());
		and1.b.set(b[31].get());
		and1.execute();
		not1.in.set(sum[31].get());
		not1.execute();
		and2.a.set(and1.out.get());
		and2.b.set(not1.out.get());
		and2.execute();
		
		// (nota and notb) and sum
		not2.in.set(a[31].get());
		not2.execute();
		not3.in.set(b[31].get());
		not3.execute();
		and3.a.set(not2.out.get());
		and3.b.set(not3.out.get());
		and3.execute();
		and4.a.set(and3.out.get());
		and4.b.set(sum[31].get());
		and4.execute();
		
		// and2 or and4
		or.a.set(and2.out.get());
		or.b.set(and4.out.get());
		or.execute();
		overflow.set(or.out.get());
		
		
		
	}


	// inputs
	public RussWire[] a;
	public RussWire[] b;
	// outputs
	public RussWire[] sum;
	public RussWire carryOut;
	public RussWire overflow;
	// gates
	public HwProj02_FullAdder[] adders;
	public HwProj02_AND and1;
	public HwProj02_AND and2;
	public HwProj02_AND and3;
	public HwProj02_AND and4;
	public HwProj02_NOT not1;
	public HwProj02_NOT not2;
	public HwProj02_NOT not3;
	public HwProj02_OR	or;

	public HwProj02_Adder32()
	{
		// the constructor for an object has to create all of the
		// RussWire objects to represent the inputs and outputs
		// of the object.
		a  = new RussWire[32];
		for(int i=0; i<32; i++)
		{
			a[i] = new RussWire();
		}
		b  = new RussWire[32];
		for(int i=0; i<32; i++)
		{
			b[i] = new RussWire();
		}
		sum = new RussWire[32];
		for(int i=0; i<32; i++)
		{
			sum[i] = new RussWire();
		}
		carryOut = new RussWire();
		overflow = new RussWire();
		
		adders = new HwProj02_FullAdder[32];
		for(int i=0; i<32; i++)
		{
			adders[i] = new HwProj02_FullAdder();
		}
		
		and1 = new HwProj02_AND();
		and2 = new HwProj02_AND();
		and3 = new HwProj02_AND();
		and4 = new HwProj02_AND();
		not1 = new HwProj02_NOT();
		not2 = new HwProj02_NOT();
		not3 = new HwProj02_NOT();
		or	 = new HwProj02_OR();
	}
}
