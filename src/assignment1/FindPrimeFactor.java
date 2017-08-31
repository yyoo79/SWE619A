package assignment1;

import java.util.ArrayList;
import java.util.List;

public class FindPrimeFactor {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
       
    	/*
        System.out.println(isPrime(-1));
        System.out.println(isPrime(0));
        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));
        */
       
        List<Integer> testA = new ArrayList<Integer>();
        /*
        testA.add(12);
        testA.add(25);
        testA.add(18);
        testA.add(8);
        */
        
        testA.add(-12);
        testA.add(25);
        testA.add(-18);
        testA.add(18);
        testA.add(18);
        testA.add(18);
        
        List<Integer> testB = new ArrayList<Integer>();
        /*
        testB.add(6);
        testB.add(2);
        testB.add(3);
        testB.add(2);
        */
        
        testB.add(6);
        testB.add(2);
        testB.add(3);
        
        System.out.println("-18 % 6 = " + (-18 % 6) );        
        System.out.println(findPrimeFactor(testA,testB));
        
                
    }

   // Requires: a not null; b not null;
   //           there is some index i where b[i] is
   //           both prime and a factor of a[i]
   //          
   // Effects: return the least index
   //          at which b[i] is a prime factor of a[i]
   // E.g. findPrimeFactor ([12, 25, 18, 8], [6, 2, 3, 2]) = 2
   // (Note: 6 is a factor of 12, but is not prime,
   //  and 2 is prime, but is not a factor of 25.  However,
   //  3 is a prime factor of 18. Hence, index "2" is the correct
   //  answer.  index "3" is not a possible answer, because the
   //  third index is not the least index with the desired property.)
   // Also note that a[] and b[] need not be of the same length.
    
    // Yang's Explanation
    // 1. both a and b cannot be empty because there is some index i where matches between b[i] and a[i]
    // 
    // Cases that I would like to discuss:
    // case1 - [12, 25, -18, 8] and [6, 2, 3, 2] - what's the answer? 2?
    // case2 - [12, 25, 18, 8] and [6, 2, -3, 2] - what's the answer? 3?
    // case3 - a is shorter than b
    // case4 - b is shorter than a
        
    
	public static int findPrimeFactor(List<Integer> a, List<Integer> b) {
		
		for (int i = 0; i < b.size(); i++) {			
			// Check factor AND check Prime
			if ((a.get(i) % b.get(i) == 0) && isPrime(b.get(i))) {
				return i;
			}
		}
		return 0;
	}

	private static boolean isPrime(Integer n) {
		// prime number can't be negative and 1 is not prime number
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
      
   
   
   
    /*
   
    https://cs.gmu.edu/~pammann/619/assigns/assign01.html
   
    Goal: Basic familiarity with Java; Introduction to Contract Model.

     Consider the following specification:

       public static int findPrimeFactor (List<Integer> a, List<Integer> b)
       // Requires: a not null; b not null;
       //           there is some index i where b[i] is 
       //           both prime and a factor of a[i]
       //           
       // Effects: return the least index
       //          at which b[i] is a prime factor of a[i]
       // E.g. findPrimeFactor ([12, 25, 18, 8], [6, 2, 3, 2]) = 2
       // (Note: 6 is a factor of 12, but is not prime,
       //  and 2 is prime, but is not a factor of 25.  However,
       //  3 is a prime factor of 18. Hence, index "2" is the correct
       //  answer.  index "3" is not a possible answer, because the
       //  third index is not the least index with the desired property.)
       // Also note that a[] and b[] need not be of the same length.

    Implement this method in a class called FindPrimeFactor. Although you should (obviously) 
    test your implementation yourself, you do not need to include any test code. The GTA will 
    test your code. Note that error checking in findPrimeFactor() for parameters that do not 
    satisfy the precondtions is not necessary (or even permitted, if you happen to follow Meyer). 
    We will discuss this point in detail in class when we cover exception handling.
    
    Update Aug-30 2017: To make sure you understand the point about preconditions, your code is 
    required to be minimal. Specifically, if it possible to delete parts of your implementation 
    and still have it satisfy the requirements, you'll earn less than full credit. 

Grading Criteria:

    Adherence to instructions. Do what I ask for above, not something else.
    Minimal implementation. 
    Syntax: Java compiles and runs. 

     */

   
}