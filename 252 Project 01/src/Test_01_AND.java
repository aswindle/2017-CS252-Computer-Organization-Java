/* Testcase for 252 Project 1.
 *
 * Author: Russ Lewis
 */

public class Test_01_AND
{
	public static void main(String[] args)
	{
		Proj01_AND p[] = new Proj01_AND[32];
		for (int i=0; i<32; i++)
			p[i] = new Proj01_AND();

		// because I'm lazy, I'll only set the bits which are true;
		// we know that the rest will default to false.
		p[ 0].a = true;
		p[ 1].a = true;
		p[ 2].a = true;
		p[ 3].a = true;
		p[ 6].a = true;
		p[ 7].a = true;
		p[ 8].a = true;
		p[10].a = true;
		p[16].a = true;
		p[19].a = true;
		p[31].a = true;

		p[ 2].b = true;
		p[ 3].b = true;
		p[ 5].b = true;
		p[ 7].b = true;
		p[11].b = true;
		p[13].b = true;
		p[17].b = true;
		p[19].b = true;
		p[23].b = true;
		p[29].b = true;
		p[31].b = true;

		for (int i=0; i<32; i++)
			p[i].execute();

		for (int i=0; i<32; i++)
		{
			System.out.printf("%02d: %c & %c = %c\n",
			                  i,
			                  TF(p[i].a), TF(p[i].b),
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

