/*Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.

*/

package leetcode.arrays;

import leetcode.utils.ArrayUtills;

public class FirstMissingPositive {

	public int firstMissingPositive(int[] A) {
		int i = 0;
		while(i < A.length) {
			if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
			else if(A[A[i]-1] != A[i]) ArrayUtills.swap(A, i, A[i]-1);
			else i++;
		}
		i = 0;
		while(i < A.length && A[i] == i+1) i++;
		return i+1;
	}
	
	public int firstMissingPositiveUsingPartition(int[] A) {
		int n=A.length;
		if(n==0) return 1; // No Elements
		//Do the partition and put Negative or zero on right most side of the array
		int k=partition(A)+1;
		System.out.println("K is "+ k);
		ArrayUtills.printArray(A);
		
		int temp=0;
		int first_missing_Index=k;
		for(int i=0;i<k;i++){
			temp=Math.abs(A[i]);
			System.out.println("Temp is "+ temp);
			if(temp<=k){
				// Doing temp -1 because we have moved all 0 and negative value at the right most or after partition point
				A[temp-1]=(A[temp-1]<0)?A[temp-1]:-A[temp-1];
				System.out.println("A[Temp - 1] is "+ A[temp-1]);
			}
		}
		ArrayUtills.printArray(A);
		for(int i=0;i<k;i++){
			if(A[i]>0){
				first_missing_Index=i;
				break;
			}
		}
		return first_missing_Index+1;
	}

	private int partition(int[] A){
		int n=A.length;
		int q=-1;
		for(int i=0;i<n;i++){
			if(A[i]>0){
				q++;
				ArrayUtills.swap(A,q,i);
			}
		}
		return q;
	}

	
	public static void main(String[] args) {
		FirstMissingPositive obj = new FirstMissingPositive();
		//int missed = obj.firstMissingPositiveUsingPartition(new int[] {3,4,-1,1,1,2,7,8});
		int missed = obj.firstMissingPositiveUsingPartition(new int[] {1,2,0});
		System.out.println("The Missing element is " + missed);
		
		
	}

}
