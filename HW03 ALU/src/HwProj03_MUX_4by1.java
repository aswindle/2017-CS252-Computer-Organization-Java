/* HwProj03_MUX_4by1.java
 * Alex Swindle
 * aswindle
 * CSC 252 Project HW03
 * Models a 4-by-1 MUX
 */

public class HwProj03_MUX_4by1
{
	public void execute()
	{
		/* Control bit settings for output
		 * 00 = out is in[0]
		 * 01 = out is in[1]
		 * 10 = out is in[2]
		 * 11 = out is in[3]
		 */
		boolean c0 = control[0].get();
		boolean c1 = control[1].get();
		
		// All 4 output settings for the MUX
		if(!c1 && !c0)
		{
			out.set(in[0].get());
		}
		else if(!c1 && c0)
		{
			out.set(in[1].get());
		}
		else if(c1 && !c0)
		{
			out.set(in[2].get());
		}
		else if(c1 && c0)
		{
			out.set(in[3].get());
		}
	}
	
	// wires required:
	// 2-bit control
	// 4-bit in
	// 1-bit out
	RussWire[] control;
	RussWire[] in;
	RussWire   out;
	
	public HwProj03_MUX_4by1()
	{
		// initialize all the wires for control, in, and out
		control = new RussWire[2];
		control[0] = new RussWire();
		control[1] = new RussWire();
		
		in = new RussWire[4];
		for(int i = 0; i<4; i++)
		{
			in[i] = new RussWire();
		}
		
		out = new RussWire();
		
	}
}
