package recursion;

public class Factorial {
	public int factorial(int n) {
		if(n<0) {System.out.print ("Invalid Input : "); return -1;}
		if(n==0) { return 1;}
		return n*factorial(n-1);
	}
	public static void main(String[] args) {
		System.out.println(new Factorial().factorial(-10));
		System.out.println(new Factorial().factorial(4));
	}
}