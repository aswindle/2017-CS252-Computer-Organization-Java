/* dummy testcase for Hardware Project 3
 *
 * This class doesn't actually test any of the functionality of your code.
 * However, it checks that all of the names are correct.
 *
 * In this project, it's your job to write the testcases!
 */

public class Test_00_checkFieldsAndMethods
{
	public static void main(String[] args)
	{
		/* Create one of each of the required object types */
		HwProj03_MUX_4by1   mux     = new HwProj03_MUX_4by1();
		HwProj03_ALUElement aluElem = new HwProj03_ALUElement();
		HwProj03_ALU        alu     = new HwProj03_ALU();


		/* I read each required field in each object.  This confirms
		 * two things:
		 *    - that the fields exist, and have the right names
		 *    - that their types are 'RussWire'
		 *
		 * Note that I don't have any explicit way to check if they
		 * are inputs or outputs.
		 */
		RussWire dummy;

		dummy = mux.control[0];
		dummy = mux.control[1];
		dummy = mux.in[0];
		dummy = mux.in[1];
		dummy = mux.in[2];
		dummy = mux.in[3];
		dummy = mux.out;

		dummy = aluElem.aluOp[0];
		dummy = aluElem.aluOp[1];
		dummy = aluElem.bInvert;
		dummy = aluElem.a;
		dummy = aluElem.b;
		dummy = aluElem.carryIn;
		dummy = aluElem.less;
		dummy = aluElem.result;
		dummy = aluElem.addResult;
		dummy = aluElem.carryOut;

		dummy = alu.aluOp[0];
		dummy = alu.aluOp[1];
		dummy = alu.bNegate;
		dummy = alu.a[31];
		dummy = alu.b[31];
		dummy = alu.result[31];


		/* this will never be true (at least, if you're running this
		 * under the grading script).  That is intentional.  I want to
		 * check that the various execute*() methods existed, but
		 * since I didn't set any of the input RussWire objects, none
		 * of the execute*() methods will work.
		 */
		if (args.length > 0)
		{
			mux    .execute();
			aluElem.execute_pass1();
			aluElem.execute_pass2();
			alu    .execute();
		}
	}
}

