package fractions;

public class Fraction {
	private int n;// numerateur
	private int d;// dénominateur

	public Fraction() {
		this(0, 1);
		
		

	}

	public Fraction(int n) {
		this(n, 1);// on appelle le constructeur Fraction(int n, int d)
	}

	public Fraction(int n, int d) {
		if (d == 0) {
			throw new ArithmeticException(" dénominateur interdit :" + d);
		}
		this.n = n;
		this.d = d;
		denoPositive();
		reduire();
	}

	// constructeur 4: construit une fraction d'après son expression écrite dans s.
	public Fraction(String s) {
		int iBarre = s.indexOf('/');
		if (iBarre == -1) {// le cas de saisie d'un indice invalide,on léve une exception
			throw new IllegalArgumentException("Expression de la fraction invalide");
		}
		// le numerateur sera le début de la chaine donc 0 inclus jusqu'à iBarre exclus
		this.n = Integer.parseInt(s.substring(0, iBarre));
		// le dénominarateur sera le caractere qui est juste apres iBarre,donc iBarre+1
		// inclus jusqu'à la fin de la chaine
		this.d = Integer.parseInt(s.substring(iBarre + 1));
		denoPositive();
		reduire();
		

	}

	private static  int pgcd(int a, int b) {
		int r = a % b;
		if(r == 0)
			return b;
		return pgcd(b, r);
	}

	// Méthode réduire() pour réduire nos fractions
	private void reduire() {
		int pgcd = pgcd(n, d);
		this.n = n / pgcd;
		this.d = d / pgcd;
	}

	// méthode posive qui rend notre dénominateur positif
	private void denoPositive() {
		if (this.d < 0) {
			this.n = -n;
			this.d = -d;
		}

	}
	//Accesseur en lecture pour le numerateur
	public int  getN() {
		return this.n;
		
	}
	//Acceseur en lecture pour le dénominateur
	public int getD() {
		return this.d;
		
	}
	//Accesseur en écriture pour le numerateur
	public void setN(int numerateur) {
		this.n=numerateur;
	}
	//Accesseur en écriture pour le dénominateur
	public void setD(int denominateur) {
		this.n=denominateur;
	}
	
	//valueof qui retourne une fraction dont l'expression est dans s :
	public static Fraction  valueOf(String s) {
		return  new Fraction(s);
		
		
	}
	
	//methode pour calculer le ppcm(a, b)
	public static  int ppcm(int a ,int b) {
		return (a/pgcd(a,b))*b;
		
	}
	
	
	//Méthode d 'instance plus plus(Fraction f) qui retourne 
	//le résultat de l'addition de this et f
	public Fraction plus(Fraction f) {
		int p=ppcm(this.d,f.d);
		this.n = (this.n*p)/this.d  + (f.n*p)/f.d;
		this.d = p;
		reduire();
		return this;
	
		/*
		int p=ppcm(this.d,f.d);
		return new Fraction((this.n*p)/this.d  +(f.n*p)/f.d ,p); 
		*/
		
		
	}
	
	public Fraction moins(Fraction f) {
		int p=ppcm(this.d,f.d);
		this.n = (this.n*p)/this.d  -(f.n*p)/f.d;
		this.d = p;
		reduire();
		return this;
		/*
		int p=ppcm(this.d,f.d);
		return new Fraction((this.n*p)/this.d  - (f.n*p)/f.d ,p); //on aura pas besoin de reduire le ressulat de l'additio
	   */                                                         //car ça sera fait déja 	car le constructeur
		
	}
	
	//Méthode fois(Fraction f) qui retourne résultat de la multiplication de this et f
   public Fraction fois(Fraction f) {
	   this.n = this.n*f.n;
	   this.d = this.d*f.d;
	   reduire();
	   return this;
	   
   }
   //La méthode diviseepar(Fraction f) qui retourne le résultat de la deivision de this et f
   public Fraction diviseepar(Fraction f) {
	   this.n = this.n * f.d;
	   this.d = this.d * f.n;
	   reduire();
	   return this;
	   
   }
   //la méthode CompareTo(Fraction f) qui retourne un entier négatidf si this est inferieur à f
   //posif si this est superieur à f et zéro si this est égal à f
   public int compareTo(Fraction f) {
	   int diff = n-d;
	   return diff;
   }
   
	// meéthode toString() pour tester
	public String toString() {
		return n + "/" + d;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test constructeur Fraction()
		Fraction frac1 = new Fraction();
		System.out.println(frac1);

		// test constructeur Fraction(int n)
		Fraction frac2 = new Fraction(7);
		System.out.println(frac2);

		// test constructeur Fraction(int n,int d)
		Fraction frac3 = new Fraction(1, 2);
		System.out.println(frac3);
		// test constructeur Fraction(String s)
		Fraction frac4 = new Fraction("1/4");
		System.out.println(frac4);
		
		//test vmethode valueOf(String s)
		System.out.println(Fraction.valueOf("18/9"));
		
		//test de la méthode ppcm
		System.out.println(Fraction.ppcm(1,4));
		//test de la méthode plus(Fraction f)
		System.out.println(frac3.plus(frac4));
		
		//test de la ùméthode moins(Fraction f)
		System.out.println(frac3.moins(frac4));
		//test de la méthode fois(Fraction f)
		System.out.println(frac3.fois(frac4));
		
		//test de la méthode divissepar(Fraction f){
		System.out.println(frac3.diviseepar(frac4));

	}

}
