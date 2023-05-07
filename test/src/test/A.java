public class A {
// attributs 
static int nbA=0; 
static {System.out.println("Bloc statique de A");}

{System.out.println("Bloc non statique de A pour la "+ nbA+" fois");nbA++;}
// constructeurs

// methodes
public void m1(){ 
System.out.println("m1 de A"); } 

public void m2(){ System.out.println("m2 de A"); 
} 

public String toString()
{return "je suis un A a tl 'dresse"+super.toString()  ;}

} 

