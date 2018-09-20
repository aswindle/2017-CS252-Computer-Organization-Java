/*
a = 11000...
b = 11100...
bnegate = false; 
op = 00

0000 & 00000
*/

public class Test_13_alu{
	public static void main (String[]args){
		RussWire a[] = new RussWire[32];
		for (int i = 0; i < 30; i++){
			a[i] = new RussWire();
			a[i].set(false);
		}
		a[30] = new RussWire();
		a[30].set(true);
		a[31] = new RussWire();
		a[31].set(true);

		RussWire b[] = new RussWire[32];
		for (int i = 0; i < 29; i++){
			b[i] = new RussWire();
			b[i].set(false);
		}
		b[29] = new RussWire();
		b[29].set(true);
		b[30] = new RussWire();
		b[30].set(true);
		b[31] = new RussWire();
		b[31].set(true);

		HwProj03_ALU alu1 = new HwProj03_ALU();
		
		for (int i = 0; i < 32; i++){
			alu1.a[i].set(a[i].get());
			alu1.b[i].set(b[i].get());
		}

		alu1.bNegate.set(false);
		alu1.aluOp[0].set(false);
		alu1.aluOp[1].set(false);
		alu1.execute();

		for(int i = 0; i < 32; i ++){
			
			if(alu1.result[i].get() == false ){
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		}
	}
}