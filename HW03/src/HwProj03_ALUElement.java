/* HwProj03_ALUElement.java
 * Alex Swindle
 * aswindle
 * CSC 252 Project HW03
 * Models a 1-bit ALU
 */
public class HwProj03_ALUElement
{
	public void execute_pass1()
	{
		// Calculate the value of b based on bInvert
		
		// Input to mux will be value of bInvert
		// 0 = processedB is b
		// 1 = processedB is !b
		bmux.control[0].set(bInvert.get());
		bmux.control[1].set(false);
		bmux.in[0].set(b.get());
		bmux.in[1].set(!b.get());
		bmux.in[2].set(false);
		bmux.in[3].set(false);
		bmux.execute();
		processedB.set(bmux.out.get());
		
		// Calculate add result
		// Recreates an adder's structure
		
		// Result is either exactly 1 of a, b, and carryIn, or all 3
		// a!b!c or !ab!c or !a!bc or abc
		boolean tempA = a.get();
		boolean tempB = processedB.get();
		boolean tempC = carryIn.get();
		boolean tempAdd = (tempA && !tempB && !tempC) ||
						  (!tempA && tempB && !tempC) ||
						  (!tempA && !tempB && tempC) ||
						  (tempA && tempB && tempC);
		addResult.set(tempAdd);
		
		// carryOut is at least 2 of a, b, and carryIn
		// ((a or b) and carryIn) or (a and b)
		boolean tempOut = ((tempA || tempB) && tempC) ||
						  (tempA && tempB);
		carryOut.set(tempOut);	
	}
	
	public void execute_pass2()
	{
		// mux control is the ALU Op code
		mux.control[0].set(aluOp[0].get());
		mux.control[1].set(aluOp[1].get());
		
		// mux input is the 4 operations' results
		// 0 = AND
		// 1 = OR
		// 2 = ADD
		// 3 = LESS
		
		mux.in[0].set(a.get() && b.get());
		mux.in[1].set(a.get() || b.get());
		mux.in[2].set(addResult.get());
		mux.in[3].set(less.get());
		mux.execute();
		result.set(mux.out.get());
	}
	
	// Inputs
	RussWire[] aluOp; // 2-bit input
	RussWire   bInvert;
	RussWire   a;
	RussWire   b;
	RussWire   carryIn;
	RussWire   less;
	RussWire   processedB;
	
	// MUXes: 1 for the final result, 1 for bInvert to select b's value
	HwProj03_MUX_4by1 mux;
	HwProj03_MUX_4by1 bmux;
	
	// Outputs
	RussWire result;
	RussWire addResult;
	RussWire carryOut;
	
	public HwProj03_ALUElement()
	{
		// Initialize everything
		aluOp = new RussWire[2];
		aluOp[0] = new RussWire();
		aluOp[1] = new RussWire();
		
		bInvert = new RussWire();
		a = new RussWire();
		b = new RussWire();
		carryIn = new RussWire();
		less = new RussWire();
		processedB = new RussWire();
		
		bmux = new HwProj03_MUX_4by1();
		mux = new HwProj03_MUX_4by1();
		
		result = new RussWire();
		addResult = new RussWire();
		carryOut = new RussWire();
		
	}
}
