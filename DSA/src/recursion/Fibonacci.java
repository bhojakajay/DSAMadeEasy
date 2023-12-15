package recursion;
/*
 * Fibonacci Sequence is 
 * 
 * 0 1 1 2 3 5 8 13 ...
 */
public class Fibonacci {
	public int fibonacci(int n) {
		if(n<=1){
			return n;
		}
		return fibonacci(n-2) + fibonacci(n-1);
	}
	
	public static void main(String[] args) {
		int n = 10;
		Fibonacci fibonacci = new Fibonacci();
		for(int i=0 ; i<=n ; i++) {
			System.out.print(fibonacci.fibonacci(i) + " ");
		}
	}
}