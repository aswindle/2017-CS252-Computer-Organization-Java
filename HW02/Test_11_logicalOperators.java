/* Tests all combinations of Proj02 AND, OR, NOT, and XOR gates
 * Author: Alex Swindle
 */

public class Test_11_logicalOperators
{
	public static void main(String[] args)
	{
		HwProj02_AND andff = new HwProj02_AND();
		HwProj02_AND andft = new HwProj02_AND();
		HwProj02_AND andtf = new HwProj02_AND();
		HwProj02_AND andtt = new HwProj02_AND();
		HwProj02_OR  orff  = new HwProj02_OR ();
		HwProj02_OR  orft  = new HwProj02_OR ();
		HwProj02_OR  ortf  = new HwProj02_OR ();
		HwProj02_OR  ortt  = new HwProj02_OR ();
		HwProj02_NOT notf = new HwProj02_NOT();
		HwProj02_NOT nott = new HwProj02_NOT();
		HwProj02_XOR xorff = new HwProj02_XOR();
		HwProj02_XOR xorft = new HwProj02_XOR();
		HwProj02_XOR xortf = new HwProj02_XOR();
		HwProj02_XOR xortt = new HwProj02_XOR();
		
		// test all 4 possible AND combinations
		System.out.println("AND:");
		
		andff.a.set(false);
		andff.b.set(false);
		andff.execute();
		System.out.printf("%5s and %5s : %5s\n", andff.a, andff.b, andff.out);
		
		andft.a.set(false);
		andft.b.set(true);
		andft.execute();
		System.out.printf("%5s and %5s : %5s\n", andft.a, andft.b, andft.out);
		
		andtf.a.set(true);
		andtf.b.set(false);
		andtf.execute();
		System.out.printf("%5s and %5s : %5s\n", andtf.a, andtf.b, andtf.out);
		
		andtt.a.set(true);
		andtt.b.set(true);
		andtt.execute();
		System.out.printf("%5s and %5s : %5s\n", andtt.a, andtt.b, andtt.out);
		
		System.out.println();
		
		// test all 4 possible OR combinations
		System.out.println("OR:");
		
		orff.a.set(false);
		orff.b.set(false);
		orff.execute();
		System.out.printf("%5s or %5s : %5s\n", orff.a, orff.b, orff.out);
		
		orft.a.set(false);
		orft.b.set(true);
		orft.execute();
		System.out.printf("%5s or %5s : %5s\n", orft.a, orft.b, orft.out);
		
		ortf.a.set(true);
		ortf.b.set(false);
		ortf.execute();
		System.out.printf("%5s or %5s : %5s\n", ortf.a, ortf.b, ortf.out);
		
		ortt.a.set(true);
		ortt.b.set(true);
		ortt.execute();
		System.out.printf("%5s or %5s : %5s\n", ortt.a, ortt.b, ortt.out);
		
		System.out.println();
		
		// test both NOT possibilities
		System.out.println("NOT:");
		
		notf.in.set(false);
		notf.execute();
		System.out.printf("~%5s: %s\n", notf.in, notf.out);
		
		nott.in.set(true);
		nott.execute();
		System.out.printf("~%5s: %s\n", nott.in, nott.out);
		
		System.out.println();
		
		// test all 4 possible XOR combinations
		System.out.println("XOR:");
		
		xorff.a.set(false);
		xorff.b.set(false);
		xorff.execute();
		System.out.printf("%5s xor %5s : %5s\n", xorff.a, xorff.b, xorff.out);
		
		xorft.a.set(false);
		xorft.b.set(true);
		xorft.execute();
		System.out.printf("%5s xor %5s : %5s\n", xorft.a, xorft.b, xorft.out);
		
		xortf.a.set(true);
		xortf.b.set(false);
		xortf.execute();
		System.out.printf("%5s xor %5s : %5s\n", xortf.a, xortf.b, xortf.out);
		
		xortt.a.set(true);
		xortt.b.set(true);
		xortt.execute();
		System.out.printf("%5s xor %5s : %5s\n", xortt.a, xortt.b, xortt.out);
	}
}
