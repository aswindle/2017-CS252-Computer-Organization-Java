/* Simulates a physical device that performs 2's complement on a 32-bit input.
 *
 * Author: Alex Swindle aswindle
 */

public class Proj01_2sComplement
{
	public void execute()
	{
		//execute negation on each bit of in, store in temp variable
		for(int i = 0; i < 32; i++)
		{
			negatedBits[i].in = in[i];
			negatedBits[i].execute();
			temp[i] = negatedBits[i].out;
		}
		
		//add 1 to negated number to get proper 2s complement
		adder.a = temp;
		adder.b = one;
		adder.execute();
		
		//set to out
		out = adder.sum;
	}



	// you shouldn't change these standard variables...
	public boolean[] in;
	public boolean[] out;


	public Proj01_ADD adder;
	public Proj01_NOT[] negatedBits;
	public boolean[] temp;
	public boolean[] one;


	public Proj01_2sComplement()
	{
		in  = new boolean[32];
		out = new boolean[32];

		// create and initialize an array of NOTs to negate each bit
		negatedBits = new Proj01_NOT[32];
		for(int i = 0; i < 32; i++)
		{
			negatedBits[i] = new Proj01_NOT();
		}
		adder = new Proj01_ADD();
		temp = new boolean[32];
		// create a 32-bit 1 value to add on at the end
		one = new boolean[32];
		one[0] = true;
		
	}
}

