/* Simulates a physical AND gate.
 *
 * Author: Alex Swindle aswindle
 */

public class Proj01_AND
{
	public void execute()
	{
		if(a)
		{
			if(b)
			{
				out = true;
			}
		}
		else
		{
			out = false;
		}
	}



	// ------ DON'T CHANGE ANYTHING BELOW THIS LINE ------

	public boolean a,b;   // inputs
	public boolean out;   // output

	public Proj01_AND()
	{
		/* nothing is needed here */
	}
}

