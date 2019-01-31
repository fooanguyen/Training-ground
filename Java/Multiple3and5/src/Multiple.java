/*
 If we list all the natural numbers below 10 
 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
 The sum of these multiples is 23.
 Find the sum of all the multiples of 3 or 5 below 1000.
 
 If multiples of 3...print "fizz"
 If multiples of 5...print "buzz"
 If both multiples of 3 & 5....print "fizzbuzz"
 */
public class Multiple {
	final int limit = 1000;  //change the limit for loop
	public static void main(String[] args) {
		new Multiple().run();

	}

	private void run() {
		String listOf3="";
		String listOf5="";
		String listOf3and5="";
		int count3 = 0;
		int count5 = 0;
		int count3and5 = 0;
		int sum = 0;
		
		for(Integer i = 1; i < this.limit; i++) {
			Boolean flag = true;
			if(i % 3 == 0) {				
				listOf3 += i.toString() + " ";
				count3++;
				if(count3 == 10) {
					listOf3 += "\n";
					count3 = 0;
				}
				if(flag) {
					sum += i;
					flag = false;
				}
			}
			if(i % 5 == 0) {
				listOf5 += i.toString() + " ";
				count5++;
				if(count5 == 10) {
					listOf5 += "\n";
					count5 = 0;
				}
				if(flag) {
					sum += i;
					flag = false;
				}
			}
			if(i % 3 == 0 && i % 5 == 0) {
				listOf3and5 += i.toString() + " ";
				count3and5++;
				if(count3and5 == 10) {
					listOf3and5 += "\n";
					count3and5 = 0;
				}
				if(flag) {
					sum += i;
					flag = false;
				}
			}
		}
		
		System.out.println("list all the natural numbers below: " + this.limit + "\n");
		System.out.println("list of multiples of 3 that will print fizz: \n" + listOf3 + "\n");
		System.out.println("list of multiples of 5 that will print buzz: \n" + listOf5 + "\n");
		System.out.println("list of multiples of 3 & 5 that will print fizzbuzz: \n" + listOf3and5 + "\n");
		System.out.println("The sum is: " + sum);
	}
	
}
