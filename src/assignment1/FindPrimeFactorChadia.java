package assignment1;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class FindPrimeFactorChadia {

	public static boolean isPrime(int num)
    {
    	   for(double i=2, sqrt = Math.sqrt(num); i <sqrt; i++)
    	       if(num%i == 0)
    	               return false;
    	   return true;
    }
    
    public static int findPrimeFactor(List<Integer> a, List<Integer> b)
    //Requires: a not null; b not null;
    //			there is some index i where b[i] is
    //			both prime and a factor of a[i]
    {
    	int index=0;
    	int i =0;
    	boolean found = false;
    	while (i<a.size()& i<b.size() & found==false)
    	{
//    		System.out.println("lists have " + a.get(i) + " and " + b.get(i));   //debug statement
    		if ( isPrime(b.get(i)))
    		{
    			if ( a.get(i) % b.get(i) ==0 )
    			{
    			index = i;
    			found = true;
    			}
    		}
    		i++;
    	}
    	return index;
    }
    
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        List<Integer> listA = new ArrayList<Integer>();
	     listA.add(1);
	     listA.add(18);
	     listA.add(18);
	     listA.add(8);
	 
	     List<Integer> listB = new ArrayList<Integer>();
		 listB.add(1);
		 listB.add(-3);
		 listB.add(3);
		 listB.add(2);
     
		int primeIndex = findPrimeFactor(listA, listB);
		  
		System.out.println("The result is " + primeIndex);
		
        System.exit( 0 ); 
    }

}
