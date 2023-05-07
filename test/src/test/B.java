
public class B extends A{ 
	// attributs 	
static int nbB=0;

static {System.out.println("Bloc statique de B");}

{System.out.println("Bloc non statique de B pour la "+ nbB+" fois");nbB++;} 
//contructeurs 
public B(){ 
System.out.println("Constructeur 1 "); } 

// methodes 
public void m1(){ System.out.println("m1 de B"); 
} } 

