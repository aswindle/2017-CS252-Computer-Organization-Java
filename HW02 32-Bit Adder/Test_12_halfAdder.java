/* Tests all combinations of Proj02 HalfAdder
 * Author: Alex Swindle
 */

public class Test_12_halfAdder
{
	public static void main(String[] args)
	{
		HwProj02_HalfAdder addff = new HwProj02_HalfAdder();
		HwProj02_HalfAdder addft = new HwProj02_HalfAdder();
		HwProj02_HalfAdder addtf = new HwProj02_HalfAdder();
		HwProj02_HalfAdder addtt = new HwProj02_HalfAdder();
		
		System.out.printf("%5s | %5s | %5s | %5s\n", "a", "b", "sum", "carry");
		
		addff.a.set(false);
		addff.b.set(false);
		addff.execute();
		System.out.printf("%5s | %5s | %5s | %5s\n", addff.a, addff.b, addff.sum, addff.carry);
		
		addft.a.set(false);
		addft.b.set(true);
		addft.execute();
		System.out.printf("%5s | %5s | %5s | %5s\n", addft.a, addft.b, addft.sum, addft.carry);
		
		addtf.a.set(true);
		addtf.b.set(false);
		addtf.execute();
		System.out.printf("%5s | %5s | %5s | %5s\n", addtf.a, addtf.b, addtf.sum, addtf.carry);
		
		addtt.a.set(true);
		addtt.b.set(true);
		addtt.execute();
		System.out.printf("%5s | %5s | %5s | %5s\n", addtt.a, addtt.b, addtt.sum, addtt.carry);
		
	}
}
