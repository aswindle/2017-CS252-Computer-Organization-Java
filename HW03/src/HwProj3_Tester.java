import java.util.Scanner;

public class HwProj3_Tester {
	/*
	 * (Place into the same directory where you have you ALU class)
	 * 
	 * A tester program for HwProj3. Either pass in command line arguments
	 * separated by white space, or run the program and it will prompt input.
	 * Will print out the result (in decimal and binary), based on what you.
	 * 
	 * For command line, pass in this order (a b aluOp bNegate). This is also
	 * the same order the program will prompt
	 * 
	 * a and b can either be in decimal or binary. If decimal, program will
	 * convert it to binary (signed 32-bit 2's complement). If binary, then pads
	 * with 0's to 32 bit.
	 * 
	 * Note: If you intend to use a negative value and put it in binary, make
	 * sure to pass in the whole 32 bit string (ie. my program will not sign
	 * extend) So just put in negative values through their binary
	 * representation like (-1)
	 * 
	 * aluOp must be 0 1 2 3. (No binary input allowed)
	 * 
	 * bNegate must only be 0 or 1.
	 * 
	 * ver 1.0 -- No error checking or QOL whatsoever, so if it crashes, you
	 * probably didn't input something correctly.
	 * 
	 * Feel free to make any change or tell me I'm wrong. Any major bugs or
	 * improvements to this code, please post to the Piazza.
	 * 
	 * @author Jalin Nguyen (jalinnguyen@email.arizona.edu)
	 */

	// Made them global since I'm too lazy type/pass args
	// Bad style, I know, but I just want to start testing
	static String a, b, aluOp, bNegate;
	static HwProj03_ALU alu = new HwProj03_ALU();

	public static void main(String[] args) {
		// Reading in input either from passed in command line or prompt input
		if (args.length != 4) {
			Scanner in = new Scanner(System.in);
			System.out.print("a?");
			a = in.next();

			System.out.print("b?");
			b = in.next();

			System.out.print("aluOp?");
			aluOp = in.next();

			System.out.print("bNegate?");
			bNegate = in.next();
			in.close();
		} else {
			a = args[0];
			b = args[1];
			aluOp = args[2];
			bNegate = args[3];
		}

		// Possible conversion/pad for a or b
		a = convert(a);
		b = convert(b);

		assert a.length() == 32;
		assert b.length() == 32;

		input();
		alu.execute();

		// Will print out both the binary representation and the decimal value
		printResult(alu.a);
		printResult(alu.b);
		printResult(alu.result);
	}

	private static void printResult(RussWire[] arr) {
		// Will print out the RussWire[] arr
		// Provides both a string representation and the decimal value
		// RussWire must be 32 bits in length
		assert arr.length == 32;
		String repr = "";
		for (int i = 0; i < 32; i++) {
			repr = (arr[i].get() ? "1" : "0") + repr;
		}

		int value = getTwosComplement(repr);
		System.out.println(repr + " decimal value = " + value);
	}

	// Note: I took this code from online. I didn't write it, but it works fine
	// for me.
	public static int getTwosComplement(String binaryInt) {
		// Check if the number is negative.
		// We know it's negative if it starts with a 1
		if (binaryInt.charAt(0) == '1') {
			// Call our invert digits method
			String invertedInt = invertDigits(binaryInt);
			// Change this to decimal format.
			int decimalValue = Integer.parseInt(invertedInt, 2);
			// Add 1 to the curernt decimal and multiply it by -1
			// because we know it's a negative number
			decimalValue = (decimalValue + 1) * -1;
			// return the final result
			return decimalValue;
		} else {
			// Else we know it's a positive number, so just convert
			// the number to decimal base.
			return Integer.parseInt(binaryInt, 2);
		}
	}

	// Note: I took this code from online. I didn't write it, but it works fine
	// for me.
	public static String invertDigits(String binaryInt) {
		String result = binaryInt;
		result = result.replace("0", " "); // temp replace 0s
		result = result.replace("1", "0"); // replace 1s with 0s
		result = result.replace(" ", "1"); // put the 1s back in
		return result;
	}

	private static String convert(String input) {
		// This method will handle all the conversion from decimal to binary to
		// padding to 32, in that order
		// Returns a String that is a 32-bit binary representation.
		// MSB is index 0, LSB is index 31 (essentially reversed)
		String value = "";

		// Converting to binary string representation if decimal
		if (!isBinary(input))
			value = convertBinary(input);
		else
			value = input;

		// Pad to 32 bits (pads with 0 for positive values, negative
		// signed values are already taken care of see convertBinary())
		if (value.length() < 32)
			value = pad32(value);

		return value;
	}

	private static boolean isBinary(String input) {
		// Checks to see if the passed in String is a bit String
		// If it contains any thing other than a 0 or 1, then return is false
		for (int i = 0; i < input.length(); i++) {
			if (!(input.charAt(i) == '0') && !(input.charAt(i) == '1'))
				return false;
		}
		return true;
	}

	private static String convertBinary(String input) {
		// Uncomment this code to see what Java returns, surprisingly this
		// handles negative values, converting them to signed 32 bit 2's
		// complement representations
		// If the value is positive, then it it is "lazy" and doesn't pad out to
		// 32 bits
		// System.out.println(Integer.toBinaryString(Integer.parseInt(input)));
		// System.out.println(Integer.toBinaryString(Integer.parseInt(input)).length());
		int value = Integer.parseInt(input, 10);
		return Integer.toBinaryString(value);
	}

	private static String pad32(String value) {
		// Given the value, returns a 0 padded 32 bit string copy
		String retStr = "";
		int val = 32 - value.length();
		for (int i = 0; i < val; i++) {
			retStr += "0";
		}
		return retStr + value;
	}

	private static void input() {
		// Inputs all the values into the ALU
		// The strings representations are "reversed" for the LSB and MSB, so
		// iterate backwards through the strings, iterate forwards through the
		// ALU input
		for (int i = 0; i < 32; i++) {
			alu.a[i].set((a.charAt(a.length() - 1 - i) == '1') ? true : false);
			alu.b[i].set((b.charAt(b.length() - 1 - i) == '1') ? true : false);
		}

		switch (Integer.parseInt(aluOp)) {
		case 0: // AND
			alu.aluOp[0].set(false);
			alu.aluOp[1].set(false);
			break;
		case 1: // OR
			alu.aluOp[0].set(true);
			alu.aluOp[1].set(false);
			break;
		case 2: // ADD
			alu.aluOp[0].set(false);
			alu.aluOp[1].set(true);
			break;
		case 3: // LESS
			alu.aluOp[0].set(true);
			alu.aluOp[1].set(true);
			break;
		default: // Error checking
			System.out.println("aluOp input was not 0 1 2 3! Ending program");
			assert false;
			break;
		}

		// Set bNegate
		// If aluOp = 2 && bNegate = 0, then ADD
		// If aluOp = 2 && bNegate = 1, then SUB
		// If aluOp = 3 && bNegate = 1, then LESS
		alu.bNegate.set((Integer.parseInt(bNegate)) == 1 ? true : false);
	}

} // class HwProj3_Tester
