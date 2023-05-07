public class Main {
public static void main(String[] args) {
	System.out.println("Bonjour TP5 "); 
	A[] list = new A[4];
	list[0]= new A();
	list[1]= new B();
	list[2]= new C();
	list[3]= new D(5);
	for (int i=0;i<4; i++){
	      list[i].m1();
	      list[i].m2();
	} 
}
}
