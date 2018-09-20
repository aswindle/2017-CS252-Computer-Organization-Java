/* Simulates a physical NOT gate.
 *
 * Author: Alex Swindle aswindle
 */

public class Proj01_NOT
{
	public void execute()
	{
		if(in)
		{
			out = false;
		}
		else
		{
			out = true;
		}
	}



	// ------ DON'T CHANGE ANYTHING BELOW THIS LINE ------

	public boolean in;    // input
	public boolean out;   // output

	public Proj01_NOT()
	{
		/* nothing is needed here */
	}
}

