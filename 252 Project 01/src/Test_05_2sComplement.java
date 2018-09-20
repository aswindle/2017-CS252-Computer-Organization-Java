/* Testcase for 252 Project 1.
 *
 * Author: Russ Lewis
 */

public class Test_05_2sComplement
{
	public static void main(String[] args)
	{
		Proj01_2sComplement p = new Proj01_2sComplement();

		// because I'm lazy, I'll only set the bits which are true;
		// we know that the rest will default to false.
		p.in[ 0] = true;
		p.in[ 1] = true;
		p.in[ 2] = true;
		p.in[ 3] = true;
		p.in[ 6] = true;
		p.in[ 7] = true;
		p.in[ 8] = true;
		p.in[10] = true;
		p.in[16] = true;
		p.in[19] = true;
		p.in[31] = true;

		p.execute();

		System.out.printf(" x = ");
		print_bits(p.in);
		System.out.println();

		System.out.printf("-x = ");
		print_bits(p.out);
		System.out.println();
	}

	public static void print_bits(boolean[] bits)
	{
		for (int i=31; i>=0; i--)
		{
			if (bits[i])
				System.out.print("1");
			else
				System.out.print("0");
		}
	}
}

