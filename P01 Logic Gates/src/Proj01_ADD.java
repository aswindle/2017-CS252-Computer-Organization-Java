/* Simulates a physical device that performs (signed) addition on a 32-bit input.
 *
 * Author: Alex Swindle aswindle
 */

public class Proj01_ADD
{
	public void execute()
	{
		boolean curCarry = false;
		for(int i = 0; i < 32; i++)
		{
			// with carry
			if(curCarry)
			{
				sum[i] = (a[i] == b[i]);
			}
			// without carry
			else
			{
				sum[i] = a[i] != b[i];
			}
			// carry occurs when 2 or more are true
			curCarry = (a[i] && b[i]) || (curCarry && (a[i] || b[i]));
			
		}
		// carryOut is the final curCarry value
		carryOut = curCarry;
		// overflow happens if the two input LMBs are the same and don't agree with output LMB
		overflow = (a[31] == b[31]) && (sum[31] != a[31]);
	}



	// ------ DON'T CHANGE ANYTHING BELOW THIS LINE ------

	// inputs
	public boolean[] a,b;

	// outputs
	public boolean[] sum;
	public boolean   carryOut, overflow;

	public Proj01_ADD()
	{
		a   = new boolean[32];
		b   = new boolean[32];
		sum = new boolean[32];
	}
}

