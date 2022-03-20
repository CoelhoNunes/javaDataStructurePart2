/******************************************************************************************* 
Purpose/Description: Using one Stack by implementing Java an O(n) running complexity method
static int leader(int[] A) to find a leader element and returning the index of any leader
in A. 
*******************************************************************************************/

package dataStructure_A2;
import java.util.Stack;

public class oneStack {
	
	// The starting method in finding the leader element
	static int Leader(int[] A) {
		
		Stack <Integer> sk = new Stack <Integer>();
		
		// Creating the first leader element
		int x = 1;
		sk.push(0);
		
		int count = 1;
		for(x = 1; x < A.length; x++) {
			if(A[sk.peek()] == A[x]) {
				count++;
			}
			else count--;
			if(count == 0) {
				
				// Pushing the new leader
				sk.pop();
				sk.push(x);
				count = 1;
			}
		}
		
		// Loop the checks is the leader is in the data set & then returning the index
		int leader = sk.peek();
		count = 0;
		for(x = 0; x < A.length; x++) {
			if(A[x] == A[leader])
				count++;
		}
		
		if(A.length/2 < count)
			return leader + 1;
		return -1;
	}
	
	// Creating the array that starts with the one
	public static void main(String argv[]) {
		
		// Random array of numbers and printouts 
		int[] a = {23, 23, 67, 23, 67, 23, 45};
		System.out.println("Leader = " + Leader(a));
		
		int[] b = {23, 24, 67, 23, 67, 23, 45};
		System.out.println("Leader = " + Leader(b));
		
		int[] c = {23, 24, 67, 67, 67, 67, 45};
		System.out.println("Leader = " + Leader(c));
		
		int[] d = {17, 17, 89, 89, 89, 17, 17};
		System.out.println("Leader = " + Leader(d));
	}
}

/***** Program output *****
 * ------------------------
	Leader = 1
	Leader = -1
	Leader = 3
	Leader = 7
 * ------------------------
*/
