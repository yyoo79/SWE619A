package assignment2;

import java.util.ArrayList;
import java.util.List;

public class FindPrimeFactor2 {
	
	public static void main(String[] args) {
	       
        List<Integer> testA = new ArrayList<Integer>();
//        testA.add(12);
//        testA.add(25);
//        testA.add(18);
//        testA.add(8);
        
        List<Integer> testB = new ArrayList<Integer>();
//        testB.add(6);
//        testB.add(2);
//        testB.add(3);
//        testB.add(2);
        
        // case 1 - a is null | Expect: NPE
        // testA = null;
        
        // case 2 - b is null | Expect: NPE
        // testB = null;
        
        // case 3 - a = [] or b = [] | Expect: IAE
        // nothing
        
        // case 4 - index not found | Expect: IAE
		// testA.add(10);
		// testB.add(0);
        
        // case 5 - index found | Expect: index number (2)
        // testA.add(10); 	testA.add(12); 	testA.add(18); 	testA.add(8);
        // testB.add(0); 	testB.add(0); 	testB.add(3);	testB.add(2);
        
        // case 6 - null element ??? | what to expect? | result is 0 (found at index 0)
        //testA.add(9);	testA.add(null);
        //testB.add(3);	testB.add(3);
        
        // case 7 - null element ???
        // testA.add(null);	testA.add(9);
        // testB.add(3);		testB.add(3);
        
        // case 8 - null element ???
        testA.add(4);		testA.add(9);
        testB.add(null);	testB.add(3);
       
      
        System.out.println(findPrimeFactor2(testA,testB));        
                
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
	
	//Precondition 1 - a not null; b not null;
	//Precondition 2 - there is some index i where b[i] is both prime and a factor of a[i]

	/**
	 * return the least index at which b[i] is a prime factor of a[i]
	 * @param 	a	list of Integer; a cannot be null 
	 * @param 	b	list of Integer; b cannot be null
	 * @return 		the least index at which b[i] is a prime factor of a[i]
	 * @throws	NullPointerException		if a is null; if b is null
	 * @throws	IllegalArgumentException	there is NO index FOUND i where b[i] is both prime and a factor of a[i]
	 */
	
	public static int findPrimeFactor2(List<Integer> a, List<Integer> b) {
		
		if (a == null || b == null) {
			throw new NullPointerException("a or b cannot be null.");
		}
		
		for (int i = 0; i < b.size() ; i++) {
			// check element is null
			if (a.get(i) != null && b.get(i) != null) {
				// check Prime first then check factor
				if (isPrime(b.get(i)) && (a.get(i) % b.get(i) == 0)) { 
					return i;
				}
			}
		}
		
		// no index found - throw IllegalArgumentException
		throw new IllegalArgumentException("there is NO index FOUND i where b[i] is both prime and a factor of a[i]");
		
		//return -1;   //this means if caller doesn't adhere to requirements, it will get result -1 if lists are of equal size
		
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
