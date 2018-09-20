/* Testcase for 252 Project 1.
 *
 * Author: Russ Lewis
 */

public class Test_04_NOT
{
	public static void main(String[] args)
	{
		Proj01_NOT p[] = new Proj01_NOT[32];
		for (int i=0; i<32; i++)
			p[i] = new Proj01_NOT();

		// because I'm lazy, I'll only set the bits which are true;
		// we know that the rest will default to false.
		p[ 0].in = true;
		p[ 1].in = true;
		p[ 2].in = true;
		p[ 3].in = true;
		p[ 6].in = true;
		p[ 7].in = true;
		p[ 8].in = true;
		p[10].in = true;
		p[16].in = true;
		p[19].in = true;
		p[31].in = true;

		for (int i=0; i<32; i++)
			p[i].execute();

		for (int i=0; i<32; i++)
		{
			System.out.printf("%02d: ~%c = %c\n",
			                  i,
			                  TF(p[i].in ),
			                  TF(p[i].out));
		}
	}

	public static char TF(boolean b)
	{
		if (b)
			return 'T';
		else
			return 'F';
	}
}

