public class Fibonacci {

	public static void main( String args[] ) {

		BigInt fibonacciNumber = new BigInt("1");
  
		int nthNumber = 0;
		String fibonacciPrevious = "";
		String oldFibonacci1 = "0";
		String oldFibonacci2 = "0";
  		try {
			nthNumber = Integer.parseInt(args[0]);

				
				
			} catch(NumberFormatException nfe)
			{
			System.out.println( " Please enter an interger value greater than 0 ");
			 System.exit(1);
			}
	
		for (int i = 0; i < nthNumber; i++){
			
			if (i%2 == 0){
				fibonacciPrevious = oldFibonacci1;
			}else if (i%2 == 1){
				fibonacciPrevious = oldFibonacci2;
			}
			
			fibonacciNumber.add(fibonacciPrevious);
				
			if (i%2== 0){
				oldFibonacci1 = fibonacciNumber.toString();
			}
			if (i%2== 1){
				oldFibonacci2 = fibonacciNumber.toString();
			}
		
		
		}
  
  			System.out.println( " Fibonacci Number: " + fibonacciNumber.toString());

	}
}