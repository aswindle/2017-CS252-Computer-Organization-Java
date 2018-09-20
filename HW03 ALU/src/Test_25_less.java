/*
b = ..000 (16 + 8 + 2 = 26)
a = ..000(2)
bnegate = true; 
op = 11

11010 (less than?) 000010 = 24 (less than?) 2= 00000
*/

public class Test_25_less{
	public static void main (String[]args){
		RussWire b[] = new RussWire[32];
		

		for (int i = 0; i < 32; i++){
			b[i] = new RussWire();
			b[i].set(true);
		}
		

		RussWire a[] = new RussWire[32];
		
		for (int i = 0; i < 32; i++){
			a[i] = new RussWire();
			a[i].set(true);
		}

		HwProj03_ALU alu1 = new HwProj03_ALU();
		
		for (int i = 0; i < 32; i++){
			alu1.a[i].set(a[i].get());
			alu1.b[i].set(b[i].get());
		}

		alu1.bNegate.set(true);
		alu1.aluOp[0].set(true);
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