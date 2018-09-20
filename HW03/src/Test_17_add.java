/*
a = 000
b = 000
bnegate = false; 
op = 10

000 + 000 = 000
*/

public class Test_17_add{
	public static void main (String[]args){
		RussWire a[] = new RussWire[32];
		a[0] = new RussWire();
		a[0].set(false);
		a[1] = new RussWire();
		a[1].set(false);
		a[2] = new RussWire();
		a[2].set(false);
		a[3] = new RussWire();
		a[3].set(false);

		for (int i = 4; i < 30; i++){
			a[i] = new RussWire();
			a[i].set(false);
		}
		a[30] = new RussWire();
		a[30].set(false);
		a[31] = new RussWire();
		a[31].set(false);

		RussWire b[] = new RussWire[32];
		b[0] = new RussWire();
		b[0].set(false);

		for (int i = 1; i < 29; i++){
			b[i] = new RussWire();
			b[i].set(false);
		}
		b[29] = new RussWire();
		b[29].set(false);
		b[30] = new RussWire();
		b[30].set(false);
		b[31] = new RussWire();
		b[31].set(false);

		HwProj03_ALU alu1 = new HwProj03_ALU();
		
		for (int i = 0; i < 32; i++){
			alu1.a[i].set(a[i].get());
			alu1.b[i].set(b[i].get());
		}

		alu1.bNegate.set(false);
		alu1.aluOp[0].set(false);
		alu1.aluOp[1].set(true);
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