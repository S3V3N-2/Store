public class C extends A{
// attributs	
static int nbC=0; 

static {System.out.println("Bloc statique de C");} 

{System.out.println("Bloc non statique de C pour la "+ nbC+" fois");nbC++;} 
// constructeurs
public C(){ 
System.out.println("Constructeur 1 de C "); } 

public C(int paramInutil)

{ System.out.println("Constructeur 2 de C "); 
}
//methodes 
public void m2(){ 
System.out.println("m2 de C"); } 
} 
