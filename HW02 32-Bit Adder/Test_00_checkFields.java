public class Test_00_checkFields
{
	public static void main(String[] args)
	{
		HwProj02_AND and = new HwProj02_AND();
		HwProj02_OR  or  = new HwProj02_OR ();
		HwProj02_NOT not = new HwProj02_NOT();
		HwProj02_XOR xor = new HwProj02_XOR();

		HwProj02_HalfAdder ha  = new HwProj02_HalfAdder();
		HwProj02_FullAdder fa  = new HwProj02_FullAdder();
		HwProj02_Adder32   a32 = new HwProj02_Adder32();

		/* we just just check the various fields - just to see
		 * if they exist.  This is *NOT* a logical test of any
		 * of the functionality!
		 */

		and.a.set(false);
		and.b.set(false);
		and.execute();
		System.out.printf("AND: %s %s -> %s\n",
		                  and.a.get(), and.b.get(), and.out.get());

		or .a.set(false);
		or .b.set(false);
		or .execute();
		System.out.printf("OR : %s %s -> %s\n",
		                  or .a.get(), or .b.get(), or .out.get());

		not.in.set(false);
		not.execute();
		System.out.printf("NOT: %s -> %s\n",
		                  not.in.get(), not.out.get());

		xor.a.set(false);
		xor.b.set(false);
		xor.execute();
		System.out.printf("XOR: %s %s -> %s\n",
		                  xor.a.get(), xor.b.get(), xor.out.get());

		ha.a.set(false);
		ha.b.set(false);
		ha.execute();
		System.out.printf("HALF ADDER: %s %s -> %s %s\n",
		                  ha.a.get(), ha.b.get(), ha.sum.get(), ha.carry.get());

		fa.a      .set(false);
		fa.b      .set(false);
		fa.carryIn.set(false);
		fa.execute();
		System.out.printf("FULL ADDER: %s %s %s -> %s %s\n",
		                  fa.a.get(), fa.b.get(), fa.carryIn.get(),
		                  fa.sum.get(), fa.carryOut.get());

		for (int i=0; i<32; i++)
		{
			a32.a[i].set(true);
			a32.b[i].set(true);
		}
		a32.execute();
		System.out.printf("ADD32 (too much to print): %s %s\n",
		                  a32.overflow.get(), a32.carryOut.get());
	}
}

