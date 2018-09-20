/*
a = ..0000
b = ..0000
bnegate = false; 
op = 01

0000 || 00000
*/

public class Test_14_alu{
	public static void main (String[]args){
		RussWire a[] = new RussWire[32];
		for (int i = 0; i < 32; i++){
			a[i] = new RussWire();
			a[i].set(false);
		}

		RussWire b[] = new RussWire[32];
		for (int i = 0; i < 31; i++){
			b[i] = new RussWire();
			b[i].set(false);
		}
		b[31] = new RussWire();
		b[31].set(false);

		HwProj03_ALU alu1 = new HwProj03_ALU();
		
		for (int i = 0; i < 32; i++){
			alu1.a[i].set(a[i].get());
			alu1.b[i].set(b[i].get());
		}

		alu1.bNegate.set(false);
		alu1.aluOp[0].set(true);
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