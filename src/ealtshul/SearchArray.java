package ealtshul;

import java.util.*;
public class SearchArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int[] arr = new int[10];
		
		for(int i = 0; i<arr.length; i++)
			arr[i] = rand.nextInt(20);
		
		//Linear Search
		int k = rand.nextInt(20);
		
		System.out.println("Linear Search");
		System.out.print("Arr: ");
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
		System.out.println("\nN: " + arr.length);
		System.out.println("K: " + k);
		System.out.println("Returns: " + linearSearch(arr, arr.length, k));
		System.out.println("Time Complexity : O(n)");
		System.out.println("Auxiliary Space : O(1)");
		
		//sort array
		Arrays.sort(arr);
		
		//binary search
		k = rand.nextInt(20);
		System.out.println();
		System.out.println("Binary Search");
		System.out.print("Arr: ");
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
		System.out.println("\nN: " + arr.length);
		System.out.println("K: " + k);
		System.out.println("Returns: " + binarySearch(arr, k));
		System.out.println("Time Complexity : O(log n)");
		System.out.println("Auxiliary Space : O(1)");
		
		//jump search
		k = rand.nextInt(20);
		System.out.println();
		System.out.println("Jump Search");
		System.out.print("Arr: ");
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
		System.out.println("\nN: " + arr.length);
		System.out.println("K: " + k);
		System.out.println("Returns: " + jumpSearch(arr, k));
		System.out.println("Time Complexity : O(sqrt(n))");
		System.out.println("Auxiliary Space : O(1)");
		
		//Interpolation search
		k = rand.nextInt(20);
		System.out.println();
		System.out.println("Interpolation Search");
		System.out.print("Arr: ");
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
		System.out.println("\nN: " + arr.length);
		System.out.println("K: " + k);
		System.out.println("Returns: " + interpolationSearch(arr, 0, arr.length-1, k));
		System.out.println("Time Complexity : O(log n)");
		System.out.println("Auxiliary Space : O(1)");
		
		k = rand.nextInt(20);
		System.out.println();
		System.out.println("Exponential Search");
		System.out.print("Arr: ");
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
		System.out.println("\nN: " + arr.length);
		System.out.println("K: " + k);
		System.out.println("Returns: " + exponentialSearch(arr, k));
		System.out.println("Time Complexity : O(log n)");
		System.out.println("Auxiliary Space : O(1)");
		
		k = rand.nextInt(20);
		System.out.println();
		System.out.println("Ternary Search");
		System.out.print("Arr: ");
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
		System.out.println("\nN: " + arr.length);
		System.out.println("K: " + k);
		System.out.println("Returns: " + ternarySearch(arr, 0, arr.length-1, k));
		System.out.println("Time Complexity : O(2c log 3 n)");
		System.out.println("Auxiliary Space : O(1)");
	}
	
	// Java code for linearly searching k in arr. If k 
	// is present then return its location, otherwise 
	// return -1 
	public static int linearSearch(int[] arr, int n, int k) {
        for(int i = 0; i<n; i++)
            if(arr[i] == k ) return i;
       
        return -1;
    }
	
	static int binarySearch(int arr[], int K) 
    { 
		return binarySearch(arr, 0, arr.length-1, K);
    }
	
	static int binarySearch(int arr[], int begin, int end, int K) 
    { 
		while (begin <= end) { 
            int m = begin + (end - begin) / 2; 
  
            // Check if x is present at mid 
            if (arr[m] == K) 
                return m; 
  
            // If x greater, ignore left half 
            if (arr[m] < K) 
            	begin = m + 1; 
  
            // If x is smaller, ignore right half 
            else
            	end = m - 1; 
        } 
  
        // if we reach here, then element was 
        // not present 
        return -1; 
    } 
	
	//Jump Search. 
	public static int jumpSearch(int[] arr, int k) 
	{ 
		int n = arr.length; 

		// Finding block size to be jumped 
		int step = (int)Math.floor(Math.sqrt(n)); 
		// Finding the block where element is 
		// present (if it is present) 
		int prev = 0; 
		while (arr[Math.min(step, n)-1] < k) 
		{ 
			prev = step; 
			step += (int)Math.floor(Math.sqrt(n)); 
			if (prev >= n) 
				return -1; 
		} 

		// Doing a linear search for x in block 
		// beginning with prev. 
		while (arr[prev] < k) 
		{ 
			prev++; 

			// If we reached next block or end of 
			// array, element is not present. 
			if (prev == Math.min(step, n)) 
				return -1; 
		} 
		
		// If element is found 
		if (arr[prev] == k) 
			return prev; 

		return -1; 
	} 

	//Interpolation  Search. 
	public static int interpolationSearch(int[] arr, int lo, int hi, int k) {
		//y = mx+b
				 
        // Since array is sorted, an element
        // present in array must be in range  
        // defined by corner
		int pos;
		 
        // Since array is sorted, an element
        // present in array must be in range
        // defined by corner
        if (lo <= hi && k >= arr[lo] && k <= arr[hi]) {
 
            // Probing the position with keeping
            // uniform distribution in mind.
            pos = lo
                  + (((hi - lo) / (arr[hi] - arr[lo]))
                     * (k - arr[lo]));
 
            // Condition of target found
            if (arr[pos] == k)
                return pos;
 
            // If k is larger, k is in right sub array
            if (arr[pos] < k)
                return interpolationSearch(arr, pos + 1, hi,
                                           k);
 
            // If k is smaller, k is in left sub array
            if (arr[pos] > k)
                return interpolationSearch(arr, lo, pos - 1,
                                           k);
        }
        return -1;
	}
	
	// Returns position of 
    // first occurrence of
    // k in array
    static int exponentialSearch(int arr[], int k)
    {
        // If k is present at firt location itself
        if (arr[0] == k)
            return 0;
     
        // Find range for binary search by
        // repeated doubling
        int i = 1;
        while (i < arr.length && arr[i] <= k)
            i = i*2;
     
        // Call binary search for the found range.
        return binarySearch(arr, i/2,  Math.min(i, arr.length-1), k);
    }
    
    //Ternary Search
    static int ternarySearch(int arr[], int l,  int r, int k) { 
		if (r >= l) { 
			int mid1 = l + (r - l) / 3; 
			int mid2 = mid1 + (r - l) / 3; 
		
			// If k is present at the mid1 
			if (arr[mid1] == k)  return mid1; 
		
			// If k is present at the mid2 
			if (arr[mid2] == k)  return mid2; 
		
			// If k is present in left one-third 
			if (arr[mid1] > k)  
			return ternarySearch(arr, l, mid1 - 1, k); 
		
			// If k is present in right one-third 
			if (arr[mid2] < k)  
			return ternarySearch(arr, mid2 + 1, r, k); 
		
			// If k is present in middle one-third 
			return ternarySearch(arr, mid1 + 1, mid2 - 1, k); 
		} 

		// We reach here when element is 
		// not present in array 
		return -1; 
	} 
}
