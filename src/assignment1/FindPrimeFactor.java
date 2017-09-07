// SWE619 Assignment1 by Yang Kyu Yoo and Chadia Habib
package assignment1;

import java.util.ArrayList;
import java.util.List;

public class FindPrimeFactor {

    public static void main(String[] args) {
       
        List<Integer> testA = new ArrayList<Integer>();
        testA.add(10);
        testA.add(12);
//        testA.add(18);
//        testA.add(8);
        
        List<Integer> testB = new ArrayList<Integer>();
        testB.add(0);
        testB.add(3);
//        testB.add(3);
//        testB.add(2);
      
        System.out.println(findPrimeFactor(testA,testB));        
                
    }

    // *********************************************************************************
    // Yang Kyu Yoo's Explanation
    // 1. both a and b cannot be empty because there is some index i where matches between b[i] and a[i]
    // 2. both a and b cannot be null because there is some index i where matches between b[i] and a[i]
    // 3. case1 - [12, 25, -18, 8] and [6, 2, 3, 2] - negative number in 'a' still satisfy the precondition.
    // 4. case2 - [12, 25, 18, 8] and [6, 2, -3, 2] - negative number in 'b' still satisfy the precondition.
    // *********************************************************************************
    
    // *********************************************************************************
    // Chadia Habib's Explanation
    // NOTE: we would normally also check  && i < a.size() in below for loop
    // but considering requirement "there is some index i where b[i] is both prime and factor of a[i]"
    // it's unnecessary to check size of both lists as i will be already found when we reach end of a[]
    // could use for(int i=0; i<b.size() && i<a.size();i++) but unnecessary as per above explanation 
    // NOTE: Chadia's note: if caller doesn't adhere to above condition and lists are of equal size function was returning 0. 
    // Yoo's suggestion to address this issue was to return -1 in this scenario.
    // NOTE: need to test case where prime factor is first, middle and end of list
    // *********************************************************************************


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

	public static int findPrimeFactor(List<Integer> a, List<Integer> b) {
		for (int i = 0; i < b.size() ; i++) {	
			// Check factor AND check Prime
			if ((a.get(i) % b.get(i) == 0) && isPrime(b.get(i))) { 
				return i;
			}
		}
		return -1;   //this means if caller doesn't adhere to requirements, it will get result -1 if lists are of equal size
	}

	private static boolean isPrime(Integer n) {
		// prime number can't be negative and 0 or 1 is not prime number
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
   
}