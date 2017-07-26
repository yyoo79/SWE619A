import java.util.ArrayList;
import java.util.List;

public class SWE619A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("Hello world!");
		
		List<Integer> tempList = new ArrayList<Integer>();
		tempList.add(50);
		tempList.add(20);
		tempList.add(60);
		
		Integer result = min(tempList);
		
		System.out.println("The minimum number is " + result);

	}
	
	
	/**
    * Returns the mininum element in a list
    * @param list Comparable list of elements to search
    * @return the minimum element in the list
    * @throws NullPointerException if list is null or
    *         if any list elements are null
    * @throws ClassCastException if list elements are not mutually comparable
    * @throws IllegalArgumentException if list is empty
    */
    public static <T extends Comparable<? super T>> T min (List<? extends T> list) {
       if (list.size() == 0) {
          throw new IllegalArgumentException ("Min.min");
       }

       T result = list.get(0);

       for (T comp : list) {
           if (comp.compareTo(result) < 0) {    // throws NPE, CCE as needed
               result = comp;
           }
       }
       return result;
    }
    
    /** Assignment
    
    Identify tests you think are necessary for this code. Justify each test.

    First, think about happy path tests.
    Next, think about remaining tests.
    Which of these tests come from the specification, and which come from the code? 
     
     */
    
	/**
	 Note from yyoo4
	 
	 Java.awt.list (awt being the abstract window toolkit) MUST not import when you try to use List
	 https://stackoverflow.com/questions/14163687/importing-list-from-java-awt-or-java-utils
	 
	 Explanation of line 24 - <T extends Comparable<? super T>>
	 https://stackoverflow.com/questions/15318927/what-does-this-java-generics-mean
	 
	 	 
	 */

}
