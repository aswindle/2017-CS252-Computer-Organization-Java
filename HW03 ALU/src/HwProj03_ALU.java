/* HwProj03_ALU.java
 * Alex Swindle
 * aswindle
 * CSC 252 Project HW03
 * Models a 32-bit ALU
 */

public class HwProj03_ALU
{
	public void execute()
	{
		// Handle first ALUElement as a special case
		
		// first carryIn and bInvert are set to bNegate's value
		// aluOp is copied over
		// values of a and b are copied from 32bit wire
		// pass 1 is run, but less won't be set until the rest are run
		
		alu[0].carryIn.set(bNegate.get());
		alu[0].bInvert.set(bNegate.get());
		alu[0].aluOp[0].set(aluOp[0].get());
		alu[0].aluOp[1].set(aluOp[1].get());
		alu[0].a.set(a[0].get());
		alu[0].b.set(b[0].get());
		alu[0].execute_pass1();
		
		// Handle all other ALUElements
		
		 /* all other carryIn values are the previous carryOut
		  * each bInvert value is the value of bNegate
		  * aluOp gets copied over
		  * a and b values are copied from 32bit wire
		  * value of less is always false for every element other than 0
		  * execute pass 1
		  */
		 
		for(int i = 1; i<32; i++)
		{
			alu[i].carryIn.set(alu[i-1].carryOut.get());
			alu[i].bInvert.set(bNegate.get());
			alu[i].aluOp[0].set(aluOp[0].get());
			alu[i].aluOp[1].set(aluOp[1].get());
			alu[i].a.set(a[i].get());
			alu[i].b.set(b[i].get());
			alu[i].less.set(false);
			alu[i].execute_pass1();
		}
		
		// first less value is the addResult of bit 31
		alu[0].less.set(alu[31].addResult.get());
		
		// all bits now have their less values set, so pass 2 can run
		// results can also be copied over to result wire
		for(int i = 0; i< 32; i++)
		{
			alu[i].execute_pass2();
			result[i].set(alu[i].result.get());
		}
	}
	
	
	/* Required fields:
	 * aluOp = 2bit wire
	 * bNegate = 1bit wire
	 * a, b = 32bit wires
	 * result = 32bit wire
	 * alu = 32bit ALUElement array
	 */
	RussWire[] aluOp;
	RussWire   bNegate;
	RussWire[] a;
	RussWire[] b;
	RussWire[] result;
	HwProj03_ALUElement[] alu;
	
	public HwProj03_ALU()
	{
		//initialize all fields
		aluOp = new RussWire[2];
		aluOp[0] = new RussWire();
		aluOp[1] = new RussWire();
		
		bNegate = new RussWire();
		
		a = new RussWire[32];
		b = new RussWire[32];
		result = new RussWire[32];
		alu = new HwProj03_ALUElement[32];
		
		for(int i = 0; i<32; i++)
		{
			a[i] = new RussWire();
			b[i] = new RussWire();
			result[i] = new RussWire();
			alu[i] = new HwProj03_ALUElement();
		}
	}
}
