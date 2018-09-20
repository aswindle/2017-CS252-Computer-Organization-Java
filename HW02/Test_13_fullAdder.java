/* Tests all combinations of Proj02 FullAdder
 * Author: Alex Swindle
 */

public class Test_13_fullAdder
{
	public static void main(String[] args)
	{
		HwProj02_FullAdder addfff = new HwProj02_FullAdder();
		HwProj02_FullAdder addfft = new HwProj02_FullAdder();
		HwProj02_FullAdder addftf = new HwProj02_FullAdder();
		HwProj02_FullAdder addftt = new HwProj02_FullAdder();
		HwProj02_FullAdder addtff = new HwProj02_FullAdder();
		HwProj02_FullAdder addtft = new HwProj02_FullAdder();
		HwProj02_FullAdder addttf = new HwProj02_FullAdder();
		HwProj02_FullAdder addttt = new HwProj02_FullAdder();
		
		System.out.printf("%5s | %5s | %5s | %5s | %5s\n", "a", "b", "cIn", "sum", "cOut");
		
		addfff.a.set(false);
		addfff.b.set(false);
		addfff.carryIn.set(false);
		addfff.execute();
		System.out.printf("%5s | %5s | %5s | %5s | %5s\n", addfff.a, addfff.b, addfff.carryIn, addfff.sum, addfff.carryOut);
		
		addfft.a.set(false);
		addfft.b.set(false);
		addfft.carryIn.set(true);
		addfft.execute();
		System.out.printf("%5s | %5s | %5s | %5s | %5s\n", addfft.a, addfft.b, addfft.carryIn, addfft.sum, addfft.carryOut);
		
		addftf.a.set(false);
		addftf.b.set(true);
		addftf.carryIn.set(false);
		addftf.execute();
		System.out.printf("%5s | %5s | %5s | %5s | %5s\n", addftf.a, addftf.b, addftf.carryIn, addftf.sum, addftf.carryOut);
		
		addftt.a.set(false);
		addftt.b.set(true);
		addftt.carryIn.set(true);
		addftt.execute();
		System.out.printf("%5s | %5s | %5s | %5s | %5s\n", addftt.a, addftt.b, addftt.carryIn, addftt.sum, addftt.carryOut);
		
		addtff.a.set(true);
		addtff.b.set(false);
		addtff.carryIn.set(false);
		addtff.execute();
		System.out.printf("%5s | %5s | %5s | %5s | %5s\n", addtff.a, addtff.b, addtff.carryIn, addtff.sum, addtff.carryOut);
		
		addtft.a.set(true);
		addtft.b.set(false);
		addtft.carryIn.set(true);
		addtft.execute();
		System.out.printf("%5s | %5s | %5s | %5s | %5s\n", addtft.a, addtft.b, addtft.carryIn, addtft.sum, addtft.carryOut);
		
		addttf.a.set(true);
		addttf.b.set(true);
		addttf.carryIn.set(false);
		addttf.execute();
		System.out.printf("%5s | %5s | %5s | %5s | %5s\n", addttf.a, addttf.b, addttf.carryIn, addttf.sum, addttf.carryOut);
		
		addttt.a.set(true);
		addttt.b.set(true);
		addttt.carryIn.set(true);
		addttt.execute();
		System.out.printf("%5s | %5s | %5s | %5s | %5s\n", addttt.a, addttt.b, addttt.carryIn, addttt.sum, addttt.carryOut);
	}
}
